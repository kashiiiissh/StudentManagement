import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    dao.addStudent(new Student(id, name, course, marks));
                    break;

                case 2:
                    dao.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    dao.searchStudent(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter Student ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String uname = sc.nextLine();

                    System.out.print("Enter New Course: ");
                    String ucourse = sc.nextLine();

                    System.out.print("Enter New Marks: ");
                    double umarks = sc.nextDouble();

                    dao.updateStudent(uid, uname, ucourse, umarks);
                    break;

                case 5:
                    System.out.print("Enter Student ID: ");
                    dao.deleteStudent(sc.nextInt());
                    break;

                case 6:
                    System.out.println("Program Ended");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}