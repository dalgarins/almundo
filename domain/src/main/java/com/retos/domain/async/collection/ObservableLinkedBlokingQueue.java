/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.domain.async.collection;

import com.retos.domain.async.ObservableHelper;
import com.retos.domain.async.Subscriber;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author dalgarins
 */
public class ObservableLinkedBlokingQueue <E> extends LinkedBlockingQueue<E> implements Subscriber<E>, ObservableQueue<E> {

    private ObservableHelper observable = new ObservableHelper();

    @Override
    public boolean add(E e) {
        if (super.add(e)) {
            notifyObservers();
            return true;
        }
        return false; //To change body of generated methods, choose Tools | Templates.
    }    
    
    @Override
    public void addObserver(Observer o) {
        observable.addObserver(o);
    }

    @Override
    public void deleteObserver(Observer o) {
        observable.deleteObserver(o);
    }

    @Override
    public void deleteObservers() {
        observable.deleteObservers();
    }

    @Override
    public void notifyObservers() {
        observable.setChanged();
        observable.notifyObservers();
    }
    
}
