package com.tobeto.bootcampproject.business.abstracts;

import com.tobeto.bootcampproject.business.requests.create.employee.CreateEmployeeRequest;
import com.tobeto.bootcampproject.business.responses.create.employee.CreateEmployeeResponse;
import com.tobeto.bootcampproject.business.responses.get.employee.GetAllEmployeeResponse;
import com.tobeto.bootcampproject.business.responses.get.employee.GetEmployeeResponse;
import com.tobeto.bootcampproject.core.utilities.results.DataResult;

import java.util.List;

public interface EmployeeService {
    DataResult<CreateEmployeeResponse> create(CreateEmployeeRequest createEmployeeRequest);
    DataResult<GetEmployeeResponse> getById(int id);
    DataResult<List<GetAllEmployeeResponse>> getAll();

}
