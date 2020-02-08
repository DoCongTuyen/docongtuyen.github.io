package com.itsol.backend.repository;

import com.itsol.backend.domain.StatusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusTypeRepository extends JpaRepository<StatusType,Long> {
}
