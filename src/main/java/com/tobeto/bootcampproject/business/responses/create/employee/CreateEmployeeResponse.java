package com.tobeto.bootcampproject.business.responses.create.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeResponse {
    private int id;
    private String firstName;
}
