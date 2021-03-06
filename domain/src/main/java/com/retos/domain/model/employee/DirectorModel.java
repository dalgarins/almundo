/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.domain.model.employee;

import com.retos.domain.model.employee.Employee;

/**
 *
 * @author darwin.algarin
 */
public class DirectorModel extends Employee {

    private SupportLevel supportLevel;
    
    protected DirectorModel(String id, String name, SupportLevel supportLevel) {
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
        
        public DirectorModel build() {
            return new DirectorModel(id, name, supportLevel);
        }        
    }
    
}
