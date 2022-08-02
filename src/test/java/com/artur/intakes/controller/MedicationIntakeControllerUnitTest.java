package com.artur.intakes.controller;

import com.artur.intakes.dto.MedicationIntakeDTO;
import com.artur.intakes.entity.MedicationIntake;
import com.artur.intakes.entity.User;
import com.artur.intakes.service.MedicationIntakeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class MedicationIntakeControllerUnitTest {
    private static User user1;
    private static User user2;
    private static MedicationIntake medicationIntake1;
    private static MedicationIntake medicationIntake2;
    private MedicationIntakeDTO medicationIntakeDTO1;
    private MedicationIntakeDTO medicationIntakeDTO2;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
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
                .id(1L).time("13.").day("day off")
                .medicine01("Med1").pieces01(1).dose01(15)
                .build();

        medicationIntake2 = MedicationIntake.builder()
                .id(2L).time("14.").day("nex day")
                .medicine02("Med2").pieces02(3).dose02(10)
                .build();

        medicationIntakeDTO1 = new MedicationIntakeDTO(medicationIntake1);
        medicationIntakeDTO2 = new MedicationIntakeDTO(medicationIntake2);
    }


    @Test
    public void findAll_returnListOfMedicationIntakes() throws Exception {

        when(service.retrieveAllIntakes())
                .thenReturn(List.of(medicationIntakeDTO1, medicationIntakeDTO2));

        mockMvc.perform(get("/intakes/allIntakes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)));
    }

}

