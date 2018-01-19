/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.app.dispatcher;

import com.retos.domain.async.collection.ObservableQueue;
import com.retos.domain.dispatcher.Dispatcher;
import com.retos.domain.model.employee.Employee;
import com.retos.domain.model.phonecall.PhoneCall;

/**
 *
 * @author darwin.algarin
 */
public class DispatcherImpl implements Dispatcher {
    
    
    private ObservableQueue<PhoneCall> callsOnHold;
    private ObservableQueue<Employee> employeesAvailable;
    
    public DispatcherImpl(ObservableQueue<PhoneCall> callsOnHold, 
            ObservableQueue<Employee> employeesAvailable) {
        
        this.callsOnHold = callsOnHold;
        this.employeesAvailable = employeesAvailable;
    }

    @Override
    public void dispatchCall(PhoneCall call) {

        callsOnHold.add(call);
    }
    
}
