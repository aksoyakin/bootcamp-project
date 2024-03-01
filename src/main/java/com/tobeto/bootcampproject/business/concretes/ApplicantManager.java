package com.tobeto.bootcampproject.business.concretes;

import com.tobeto.bootcampproject.business.abstracts.ApplicantService;
import com.tobeto.bootcampproject.business.constants.ApplicantMessage;
import com.tobeto.bootcampproject.business.requests.create.applicant.CreateApplicantRequest;
import com.tobeto.bootcampproject.business.requests.update.applicant.UpdateApplicantRequest;
import com.tobeto.bootcampproject.business.responses.create.applicant.CreateApplicantResponse;
import com.tobeto.bootcampproject.business.responses.get.applicant.GetAllApplicantResponse;
import com.tobeto.bootcampproject.business.responses.get.applicant.GetApplicantResponse;
import com.tobeto.bootcampproject.business.responses.update.applicant.UpdateApplicantResponse;
import com.tobeto.bootcampproject.core.utilities.modelmapper.ModelMapperService;
import com.tobeto.bootcampproject.core.utilities.results.DataResult;
import com.tobeto.bootcampproject.core.utilities.results.Result;
import com.tobeto.bootcampproject.core.utilities.results.SuccessDataResult;
import com.tobeto.bootcampproject.core.utilities.results.SuccessResult;
import com.tobeto.bootcampproject.dataaccess.abstracts.ApplicantRepository;
import com.tobeto.bootcampproject.entities.concretes.Applicant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicantManager implements ApplicantService {

    private ApplicantRepository applicantRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<CreateApplicantResponse> create(CreateApplicantRequest createApplicantRequest) {
        Applicant applicantToBeCreate = modelMapperService
                .forRequest()
                .map(createApplicantRequest,Applicant.class);

        applicantToBeCreate.setCreatedDate(LocalDateTime.now());

        applicantRepository.save(applicantToBeCreate);

        CreateApplicantResponse response = modelMapperService
                .forResponse()
                .map(applicantToBeCreate,CreateApplicantResponse.class);

        return new SuccessDataResult
                <CreateApplicantResponse>
                (response, ApplicantMessage.applicantCreated);
    }

    @Override
    public DataResult<GetApplicantResponse> getById(int id) {
        Applicant getApplicant = applicantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bu id'ye sahip bir 'Applicant' bulunamadı."));

        GetApplicantResponse response = modelMapperService.forResponse()
                .map(getApplicant,GetApplicantResponse.class);

        return new SuccessDataResult
                <GetApplicantResponse>
                (response,ApplicantMessage.applicantGetById);

    }

    @Override
    public DataResult<List<GetAllApplicantResponse>> getAll() {

        List<Applicant> applicants = applicantRepository.findAll();

        List<GetAllApplicantResponse> applicantResponses =
                applicants.stream()
                        .map(applicant -> modelMapperService
                        .forResponse()
                        .map(applicant, GetAllApplicantResponse.class))
                        .collect(Collectors.toList());

        return new SuccessDataResult
                <List<GetAllApplicantResponse>>
                (applicantResponses,ApplicantMessage.applicantListed);
    }

    @Override
    public DataResult<UpdateApplicantResponse> updateApplicantById(UpdateApplicantRequest request, int id) {
        Applicant applicant = applicantRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Bu id'ye sahip bir 'applicant' bulunamadı!"));

        Applicant applicantToBeUpdate = modelMapperService
                .forRequest()
                .map(request,Applicant.class);

        applicant.setId(id);
        applicant.setUpdatedDate(LocalDateTime.now());

        applicant.setFirstName(applicantToBeUpdate.getFirstName() != null ? applicantToBeUpdate.getFirstName() : applicant.getFirstName());
        applicant.setLastName(applicantToBeUpdate.getLastName() != null? applicantToBeUpdate.getLastName() : applicant.getLastName());
        applicant.setAbout(applicantToBeUpdate.getAbout() != null ? applicantToBeUpdate.getAbout() : applicant.getAbout());
        applicant.setUsername(applicantToBeUpdate.getUsername() != null ? applicantToBeUpdate.getUsername() : applicant.getAbout());
        applicant.setNationalIdentity(applicantToBeUpdate.getNationalIdentity() != null ? applicantToBeUpdate.getNationalIdentity() : applicant.getNationalIdentity());
        applicant.setDateOfBirth(applicantToBeUpdate.getDateOfBirth() != null ? applicantToBeUpdate.getDateOfBirth() : applicant.getDateOfBirth());
     //   applicant.setEmail(applicantToBeUpdate.getEmail() != null ? applicantToBeUpdate.getEmail() : applicant.getEmail());
        applicantRepository.save(applicant);

        UpdateApplicantResponse response = modelMapperService
                .forResponse()
                .map(applicant,UpdateApplicantResponse.class);

        return new SuccessDataResult<UpdateApplicantResponse>(response,"Applicant updated successfully.");
    }

    @Override
    public Result delete(int id) {
        applicantRepository.deleteById(id);
        return new SuccessResult("Applicant deleted successfully.");
    }
}
