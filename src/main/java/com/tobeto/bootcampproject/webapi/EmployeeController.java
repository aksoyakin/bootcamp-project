package com.tobeto.bootcampproject.webapi;

import com.tobeto.bootcampproject.business.abstracts.EmployeeService;
import com.tobeto.bootcampproject.business.requests.create.employee.CreateEmployeeRequest;
import com.tobeto.bootcampproject.business.requests.update.employee.UpdateEmployeeRequest;
import com.tobeto.bootcampproject.business.responses.create.employee.CreateEmployeeResponse;
import com.tobeto.bootcampproject.business.responses.get.employee.GetAllEmployeeResponse;
import com.tobeto.bootcampproject.business.responses.get.employee.GetEmployeeResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController extends BaseController {
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateEmployeeRequest request){
        return handleDataResult(employeeService.create(request));
        /*
        CreateEmployeeResponse result = employeeService.create(request);
        return result;
         */
    }

    @GetMapping(value = "getbyid/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return handleDataResult(employeeService.getById(id));
        // return employeeService.getById(id);
    }

    @GetMapping(value = "getall")
    public ResponseEntity<?> getAll(){
        return handleDataResult(employeeService.getAll());
        // return employeeService.getAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@RequestBody UpdateEmployeeRequest request, @PathVariable int id){
        return handleDataResult(employeeService.updateEmployee(request,id));
    }
}
