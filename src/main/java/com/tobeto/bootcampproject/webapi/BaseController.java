package com.tobeto.bootcampproject.webapi;

import com.tobeto.bootcampproject.core.utilities.results.DataResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    public ResponseEntity<?> handleDataResult(DataResult<?> dataResult){
        if(dataResult.isSuccess())
            return ResponseEntity.ok(dataResult);

        return ResponseEntity.badRequest().body(dataResult);
    }
}
