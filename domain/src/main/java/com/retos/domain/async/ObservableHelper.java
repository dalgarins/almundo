/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.domain.async;

import java.util.Observable;

/**
 *
 * @author dalgarins
 */
public class ObservableHelper extends Observable {

    @Override
    public void clearChanged() {
        super.clearChanged();
    }

    @Override
    public void setChanged() {
        super.setChanged();
    }

}
