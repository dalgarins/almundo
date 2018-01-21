package com.retos.data.factory;

import com.retos.domain.model.employee.DirectorModel;
import com.retos.domain.model.employee.OperatorModel;
import com.retos.domain.model.employee.SupervisorModel;
import com.retos.domain.model.employee.Employee;
import com.retos.domain.model.employee.Support;

/**
 * Factory to create different types of employees
 * @author dalgarins
 */
public final class EmployeeFactory {
    
    private EmployeeFactory(){}
    
    private static class SingletonHelper {
        private static EmployeeFactory INSTANCE = new EmployeeFactory();
    }
    
    public static EmployeeFactory getInstance() {
        return SingletonHelper.INSTANCE;
    }
    
    public Employee getEmployee(String id, String name, Support.SupportLevel level) {
        
        if (level == Support.SupportLevel.LEVEL_1) {
            return new OperatorModel.Builder()
                    .setId(id)
                    .setName(name)
                    .setSupportLevel(Support.SupportLevel.LEVEL_1)
                    .build();
        } else if (level == Support.SupportLevel.LEVEL_2) {
            return new SupervisorModel.Builder()
                    .setId(id)
                    .setName(name)
                    .setSupportLevel(Support.SupportLevel.LEVEL_2)
                    .build();
        }
        return new DirectorModel.Builder()
                .setId(id)
                .setName(name)
                .setSupportLevel(Support.SupportLevel.LEVEL_3)
                .build();
    }
    
}
