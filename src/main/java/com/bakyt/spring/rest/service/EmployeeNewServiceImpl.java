package com.bakyt.spring.rest.service;

import com.bakyt.spring.rest.dao.EmployeeNewDAO;
import com.bakyt.spring.rest.entity.EmployeeNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeNewServiceImpl implements EmployeeNewService {

    @Autowired
    private EmployeeNewDAO employeeNewDAO;

    @Override
    @Transactional
    public List<EmployeeNew> getAllEmployees() {
        return employeeNewDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(EmployeeNew employeeNew) {
        employeeNewDAO.saveEmployee(employeeNew);
    }

    @Override
    @Transactional
    public EmployeeNew getEmployee(int id) {
        return employeeNewDAO.getEmployee(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeNewDAO.deleteEmployee(id);
    }


}
