/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.domain.repository.phonecall;

import com.retos.domain.model.phonecall.PhoneCall;
import java.util.stream.Stream;

/**
 *
 * @author darwin.algarin
 */
public interface PhoneCallRepository {
      
    Stream<PhoneCall> getNextPhoneCallRinning();
    
    Stream<PhoneCall> getNextPhoneCallRinning(int maxNumPhoneCall);
    
}
