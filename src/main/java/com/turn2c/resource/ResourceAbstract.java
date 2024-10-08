package com.turn2c.resource;

import com.turn2c.dto.response.ResponseDto;
import org.springframework.web.bind.annotation.ResponseStatus;


import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

public class ResourceAbstract {

    @ResponseStatus(OK)
    protected <C> ResponseDto<C> returnSuccess(C data) {

        return ResponseDto.success(data);
    }

    @ResponseStatus(OK)
    protected ResponseDto<Void> returnSuccess() {

        return ResponseDto.success();
    }

    @ResponseStatus(CREATED)
    protected <C> ResponseDto<C> returnCreated(C data) {

        return ResponseDto.success(data);
    }
}
