package com.tobeto.bootcampproject.business.abstracts;

import com.tobeto.bootcampproject.business.requests.create.employee.CreateEmployeeRequest;
import com.tobeto.bootcampproject.business.requests.update.employee.UpdateEmployeeRequest;
import com.tobeto.bootcampproject.business.responses.create.employee.CreateEmployeeResponse;
import com.tobeto.bootcampproject.business.responses.get.employee.GetAllEmployeeResponse;
import com.tobeto.bootcampproject.business.responses.get.employee.GetEmployeeResponse;
import com.tobeto.bootcampproject.business.responses.update.employee.UpdateEmployeeResponse;
import com.tobeto.bootcampproject.core.utilities.results.DataResult;
import com.tobeto.bootcampproject.core.utilities.results.Result;

import java.util.List;

public interface EmployeeService {
    DataResult<CreateEmployeeResponse> create(CreateEmployeeRequest createEmployeeRequest);
    DataResult<GetEmployeeResponse> getById(int id);
    DataResult<List<GetAllEmployeeResponse>> getAll();
    DataResult<UpdateEmployeeResponse> updateEmployee(UpdateEmployeeRequest request, int id);
    Result delete(int id);
}
