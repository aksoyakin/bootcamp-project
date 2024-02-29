package com.tobeto.bootcampproject.dataaccess.abstracts;

import com.tobeto.bootcampproject.entities.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
