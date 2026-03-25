import dao.StudentDAO;
import model.Student;

import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Marks");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit....");

            System.out.println("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter name: ");
                    String name = sc.next();
                    System.out.println("Enter Marks: ");
                    int marks = sc.nextInt();
                    dao.addStudent(new Student(name,marks));
                    break;

                case 2:
                    List<Student> list= dao.getAllStudents() ;
                    for(Student s: list){
                        System.out.println(s.getId()+ " " +s.getName()+ " " + s.getMarks());
                    }
                    break;
                case 3:
                    System.out.println("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.println("Enter New marks: ");
                    int m = sc.nextInt();
                    dao.updateStudent(id,m);
                    break;
                case 4:
                    System.out.println("Enter ID: ");
                    int delId = sc.nextInt();
                    dao.deleteStudent(delId);
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}