/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.domain.async.collection;

import java.util.Observer;

/**
 *
 * @author dalgarins
 */
public interface ObservableQueue <E> {
    
    public boolean add(E e);
    
    public void addObserver(Observer o);
    
}
