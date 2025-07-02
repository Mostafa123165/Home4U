package com.service.freelancer.model;

import com.service.base.model.BaseEntity;
import com.service.common.model.City;
import com.service.common.model.Governorate;
import com.service.userManagement.model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "fre_ask_engineer")
public class AskEngineer extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "project_name", nullable = false)
    private String projectName;

    @Column(name = "project_description", length = 1000)
    private String projectDescription;

    @ManyToOne
    @JoinColumn(name = "engineer_type_id", nullable = false)
    private EngineerType engineerType;

    @ManyToOne
    @JoinColumn(name = "unit_type_id", nullable = false)
    private UnitType unitType;

    @Column(nullable = false)
    private Long budget;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @ManyToOne
    @JoinColumn(name = "governorate_id", nullable = false)
    private Governorate governorate;

    @ManyToOne
    @JoinColumn(name = "urgency_level_id", nullable = false)
    private UrgencyLevel urgencyLevel;

    private String deadline;

    @OneToMany(mappedBy = "askEngineer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AskEngineerPhotos> photos;

    @Formula("(SELECT COALESCE(count(r.id),0) FROM fre_request_ask_engineer r WHERE r.ask_id = id AND (r.is_rejected IS NULL OR r.is_rejected != false))")
    private Long requestCount;

    @Formula(
            "(SELECT " +
                    "  CASE " +
                    "    WHEN (SELECT COUNT(r.id) FROM fre_request_ask_engineer r WHERE r.ask_id = id AND r.is_finished = true) > 0 " +
                    "      THEN 'finished' " +
                    "    WHEN (SELECT COUNT(r.id) FROM fre_request_ask_engineer r WHERE r.ask_id = id AND r.is_accepted = true) > 0 " +
                    "      THEN 'pending' " +
                    "    ELSE 'available' " +
                    "  END" +
                    ")"
    )
    private String askStatus;


}
