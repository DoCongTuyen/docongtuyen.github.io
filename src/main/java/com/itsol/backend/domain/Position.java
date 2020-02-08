package com.itsol.backend.domain;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "POSITION")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUTO_INCRE_SEQ_POSITION")
    @SequenceGenerator(sequenceName = "AUTO_INCRE_SEQ_POSITION", allocationSize = 1, name = "AUTO_INCRE_SEQ_POSITION")
    private Long id;

    @Column(name = "NAME")
    private String name;

}
