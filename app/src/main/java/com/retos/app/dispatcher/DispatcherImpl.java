/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.app.dispatcher;

import com.retos.app.injection.Injection;
import com.retos.domain.async.collection.ObservableQueue;
import com.retos.domain.dispatcher.Dispatcher;
import com.retos.domain.model.employee.Employee;
import com.retos.domain.model.phonecall.PhoneCall;
import com.retos.domain.repository.Repository;

/**
 *
 * @author darwin.algarin
 */
public class DispatcherImpl implements Dispatcher {
    
    
    private ObservableQueue<PhoneCall> callsOnHold;
    private ObservableQueue<Employee> employeesAvailable;
    private Repository repository;
    
    public DispatcherImpl(Repository repository,
            ObservableQueue<PhoneCall> callsOnHold, 
            ObservableQueue<Employee> employeesAvailable) {
        
        this.repository = repository;
        
        this.callsOnHold = callsOnHold;   
        this.callsOnHold.addObserver(Injection.provideObserverQueuePhone(callsOnHold));
        
        this.employeesAvailable = employeesAvailable;
        this.employeesAvailable.addObserver(Injection.provideObserverQueueEmployee(employeesAvailable));
    }

    @Override
    public void dispatchCall(PhoneCall call) {

        callsOnHold.offer(call);
    }
    
}
