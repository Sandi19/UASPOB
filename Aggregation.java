import java.util.ArrayList;
import java.util.List;

public class Aggregation {

    // Kelas Department
    static class Department {
        private String name;
        private List<Employee> employees;

        public Department(String name) {
            this.name = name;
            this.employees = new ArrayList<>();
        }

        public void addEmployee(Employee employee) {
            employees.add(employee);
        }

        public List<Employee> getEmployees() {
            return new ArrayList<>(employees);
        }
    }

    // Kelas Employee
    static class Employee {
        private String name;

        public Employee(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    // Metode main untuk menjalankan contoh Aggregation
    public static void main(String[] args) {
        Department hr = new Department("Human Resources");
        Employee john = new Employee("John Doe");
        hr.addEmployee(john);
        System.out.println(hr.getEmployees().get(0).getName()); // Output: John Doe
    }
}