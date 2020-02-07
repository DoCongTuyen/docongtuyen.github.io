package com.itsol.projectservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.itsol.projectservice.service.common.DateAudit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class TimeSheet extends DateAudit {

    @Id
    @GeneratedValue()
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String  title;

    @Column(name = "content")
    private String content;

    @Column(name = "note")
    private String note;

    @Column(name = "checker")
    private String checker;

    @Column(name = "status")
    private boolean status;

    @ManyToOne(fetch = FetchType.EAGER)
    private Eproject eproject;


}
