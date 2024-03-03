package com.tobeto.bootcampproject.entities.concretes;

import com.tobeto.bootcampproject.core.entities.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "APPLICATIONS")
public class Application extends BaseEntity<Integer> {

    @ManyToOne
    @JoinColumn(name = "applicantId")
    private Applicant applicant;

    @ManyToOne
    @JoinColumn(name = "bootcampId")
    private Bootcamp bootcamp;

    @ManyToOne
    @JoinColumn(name = "applicationStateId")
    private ApplicationState applicationState;









}
