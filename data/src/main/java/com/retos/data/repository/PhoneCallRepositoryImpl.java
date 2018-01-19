/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.data.repository;

import com.retos.domain.model.phonecall.PhoneCall;
import com.retos.data.repository.model.PhoneCallSupplier;
import com.retos.domain.repository.phonecall.PhoneCallRepository;
import java.util.stream.Stream;

/**
 *
 * @author dalgarins
 */
public class PhoneCallRepositoryImpl implements PhoneCallRepository {

    @Override
    public Stream<PhoneCall> getNextPhoneCallRinning() {
        
        return Stream.generate(new PhoneCallSupplier());
    }

    @Override
    public Stream<PhoneCall> getNextPhoneCallRinning(int maxNumPhoneCall) {
        
        return this.getNextPhoneCallRinning().limit(maxNumPhoneCall);
    }
    
}
