package com.itsol.projectservice.repository;

import com.itsol.projectservice.domain.Eproject;
import com.itsol.projectservice.service.common.AbstractEntityManagerDao;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectGroupRepositoryImpl extends AbstractEntityManagerDao<Integer, Eproject> implements ProjectGroupRepository {
}
