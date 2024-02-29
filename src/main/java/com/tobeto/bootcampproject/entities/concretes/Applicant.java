package com.tobeto.bootcampproject.entities.concretes;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "APPLICANTS")
@PrimaryKeyJoinColumn(name = "USER_ID")
public class Applicant extends User {

    @Column(name = "ABOUT")
    private String about;

}
