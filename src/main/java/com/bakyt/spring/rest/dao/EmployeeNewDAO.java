package com.bakyt.spring.rest.dao;

import com.bakyt.spring.rest.entity.EmployeeNew;

import java.util.List;

public interface EmployeeNewDAO {

    public List<EmployeeNew> getAllEmployees();

    public  void saveEmployee(EmployeeNew employeeNew);

    public EmployeeNew getEmployee(int id);

    public  void deleteEmployee(int id);
}
