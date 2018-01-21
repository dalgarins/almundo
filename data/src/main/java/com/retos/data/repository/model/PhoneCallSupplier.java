/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.data.repository.model;

import com.retos.domain.model.phonecall.PhoneCallModel;
import com.retos.domain.model.phonecall.PhoneCall;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

/**
 * Generator of random calls
 * @author dalgarins
 */
public class PhoneCallSupplier implements Supplier<PhoneCall>{

    @Override
    public PhoneCall get() {
        return new PhoneCallModel.Builder()
                .setIdCall(UUID.randomUUID().toString())
                .setCallStatus(PhoneCall.PhoneCallStatus.RINNING)
                .setTimeofCall(ThreadLocalRandom.current().nextLong(5, 11))
                .build();
    }
    
}
