/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.app.injection;

import com.retos.app.dispatcher.DispatcherImpl;
import com.retos.data.repository.PhoneCallRepositoryImpl;
import com.retos.domain.dispatcher.Dispatcher;
import com.retos.domain.repository.phonecall.PhoneCallRepository;

/**
 *
 * @author darwin.algarin
 */
public final class Injection {
    
    private Injection(){}
    
    public static PhoneCallRepository providePhoneCallRepository() {
        
        return new PhoneCallRepositoryImpl();
    }
    
    public static Dispatcher provideDispatcher() {
        
        return new DispatcherImpl();
    }
    
}
