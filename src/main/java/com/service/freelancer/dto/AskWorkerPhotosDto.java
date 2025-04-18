package com.service.freelancer.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AskWorkerPhotosDto {

    private Long id;

    private Long askWorkerId;

    private String photoPath;
}
