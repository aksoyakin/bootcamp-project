package com.tobeto.bootcampproject.business.responses.create.applicant;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicantResponse {
    private int id;
    private String firstName;
}
