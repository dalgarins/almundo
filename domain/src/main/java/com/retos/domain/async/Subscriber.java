/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.domain.async;

import java.util.Observer;

/**
 *
 * @author dalgarins
 */
public interface Subscriber<T> {

    public void addObserver(Observer o);

    public void deleteObserver(Observer o);

    public void deleteObservers();

    public void notifyObservers();

}
