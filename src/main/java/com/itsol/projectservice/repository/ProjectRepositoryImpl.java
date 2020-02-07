package com.itsol.projectservice.repository;


import com.itsol.projectservice.domain.Project;
import com.itsol.projectservice.service.common.AbstractEntityManagerDao;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectRepositoryImpl extends AbstractEntityManagerDao<Integer, Project> implements ProjectRepository {
}
