/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.data.repository;

import com.retos.domain.model.employee.Employee;
import com.retos.domain.model.phonecall.PhoneCall;
import com.retos.domain.repository.Repository;
import com.retos.domain.repository.employee.EmployeeRepository;
import com.retos.domain.repository.phonecall.PhoneCallRepository;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author dalgarins
 */
public class RepositoryImpl implements Repository {

    private PhoneCallRepository phoneRepository;
    private EmployeeRepository employeeRepository;
    
    public RepositoryImpl(EmployeeRepository employeeRepository, PhoneCallRepository phoneRepository) {
        
        this.employeeRepository = employeeRepository;
        this.phoneRepository = phoneRepository;
    }
    
    @Override
    public Stream<PhoneCall> getNextPhoneCallRinning() {

        return phoneRepository.getNextPhoneCallRinning();
    }

    @Override
    public Stream<PhoneCall> getNextPhoneCallRinning(int maxNumPhoneCall) {

        return phoneRepository.getNextPhoneCallRinning(maxNumPhoneCall);
    }

    @Override
    public List<Employee> getEmployees() {

        return employeeRepository.getEmployees();
    }
    
}
