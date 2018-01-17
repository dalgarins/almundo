/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.domain.usecase;

/**
 *
 * @author darwin.algarin
 */
public interface UseCaseUiThreadPool {
    
    void execute(final Runnable runnable);
    
}
