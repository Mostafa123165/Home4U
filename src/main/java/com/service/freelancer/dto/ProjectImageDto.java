package com.service.freelancer.dto;

import com.service.base.dto.BaseEntityDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ProjectImageDto  {
    private Long id;
    private byte[] path;

    public ProjectImageDto(Long id, byte[] path) {
        this.id = id;
        this.path = path;
    }
}
