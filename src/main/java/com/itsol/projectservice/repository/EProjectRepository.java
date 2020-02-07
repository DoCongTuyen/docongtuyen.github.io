package com.itsol.projectservice.repository;

import com.itsol.projectservice.domain.Employee;
import com.itsol.projectservice.domain.Eproject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EProjectRepository extends JpaRepository<Eproject, Integer> {
    Eproject findEprojectByEmployee(Employee employee);

    Eproject findEprojectByIdAndEmployee(int eProject_Id, Employee employee);

}
