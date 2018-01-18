/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.app;

import com.retos.app.injection.Injection;
import com.retos.domain.dispatcher.Dispatcher;
import com.retos.domain.repository.phonecall.PhoneCallRepository;

/**
 *
 * @author darwin.algarin
 */
public class Main {

    public static void main(String[] args) {

        PhoneCallRepository phoneCallRepository = Injection.providePhoneCallRepository();

        Dispatcher dispatcher = Injection.provideDispatcher();
        
        phoneCallRepository.getNextPhoneCallRinning()
                .parallel()
                .forEach(dispatcher::dispatchCall);
    }
    
}
