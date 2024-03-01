package com.tobeto.bootcampproject.business.abstracts;

import com.tobeto.bootcampproject.business.responses.get.user.GetAllUserResponse;
import com.tobeto.bootcampproject.business.responses.get.user.GetUserByEmailResponse;
import com.tobeto.bootcampproject.core.utilities.results.DataResult;

import java.util.List;

public interface UserService {
    DataResult<List<GetAllUserResponse>> getAll();
    DataResult<GetUserByEmailResponse> getUserByEmail(String email);
}
