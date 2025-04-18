package com.service.freelancer.model;

import com.service.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "fre_ask_worker_photos")
public class AskWorkerPhotos  {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ask_worker_id", nullable = false)
    private AskWorker askWorker;

    @Column(name = "photo_path")
    private String photoPath;
}
