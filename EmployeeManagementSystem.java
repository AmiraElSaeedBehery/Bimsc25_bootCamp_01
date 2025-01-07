import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private int age;
    private String department;
    private double salary;

    // Constructor
    // i changed this file now
    // update Again
    public Employee(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", department='" + department + "', salary=" + salary + "}";
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        // Step 1: Create and store dataset in a collection
        List<Employee> employees = Arrays.asList(
                new Employee("Employee_01", 28, "HR", 55000),
                new Employee("Employee_02", 35, "IT", 75000),
                new Employee("Employee_03", 40, "Finance", 80000),
                new Employee("Employee_04", 30, "IT", 72000),
                new Employee("Employee_05", 25, "HR", 48000)
        );

        // Step 2: Define a Function interface implementation to concatenate name and department
        Function<Employee, String> nameAndDepartment = 
                emp -> emp.getName() + " - " + emp.getDepartment();

        // Step 3: Use streams to generate a new collection of concatenated strings
        List<String> nameDeptList = employees.stream()
                .map(nameAndDepartment) // Apply the Function interface
                .collect(Collectors.toList());

        System.out.println("Name and Department List:");
        nameDeptList.forEach(System.out::println);

        // Step 4: Calculate the average salary using streams
        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary) // Extract salaries
                .average() // Calculate average
                .orElse(0.0);

        System.out.println("\nAverage Salary: " + averageSalary);

        // Step 5: Filter employees whose age is above 30
        int ageThreshold = 30;
        List<Employee> filteredEmployees = employees.stream()
                .filter(emp -> emp.getAge() > ageThreshold) // Filter based on age
                .collect(Collectors.toList());

        System.out.println("\nEmployees Above Age " + ageThreshold + ":");
        filteredEmployees.forEach(System.out::println);
    }
}
