/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.data.factory;

import com.retos.data.repository.model.employee.DirectorModel;
import com.retos.data.repository.model.employee.OperatorModel;
import com.retos.data.repository.model.employee.SupervisorModel;
import com.retos.domain.model.employee.Employee;
import com.retos.domain.model.employee.Support;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dalgarins
 */
public class EmployeeFactoryTest {
    
    public EmployeeFactoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void shouldReturnAnOperatorEmployee() {
        
        Employee employee = EmployeeFactory.getInstance().getEmployee("1", "operador", Support.SupportLevel.LEVEL_1);
        
        assertTrue(employee instanceof OperatorModel);
    }
    
    @Test
    public void shouldReturnAnSupervisorEmployee() {
        
        Employee employee = EmployeeFactory.getInstance().getEmployee("1", "supervisor", Support.SupportLevel.LEVEL_2);
        
        assertTrue(employee instanceof SupervisorModel);
    }
    
    @Test
    public void shouldReturnAnDirectorEmployee() {
        
        Employee employee = EmployeeFactory.getInstance().getEmployee("1", "director", Support.SupportLevel.LEVEL_3);
        
        assertTrue(employee instanceof DirectorModel);        
    }
}
