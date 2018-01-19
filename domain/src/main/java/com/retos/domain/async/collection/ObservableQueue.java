/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.domain.async.collection;

import com.retos.domain.async.Subscriber;
import java.util.Queue;

/**
 *
 * @author dalgarins
 */
public interface ObservableQueue <E> extends Queue<E>, Subscriber<E> {
    
        
}
