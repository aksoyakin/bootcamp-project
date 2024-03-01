package com.tobeto.bootcampproject.business.concretes;

import com.tobeto.bootcampproject.business.abstracts.InstructorService;
import com.tobeto.bootcampproject.business.constants.ApplicantMessage;
import com.tobeto.bootcampproject.business.constants.InstructorMessage;
import com.tobeto.bootcampproject.business.requests.create.instructor.CreateInstructorRequest;
import com.tobeto.bootcampproject.business.requests.update.instructor.UpdateInstructorRequest;
import com.tobeto.bootcampproject.business.responses.create.instructor.CreateInstructorResponse;
import com.tobeto.bootcampproject.business.responses.get.instructor.GetAllInstructorResponse;
import com.tobeto.bootcampproject.business.responses.get.instructor.GetInstructorResponse;
import com.tobeto.bootcampproject.business.responses.update.instructor.UpdateInstructorResponse;
import com.tobeto.bootcampproject.core.utilities.modelmapper.ModelMapperService;
import com.tobeto.bootcampproject.core.utilities.results.DataResult;
import com.tobeto.bootcampproject.core.utilities.results.Result;
import com.tobeto.bootcampproject.core.utilities.results.SuccessDataResult;
import com.tobeto.bootcampproject.core.utilities.results.SuccessResult;
import com.tobeto.bootcampproject.dataaccess.abstracts.InstructorRepository;
import com.tobeto.bootcampproject.entities.concretes.Instructor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    @Override
    public DataResult<UpdateInstructorResponse> updateInstructorById(UpdateInstructorRequest request, int id) {
        Instructor instructor = instructorRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Bu id'ye sahip bir 'Instructor' bulunamadı."));

        Instructor instructorToBeUpdate = modelMapperService
                .forRequest()
                .map(request,Instructor.class);

        instructor.setId(id);
        instructor.setUpdatedDate(LocalDateTime.now());

        instructor.setFirstName(instructorToBeUpdate.getFirstName() != null ? instructorToBeUpdate.getFirstName() : instructor.getFirstName());
        instructor.setLastName(instructorToBeUpdate.getLastName() != null ? instructorToBeUpdate.getLastName() : instructor.getLastName());
        instructor.setUsername(instructorToBeUpdate.getUsername() != null ? instructorToBeUpdate.getUsername() : instructor.getUsername());
        instructor.setNationalIdentity(instructorToBeUpdate.getNationalIdentity() != null ? instructorToBeUpdate.getNationalIdentity() : instructor.getNationalIdentity());
        instructor.setDateOfBirth((instructorToBeUpdate.getDateOfBirth() != null ? instructorToBeUpdate.getDateOfBirth() : instructor.getDateOfBirth()));
        instructor.setCompanyName(instructorToBeUpdate.getCompanyName() != null ? instructorToBeUpdate.getCompanyName() : instructor.getCompanyName());

        instructorRepository.save(instructor);

        UpdateInstructorResponse response = modelMapperService
                .forResponse()
                .map(instructor, UpdateInstructorResponse.class);

        return new SuccessDataResult<UpdateInstructorResponse>(response,"Instructor updated successfully.");

    }

    @Override
    public Result delete(int id) {
        instructorRepository.deleteById(id);
        return new SuccessResult("Applicant deleted succcessfully.");
    }
}
