package com.itsol.backend.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "STATUS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Status{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUTO_INCRE_SEQ_STATUS")
    @SequenceGenerator(sequenceName = "AUTO_INCRE_SEQ_STATUS", allocationSize = 1, name = "AUTO_INCRE_SEQ_STATUS")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TYPE_ID")
    private StatusType statusType;
}
