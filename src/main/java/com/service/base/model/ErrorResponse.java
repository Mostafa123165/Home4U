package com.service.base.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.service.base.Constant;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
public class ErrorResponse extends BaseResponse{

    private final String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> details;

    @JsonFormat(pattern = Constant.DateFormate.DATE_TIME_FORMAT_AM)
    private final LocalDateTime timestamp;


    public ErrorResponse(HttpStatus status, String message, List<String> details) {
        super(status.value(), Boolean.FALSE);
        this.message = message;
        this.details = details;
        this.timestamp = LocalDateTime.now();
    }

    public ErrorResponse(HttpStatus status, String message) {
        super(status.value(), Boolean.FALSE);
        this.message = message;
        this.timestamp = LocalDateTime.now();
        this.details = null;
    }
}
