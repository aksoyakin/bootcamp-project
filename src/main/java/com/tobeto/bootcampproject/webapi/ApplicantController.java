package com.tobeto.bootcampproject.webapi;


import com.tobeto.bootcampproject.business.abstracts.ApplicantService;
import com.tobeto.bootcampproject.business.requests.create.applicant.CreateApplicantRequest;
import com.tobeto.bootcampproject.business.requests.update.applicant.UpdateApplicantRequest;
import com.tobeto.bootcampproject.business.responses.create.applicant.CreateApplicantResponse;
import com.tobeto.bootcampproject.business.responses.get.applicant.GetAllApplicantResponse;
import com.tobeto.bootcampproject.business.responses.get.applicant.GetApplicantResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/applicants")
@AllArgsConstructor
public class ApplicantController extends BaseController{

    private ApplicantService applicantService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateApplicantRequest createApplicantRequest){
        return handleDataResult(applicantService.create(createApplicantRequest));

        /*
        CreateApplicantResponse result = applicantService.create(createApplicantRequest);
        return result;
        */
    }

    @GetMapping(value = "getbyid/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return handleDataResult(applicantService.getById(id));
     //   return applicantService.getById(id);

    }
    @GetMapping(value = "getall")
    public ResponseEntity<?> getAll(){
        return handleDataResult(applicantService.getAll());

        // return applicantService.getAll();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateApplicant(@RequestBody UpdateApplicantRequest request, @PathVariable int id){
        return handleDataResult(applicantService.updateApplicantById(request,id));
    }



}
