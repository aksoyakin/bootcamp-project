package com.tobeto.bootcampproject.core.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@MappedSuperclass
public class BaseEntity<T> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private T id;

    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;

    @Column(name = "UPDATED_DATE")
    private LocalDateTime updatedDate;

    @Column(name = "DELETED_DATE")
    private LocalDateTime deletedDate;

}
