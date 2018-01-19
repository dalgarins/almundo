/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.app.ui.executor;

import com.retos.domain.usecase.UseCaseUiThreadPool;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author dalgarins
 */
public final class UiThreadImpl implements UseCaseUiThreadPool {
    
    private static class SingletonHelper {
        private static final UiThreadImpl INSTANCE = new UiThreadImpl();
    }
    
    public static UiThreadImpl getInstance() {
        return SingletonHelper.INSTANCE;
    }
    
    private UiThreadImpl() {}
    
    private final ExecutorService executor = Executors.newCachedThreadPool();

    @Override
    public void execute(Runnable runnable) {
        executor.execute(runnable);
    }    
}
