/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.data.repository.model;

import com.retos.domain.model.phonecall.PhoneCall;
import java.util.function.Supplier;

/**
 *
 * @author dalgarins
 */
public class PhoneCallSupplier implements Supplier<PhoneCall>{

    @Override
    public PhoneCall get() {
        return new PhoneCallImpl();
    }
    
}
