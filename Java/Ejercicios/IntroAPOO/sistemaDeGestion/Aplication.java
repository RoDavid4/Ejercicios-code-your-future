package Java.Ejercicios.IntroAPOO.sistemaDeGestion;

import Java.Ejercicios.IntroAPOO.sistemaDeGestion.modelos.*;
import java.util.Scanner;

public class Aplication {
    static Scanner scanner = new Scanner(System.in);
    //    public static Empleado[] employees = new Empleado[100];
    static Empleado[] employees = {
            new Empleado("Carlos", 22, 170.14, "Sales"),
            new Empleado("Calisto", 22, 10.14, "Development"),
            new Empleado("Cris", 22, 11.14, "Marketing"),
            new Empleado("fernando", 22, 120.14, "Development"),
            new Empleado("diana", 22, 1.14, "Development")
    }; // Creating employees
    static int counter = 0;

    public static void main(String[] args) {
        int option;
        clearScreen();
        do {
            menu();
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    showEmployees(employees);
                    break;
                case 3:
                    filterEmployees();
                    break;
                case 4:
                    System.out.println("Por que lo quieres ordenar(nombre, edad, salario)");
                    String target = scanner.nextLine();
                    Empleado[] orderEmployees = Empleado.orderEmployees(employees, target);
                    showEmployees(orderEmployees);
                    break;
                case 5:
                    searchEmployee();
                    break;
                case 6:
                    //
                    break;
                case 7:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }

        } while (option != 7);
    }

    public static void clearScreen() {
        System.out.println("\033[H\033[2J");
    }

    public static void menu() {
        System.out.println("""
                \n
                Sistema de Gestión de Empleados:
                
                1. Añadir Empleado
                2. Mostrar Todos los Empleados
                3. Filtrar Empleados
                4. Ordenar Empleados
                5. Buscar Empleado por Nombre
                6. Incrementar Salario
                7. Salir
                """);

        System.out.print("Seleccione una opción: ");
    }

    public static void addEmployee() {
        clearScreen();
        System.out.print("Nombre: ");
        String name = scanner.nextLine();

        System.out.print("Edad: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Salario: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Departamento: ");
        String department = scanner.nextLine();
        employees[counter++] = new Empleado(name, age, salary, department);
        clearScreen();
    }

    public static void showEmployees(Empleado[] employees) {
        clearScreen();
        Empleado.showAllEmployees(employees);
    }

    public static void searchEmployee() {
        System.out.print("Nombre del empleado: ");
        String employeeName = scanner.nextLine();
        Empleado employeeFound = Empleado.searchByName(employees, employeeName);
        if (employeeFound != null) {
            Empleado[] newEmployees = {employeeFound};
            showEmployees(newEmployees);
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    public static void filterEmployees() {
        clearScreen();
        System.out.print("Escribe lo que quieres filtar(nombre, edad, salario):  ");
        String atribute = scanner.nextLine();

        if (atribute.equalsIgnoreCase("nombre") || atribute.equalsIgnoreCase("department")) {
            System.out.print("Escribe el nombre o departamento que quieres filtrar:  ");
            String filterName = scanner.nextLine();

            Empleado[] newEmployees = Empleado.filterEmployee(employees, filterName);
            showEmployees(newEmployees);
        }

        if (atribute.equalsIgnoreCase("edad") || atribute.equalsIgnoreCase("salario")) {
            System.out.print("Escribe la edad o salario que quieres filtrar:  ");
            String filterName = scanner.nextLine();

            Empleado[] newEmployees = Empleado.filterEmployee(employees, filterName);
            showEmployees(newEmployees);
        }

    }
}