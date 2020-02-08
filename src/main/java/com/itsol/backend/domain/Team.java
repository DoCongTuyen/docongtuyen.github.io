package com.itsol.backend.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TEAM")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Team  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUTO_INCRE_SEQ_TEAM")
    @SequenceGenerator(sequenceName = "AUTO_INCRE_SEQ_TEAM", allocationSize = 1, name = "AUTO_INCRE_SEQ_TEAM")
    private Long id;

    @Column(name = "LEADER_ID")
    private Integer leaderId;


}
