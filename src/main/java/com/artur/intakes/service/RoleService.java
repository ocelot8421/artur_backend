package com.artur.intakes.service;

import com.artur.intakes.dto.RoleDto;
import com.artur.intakes.entity.Role;
import com.artur.intakes.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public RoleDto retrieveRoleByName(String name){
        Role role = roleRepository.findByName(name).orElse(null);
        return new RoleDto(role);
    }

}
