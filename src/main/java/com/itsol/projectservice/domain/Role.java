package com.itsol.projectservice.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ROLE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUTO_INCRE_SEQ_ROLE")
    @SequenceGenerator(sequenceName = "AUTO_INCRE_SEQ_ROLE", allocationSize = 1, name = "AUTO_INCRE_SEQ_ROLE")
    private long id;

    @Column(name = "NAME")
    private String name;
}
