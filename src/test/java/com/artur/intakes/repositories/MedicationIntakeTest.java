package com.artur.intakes.repositories;

import com.artur.intakes.dto.MedicationIntakeDto;
import com.artur.intakes.model.MedicationIntake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class MedicationIntakeTest {

    @LocalServerPort
    private int port;

    private String baseUrl;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @BeforeEach
    public void setUrl() {
        this.baseUrl = "http://localhost:" + port + "/intakes";
    }

    @Test
    public void retrieveIntakeById_returnCarWithTheSameMedication(){

        MedicationIntake testIntake = new MedicationIntake();
        testIntake.setId(55L);
        testIntake.setMonth("02.");
        testIntake.setTime("22.");
        testIntake.setDay("Munkaszüneti nap");
//        testIntake.setMedicine01("L");
//        testIntake.setPieces01(0.2);
//        testIntake.setDose01(150);
        testIntake.setMedicine02("Mlfésad");
        testIntake.setPieces02(11);
        testIntake.setDose02(66);
        testIntake.setMedicine03("Z");
        testIntake.setDose03(1234567);

        System.out.println(testIntake + "keresés");
        //MedicationIntake(id=55, month=02., time=22., day=Munkaszüneti nap, medicine01=L, pieces01=0.2, dose01=150.0, medicine02=Mlfésad, dose02=66.0, pieces02=11.0, medicine03=Z, dose03=1234567.0)

        MedicationIntakeDto testIntakeResult =
                testRestTemplate.postForObject(baseUrl + "/add", testIntake, MedicationIntakeDto.class);

        System.out.println(testIntakeResult + "keresés nagyban");
        //MedicationIntakeDto{id=64, month='02.', time='22.', day='Munkaszüneti nap', medicine01='L', pieces01=0.2, dose01=150.0, medicine02='null', dose02=0.0, pieces02=0.0}

        MedicationIntakeDto result =
                testRestTemplate.getForObject(baseUrl + "/get/" + testIntakeResult.getId(), MedicationIntakeDto.class);

        System.out.println(result + "keresés juhú");
        //MedicationIntakeDto{id=64, month='02.', time='22.', day='Munkaszüneti nap', medicine01='L', pieces01=0.2, dose01=150.0, medicine02='null', dose02=0.0, pieces02=0.0}

        assertEquals(testIntakeResult.getMedicine02(), result.getMedicine02());
    }


}
