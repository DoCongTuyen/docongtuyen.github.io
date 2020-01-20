package com.itsol.projectservice.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TEAM")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Team implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUTO_INCRE_SEQ_TEAM")
    @SequenceGenerator(sequenceName = "AUTO_INCRE_SEQ_TEAM", allocationSize = 1, name = "AUTO_INCRE_SEQ_TEAM")
    private long id;

    @Column(name = "LEADER_ID")
    private Integer leaderId;


}
