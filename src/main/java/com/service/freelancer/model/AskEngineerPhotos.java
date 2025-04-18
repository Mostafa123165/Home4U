package com.service.freelancer.model;

import com.service.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "fre_ask_engineer_photos")
public class AskEngineerPhotos  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ask_engineer_id", nullable = false)
    private AskEngineer askEngineer;

    @Column(name = "photo_path")
    private String photoPath;
}
