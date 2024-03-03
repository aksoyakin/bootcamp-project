package com.tobeto.bootcampproject.entities.concretes;

import com.tobeto.bootcampproject.core.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "APPLICATION_STATE")
public class ApplicationState extends BaseEntity<Integer> {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "applicationState")
    private List<Application> applications;
}
