package com.studyopedia;
import java.util.Scanner;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.net.URI;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.regex.Pattern;

/*
java.util.Scanner for taking user input.
java.awt.Color for defining colors in GUI.
java.io.File and java.io.FileWriter for file handling.
java.io.IOException for handling I/O exceptions.
java.net.URI for representing a Uniform Resource Identifier.
javax.swing.JFrame, javax.swing.JScrollPane, and javax.swing.JTable for creating GUI components.
java.util.regex.Pattern for working with regular expressions. 
 */

class Employe {
    int id;
    String name;
    String designation;
    int cl;
    float salary;
    float net; 
}
/*
 A class named Employee, representing an employee.
It contains attributes such as id, name, designation, cl (number of leaves taken), salary, and net (net salary).
*/


public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float turnover;
        System.out.print("Enter the turnover of your company:");
        turnover = sc.nextFloat();

        int no;
        System.out.print("Enter the number of employees whose details you are gonna enter:");
        no = sc.nextInt();

        Employe[] employee = new Employe[no];
        // counter for nos employee
        int counter = 0;
        int count; // ip vala cnt
        int loop;

        int searchID;
        System.out.print("\n");
        System.out.print("\t***********************************************************\n");
        System.out.print("\t*                                                         *\n");
        System.out.print("\t*                Payroll Management System                *\n");
        System.out.print("\t*                  How may we help you?                   *\n");
        System.out.print("\t*                                                         *\n");
        System.out.print("\t*             ******** ||MAIN MENU|| ********             *\n");
        System.out.print("\t*                                                         *\n");
        System.out.print("\t*            Please enter your choice for menu:           *\n");
        System.out.print("\t*                                                         *\n");
        System.out.print("\t*          |--------------------------------------|       *\n");
        System.out.print("\t*          | Enter 1 -> Insert Employee Details   |       *\n");
        System.out.print("\t*          |--------------------------------------|       *\n");
        System.out.print("\t*          | Enter 2 -> Search for an Employee    |       *\n");
        System.out.print("\t*          |--------------------------------------|       *\n");
        System.out.print("\t*          | Enter 3 -> Display all Employees     |       *\n");
        System.out.print("\t*          |--------------------------------------|       *\n");
        System.out.print("\t*          | Enter 4 -> Update                    |       *\n");
        System.out.print("\t*          |--------------------------------------|       *\n");
        System.out.print("\t*          | Enter 5 -> Delete                    |       *\n");
        System.out.print("\t*          |--------------------------------------|       *\n");
        System.out.print("\t*          | Enter 6 -> Feedback or Suggestion    |       *\n");
        System.out.print("\t*          |--------------------------------------|       *\n");
        System.out.print("\t*          | Enter 7 -> Exit                      |       *\n");
        System.out.print("\t*          |--------------------------------------|       *\n");
        System.out.print("\t*                                                         *\n");
        System.out.print("\t***********************************************************\n\n");
        System.out.print("Choice:");
        int choice = sc.nextInt();
        while (true) {
            if (choice == 1) {
                try {
/*For file handling*/          
                  FileWriter fwrite = new FileWriter("D:FileOperationExample.txt");
                    
                    while (counter < no) {
                        employee[counter] = insert(counter, no, turnover);
/*
 * for managing employee data, such as an array employee to store employee objects, and counters for looping and searching.
 */
                        if (employee[counter] != null) {

                            fwrite.write("Employee name: " + employee[counter].name);
                            fwrite.write("\n");

                            fwrite.write("Employee Designation: " + employee[counter].designation);                         
                            fwrite.write("\n");

                            fwrite.write("Employee ID: " + String.valueOf(employee[counter].id));                            
                            fwrite.write("\n");

                            fwrite.write("No. of leaves taken: " + String.valueOf(employee[counter].cl));                            
                            fwrite.write("\n");

                            fwrite.write("Net Salary: " + String.valueOf(employee[counter].net));                           
                            fwrite.write("\n");

                            fwrite.write("___________________________________________________\n\n");
                        } else {
                            System.out.println("");
                        }

                        counter++;
                    }

                    // Closing the stream
                    fwrite.close();

                } 
                
                /*For error handling*/           
                catch (IOException e) {
                    System.out.println("Unexpected error occurred");
                    e.printStackTrace();
                }
            } else if (choice == 2) {
                System.out.print("Enter the employee id that you want to search:");
                searchID = sc.nextInt();

                count = 0;

                search(employee, count, searchID, no);
            }
/*
A new instance of JFrame named f is created. A JFrame is a top-level container used to represent a window in a Java Swing application.
f.getContentPane().setBackground(Color.BLUE); sets the background color of the content pane of the frame to blue
*/
            
/*try block is to handle any potential exceptions that might occur during the execution of GUI-related code.*/ 

/* JTable named jt is created. This table will hold the employee data.
The table is initialized with a String array for data (data) and another String array for column names (column).*/
            
            else if (choice == 3) {
            	
                try {
                    JFrame f = new JFrame();
                    f.getContentPane().setBackground(Color.BLUE);
                    f.setVisible(true);
                    String[][] data = new String[employee.length][5];
                    String[] column = {"ID", "NAME", "DESIGNATION", "SALARY", "No. of leaves"};
                    JTable jt = new JTable(data, column);

                    for (int a = 0; a < employee.length; a++) {
                        assert employee[a] != null;
                        data[a][0] = String.valueOf(employee[a].id);
                        data[a][1] = employee[a].name;
                        data[a][2] = employee[a].designation;
                        data[a][3] = String.valueOf(employee[a].net);
                        data[a][4] = String.valueOf(employee[a].cl);
                    }
                    jt.setBounds(30, 40, 200, 300);
                    JScrollPane sp = new JScrollPane(jt);
                    f.add(sp);
                    f.setSize(300, 400);
                    f.setVisible(true);
/* jt.setBounds(30, 40, 200, 300); sets the position and size of the table within the frame.
A JScrollPane named sp is created, which is a scrollable pane used to hold the JTable.
The JScrollPane is added to the frame using f.add(sp);. This ensures that if the table exceeds the frame's size, it becomes scrollable.*/
  
/*f.setSize(300, 400); sets the size of the frame to 300x400 pixels.
f.setVisible(true); makes the frame visible on the screen.*/
                              
                    display(employee);
                } catch (Exception p) {
                    System.out.println("Error!!!\nPlease enter details of employee!!!");
                }
            } else if (choice == 4) {
                update(employee, turnover);
            } else if (choice == 5) {
                delete(employee);
            } else if (choice == 6) {
                feedback();
            } else if (choice == 7) {
                break;
            } else {
                System.out.println("Please enter a valid choice from the given options.");
            }
            System.out.println("Choose any of the options:");
            System.out.println("1. Continue");
            System.out.println("2. Exit");
            System.out.print("Choice:");
            loop = sc.nextInt();
            if (loop == 1) {
                System.out.println(" ");
                System.out.print("\t***********************************************************\n");
                System.out.print("\t*            Please enter your choice for menu:           *\n");
                System.out.print("\t*                                                         *\n");
                System.out.print("\t*          |--------------------------------------|       *\n");
                System.out.print("\t*          | Enter 1 -> Insert Employee Details   |       *\n");
                System.out.print("\t*          |--------------------------------------|       *\n");
                System.out.print("\t*          | Enter 2 -> Search for an Employee    |       *\n");
                System.out.print("\t*          |--------------------------------------|       *\n");
                System.out.print("\t*          | Enter 3 -> Display all Employees     |       *\n");
                System.out.print("\t*          |--------------------------------------|       *\n");
                System.out.print("\t*          | Enter 4 -> Update                    |       *\n");
                System.out.print("\t*          |--------------------------------------|       *\n");
                System.out.print("\t*          | Enter 5 -> Delete                    |       *\n");
                System.out.print("\t*          |--------------------------------------|       *\n");
                System.out.print("\t*          | Enter 6 -> Feedback or Suggestion    |       *\n");
                System.out.print("\t*          |--------------------------------------|       *\n");
                System.out.print("\t*          | Enter 7 -> Exit                      |       *\n");
                System.out.print("\t*          |--------------------------------------|       *\n");
                System.out.print("\t*                                                         *\n");
                System.out.print("\t***********************************************************\n");

                System.out.print("Enter your choice again:");
                choice = sc.nextInt();
            } else if (loop == 2) {
                break;
            }
        }
    }

    //feedback 
    static void feedback() {
        try {
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
            URI oURL = new URI("https://forms.gle/UqFxGBQUywyMkBBf8");
            desktop.browse(oURL);
        } catch (Exception e) {
            System.out.println("Something is wrong with this link !");
        }
    }

    //insert function
    public static Employe insert(int count, int no, float turnover) {
        Pattern in = Pattern.compile("^[a-zA-Z ]+$");
        final String R = "\u001B[31m";
        final String RE = "\u001B[0m";
        Scanner sc = new Scanner(System.in);
        Employe temp = new Employe();
        int p;
        if (count == no) {
            System.out.println("You have entered the required amount of employees' details.");
            return null;
        }

        try {
            // Creating an object of a file
            File f0 = new File("D:FileOperationExample.txt");
            if (f0.createNewFile()) {
                System.out.println("File " + f0.getName() + " is created successfully.");
               
            }
        } catch (IOException exception) {
            System.out.println("An unexpected error is occurred.");
            exception.printStackTrace();
        }

        System.out.print("Enter the name of the employee:");
        temp.name = sc.nextLine();
        while (!in.matcher(temp.name).matches()) {
            System.out.println(R + " Enter valid name !! " + RE);
            System.out.print("Enter the name of the employee:");
            temp.name = sc.nextLine();
        }

        System.out.print("Enter the designation of the employee:");
        temp.designation = sc.nextLine();
        while (!in.matcher(temp.designation).matches()) {
            System.out.println(R + " Enter valid designation !! " + RE);
            System.out.print("Enter the designation of the employee:");
            temp.designation = sc.nextLine();
        }

        temp.id = count + 1;



        System.out.print("Enter the no. of leaves taken by the employee in a month:");
        temp.cl = sc.nextInt();

        System.out.print("Enter the total amount of perks the employee got:");
        p = sc.nextInt();


        if (temp.designation.equals("CEO")) {
            temp.salary = 0.40f * turnover;
        } else if (temp.designation.equals("Manager")) {
            temp.salary = 0.35f * turnover;
        } else {
            temp.salary = 0.25f * turnover;
        }
        if (temp.cl > 3) {
            temp.salary = temp.salary + p - (temp.cl - 3) * 2000;
        } else {
            temp.salary = temp.salary + p;
        }

        return temp;
    }

    //search function
    public static void search(Employe[] employee, int count, int searchID, int no) {
        if (employee.length != no) {
            System.out.println("Please enter the details of all the employees again.");
            System.out.println("Make sure to fill out the details for all the employees.");
        } else if (searchID > no) {
            System.out.println("Please enter the correct id");
        } else if (employee[count].id == searchID) {
            System.out.println("Employee Information:");
            System.out.println("---------------------------------------------");
            System.out.println("Name: " + employee[count].name);
            System.out.println("Employee ID: " + employee[count].id);
            System.out.println("Designation: " + employee[count].designation);
            System.out.println("Leaves Taken: " + employee[count].cl);                    
            System.out.println("Net Salary: " + employee[count].salary);
            System.out.println("---------------------------------------------");
        } else {
            search(employee, count + 1, searchID, no);
        }
    }

    //display function
    public static void display(Employe[] employee) {
        System.out.println("Displaying details of all employees: \n");

        for (int a = 0; a < employee.length; a++) {
            System.out.println("Employee No " + (a + 1) + " :");
            System.out.println("---------------------------------------------");
            System.out.println("Name: " + employee[a].name);
            System.out.println("Employee ID: " + employee[a].id);
            System.out.println("Designation: " + employee[a].designation);
            System.out.println("Leaves Taken: " + employee[a].cl);
            System.out.println("Net Salary: " + employee[a].salary);
            System.out.println("---------------------------------------------");
            System.out.println(" ");
        }
    }

    //update function
    public static void update(Employe[] employee, float turnover) {
        Scanner sc = new Scanner(System.in);

        String n;
        String chose;
        int choose;
        int p;

        System.out.println("Enter the name of the employee whose details you want to change:");
        n = sc.nextLine();

        System.out.println("Choose the field that you want to update:");
        System.out.println("1. Designation");
        System.out.println("2. No. of leaves taken");
        chose = sc.nextLine();
        choose = Integer.parseInt(chose);


        for (int a = 0; a < employee.length; a++) {
            if (n.equals(employee[a].name)) {
                switch (choose) {
                    case 1:
                        System.out.println("Enter the designation of the employee:");
                        employee[a].designation = sc.nextLine();
                        System.out.println("Enter the perks for the employee:");
                        p = sc.nextInt();

                        if (employee[a].designation.equals("CEO")) {
                            employee[a].salary = 0.40f * turnover;
                        } else if (employee[a].designation.equals("Manager")) {
                            employee[a].salary = 0.35f * turnover;
                        } else {
                            employee[a].salary = 0.25f * turnover;
                        }

                        if (employee[a].cl > 3) {
                            employee[a].salary = employee[a].salary + p - (employee[a].cl - 3) * 2000;
                        } else {
                            employee[a].salary = employee[a].salary + p;
                        }
                        break;
                    case 2:
                        System.out.println("Enter the number of leaves taken by the employee:");
                        employee[a].cl = sc.nextInt();
                        System.out.println("Enter the perks for the employee:");
                        p = sc.nextInt();

                        if (employee[a].cl > 3) {
                            employee[a].salary = employee[a].salary + p - (employee[a].cl - 3) * 2000;
                        } else {
                            employee[a].salary = employee[a].salary + p;
                        }
                }
            } else {
                System.out.println("No such employee found!");
            }
        }

        replace_file(employee);
    }

    //delete function
    public static void delete(Employe[] employee) {
        Scanner sc = new Scanner(System.in);

        String name;
        int index = 0;

        System.out.println("Enter the name of the employee whose details you want to delete:");
        name = sc.nextLine();

        for (int a = 0; a < employee.length; a++) {
            if (name.equals(employee[a].name)) {
                index = a;
            }
        }

        if (index == employee.length - 1) {
            employee[index] = null;
            employee[index].name = null;
            employee[index].cl = 0;
            employee[index].designation = null;

        } else {
            for (int a = 0; a < employee.length - 1; a++) {
                if (a >= index) {
                    employee[a] = employee[a + 1];
                }
            }
            employee[employee.length - 1] = null;
        }

        replace_file(employee);
    }

    //updating the file
    public static void replace_file(Employe[] employee) {
        try {
            FileWriter fwrite = new FileWriter("D:FileOperationExample.txt");
            
            for (int counter = 0; counter < employee.length; counter++){
                if (employee[counter] != null) {

                    fwrite.write("Employee name: " + employee[counter].name);	
                    fwrite.write("\n");

                    fwrite.write("Employee Designation: " + employee[counter].designation);
                    fwrite.write("\n");

                    fwrite.write("Employee ID: " + String.valueOf(employee[counter].id));
                    fwrite.write("\n");

                    fwrite.write("No. of leaves taken: " + String.valueOf(employee[counter].cl));
                    fwrite.write("\n");

                    fwrite.write("Net Salary: " + String.valueOf(employee[counter].net));
                    fwrite.write("\n");

                    fwrite.write("___________________________________________________\n\n");
                }

            }

            // Closing the stream
            fwrite.close();

        } catch (IOException e) {
            System.out.println("Unexpected error occurred");
            e.printStackTrace();
        }
    }
}
