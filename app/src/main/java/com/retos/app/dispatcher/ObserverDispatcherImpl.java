/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.app.dispatcher;

import com.retos.app.injection.Injection;
import com.retos.domain.model.employee.Employee;
import com.retos.domain.model.phonecall.PhoneCall;
import com.retos.domain.usecase.UseCaseHandler;
import java.util.Observable;
import java.util.Observer;
import java.util.Queue;

/**
 * Concrete implementation to assign a call to an free employee
 * @author dalgarins
 */
public class ObserverDispatcherImpl implements Observer {

    private Queue<PhoneCall> phoneCalls;
    private Queue<Employee> employees;

    private UseCaseHandler useCaseHandler;

    public ObserverDispatcherImpl(Queue<PhoneCall> phoneCalls,
            Queue<Employee> employees,
            UseCaseHandler useCaseHandler) {

        this.phoneCalls = phoneCalls;
        this.employees = employees;
        this.useCaseHandler = useCaseHandler;
    }

    @Override
    public void update(Observable o, Object arg) {
       
        Employee opt = employees.peek();        
        PhoneCall phoneCall = phoneCalls.peek();
        if (phoneCall != null && opt != null) {
            this.useCaseHandler.execute(Injection.provideUseCaseAnswerCall(),
                    Injection.provideRequestAnswerCall(employees.poll(), phoneCalls.poll()),
                    Injection.provideCallBackAnswerCall(employees));
        }
    }

}
