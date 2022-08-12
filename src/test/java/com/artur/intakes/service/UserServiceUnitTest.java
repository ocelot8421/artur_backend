package com.artur.intakes.service;

import com.artur.intakes.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

//@SpringBootTest
//@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
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