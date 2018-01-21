/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.domain.async.collection;

import com.retos.domain.async.ObservableHelper;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author dalgarins
 */
public class ObservableLinkedBlockingQueue <E> extends LinkedBlockingQueue<E> implements ObservableQueue<E> {

    private ObservableHelper observable = new ObservableHelper();
    
    @Override
    public synchronized boolean offer(E e) {
        if (super.offer(e)) {
            notifyObservers();
            return true;
        }
        return false;
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
