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
            
        }

        @Override
        public void onError() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    
    }
    
}
