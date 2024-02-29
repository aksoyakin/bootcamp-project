package com.tobeto.bootcampproject.business.responses.get.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllEmployeeResponse {
    private int id;
    private String firstName;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private LocalDateTime deletedDate;
}
