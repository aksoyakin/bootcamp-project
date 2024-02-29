package com.tobeto.bootcampproject.business.concretes;

import com.tobeto.bootcampproject.business.abstracts.InstructorService;
import com.tobeto.bootcampproject.business.constants.ApplicantMessage;
import com.tobeto.bootcampproject.business.constants.InstructorMessage;
import com.tobeto.bootcampproject.business.requests.create.instructor.CreateInstructorRequest;
import com.tobeto.bootcampproject.business.responses.create.instructor.CreateInstructorResponse;
import com.tobeto.bootcampproject.business.responses.get.instructor.GetAllInstructorResponse;
import com.tobeto.bootcampproject.business.responses.get.instructor.GetInstructorResponse;
import com.tobeto.bootcampproject.core.utilities.modelmapper.ModelMapperService;
import com.tobeto.bootcampproject.core.utilities.results.DataResult;
import com.tobeto.bootcampproject.core.utilities.results.SuccessDataResult;
import com.tobeto.bootcampproject.dataaccess.abstracts.InstructorRepository;
import com.tobeto.bootcampproject.entities.concretes.Instructor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InstructorManager implements InstructorService {
    private ModelMapperService modelMapperService;
    private InstructorRepository instructorRepository;
    @Override
    public DataResult<CreateInstructorResponse> create(CreateInstructorRequest createInstructorRequest) {
        Instructor instructorToBeCreated = modelMapperService.forRequest()
                .map(createInstructorRequest,Instructor.class);

        instructorRepository.save(instructorToBeCreated);

        CreateInstructorResponse response = modelMapperService.forResponse()
                .map(instructorToBeCreated, CreateInstructorResponse.class);

        return new SuccessDataResult
                <CreateInstructorResponse>
                (response, InstructorMessage.instructorCreated);
    }

    @Override
    public DataResult<GetInstructorResponse> getById(int id) {
        Instructor instructorToBeGetById = instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bu id'ye sahip 'Instructor bulunamadı.'"));

        GetInstructorResponse response = modelMapperService.forResponse()
                .map(instructorToBeGetById, GetInstructorResponse.class);

        return new SuccessDataResult
                <GetInstructorResponse>
                (response,InstructorMessage.instructedGetById);
    }

    @Override
    public DataResult<List<GetAllInstructorResponse>> getAll() {
        List<Instructor> instructors = instructorRepository.findAll();

        List<GetAllInstructorResponse> instructorResponses =
                instructors.stream().map(instructor -> modelMapperService
                        .forResponse()
                        .map(instructor,GetAllInstructorResponse.class))
                        .collect(Collectors.toList());

        return new SuccessDataResult
                <List<GetAllInstructorResponse>>
                (instructorResponses,InstructorMessage.instructedListed);

    }
}
