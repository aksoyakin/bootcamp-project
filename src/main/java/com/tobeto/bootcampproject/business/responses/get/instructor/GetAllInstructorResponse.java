package com.tobeto.bootcampproject.business.responses.get.instructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllInstructorResponse {
    private int id;
    private String firstName;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private LocalDateTime deletedDate;
}
