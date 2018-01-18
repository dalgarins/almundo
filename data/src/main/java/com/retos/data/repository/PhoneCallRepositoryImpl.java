/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.data.repository;

import com.retos.domain.model.phonecall.PhoneCall;
import com.retos.domain.repository.phonecall.PhoneCallRepository;
import java.util.stream.Stream;

/**
 *
 * @author dalgarins
 */
public class PhoneCallRepositoryImpl implements PhoneCallRepository {

    @Override
    public Stream<PhoneCall> getNextPhoneCallRinning() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Stream<PhoneCall> getNextPhoneCallRinning(int maxNumPhoneCall) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
