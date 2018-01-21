/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.domain.usecase;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 *
 * @author darwin.algarin
 */
public class UseCaseThreadPoolScheduler implements UseCaseScheduler {

    private final UseCaseUiThreadPool uiThread;
    
    public static final int MAX_POOL_SIZE = 10;

    private final Executor mThreadPoolExecutor;
    
    public UseCaseThreadPoolScheduler(UseCaseUiThreadPool uiThreadPool) {
        
        this.uiThread = uiThreadPool;
        this.mThreadPoolExecutor = Executors.newFixedThreadPool(MAX_POOL_SIZE);
    }
    
    @Override
    public void execute(Runnable runnable) {
        this.mThreadPoolExecutor.execute(runnable);
    }

    @Override
    public <V extends UseCase.ResponseValue> void notifyResponse(V response, 
            UseCase.UseCaseCallback<V> useCaseCallback) {
        
        uiThread.execute(new Runnable() {
            @Override
            public void run() {
                useCaseCallback.onSuccess(response);
            }
        });
    }

    @Override
    public <V extends UseCase.ResponseValue> void onError(UseCase.UseCaseCallback<V> useCaseCallback) {
        
        uiThread.execute(new Runnable() {
            @Override
            public void run() {
                useCaseCallback.onError();
            }
        });
    }
    
}
