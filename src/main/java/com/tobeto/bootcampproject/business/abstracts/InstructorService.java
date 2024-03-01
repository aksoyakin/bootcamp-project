package com.tobeto.bootcampproject.business.abstracts;

import com.tobeto.bootcampproject.business.requests.create.instructor.CreateInstructorRequest;
import com.tobeto.bootcampproject.business.requests.update.instructor.UpdateInstructorRequest;
import com.tobeto.bootcampproject.business.responses.create.instructor.CreateInstructorResponse;
import com.tobeto.bootcampproject.business.responses.get.instructor.GetAllInstructorResponse;
import com.tobeto.bootcampproject.business.responses.get.instructor.GetInstructorResponse;
import com.tobeto.bootcampproject.business.responses.update.instructor.UpdateInstructorResponse;
import com.tobeto.bootcampproject.core.utilities.results.DataResult;

import java.util.List;

public interface InstructorService {
    DataResult<CreateInstructorResponse> create(CreateInstructorRequest createInstructorRequest);
    DataResult<GetInstructorResponse> getById(int id);
    DataResult<List<GetAllInstructorResponse>> getAll();
    DataResult<UpdateInstructorResponse> updateInstructorById(UpdateInstructorRequest request, int id);
}
