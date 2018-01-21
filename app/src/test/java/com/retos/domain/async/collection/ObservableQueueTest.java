/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.domain.async.collection;

import com.retos.data.factory.EmployeeFactory;
import com.retos.domain.model.employee.Employee;
import com.retos.domain.model.employee.Support;
import java.util.Observable;
import java.util.Observer;
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
public class ObservableQueueTest {
                    
    public ObservableQueueTest() {
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
    public void souldCallObserverWhenAddInQueue() {
        
        ObservableQueue<Employee> queue = new ObservableLinkedBlockingQueue<>();
        
        Observer observer = new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                assertNotNull(queue.poll());
            }
        };
        
        Employee employee1 = EmployeeFactory.getInstance().getEmployee("1", "darwin", Support.SupportLevel.LEVEL_1);
               
        queue.addObserver(observer);
        queue.offer(employee1);
    }    
}
