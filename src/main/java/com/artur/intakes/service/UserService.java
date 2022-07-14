package com.artur.intakes.service;

import com.artur.intakes.dto.UserDto;
import com.artur.intakes.dto.UserInfoDto;
import com.artur.intakes.entity.User;
import com.artur.intakes.repositories.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
//    private UserRepository userRepository;
    private final UserRepository userRepository;
//    @NonNull
//    private UserRepository userRepository;

    public UserDto createAndUpdateUSer(User user) {
        User userInput = userRepository.save(user);
        return new UserDto(userInput);
    }

//    @Override
//    public Optional<UserInfoDto> vm(UUID id){
//    public Optional<UserInfoDto> findById(Long id){
    public UserInfoDto findById(Long id){
//        return userRepository.findById(id).map(this::mapToDto);
//        return userRepository.findById(id).map(UserInfoDto::new);
        return userRepository.findById(id).map(UserInfoDto::new).orElse(null);
    }

//    private UserInfoDto mapToDto(User savedUser) {
//        return new UserInfoDto(savedUser);
//    }

//    @Autowired
//    private PasswordEncoder passwordEncoder;

//    @Override
//    public User registerNewUserAccount(UserDto accountDto) throws EmailExistsException {
//        if (emailExist(accountDto.getEmail())) {
//            throw new EmailExistsException(
//                    "There is an account with that email adress:" + accountDto.getEmail());
//        }
//        User user = new User();
//        user.setFirstName(accountDto.getFirstName());
//        user.setLastName(accountDto.getLastName());
//
//        user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
//
//        user.setEmail(accountDto.getEmail());
//        user.setRole(new Role(Integer.valueOf(1), user));
//        return repository.save(user);
//    }


}
