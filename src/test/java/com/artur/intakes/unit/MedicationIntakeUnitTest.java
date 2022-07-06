package com.artur.intakes.unit;

import com.artur.intakes.controller.MedicationIntakeController;
import com.artur.intakes.dto.*;
import com.artur.intakes.entity.*;
import com.artur.intakes.service.MedicationIntakeService;
import com.artur.intakes.service.RoleService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MedicationIntakeController.class)
public class MedicationIntakeUnitTest {
    private static User user1;
    private static User user2;
    private static MedicationIntake medicationIntake1;
    private static MedicationIntake medicationIntake2;
    private MedicationIntakeDto medicationIntakeDto1;
    private MedicationIntakeDto medicationIntakeDto2;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MedicationIntakeService service;

    @MockBean
    private RoleService roleService;

    @BeforeEach
    public void setup() {
        RoleDto roledto = roleService.retrieveRoleByName("ROLE_ADMIN");

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
    public void findAll_returnListOfMedicationIntakes() throws Exception{
        when(service.retrieveAllIntakes())
                .thenReturn(List.of(medicationIntakeDto1, medicationIntakeDto2));

        mockMvc.perform(get("/intakes/allIntakes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1L)))
                .andExpect(jsonPath("$.month", is("03.")));



    }

}
