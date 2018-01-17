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
public class UseCaseHandler {
    
    private static UseCaseHandler INSTANCE;
    
    private final UseCaseScheduler useCaseScheduler;
    
    public UseCaseHandler(UseCaseScheduler useCaseScheduler) {
        
        this.useCaseScheduler = useCaseScheduler;
    }
    
    public <T extends UseCase.RequestValues, R extends UseCase.ResponseValue> void execute(
            final UseCase<T, R> useCase, T values, UseCase.UseCaseCallback<R> callback) {
    
        useCase.setRequestValues(values);
        useCase.setUseCaseCallback(new UiCallbackWrapper<> (callback, this));
        
        useCaseScheduler.execute(new Runnable() {
            @Override
            public void run() {
                useCase.run();
            }
        });
    }
    
    public <V extends UseCase.ResponseValue> void notifyResponse(final V response, 
            final UseCase.UseCaseCallback<V> useCaseCallback) {
        
        this.useCaseScheduler.notifyResponse(response, useCaseCallback);
    }
    
    public <V extends UseCase.ResponseValue> void notifyError(
            final UseCase.UseCaseCallback<V> useCaseCallback) {
        
        this.useCaseScheduler.onError(useCaseCallback);
    }
    
    private static final class UiCallbackWrapper<V extends UseCase.ResponseValue> implements 
            UseCase.UseCaseCallback<V> {

        private final UseCase.UseCaseCallback<V> mCallback;
        private final UseCaseHandler mUseCaseHandler;
        
        public UiCallbackWrapper(UseCase.UseCaseCallback<V> callback, 
                UseCaseHandler useCaseHandler){
        
            this.mCallback = callback;
            this.mUseCaseHandler = useCaseHandler;
        }
        
        @Override
        public void onSuccess(V response) {
            
            this.mUseCaseHandler.notifyResponse(response, mCallback);
        }

        @Override
        public void onError() {

            this.mUseCaseHandler.notifyError(mCallback);
        }   
    }
    
    public static UseCaseHandler getInstance(UseCaseUiThreadPool mHandler) {
        if (INSTANCE == null) {
            INSTANCE = new UseCaseHandler(new UseCaseThreadPoolScheduler(mHandler));
        }
        return INSTANCE;
    }
    
}
