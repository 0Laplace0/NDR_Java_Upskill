/*
 * A test class to demonstrate the functionality of the refactored Student class.
 */

public class StudentTest {
    public static void main(String[] args) {
    Student s1 = new Student("Ratchawin Jaidee", "Pattanakarn 37");
    System.out.println(s1);
    s1.addCourseGrade("Math", 90);
    s1.addCourseGrade("English", 85);
    s1.addCourseGrade("History", 78);
    s1.addCourseGrade("Physics", 92);
    s1.printGrades();
    System.out.printf("Average Grade: %.2f\n", s1.getAverageGrade());

    StudentList s2 = new StudentList("Kritpanit Teerakaittikul", "Pattanakarn 37");
    System.out.println(s2);
    s2.addCourseGrade("Math", 80);
    s2.addCourseGrade("Japanese", 90);
    s2.addCourseGrade("Java", 80);
    s2.addCourseGrade("Web", 80);
    s2.printGrades();
    System.out.printf("Average Grade: %.2f\n", s2.getAverageGrade());
    }
}

