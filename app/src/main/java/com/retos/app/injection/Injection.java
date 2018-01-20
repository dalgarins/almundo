/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.app.injection;

import com.retos.app.dispatcher.DispatcherImpl;
import com.retos.app.dispatcher.ObserverDispatcherImpl;
import com.retos.app.ui.executor.UiThreadImpl;
import com.retos.data.factory.EmployeeFactory;
import com.retos.data.repository.EmployeeRepositoryImpl;
import com.retos.data.repository.PhoneCallRepositoryImpl;
import com.retos.data.repository.RepositoryImpl;
import com.retos.domain.async.collection.ObservableLinkedBlockingQueue;
import com.retos.domain.async.collection.ObservablePriorityBlockingQueue;
import com.retos.domain.dispatcher.Dispatcher;
import com.retos.domain.model.employee.Employee;
import com.retos.domain.model.phonecall.PhoneCall;
import com.retos.domain.repository.Repository;
import com.retos.domain.repository.employee.EmployeeRepository;
import com.retos.domain.repository.phonecall.PhoneCallRepository;
import com.retos.domain.usecase.UseCase;
import com.retos.domain.usecase.UseCaseHandler;
import com.retos.domain.usecase.UseCaseUiThreadPool;
import com.retos.domain.usecase.employee.AnswerCall;
import java.util.Comparator;
import java.util.Observer;
import java.util.Queue;

/**
 *
 * @author darwin.algarin
 */
public final class Injection {

    private Injection() {
    }

    public static EmployeeFactory provideEmployeeFactory() {
        return EmployeeFactory.getInstance();
    }

    private static UseCaseUiThreadPool provideUiThreadPool() {

        return UiThreadImpl.getInstance();
    }

    public static UseCaseHandler provideUseCaseHandler() {

        return UseCaseHandler.getInstance(provideUiThreadPool());
    }

    public static AnswerCall provideUseCaseAnswerCall() {

        return new AnswerCall();
    }

    public static AnswerCall.RequestValues provideRequestAnswerCall(Employee employee, PhoneCall phoneCall) {

        return new AnswerCall.RequestValues(employee, phoneCall);
    }

    public static UseCase.UseCaseCallback<AnswerCall.ResponseValues> provideCallBackAnswerCall(Queue<Employee> employee) {

        return new UseCase.UseCaseCallback<AnswerCall.ResponseValues>() {

            @Override
            public void onSuccess(AnswerCall.ResponseValues response) {
                
                employee.offer(response.getEmployee());  
                System.out.println("Ok: " + response.getEmployee().getName() + " " + response.getEmployee().getLevelOfSupport());
            }

            @Override
            public void onError() {
                
                System.err.println("Ocurrio un error al procesar la llamada");
            }
        };
    }

    private static PhoneCallRepository providePhoneCallRepository() {

        return new PhoneCallRepositoryImpl();
    }

    private static EmployeeRepository provideEmployeeRepository() {

        return new EmployeeRepositoryImpl(provideEmployeeFactory());
    }

    public static Repository provideRepository() {

        return new RepositoryImpl(provideEmployeeRepository(), providePhoneCallRepository());
    }

    private static ObservableLinkedBlockingQueue<PhoneCall> provideObservableListPhoneCall() {

        return new ObservableLinkedBlockingQueue<>();
    }

    public static ObservablePriorityBlockingQueue<Employee> provideObservableListEmployee() {

        return new ObservablePriorityBlockingQueue<>(provideComparatorPriority());
    }
    
    private static Comparator<Employee> provideComparatorPriority() {
        
        return new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getLevelOfSupport().getLevel() - o2.getLevelOfSupport().getLevel();
            }
        };
    }

    public static Observer provideObserverDispatcher(Queue<PhoneCall> phoneCalls,
            Queue<Employee> employees,
            UseCaseHandler useCaseHandler) {

        return new ObserverDispatcherImpl(phoneCalls, employees, useCaseHandler);
    }    

    public static Dispatcher provideDispatcher() {

        return new DispatcherImpl(
                provideRepository(),
                provideObservableListPhoneCall(),
                provideObservableListEmployee(),
                provideUseCaseHandler()
        );
    }

}
