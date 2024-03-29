package com.artur.intakes.entity;

import com.artur.intakes.dto.MedicationIntakeDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ActiveProfiles("integration-test")
@Sql(scripts = {"classpath:/test_schema.sql", "classpath:/test_data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class MedicationIntakeIntegrationTest {

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
    public void retrieveAllIntakes_returnTheBasicWeek() {
        MedicationIntakeDto[] mondayToSunDay = testRestTemplate.getForObject(baseUrl + "/allIntakes", MedicationIntakeDto[].class);
        for (MedicationIntakeDto medicationIntakeDto : mondayToSunDay) {
            System.out.println(medicationIntakeDto + " searching test data");
        }
        assertEquals(4, mondayToSunDay.length);
    }

    @Test
    public void retrieveIntakeById_returnIntakeWithTheSameMedication() {

        MedicationIntake testIntake = new MedicationIntake(
                8L, "2022", "test month", "test day of month", "test day of week", "evening",
                "med 1", 0.123, 123,
                "med 2", 0.456, 456,
                null, 0);

        MedicationIntakeDto testIntakeDto =
                testRestTemplate.postForObject(baseUrl + "/add", testIntake, MedicationIntakeDto.class);
        MedicationIntakeDto testIntakeDtoResult =
                testRestTemplate.getForObject(baseUrl + "/get/" + testIntakeDto.getId(), MedicationIntakeDto.class);
        assertEquals(testIntakeDto.getMedicine02(), testIntakeDtoResult.getMedicine02());
    }

    @Test
    public void updateIntakeById_returnIntakeWithUpdatedMedication() {
        MedicationIntake testIntake = new MedicationIntake(
                9L,"2022", "test month", "test day of month", "test day of week",
                "morning", "med 1", 0.123, 123,
                 "med 2", 0.456, 456,
                null, 0);

        MedicationIntakeDto testIntakeDto =
                testRestTemplate.postForObject(baseUrl + "/add", testIntake, MedicationIntakeDto.class);
        MedicationIntake testIntakeModified = new MedicationIntake(
                testIntakeDto.getId(), "2022", "test month", "test day of month", "test day of week",
                "every hour", "changed med", 0.123, 123,
                "med 2", 0.456, 456,
                null, 0);
        testRestTemplate.put(baseUrl + "/put/" + testIntakeDto.getId(), testIntakeModified);
        MedicationIntakeDto testIntakeDtoModified = testRestTemplate.getForObject(
                baseUrl + "/get/" + testIntakeDto.getId(), MedicationIntakeDto.class);
        assertEquals("changed med", testIntakeDtoModified.getMedicine01());
    }


    @Test
    public void deleteIntakeById_returnListWithRemainingIntakes() {
        MedicationIntake testIntake10 = new MedicationIntake(
                10L, "2022", "test month", "test day of month", "Monday", "evening",
                "med 10", 0.10, 100,
                "med 10", 10, 0.1010,
                "something", 10);
        MedicationIntake testIntake11 = new MedicationIntake(
                11L, "2022", "test month", "test day of month", "Tuesday", "morning",
                "med 11", 0.11, 110,
                "med 11", 11, 0.1111,
                "something", 11);
        MedicationIntake testIntake12 = new MedicationIntake(
                12L,"2022", "test month", "test day of month", "Wednesday", "noon",
                "med 22", 0.12, 120,
                "med 22", 12, 0.1212,
                "something", 12);
        List<MedicationIntake> listMedicationIntake = new ArrayList<>();
        listMedicationIntake.add(testIntake10);
        listMedicationIntake.add(testIntake11);
        listMedicationIntake.add(testIntake12);

        List<MedicationIntakeDto> starterIntakeDtoList =
                List.of(testRestTemplate.getForObject(baseUrl + "/allIntakes", MedicationIntakeDto[].class));
        listMedicationIntake.forEach(
                testIntake -> testRestTemplate.postForObject(
                        baseUrl + "/add", testIntake, MedicationIntakeDto.class
                )
        );
        testRestTemplate.delete(baseUrl + "/del/" + testIntake10.getId());
        List<MedicationIntakeDto> remainingIntakeDtoList =
                List.of(testRestTemplate.getForObject(baseUrl + "/allIntakes", MedicationIntakeDto[].class));
        int sizeDifference = remainingIntakeDtoList.size() - starterIntakeDtoList.size();

        listMedicationIntake.remove(testIntake10);
        assertEquals(listMedicationIntake.size(), sizeDifference);
        for (int i = 0; i < listMedicationIntake.size(); i++) {
            assertEquals(listMedicationIntake.get(i).getDay(), remainingIntakeDtoList.get(i + starterIntakeDtoList.size()).getDay());
        }
    }

}
