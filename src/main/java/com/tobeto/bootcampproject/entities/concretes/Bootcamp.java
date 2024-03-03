package com.tobeto.bootcampproject.entities.concretes;

import com.tobeto.bootcampproject.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BOOTCAMPS")
public class Bootcamp extends BaseEntity<Integer> {

    @Column(name = "NAME")
    private String name;

    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "instructorId")
    private Instructor instructor;

    @ManyToOne
    @JoinColumn(name = "bootcampStateId")
    private BootcampState bootcampState;

    @OneToMany(mappedBy = "bootcamp")
    private List<Application> applications;



}
