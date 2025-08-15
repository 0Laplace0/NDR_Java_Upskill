// ----------------------------------------------------------------------------
// Main class with a main() method to demonstrate the code
// ----------------------------------------------------------------------------
package Homework;

public class Main {
    public static void main(String[] args) {
        // ---Demonstrate Person Class --
        System.out.println("---Demonstrating Person Class ---");
        Person person = new Person("John Smith", "123 Main St");
        System.out.println(person);
        person.setAddress("456 Oak Ave");
        System.out.println("New Address: " + person.getAddress());
        System.out.println();

        // ---Demonstrate Student Class --
        System.out.println("---Demonstrating Student Class ---");
        Student student = new Student("Alice Johnson", "789 Pine Ln");
        System.out.println(student);
        student.addCourseGrade("Math", 95);
        student.addCourseGrade("Physics", 88);
        student.addCourseGrade("Chemistry", 76);
        student.addCourseGrade("Math", 90); 
        student.printGrades();
        System.out.printf("Average grade for %s is: %.2f\n", 
        student.getName(), student.getAverageGrade());
        System.out.println();

        // ---Demonstrate Teacher Class --
        System.out.println("---Demonstrating Teacher Class ---");
        Teacher teacher = new Teacher("Mr. Davis", "101 Maple Rd");
        System.out.println(teacher);
        teacher.addCourse("Calculus");
        teacher.addCourse("Algebra");
        teacher.addCourse("Physics");
        teacher.addCourse("Algebra"); // Attempt to add existing course
        System.out.println("Removing 'Physics': " + 
        teacher.removeCourse("Physics"));
        System.out.println("Removing 'English': " + 
        teacher.removeCourse("English")); // Attempt to remove non-existent course
        System.out.println();
        System.out.println("Final state of teacher object:");
        System.out.println(teacher);
    }
}