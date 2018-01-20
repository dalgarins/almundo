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
import com.retos.domain.usecase.UseCaseHandler;
import java.util.Observer;

/**
 *
 * @author darwin.algarin
 */
public class DispatcherImpl implements Dispatcher {
    
    
    private ObservableQueue<PhoneCall> callsOnHold;
    private ObservableQueue<Employee> employeesAvailable;
    private Observer observerDispatcher;
    
    public DispatcherImpl(Repository repository,
            ObservableQueue<PhoneCall> callsOnHold, 
            ObservableQueue<Employee> employeesAvailable, 
            UseCaseHandler useCaseHandler) {
        
        this.observerDispatcher = Injection.provideObserverDispatcher(callsOnHold, employeesAvailable, useCaseHandler);
               
        this.callsOnHold = callsOnHold;   
        this.callsOnHold.addObserver(observerDispatcher);
        
        this.employeesAvailable = employeesAvailable;
        
        this.employeesAvailable.addObserver(observerDispatcher);
        this.employeesAvailable.addAll(repository.getEmployees());
    }

    @Override
    public void dispatchCall(PhoneCall call) {

        callsOnHold.offer(call);
    }
    
}
