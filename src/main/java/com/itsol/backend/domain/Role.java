package com.itsol.backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ROLE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUTO_INCRE_SEQ_ROLE")
    @SequenceGenerator(sequenceName = "AUTO_INCRE_SEQ_ROLE", allocationSize = 1, name = "AUTO_INCRE_SEQ_ROLE")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Set<Employee> employees = new HashSet<>();
}
