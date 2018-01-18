/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.domain.dispatcher;

import com.retos.domain.model.phonecall.PhoneCall;

/**
 *
 * @author dalgarins
 */
public interface Dispatcher {
    
    void dispatchCall(PhoneCall call);
    
}
