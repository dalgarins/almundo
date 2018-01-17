/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.domain.repository.phonecall;

import com.retos.domain.model.phonecall.PhoneCall;

/**
 *
 * @author darwin.algarin
 */
public interface PhoneCallRepository {
    
    PhoneCall getNextPhoneCallRinning();
    
}
