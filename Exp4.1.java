Experiment 4.1: Employee Management System

The Employee Management System is a simple Java-based application that uses ArrayList to manage employee records. The system allows users to perform the following operations:

Add Employee → Store Employee ID, Name, and Salary.

Update Employee → Modify employee details based on their ID.

Remove Employee → Delete an employee using their ID.

Search Employee → Find employees by ID or Name.

Display All Employees → Show a complete list of employees.

Program/Code: 
Experiment 4.1
Program/Code:

import java.util.*;
    class Employee {
        int id;
        String name;
        double salary;

        Employee(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        public String toString() {
            return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
        }
    }

    public class EmployeeManagementSystem {
        private static ArrayList<Employee> employees = new ArrayList<>();

        public static void addEmployee(int id, String name, double salary) {
            for (Employee emp : employees) {
                if (emp.id == id) {
                    System.out.println("Error: Employee with ID " + id + " already exists.");
                    return;
                }
            }
            employees.add(new Employee(id, name, salary));
            System.out.println("Employee Added: ID=" + id + ", Name=" + name + ", Salary=" + salary);
        }

        public static void updateEmployee(int id, double newSalary) {
            for (Employee emp : employees) {
                if (emp.id == id) {
                    emp.salary = newSalary;
                    System.out.println("Employee ID " + id + " updated successfully.");
                    return;
                }
            }
            System.out.println("Error: Employee ID " + id + " not found.");
        }

        public static void removeEmployee(int id) {
            for (Employee emp : employees) {
                if (emp.id == id) {
                    employees.remove(emp);
                    System.out.println("Employee ID " + id + " removed successfully.");
                    return;
                }
            }
            System.out.println("Error: Employee ID " + id + " not found.");
        }

        public static void searchEmployeeById(int id) {
            for (Employee emp : employees) {
                if (emp.id == id) {
                    System.out.println("Employee Found: " + emp);
                    return;
                }
            }
            System.out.println("Error: Employee ID " + id + " not found.");
        }

        public static void displayAllEmployees() {
            if (employees.isEmpty()) {
                System.out.println("No employees found.");
            } else {
                for (Employee emp : employees) {
                    System.out.println("ID: " + emp.id + ", Name: " + emp.name + ", Salary: " + emp.salary);
                }
            }
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\n1. Add Employee\n2. Update Employee\n3. Remove Employee\n4. Search Employee by ID\n5. Display All Employees\n6. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Salary: ");
                        double salary = scanner.nextDouble();
                        addEmployee(id, name, salary);
                        break;
                    case 2:
                        System.out.print("Enter Employee ID: ");
                        int updateId = scanner.nextInt();
                        System.out.print("Enter New Salary: ");
                        double newSalary = scanner.nextDouble();
                        updateEmployee(updateId, newSalary);
                        break;
                    case 3:
                        System.out.print("Enter Employee ID: ");
                        int removeId = scanner.nextInt();
                        removeEmployee(removeId);
                        break;
                    case 4:
                        System.out.print("Enter Employee ID: ");
                        int searchId = scanner.nextInt();
                        searchEmployeeById(searchId);
                        break;
                    case 5:
                        displayAllEmployees();
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
