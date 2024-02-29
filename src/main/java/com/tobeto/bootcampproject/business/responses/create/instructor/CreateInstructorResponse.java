package com.tobeto.bootcampproject.business.responses.create.instructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInstructorResponse {
    private int id;
    private String firstName;
}
