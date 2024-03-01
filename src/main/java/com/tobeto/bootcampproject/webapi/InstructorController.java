package com.tobeto.bootcampproject.webapi;

import com.tobeto.bootcampproject.business.abstracts.InstructorService;
import com.tobeto.bootcampproject.business.requests.create.instructor.CreateInstructorRequest;
import com.tobeto.bootcampproject.business.requests.update.instructor.UpdateInstructorRequest;
import com.tobeto.bootcampproject.business.responses.create.instructor.CreateInstructorResponse;
import com.tobeto.bootcampproject.business.responses.get.instructor.GetAllInstructorResponse;
import com.tobeto.bootcampproject.business.responses.get.instructor.GetInstructorResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/instructors")
public class InstructorController extends BaseController {
    private InstructorService instructorService;

    @PostMapping
    ResponseEntity<?> create(@RequestBody CreateInstructorRequest request){
        return handleDataResult(instructorService.create(request));
        /*
        CreateInstructorResponse result = instructorService.create(request);
        return result;
         */

    }
    @GetMapping(value = "getbyid/{id}")
    ResponseEntity<?> getById(@PathVariable int id){
        return handleDataResult(instructorService.getById(id));

        // return instructorService.getById(id);

    }

    @GetMapping(value = "getall")
    ResponseEntity<?> getAll(){
        return handleDataResult(instructorService.getAll());
       // return instructorService.getAll();
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateInstructorById(@RequestBody UpdateInstructorRequest request, @PathVariable int id){
        return handleDataResult(instructorService.updateInstructorById(request,id));

    }
}
