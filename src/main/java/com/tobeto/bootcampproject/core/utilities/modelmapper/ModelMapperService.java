package com.tobeto.bootcampproject.core.utilities.modelmapper;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    ModelMapper forRequest();
    ModelMapper forResponse();
}

    



