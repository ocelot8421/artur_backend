package com.artur.intakes.dto;

import com.artur.intakes.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {

    private String name;

    public RoleDto(Role role) {
        this.name = role.getName();
    }
}
