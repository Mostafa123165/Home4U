package com.service.business.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductRatingResponseDTO {

    private Long id;
    private Long userId;
    private String userName;
    private String userImage;

    @JsonFormat(pattern = "MMM d, yyyy")
    private LocalDateTime createdDate;

    private Double rate;
    private String comment;

    public ProductRatingResponseDTO(Long id, Long userId, String firstName,String lastName, String userImage, LocalDateTime createdDate, Double rate, String comment) {
        this.id = id;
        this.userId = userId;
        this.userName = firstName + " " + lastName;
        this.userImage = userImage;
        this.createdDate = createdDate;
        this.rate = rate;
        this.comment = comment;
    }
}
