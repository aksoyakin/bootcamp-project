package com.tobeto.bootcampproject.entities.concretes;


import com.tobeto.bootcampproject.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "USERS")
public class User extends BaseEntity<Integer> {

    @Column(name = "USER_NAME")
    private String username;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "DATE_OF_BIRTH")
    private LocalDate dateOfBirth;

    @Column(name = "NATIONAL_IDENTITY")
    private String nationalIdentity;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

}
