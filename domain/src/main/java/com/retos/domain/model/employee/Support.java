/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.domain.model.employee;

/**
 *
 * @author darwin.algarin
 */
public interface Support {
    
    public enum SupportLevel {
        
        LEVEL_1(1), LEVEL_2(2), LEVEL_3(3);
        
        int value;

        private SupportLevel(int value) {
            this.value = value;
        }
        
        public int getLevel(){
            return this.value;
        }        
    }
       
    SupportLevel getLevelOfSupport();
    
}
