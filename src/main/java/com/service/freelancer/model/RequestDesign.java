package com.service.freelancer.model;

import com.service.base.model.BaseEntity;
import com.service.common.model.Governorate;
import com.service.userManagement.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.Formula;

@Getter
@Setter
@Entity
@Table(name = "fre_request_design")
public class RequestDesign extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String phoneNumber;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "Unit_type_id")
    private UnitType unitType;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "governorate_id")
    private Governorate governorate;

    private Long unitArea;

    private Long budget;

    private Long requiredDuration;

    private String notes;

    @Formula("(SELECT COALESCE(count(r.id),0) FROM fre_request_request_design r WHERE r.request_id = id AND (r.is_rejected IS NULL OR r.is_rejected != false))")
    private Long requestCount;

    @Formula(
            "(SELECT " +
                    "  CASE " +
                    "    WHEN (SELECT COUNT(r.id) FROM fre_request_request_design r WHERE r.request_id = id AND r.is_finished = true) > 0 " +
                    "      THEN 'finished' " +
                    "    WHEN (SELECT COUNT(r.id) FROM fre_request_request_design r WHERE r.request_id = id AND r.is_accepted = true) > 0 " +
                    "      THEN 'pending' " +
                    "    ELSE 'available' " +
                    "  END" +
                    ")"
    )
    private String askStatus;

}
