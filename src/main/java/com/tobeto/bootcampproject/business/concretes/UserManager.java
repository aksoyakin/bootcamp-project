package com.tobeto.bootcampproject.business.concretes;

import com.tobeto.bootcampproject.business.abstracts.UserService;
import com.tobeto.bootcampproject.business.responses.get.user.GetAllUserResponse;
import com.tobeto.bootcampproject.core.utilities.modelmapper.ModelMapperService;
import com.tobeto.bootcampproject.core.utilities.results.DataResult;
import com.tobeto.bootcampproject.core.utilities.results.SuccessDataResult;
import com.tobeto.bootcampproject.dataaccess.abstracts.UserRepository;
import com.tobeto.bootcampproject.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
    private UserRepository userRepository;
    private ModelMapperService modelMapperService;
    @Override
    public DataResult<List<GetAllUserResponse>> getAll() {
        List<User> users = userRepository.findAll();

        List<GetAllUserResponse> userResponses = users
                .stream()
                .map(user ->
                        modelMapperService.forResponse()
                        .map(user, GetAllUserResponse.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllUserResponse>>(userResponses,"All users are listed.");
    }
}
