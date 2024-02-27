public class Employee {
    private String name;
    private int age;
    private String designation;
    private double salary;

    public Employee(String name) {
        this.name = name;
    }

    public void empAge(int empAge) {
        age = empAge;
    }

    public void empDesignation(String empDesig) {
        designation = empDesig;
    }

    public void empSalary(double empSalary) {
        salary = empSalary;
    }

    public void printEmployee() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Designation: " + designation);
        System.out.println("Salary: " + salary);
    }
}

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByName(String name);
}

@service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee findEmployeeByName(String name) {
        return employeeRepository.findByName(name);
    }
    public list<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    public Employee getEmployee(Long id) {
        return employeeRepository.findOne(id);
    }
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    public void deleteEmployee(Long id) {
        employeeRepository.delete(id);
    }
}

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee/{name}", method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable String name) {
        return employeeService.findEmployeeByName(name);
    }
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public list<Employee> getAllEmployees() {
        return employeeService.findAllEmployees();
    }
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
```
Comments: http://localhost:8080/api/employees

## 3.2.2. Spring Boot Application
## This is a basic example of creating a REST API using Java and Spring Boot. You can customize and extend this example based on your specific requirements.
```java