// Done by Vatsal Jaiswal
package Day7;

import java.util.ArrayList;

class Main {

    public static void main(String[] args) {

        Employee e1 = new Employee(1, "abc", 55000.00, "development");
        Employee e2 = new Employee(11, "xyz", 43500.00, "development");
        Employee e3 = new Employee(5, "fname", 100000.00, "production");
        Employee e4 = new Employee(21, "name123", 75000, "support");
        Employee e5 = new Employee(17, "someName", 85000, "development");

        ArrayList<Employee> empList = new ArrayList<>();
        empList.add(e1);
        empList.add(e2);
        empList.add(e3);
        empList.add(e4);
        empList.add(e5);

        // print average salary
        // write your code here

        // --- Solution using Java 8 Streams ---

        // 1. Convert the list to a stream
        double averageSalary = empList.stream()

                // 2. Filter the stream to find only employees in "development"
                .filter(emp -> emp.getDepartment().equals("development"))

                // 3. Map the Employee objects to just their salaries (as a DoubleStream)
                .mapToDouble(Employee::getSalary)

                // 4. Calculate the average of those salaries
                .average()

                // 5. If no employees were found (to avoid errors), default to 0.0
                .orElse(0.0);

        // 6. Print the result
        System.out.println(averageSalary);
    }
}

class Employee { // Changed to 'class' from 'public class' to be in the same file
    int id;
    String name;
    double salary;
    String department;

    public Employee() {
        super();
    }

    public Employee(int id, String name, double salary, String department) {
        super();
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
