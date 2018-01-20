/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.domain.model.phonecall;

/**
 *
 * @author darwin.algarin
 */
public interface PhoneCall {
    
    public enum PhoneCallStatus {
        
        RINNING, ANSWER, END 
        
    }
    
    String getId();
    
    PhoneCallStatus getCallStatus();
    
    Long getTimeOfCall();
    
}
