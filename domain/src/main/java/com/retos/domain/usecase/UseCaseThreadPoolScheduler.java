/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.domain.usecase;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author darwin.algarin
 */
public class UseCaseThreadPoolScheduler implements UseCaseScheduler {

    private final UseCaseUiThreadPool uiThread;
    
    public static final int POOL_SIZE = 2;

    public static final int MAX_POOL_SIZE = 10;

    public static final int TIMEOUT = 30;

    private ThreadPoolExecutor mThreadPoolExecutor;
    
    public UseCaseThreadPoolScheduler(UseCaseUiThreadPool uiThreadPool) {
        
        this.uiThread = uiThreadPool;
        this.mThreadPoolExecutor = new ThreadPoolExecutor(POOL_SIZE, 
                MAX_POOL_SIZE, TIMEOUT, TimeUnit.SECONDS, 
                new ArrayBlockingQueue<Runnable>(POOL_SIZE));
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
