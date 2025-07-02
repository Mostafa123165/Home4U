package com.service.freelancer.model;

import com.service.base.model.BaseEntity;
import com.service.userManagement.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "fre_request_ask_engineer")
public class RequestAskEngineer extends BaseEntity<Long> {
    @ManyToOne
    @NotNull
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "ask_id", nullable = false)
    private AskEngineer askEngineer;

    @NotNull
    private String comment;

    private Boolean isAccepted;
    private Boolean isFinished;
    private Boolean isRejected;
}
