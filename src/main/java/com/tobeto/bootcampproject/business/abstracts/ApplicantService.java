package com.tobeto.bootcampproject.business.abstracts;

import com.tobeto.bootcampproject.business.requests.create.applicant.CreateApplicantRequest;
import com.tobeto.bootcampproject.business.requests.update.applicant.UpdateApplicantRequest;
import com.tobeto.bootcampproject.business.responses.create.applicant.CreateApplicantResponse;
import com.tobeto.bootcampproject.business.responses.get.applicant.GetAllApplicantResponse;
import com.tobeto.bootcampproject.business.responses.get.applicant.GetApplicantResponse;
import com.tobeto.bootcampproject.business.responses.update.applicant.UpdateApplicantResponse;
import com.tobeto.bootcampproject.core.utilities.results.DataResult;

import java.util.List;

public interface ApplicantService {
    DataResult<CreateApplicantResponse> create(CreateApplicantRequest createApplicantRequest);
    DataResult<GetApplicantResponse> getById(int id);
    DataResult<List<GetAllApplicantResponse>> getAll();
    DataResult<UpdateApplicantResponse> updateApplicantById(UpdateApplicantRequest request, int id);
}
