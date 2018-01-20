/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.domain.async.collection;

import com.retos.domain.async.ObservableHelper;
import java.util.Comparator;
import java.util.Observer;
import java.util.concurrent.PriorityBlockingQueue;

/**
 *
 * @author dalgarins
 */
public class ObservablePriorityBlockingQueue <E> extends PriorityBlockingQueue<E> implements ObservableQueue<E> {
    
    private ObservableHelper observable = new ObservableHelper();
    
    public ObservablePriorityBlockingQueue(Comparator<E> comparator) {
        super(10, comparator);
    }

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
