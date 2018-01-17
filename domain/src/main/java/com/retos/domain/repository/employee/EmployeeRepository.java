/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.domain.repository.employee;

import com.retos.domain.model.employee.Employee;

/**
 *
 * @author darwin.algarin
 */
public interface EmployeeRepository {
    
    Employee getFreeEmployee();
    
}
