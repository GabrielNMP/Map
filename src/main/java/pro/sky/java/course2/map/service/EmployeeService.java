package pro.sky.java.course2.map.service;
import pro.sky.java.course2.map.book.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee passEmployee (String firstName, String lastName);
    Employee addEmployee (String firstName, String lastName);
    Employee deleteEmployee (String firstName, String lastName);

    Collection<Employee> finedAll();
}
