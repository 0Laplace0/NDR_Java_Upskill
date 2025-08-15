/*
 * สมมติว่านักเรียนเรียนไม่เกิน 30 รายวิชาตลอดหลักสูตร
 * สำหรับนักเรียน เราต้องรักษารายวิชาที่เรียนและเกรดของรายวิชานั้นๆ เพิ่มรายวิชาพร้อมเกรด พิมพ์รายวิชาทั้งหมดที่เรียนและเกรดเฉลี่ย
 */

package Homework;

public class Student extends Person{
    
    private int numCourse = 0;
    private String[] courses = new String[30];
    private int[] grades = new int[30];

    public Student(String name, String address){
        super(name, address);
    }

    @Override
    public String toString() {
        return "Student: " + super.toString();
    }

    public void addCourseGrade(String course, int grade){
        if (numCourse < 30) {
            courses[numCourse] = course;
            grades[numCourse] = grade;
            numCourse++;
        }else{
            System.out.println("Cannot add more than 30 coures.");
        }
    }

    public void printGrades(){
        System.out.print(super.getName() + " ");
        for(int i = 0; i<numCourse; i++){
            System.out.print(courses[i] + ":" + grades[i]);
            if (i < numCourse - 1) System.out.print(", ");
        }
        System.out.println();
    }

    public double getAverageGrade(){
        if (numCourse == 0) return 0.0;
        int sum = 0;
        for(int i = 0; i<numCourse; i++){
            sum += grades[i];
        }
        return (double)sum/numCourse;
    }
}
