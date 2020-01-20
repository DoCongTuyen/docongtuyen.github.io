package com.itsol.projectservice.service.Impl;

import com.itsol.projectservice.domain.Department;
import com.itsol.projectservice.dto.DepartmentDto;
import com.itsol.projectservice.repository.DepartmentRepository;
import com.itsol.projectservice.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<DepartmentDto> getAllDepartment() {
        List<Department> list = departmentRepository.findAll();
        modelMapper = new ModelMapper();
        return list.stream().map(department ->
                modelMapper.map(department, DepartmentDto.class)).collect(Collectors.toList());

    }

    @Override
    public void create(Department department) {

    }

    @Override
    public void update(Department department) {

    }

    @Override
    public void delete(long departmentId) {

    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        return null;
    }
}
