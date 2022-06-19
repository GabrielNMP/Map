package pro.sky.java.course2.map.service;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.map.book.Employee;
import pro.sky.java.course2.map.exception.EmployeeAlredyInnExceptions;
import pro.sky.java.course2.map.exception.EmployeeNotFoudExceptions;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String,Employee> employeeMap;

    public EmployeeServiceImpl() {
        this.employeeMap = new HashMap<>();
    }

    private String getKey(Employee employee){
        return employee.getFirstName() + employee.getLastName();
    }

    @Override
    public Employee passEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        if (employeeMap.containsKey(getKey(employee))){
            return employee;
        }
        throw new EmployeeNotFoudExceptions();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        if (employeeMap.containsKey(getKey(employee))){
            throw new EmployeeAlredyInnExceptions();
        }
        employeeMap.put(getKey(employee),employee);
        return employee;
    }


    @Override
    public Employee deleteEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeMap.containsKey(getKey(employee))){
            employeeMap.remove(getKey(employee),employee);
            return employee;
        }
        throw new EmployeeNotFoudExceptions();
    }

    @Override
    public List<Employee> finedAll() {
        return new ArrayList<>(employeeMap.values());
    }
}
