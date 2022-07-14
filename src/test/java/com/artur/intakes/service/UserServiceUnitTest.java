package com.artur.intakes.service;

import com.artur.intakes.dto.UserInfoDto;
import com.artur.intakes.entity.User;
import com.artur.intakes.repositories.UserRepository;
import com.artur.intakes.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class UserServiceUnitTest {

    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;


//    Dependency Injection evolution:

//    private UserService userService;
//    private UserRepository userRepository;
//
//    @BeforeEach
//    public void setUp() {
//        userRepository = Mockito.mock(UserRepository.class);
//        userService = new UserService(userRepository);
//    }

//    @Test
//    public void findById_returnDto(){
//        UserRepository userRepository = Mockito.mock(UserRepository.class);
//        UserService userService = new UserService(userRepository);
//    }


    @Test
    public void findById_returnDtoInfo() {
        Long id = 1234L;
        User user = new User(
                id, "Hello Bella", "hebe",
                "hebe@example.org", "testPasswordHebe",
                "ROLE_USER");
        when(userRepository.findById(any())).thenReturn(Optional.of(user));

        UserInfoDto resultDto = userService.findById(id);
//        assertThat(resultDto).contains(new UserInfoDto("hebe"));
//        assertThat(resultDto).contains(new UserInfoDto(id,"hebe"));
//        assertThat(resultDto).hasValue(new UserInfoDto(id,"hebe"));
//        contains(new UserInfoDto(id,"hebe"));
        assertThat(resultDto.getId()).isEqualTo(user.getId());
        assertThat(resultDto.getUsername()).isEqualTo(user.getUsername());
//        verify(userRepository).findById(id);
    }


}