package Java.Ejercicios.IntroAPOO.sistemaDeGestion.modelos;

import java.util.Arrays;
import java.util.Objects;


public class Empleado {
    private String name;
    private Integer age;
    private double salary;
    private String department;

    public Empleado(String name, Integer age, double salary, String department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public Empleado() {
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public static void showAllEmployees(Empleado[] employees) {
        int counter = 0;

        System.out.println("-----------------------------------------------------------");
        System.out.printf("%-5s %-20s %-5s %-10s %-15s%n", "No.", "Name", "Age", "Salary", "Department");
        System.out.println("-----------------------------------------------------------");

        while (counter < employees.length && employees[counter] != null) {
            Empleado e = employees[counter];
            System.out.printf("%-5d %-20s %-5d %-10.2f %-15s%n", (counter + 1), e.getName(), e.getAge(), e.getSalary(), e.getDepartment());
            counter++;
        }

    }

    public static Empleado[] filterEmployee(Empleado[] employees, String filter) {
        Empleado[] filteredEmployees = new Empleado[employees.length];
        int counter = 0;

        for (Empleado empleado : employees) {
            if ((empleado != null) && (empleado.getName().equalsIgnoreCase(filter) || empleado.getDepartment().equalsIgnoreCase(filter))) {
                filteredEmployees[counter] = empleado;
                counter++;
                System.out.printf("entrio" + filter);
            } // check null in the arrays
        }
        Empleado[] newArray = Arrays.copyOf(filteredEmployees, counter);
        return newArray;
    }

    public static Empleado[] filterEmployee(Empleado[] employees, Integer filter, double filter2) {
        Empleado[] filteredEmployees = new Empleado[employees.length];
        int counter = 0;

        for (Empleado empleado : employees) {
            if ((empleado != null) && (Objects.equals(empleado.getAge(), filter) || empleado.getSalary() == (filter2))) {
                filteredEmployees[counter] = empleado;
                counter++;
            } // check null in the arrays
        }

        return Arrays.copyOf(filteredEmployees, counter);
    }

    public static Empleado[] orderEmployees(Empleado[] employees, String target) {
        int n = employees.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                boolean mustChange = false;

                if (target.equalsIgnoreCase("nombre")) {
                    if ((employees[j].getName().compareToIgnoreCase(employees[j + 1].getName())) > 0) {
                        mustChange = true;
                    }
                } else if (target.equalsIgnoreCase("edad")) {
                    if (employees[j].getAge() > (employees[j + 1].getAge())) {
                        mustChange = true;
                    }
                } else if (target.equalsIgnoreCase("salario")) {
                    if (employees[j].getSalary() > (employees[j + 1].getSalary())) {
                        mustChange = true;
                    }
                }

                if (mustChange) {
                    Empleado temp = employees[j];
                    employees[j] = employees[j + 1];
                    employees[j + 1] = temp;
                }

            }
        }

        return employees;
    }

    public static Empleado searchByName(Empleado[] employees, String employeeName) {
        Empleado employeeToReturn = null;
        for (Empleado employee : employees) {
            if (employeeName.equalsIgnoreCase(employee.name)) {
                employeeToReturn = employee;
            }
        }
        return employeeToReturn;
    }

    public static Empleado increaseSalary(Empleado employee, double percentage) {
        double newSalary = employee.getSalary() * (1 + percentage / 100);
        employee.setSalary(newSalary);
        return employee;
    }

}
