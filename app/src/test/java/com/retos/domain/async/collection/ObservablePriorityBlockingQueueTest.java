/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.domain.async.collection;

import com.retos.data.factory.EmployeeFactory;
import com.retos.domain.model.employee.Employee;
import com.retos.domain.model.employee.Support;
import java.util.Comparator;
import java.util.Queue;
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
public class ObservablePriorityBlockingQueueTest {
    
    public ObservablePriorityBlockingQueueTest() {
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

    @Test
    public void shouldReturnAEmployeeWithLowerPriorityLevelSupport() {
        
        /**
         * Given
         */
        Employee employeeLvel1 = EmployeeFactory.getInstance().getEmployee("1", "Operador", Support.SupportLevel.LEVEL_1);
        Employee employeeLvel2 = EmployeeFactory.getInstance().getEmployee("2", "Supervisor", Support.SupportLevel.LEVEL_2);
        Employee employeeLvel3 = EmployeeFactory.getInstance().getEmployee("3", "Director", Support.SupportLevel.LEVEL_3);
        
        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getLevelOfSupport().getLevel() - o2.getLevelOfSupport().getLevel();
            }
        };

        /**
         * When
         */
        Queue<Employee> queueEmployees = new ObservablePriorityBlockingQueue(comparator);
        queueEmployees.add(employeeLvel3);
        queueEmployees.add(employeeLvel2);
        queueEmployees.add(employeeLvel1);
        
        /**
         * Then
         */
        assertEquals(employeeLvel1, queueEmployees.poll());        
    }
}
