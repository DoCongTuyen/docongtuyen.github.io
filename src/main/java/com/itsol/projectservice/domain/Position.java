package com.itsol.projectservice.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "POSITION")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Position implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUTO_INCRE_SEQ_POSITION")
    @SequenceGenerator(sequenceName = "AUTO_INCRE_SEQ_POSITION", allocationSize = 1, name = "AUTO_INCRE_SEQ_POSITION")
    private long id;

    @Column(name = "NAME")
    private String name;

}
