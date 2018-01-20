/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.domain.usecase.employee;

import com.retos.domain.model.employee.Employee;
import com.retos.domain.model.phonecall.PhoneCall;
import com.retos.domain.usecase.UseCase;

/**
 *
 * @author darwin.algarin
 */
public class AnswerCall extends UseCase<AnswerCall.RequestValues, AnswerCall.ResponseValues> {

    private static int FROM_MILIS_TO_SECONDS = 1000;
    
    public AnswerCall() {
        
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {

        try {
            Thread.sleep(requestValues.getPhoneCall().getTimeOfCall() * FROM_MILIS_TO_SECONDS);
        } catch (Exception e) {
            getUseCaseCallback().onError();
        }
        getUseCaseCallback().onSuccess(new ResponseValues(requestValues.getEmployee()));
    }    
     
    public final static class RequestValues implements UseCase.RequestValues {
        
        private Employee employee;
        private PhoneCall phoneCall;
        
        public RequestValues(Employee employee, PhoneCall phoneCall) {
            
            this.employee = employee;
            this.phoneCall = phoneCall;
        }  

        public Employee getEmployee() {
            return employee;
        }

        public PhoneCall getPhoneCall() {
            return phoneCall;
        }        
    }
    
    public final static class ResponseValues implements UseCase.ResponseValue {
        
        private Employee employee;
        
        public ResponseValues(Employee employee) {
            this.employee = employee;
        }
        
        public Employee getEmployee() {
            return employee;
        }        
    }

}
