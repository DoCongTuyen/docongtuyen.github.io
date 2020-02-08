package com.itsol.backend.domain;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "DEPARTMENT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUTO_INCRE_SEQ_DEPARTMENT")
    @SequenceGenerator(sequenceName = "AUTO_INCRE_SEQ_DEPARTMENT", allocationSize = 1, name = "AUTO_INCRE_SEQ_DEPARTMENT")
    private Long id;

    @Column(name = "MANAGER_ID")
    private Integer managerId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LOCATION")
    private String location;

}
