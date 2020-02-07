package com.itsol.projectservice.repository;

import com.itsol.projectservice.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRRepository extends JpaRepository<Project,Integer> {
}
