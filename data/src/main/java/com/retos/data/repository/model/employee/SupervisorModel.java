/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.data.repository.model.employee;

import com.retos.domain.model.employee.Employee;
import com.retos.domain.model.employee.Support;

/**
 *
 * @author darwin.algarin
 */
public class SupervisorModel extends Employee implements Support {
    
    private SupportLevel supportLevel;
    
    protected SupervisorModel(String id, String name, SupportLevel supportLevel) {
        super(id, name);
        this.supportLevel = supportLevel;
    }
    
    @Override
    public SupportLevel getLevelOfSupport() {
        return this.supportLevel;
    }
    
    public static class Builder {
        
        private String id;
        private String name;
        private SupportLevel supportLevel;
        
        public Builder setId(String id) {
            this.id = id;
            return this;
        }
        
        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        
        public Builder setSupportLevel(SupportLevel level) {
            this.supportLevel = level;
            return this;
        }
        
        public SupervisorModel build() {
            return new SupervisorModel(id, name, supportLevel);
        }
        
    }
    
}
