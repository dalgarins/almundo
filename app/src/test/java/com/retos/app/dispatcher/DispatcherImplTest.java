/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.app.dispatcher;

import com.retos.app.ui.executor.UiThreadImpl;
import com.retos.data.factory.EmployeeFactory;
import com.retos.data.repository.PhoneCallRepositoryImpl;
import com.retos.data.repository.RepositoryImpl;
import com.retos.data.repository.model.employee.DirectorModel;
import com.retos.domain.async.collection.ObservableLinkedBlockingQueue;
import com.retos.domain.async.collection.ObservablePriorityBlockingQueue;
import com.retos.domain.async.collection.ObservableQueue;
import com.retos.domain.dispatcher.Dispatcher;
import com.retos.domain.model.employee.Employee;
import com.retos.domain.model.employee.Support;
import com.retos.domain.model.phonecall.PhoneCall;
import com.retos.domain.repository.Repository;
import com.retos.domain.repository.employee.EmployeeRepository;
import com.retos.domain.repository.phonecall.PhoneCallRepository;
import com.retos.domain.usecase.UseCaseHandler;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dalgarins
 */
public class DispatcherImplTest {

    private EmployeeRepository emptyEmployeeRepository;

    private EmployeeRepository fullEmployeeRepository;

    private PhoneCallRepository phoneCallRepository;

    private Comparator<Employee> comparator;
    
    public DispatcherImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        emptyEmployeeRepository = new EmployeeRepository() {
            @Override
            public List<Employee> getEmployees() {

                return new ArrayList<>();
            }
        };

        fullEmployeeRepository = new EmployeeRepository() {
            @Override
            public List<Employee> getEmployees() {

                List<Employee> response = new ArrayList<>();

                response.add(EmployeeFactory.getInstance().getEmployee(UUID.randomUUID().toString(), "Empleado 9", Support.SupportLevel.LEVEL_3));
                response.add(EmployeeFactory.getInstance().getEmployee(UUID.randomUUID().toString(), "Empleado 10", Support.SupportLevel.LEVEL_2));

                response.add(EmployeeFactory.getInstance().getEmployee(UUID.randomUUID().toString(), "Empleado 1", Support.SupportLevel.LEVEL_1));
                response.add(EmployeeFactory.getInstance().getEmployee(UUID.randomUUID().toString(), "Empleado 2", Support.SupportLevel.LEVEL_1));
                response.add(EmployeeFactory.getInstance().getEmployee(UUID.randomUUID().toString(), "Empleado 3", Support.SupportLevel.LEVEL_1));
                response.add(EmployeeFactory.getInstance().getEmployee(UUID.randomUUID().toString(), "Empleado 4", Support.SupportLevel.LEVEL_1));
                response.add(EmployeeFactory.getInstance().getEmployee(UUID.randomUUID().toString(), "Empleado 5", Support.SupportLevel.LEVEL_1));

                response.add(EmployeeFactory.getInstance().getEmployee(UUID.randomUUID().toString(), "Empleado 6", Support.SupportLevel.LEVEL_2));
                response.add(EmployeeFactory.getInstance().getEmployee(UUID.randomUUID().toString(), "Empleado 7", Support.SupportLevel.LEVEL_2));
                response.add(EmployeeFactory.getInstance().getEmployee(UUID.randomUUID().toString(), "Empleado 8", Support.SupportLevel.LEVEL_2));

                return response;
            }
        };

        phoneCallRepository = new PhoneCallRepositoryImpl();

        comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getLevelOfSupport().getLevel() - o2.getLevelOfSupport().getLevel();
            }
        };

    }

    @After
    public void tearDown() {
    }

    @Test
    public void given0EmployeesSouldGlueCalls() {

        int numberOfCalls = 10;

        Repository repository = new RepositoryImpl(
                emptyEmployeeRepository,
                phoneCallRepository);
        ObservableQueue<PhoneCall> callsOnHold = new ObservableLinkedBlockingQueue<>();
        ObservableQueue<Employee> employeesAvailable = new ObservablePriorityBlockingQueue<>(comparator);
        UseCaseHandler useCaseHandler = UseCaseHandler.getInstance(UiThreadImpl.getInstance());
        Dispatcher dispatcher = new DispatcherImpl(repository, callsOnHold, employeesAvailable, useCaseHandler);

        /**
         * Given 10 phonecalls
         */
        List<PhoneCall> calls = phoneCallRepository.getNextPhoneCallRinning(numberOfCalls).collect(Collectors.toList());
        for (PhoneCall call : calls) {
            dispatcher.dispatchCall(call);
        }

        assertTrue(calls.size() == numberOfCalls);
    }

    @Test
    public void given9CallsSouldBeADirectorWithoutCalls() {

        int numberOfCalls = 9;

        Repository repository = new RepositoryImpl(
                fullEmployeeRepository,
                phoneCallRepository);
        ObservableQueue<PhoneCall> callsOnHold = new ObservableLinkedBlockingQueue<>();
        ObservableQueue<Employee> employeesAvailable = new ObservablePriorityBlockingQueue<>(comparator);
        UseCaseHandler useCaseHandler = UseCaseHandler.getInstance(UiThreadImpl.getInstance());
        Dispatcher dispatcher = new DispatcherImpl(repository, callsOnHold, employeesAvailable, useCaseHandler);

        /**
         * Given 10 phonecalls
         */
        List<PhoneCall> calls = phoneCallRepository.getNextPhoneCallRinning(numberOfCalls).collect(Collectors.toList());
        for (PhoneCall call : calls) {
            dispatcher.dispatchCall(call);
        }

        assertTrue(employeesAvailable.poll() instanceof DirectorModel);
    }

    @Test
    public void given10EmployeesSouldDispatch10CallAtTheSameTime() {

        int numberOfCalls = 10;

        Repository repository = new RepositoryImpl(
                fullEmployeeRepository,
                phoneCallRepository);
        ObservableQueue<PhoneCall> callsOnHold = new ObservableLinkedBlockingQueue<>();
        ObservableQueue<Employee> employeesAvailable = new ObservablePriorityBlockingQueue<>(comparator);
        UseCaseHandler useCaseHandler = UseCaseHandler.getInstance(UiThreadImpl.getInstance());
        Dispatcher dispatcher = new DispatcherImpl(repository, callsOnHold, employeesAvailable, useCaseHandler);

        /**
         * Given 10 phonecalls
         */
        List<PhoneCall> calls = phoneCallRepository.getNextPhoneCallRinning(numberOfCalls).collect(Collectors.toList());
        for (PhoneCall call : calls) {
            dispatcher.dispatchCall(call);
        }

        assertTrue(employeesAvailable.isEmpty());
    }
}
