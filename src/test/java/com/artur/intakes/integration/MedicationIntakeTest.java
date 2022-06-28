package com.artur.intakes.integration;

import com.artur.intakes.dto.MedicationIntakeDto;
import com.artur.intakes.model.MedicationIntake;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ActiveProfiles("test")
@Sql(scripts = "classpath:/deleteTestRow.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
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
    public void retrieveIntakeById_returnIntakeWithTheSameMedication() {

        MedicationIntake testIntake = new MedicationIntake(
                8L, "test month", "test day of month", "test day of week",
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
                9L, "test month", "test day of month", "test day of week",
                "med 1", 0.123, 123,
                "med 2", 0.456, 456,
                null, 0);

        MedicationIntakeDto testIntakeDto =
                testRestTemplate.postForObject(baseUrl + "/add", testIntake, MedicationIntakeDto.class);
        MedicationIntake testIntakeModified = new MedicationIntake(
                testIntakeDto.getId(), "test month", "test day of month", "test day of week",
                "changed med", 0.123, 123,
                "med 2", 0.456, 456,
                null, 0);
        testRestTemplate.put(baseUrl + "/put/" + testIntakeDto.getId(), testIntakeModified);
        MedicationIntakeDto testIntakeDtoModified = testRestTemplate.getForObject(
                baseUrl + "/get/" + testIntakeDto.getId(), MedicationIntakeDto.class);
        assertEquals("changed med", testIntakeDtoModified.getMedicine01());
    }


//    @Test
//    @Order(3)
//    public void deleteIntakeById_returnIntakeWithTheSameMedication() {
//
//    }

}
