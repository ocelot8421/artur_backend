//package com.artur.intakes.controller;
//
//import com.artur.intakes.dto.LoginDto;
//import com.artur.intakes.dto.SignUpDto;
//import com.artur.intakes.entity.Role;
//import com.artur.intakes.entity.User;
//import com.artur.intakes.repositories.RoleRepository;
//import com.artur.intakes.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Collections;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private RoleRepository roleRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    //    http://localhost:8080/api/auth/login
//    @PostMapping("/login")
//    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto){
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        loginDto.getUsernameOrEmail(), loginDto.getPassword()
//                )
//        );
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        return new ResponseEntity<>("User signed in successfully.", HttpStatus.OK);
//    }
//
//    //    http://localhost:8080/api/auth/register
//    @PostMapping("/register")
//    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto){
//
//        //Checking that if it exists or not (username, email)
//        if (userRepository.existsByUsername(signUpDto.getUsername())){
//            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
//        }
//        if (userRepository.existByEmail(signUpDto.getEmail())){
//            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
//        }
//
//        //create user object
//        User user = new User();
//        user.setName(signUpDto.getName());
//        user.setUsername(signUpDto.getUsername());
//        user.setEmail(signUpDto.getEmail());
//        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
//
//        Role roles = roleRepository.findByName("ROLE_ADMIN").get();
//        user.setRoles(Collections.singleton(roles));
//
//        userRepository.save(user);
//
//        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
//    }
//
//
//
//}
