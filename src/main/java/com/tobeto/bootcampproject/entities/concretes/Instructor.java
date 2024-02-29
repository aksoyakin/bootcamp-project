package com.tobeto.bootcampproject.entities.concretes;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "INSTRUCTORS")
@PrimaryKeyJoinColumn(name = "USER_ID")
public class Instructor extends User {

    @Column(name = "COMPANY_NAME")
    private String companyName;

}
