/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.domain.model.phonecall;

import com.retos.domain.model.phonecall.PhoneCall;

/**
 *
 * @author dalgarins
 */
public class PhoneCallModel implements PhoneCall {
    
    private String idCall;
    private PhoneCallStatus callStatus;
    private Long timeOfCall;
    
    protected PhoneCallModel(String idCall, PhoneCallStatus callStatus, Long timeOfCall) {
        
        this.idCall = idCall;
        this.callStatus = callStatus;
        this.timeOfCall = timeOfCall;
    }
    
    @Override
    public String getId() {
        return idCall;
    }

    @Override
    public PhoneCallStatus getCallStatus() {
        return callStatus;
    }
    
    @Override
    public Long getTimeOfCall() {
        
        return timeOfCall;
    }
    
    public static class Builder {
        
        private String idCall;
        private PhoneCallStatus callStatus;
        private Long timeOfCall;
        
        public Builder setIdCall(String idCall){
            this.idCall = idCall;
            return this;
        }
        
        public Builder setCallStatus(PhoneCallStatus callStatus) {
            this.callStatus = callStatus;
            return this;
        }
        
        public Builder setTimeofCall(Long timeOfcall) {
            this.timeOfCall = timeOfcall;
            return this;
        }
        
        public PhoneCall build(){
            return new PhoneCallModel(idCall, callStatus, timeOfCall);
        }        
    }   
}
