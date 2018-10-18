package com.thoughtworks.learnr.services;

import com.thoughtworks.learnr.models.Employee;
import com.thoughtworks.learnr.repositories.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {
    EmployeeService employeeService;

    @Mock
    EmployeeRepository employeeRepository;

    @Before
    public void setUp() throws Exception {
        this.employeeService = new EmployeeService(employeeRepository);
    }

    @Test
    public void shouldFetchEmployee(){
        String employeeId = "testEmployeeId";
        Employee employee = new Employee();
        employee.setId( employeeId );
        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of( employee ));
        employeeService.getEmployee(employeeId);

        verify(employeeRepository, times(1)).findById(employeeId);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowAnExceptionWhenEmployeeNotFound() {
        String employeeId = "testEmployeeId";
        employeeService.getEmployee(employeeId);
    }

}