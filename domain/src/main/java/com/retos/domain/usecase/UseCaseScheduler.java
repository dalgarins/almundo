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
public interface UseCaseScheduler {
    
    void execute(Runnable runnable);
    
    <V extends UseCase.ResponseValue> void notifyResponse(final V response,  
            final UseCase.UseCaseCallback<V> useCaseCallback);
    
    <V extends UseCase.ResponseValue> void onError(final UseCase.UseCaseCallback<V> useCaseCallback);
    
}
