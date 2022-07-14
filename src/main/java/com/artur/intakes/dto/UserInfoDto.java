package com.artur.intakes.dto;

import com.artur.intakes.entity.User;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

@Data
public class UserInfoDto {

    private Long id;
//    Long id;
    private String username;
//    String username;

    @JsonCreator
    public UserInfoDto(
            @JsonProperty("id") Long id,
            @JsonProperty("username") String username
    ) {
        this.id = id;
        this.username = username;
    }

    public UserInfoDto(User user) {
        id = user.getId();
        username = user.getUsername();
    }

    @Override
    public String toString() {
        return "UserInfoDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", hashcode= " + hashCode() +
                '}';
    }


}
