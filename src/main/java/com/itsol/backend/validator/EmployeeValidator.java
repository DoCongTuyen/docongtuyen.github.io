package com.itsol.backend.validator;

import com.itsol.backend.dto.EmployeeDto;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EmployeeValidator implements Validator {

    private EmailValidator emailValidator = EmailValidator.getInstance();

    private EmployeeDto employeeDto;
    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {

    }
}
