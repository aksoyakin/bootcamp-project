package com.tobeto.bootcampproject.business.responses.get.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserByEmailResponse {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
}
