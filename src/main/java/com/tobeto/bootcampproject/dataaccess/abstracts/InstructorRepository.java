package com.tobeto.bootcampproject.dataaccess.abstracts;

import com.tobeto.bootcampproject.entities.concretes.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor,Integer> {

}
