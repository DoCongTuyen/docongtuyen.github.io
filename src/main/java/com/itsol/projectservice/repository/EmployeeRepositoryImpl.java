package com.itsol.projectservice.repository;

import com.itsol.projectservice.domain.Employee;
import com.itsol.projectservice.service.common.AbstractEntityManagerDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmployeeRepositoryImpl extends AbstractEntityManagerDao<Integer, Employee> {
    private Logger logger = LoggerFactory.getLogger(EmployeeRepositoryImpl.class);

    public Employee getEmployeeById(Integer employeeId){
        try{
            Employee employee = findEntityById(employeeId);
            if (employee != null){
                return employee;
            }

        }catch (Exception e){
            logger.info("Error"+ e.getMessage());
        }
        return null;
    }
}
