/*
 * ครูสอนไม่เกิน 5 รายวิชาพร้อมกัน
 * สำหรับครู เราต้องรักษารายวิชาที่สอนในปัจจุบัน และสามารถเพิ่มหรือลบรายวิชาที่สอนได้
 */

package Homework;

public class Teacher extends Person {

    final int MAX_COURSES = 5;

    private int numCourse = 0;
    private String[] courses = new String[MAX_COURSES];

    public Teacher(String name, String address) {
        super(name, address);
    }

    @Override
    public String toString() {
        return "Teacher: " + super.toString();
    }

    public boolean addCourse(String course) {
        // Check Course name if have a course return false.
        for (int i = 0; i < numCourse; i++) {
            if (courses[i].equals(course)) {
                return false;
            }
        }

        // If course have a slot add course and plus numCourse for next check. 
        // If not send can't add course.
        if (numCourse < MAX_COURSES) {
            // courses[numCourse] = course;
            // numCourse++;
            courses[numCourse++] = course;
            return true;
        } else {
            throw new IllegalArgumentException("Cannot add course more than " + MAX_COURSES + " courses");
        }
    }

    public boolean removeCourse(String course) {
        // Check course name if have delete that course and slide order course and size.
        for (int i = 0; i < numCourse; i++) {
            if (courses[i].equals(course)) {
                for (int j = i; j < numCourse - 1; j++) {
                    courses[j] = courses[j + 1];
                }
                numCourse--;
                return true;
            }
        }
        return false;
    }
}