package com.tobeto.bootcampproject.business.concretes;

import com.tobeto.bootcampproject.business.abstracts.EmployeeService;
import com.tobeto.bootcampproject.business.constants.EmployeeMessage;
import com.tobeto.bootcampproject.business.requests.create.employee.CreateEmployeeRequest;
import com.tobeto.bootcampproject.business.requests.update.employee.UpdateEmployeeRequest;
import com.tobeto.bootcampproject.business.responses.create.employee.CreateEmployeeResponse;
import com.tobeto.bootcampproject.business.responses.get.employee.GetAllEmployeeResponse;
import com.tobeto.bootcampproject.business.responses.get.employee.GetEmployeeResponse;
import com.tobeto.bootcampproject.business.responses.update.employee.UpdateEmployeeResponse;
import com.tobeto.bootcampproject.core.utilities.modelmapper.ModelMapperService;
import com.tobeto.bootcampproject.core.utilities.results.DataResult;
import com.tobeto.bootcampproject.core.utilities.results.Result;
import com.tobeto.bootcampproject.core.utilities.results.SuccessDataResult;
import com.tobeto.bootcampproject.core.utilities.results.SuccessResult;
import com.tobeto.bootcampproject.dataaccess.abstracts.EmployeeRepository;
import com.tobeto.bootcampproject.entities.concretes.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private ModelMapperService modelMapperService;
    @Override
    public DataResult<CreateEmployeeResponse> create(CreateEmployeeRequest createEmployeeRequest) {
        Employee employeeToBeCreated = modelMapperService.forRequest()
                .map(createEmployeeRequest, Employee.class);

        employeeRepository.save(employeeToBeCreated);

        CreateEmployeeResponse response = modelMapperService.forResponse()
                .map(employeeToBeCreated,CreateEmployeeResponse.class);

        return new SuccessDataResult<CreateEmployeeResponse>(response, EmployeeMessage.employeeCreated);
    }

    @Override
    public DataResult<GetEmployeeResponse> getById(int id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bu id'ye sahip 'Employee' bulunamad!"));

        GetEmployeeResponse response = modelMapperService.forResponse()
                .map(employee, GetEmployeeResponse.class);

        return new SuccessDataResult<GetEmployeeResponse>(response,EmployeeMessage.employeeGetById);

    }

    @Override
    public DataResult<List<GetAllEmployeeResponse>> getAll() {
        List<Employee> employees = employeeRepository.findAll();

        List<GetAllEmployeeResponse> employeeResponses =
                employees.stream().map(employee -> modelMapperService
                        .forResponse()
                        .map(employee,GetAllEmployeeResponse.class))
                        .collect(Collectors.toList());

        return new SuccessDataResult
                <List<GetAllEmployeeResponse>>
                (employeeResponses,EmployeeMessage.employeeListed);
    }

    @Override
    public DataResult<UpdateEmployeeResponse> updateEmployee(UpdateEmployeeRequest request, int id) {
        Employee employee = employeeRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Bu id'ye sahip bir 'Employee' bulunamadı."));

        Employee employeeToBeUpdate = modelMapperService
                .forRequest()
                .map(request, Employee.class);

        employee.setId(id);
        employee.setUpdatedDate(LocalDateTime.now());

        employee.setFirstName(employeeToBeUpdate.getFirstName() != null ? employeeToBeUpdate.getFirstName() : employee.getFirstName());
        employee.setLastName(employeeToBeUpdate.getLastName() != null ? employeeToBeUpdate.getLastName() : employee.getLastName());
        employee.setUsername(employeeToBeUpdate.getUsername() != null ? employeeToBeUpdate.getUsername() : employee.getUsername());
        employee.setNationalIdentity(employeeToBeUpdate.getNationalIdentity() != null ? employeeToBeUpdate.getNationalIdentity() : employee.getNationalIdentity());
        employee.setDateOfBirth(employeeToBeUpdate.getDateOfBirth() != null ? employeeToBeUpdate.getDateOfBirth() : employee.getDateOfBirth());
       // employee.setEmail(employeeToBeUpdate.getEmail() != null ? employeeToBeUpdate.getEmail() : employee.getEmail());
        employee.setPosition(employeeToBeUpdate.getPosition() != null ? employeeToBeUpdate.getPosition() : employee.getPosition());

        employeeRepository.save(employee);

        UpdateEmployeeResponse response = modelMapperService
                .forResponse()
                .map(employee, UpdateEmployeeResponse.class);

        return new SuccessDataResult<UpdateEmployeeResponse>(response,"Employee updated successfully.");



    }

    @Override
    public Result delete(int id) {
        employeeRepository.deleteById(id);
        return new SuccessResult("Employee deleted successfully.");

    }


}
