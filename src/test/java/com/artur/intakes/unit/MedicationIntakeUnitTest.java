package com.artur.intakes.unit;

import com.artur.intakes.dto.MedicationIntakeDto;
import com.artur.intakes.entity.MedicationIntake;
import com.artur.intakes.entity.User;
import com.artur.intakes.repositories.MedicationIntakeRepository;
import com.artur.intakes.service.MedicationIntakeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest
@ActiveProfiles("unit-test")
public class MedicationIntakeUnitTest {
    private static User user1;
    private static User user2;
    private static MedicationIntake medicationIntake1;
    private static MedicationIntake medicationIntake2;
    private MedicationIntakeDto medicationIntakeDto1;
    private MedicationIntakeDto medicationIntakeDto2;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private  MedicationIntakeRepository medicationIntakeRepository;

    @InjectMocks
    private MedicationIntakeService service;

    @BeforeEach
    public void setup() {

        user1 = User.builder()
                .id(1L)
                .name("Anonymous")
                .username("Mr A")
                .email("mra@example.com")
                .password("mraPassword")
                .role("ROLE_USER")
                .build();

        user2 = User.builder()
                .id(2L)
                .name("Anonymoa")
                .username("Ms A")
                .email("msa@example.com")
                .password("msaPassword")
                .role("ROLE_ADMIN")
                .build();

        medicationIntake1 = MedicationIntake.builder()
                .id(1L).month("03.").time("13.").day("day off")
                .medicine01("Med1").pieces01(1).dose01(15)
                .build();

        medicationIntake2 = MedicationIntake.builder()
                .id(2L).month("03.").time("14.").day("nex day")
                .medicine02("Med2").pieces02(3).dose02(10)
                .build();

        medicationIntakeDto1 = new MedicationIntakeDto(medicationIntake1);
        medicationIntakeDto2 = new MedicationIntakeDto(medicationIntake2);
    }

    @Test
    public void findAll_returnListOfMedicationIntakes() throws Exception {
        when(service.retrieveAllIntakes())
                .thenReturn(List.of(medicationIntakeDto1, medicationIntakeDto2));

        mockMvc.perform(get("/intakes/allIntakes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)));


    }

}

