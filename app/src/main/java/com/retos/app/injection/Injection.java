/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.app.injection;

import com.retos.app.dispatcher.DispatcherImpl;
import com.retos.app.ui.executor.UiThreadImpl;
import com.retos.data.repository.PhoneCallRepositoryImpl;
import com.retos.domain.async.collection.ObservableLinkedBlokingQueue;
import com.retos.domain.dispatcher.Dispatcher;
import com.retos.domain.model.employee.Employee;
import com.retos.domain.model.phonecall.PhoneCall;
import com.retos.domain.repository.phonecall.PhoneCallRepository;
import com.retos.domain.usecase.UseCaseHandler;
import com.retos.domain.usecase.UseCaseUiThreadPool;

/**
 *
 * @author darwin.algarin
 */
public final class Injection {
    
    private Injection(){}
    
    private static UseCaseUiThreadPool provideUiThreadPool() {
        
        return UiThreadImpl.getInstance();
    }
    
    public static UseCaseHandler provideUseCaseHandler() {
        
        return UseCaseHandler.getInstance(provideUiThreadPool());
    }
    
    public static PhoneCallRepository providePhoneCallRepository() {
        
        return new PhoneCallRepositoryImpl();
    }
    
    private static ObservableLinkedBlokingQueue<PhoneCall> provideObservableListPhoneCall() {
        
        return new ObservableLinkedBlokingQueue<>();
    }
    
    public static ObservableLinkedBlokingQueue<Employee> provideObservableListEmployee() {
        
        return new ObservableLinkedBlokingQueue<>();
    }
    
    public static Dispatcher provideDispatcher() {
        
        return new DispatcherImpl(provideObservableListPhoneCall(), provideObservableListEmployee());
    }
    
}
