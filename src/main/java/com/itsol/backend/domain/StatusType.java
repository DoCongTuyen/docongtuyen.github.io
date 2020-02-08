package com.itsol.backend.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "STATUS_TYPE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StatusType  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUTO_INCRE_SEQ_STATUS_TYPE")
    @SequenceGenerator(sequenceName = "AUTO_INCRE_SEQ_STATUS_TYPE", allocationSize = 1, name = "AUTO_INCRE_SEQ_STATUS_TYPE")
    private Long id;

    @Column(name = "name")
    private String name;
}
