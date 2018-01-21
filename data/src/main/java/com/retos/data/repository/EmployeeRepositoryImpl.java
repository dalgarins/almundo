/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.data.repository;

import com.retos.data.factory.EmployeeFactory;
import com.retos.domain.model.employee.Employee;
import com.retos.domain.model.employee.Support;
import com.retos.domain.repository.employee.EmployeeRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author dalgarins
 */
public class EmployeeRepositoryImpl implements EmployeeRepository {
    
    private EmployeeFactory factory;
    
    public EmployeeRepositoryImpl(EmployeeFactory factory) {
        
        this.factory = factory;
    }

    @Override
    public List<Employee> getEmployees() {
        
        List<Employee> response = new ArrayList<>();
        
        response.add(factory.getEmployee(UUID.randomUUID().toString(), "Empleado 9", Support.SupportLevel.LEVEL_3));
        response.add(factory.getEmployee(UUID.randomUUID().toString(), "Empleado 10", Support.SupportLevel.LEVEL_3));
        
        response.add(factory.getEmployee(UUID.randomUUID().toString(), "Empleado 1", Support.SupportLevel.LEVEL_1));
        response.add(factory.getEmployee(UUID.randomUUID().toString(), "Empleado 2", Support.SupportLevel.LEVEL_1));
        response.add(factory.getEmployee(UUID.randomUUID().toString(), "Empleado 3", Support.SupportLevel.LEVEL_1));
        response.add(factory.getEmployee(UUID.randomUUID().toString(), "Empleado 4", Support.SupportLevel.LEVEL_1));
        response.add(factory.getEmployee(UUID.randomUUID().toString(), "Empleado 5", Support.SupportLevel.LEVEL_1));
        
        response.add(factory.getEmployee(UUID.randomUUID().toString(), "Empleado 6", Support.SupportLevel.LEVEL_2));
        response.add(factory.getEmployee(UUID.randomUUID().toString(), "Empleado 7", Support.SupportLevel.LEVEL_2));
        response.add(factory.getEmployee(UUID.randomUUID().toString(), "Empleado 8", Support.SupportLevel.LEVEL_2));
               
        return response;
    }
    
}
