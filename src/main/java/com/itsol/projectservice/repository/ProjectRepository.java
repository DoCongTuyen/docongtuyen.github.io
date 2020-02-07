package com.itsol.projectservice.repository;

import com.itsol.projectservice.domain.Project;
import com.itsol.projectservice.service.common.GennerEntityManagerDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends GennerEntityManagerDAO<Integer, Project> {
}
