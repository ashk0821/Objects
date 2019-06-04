package PowerSchool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class School {

    final String name;
    Student[] enrolledStudents = new Student[300];
    Course[] schoolCourses = new Course[300];

    // Maximum of 300 Students per school
    // Maximum of 300 Courses per school
    public School(String name) {
        this.name = name;
    }

    // Returns name of school
    public String getName() {
        return name;
    }

    // Returns number of enrolled students
    public int enrolledStudents() {
        int length = 0;
        for (int i = 0; i < enrolledStudents.length; i++) {
            if (enrolledStudents[i] == null)
                break;
            length++;
        }

        return length;
    }

    /* Returns the array of courses. (Deep copy)
     */
    public Course[] getCourses() {
       int length = 0;

       for (int i=0; i<schoolCourses.length; i++) {
           if (schoolCourses[i] != null)
               length++;

       }

        Course[] ret = new Course[length];

        for (int i = 0; i < ret.length; i++) {
            ret[i] = schoolCourses[i];
        }

        return ret;
    }

    /* returns Student with specified class rank. Since you have implemented compareTo,
     * you can use Arrays.sort to sort enrolledStudents.
     */
    public Student kidWithClassRank(int rank) {
        Arrays.sort(enrolledStudents);

        for (int i = 0; i < enrolledStudents.length; i++) {
            if (i + 1 == rank) {
                return enrolledStudents[i];
            }

        }
        return null;
    }

    /* Adds a student to the school.
    Returns false if the school is already full or if
    * Student is already enrolled at that school.
    */
    public boolean addStudent(Student someKid) {
        int length;

        for (length=0; length<enrolledStudents.length; length++) {
            if (enrolledStudents[length] == null)
                break;
            if (enrolledStudents[length].equals(someKid))
                return false;
            if (length == 300)
                return false;
        }

        enrolledStudents[length] = someKid;
        return true;
    }

    /* Removes a student to the school.
     */
    public void unenrollStudent(Student someKid) {
        for (int i = 0; i < enrolledStudents.length; i++) {
            if (enrolledStudents[i].equals(someKid)) {
                enrolledStudents[i] = null;

                for (int j=i; j<enrolledStudents.length; j++) {
                    if (enrolledStudents[j+1] == null)
                        break;

                    enrolledStudents[j] = enrolledStudents[j+1];
                }
                break;
            }
        }

        for (int i=0; i<schoolCourses.length; i++) {
            if (schoolCourses[i] == null)
                break;
            schoolCourses[i].unenroll(someKid);
        }
    }

    /* Creates a class. Returns false if a class with exactly the same specifications
     * have already been made.
     */
    public boolean createClass(String Teacher, String title, boolean honors) {
        Course c1 = new Course(Teacher, title, honors);

        for (int i=0; i<getCourses().length; i++) {
            if (getCourses()[i].teacher.equals(c1.teacher)&&getCourses()[i].courseTitle.equals(c1.courseTitle))
                return false;
        }

        for (int i=0; i<schoolCourses.length; i++) {
            if (schoolCourses[i] == null) {
                schoolCourses[i] = c1;
                return true;
            }
        }

        return false;
    }

    /* Enrolls Student in Course and returns true if successful.
     * Returns false if: Course not in school, Course would have more than 20 students, or
     * Student would have more than 10 Courses.
     */
    public boolean enroll(Student kid, Course someCourse, boolean audited) {
//      for (int i=0; i<schoolCourses.length; i++) {
//            if (schoolCourses[i]!= null && schoolCourses[i].teacher.equals((someCourse.teacher)))
        for (int i = 0; i < schoolCourses.length; i++) {
            try {
                if (schoolCourses[i].courseTitle.equals(someCourse.courseTitle))
                    return (someCourse.enroll(kid, audited));
            }catch (Exception e){
                return false;}
        }
    return false;


    }

    /* Unenrolls Student in Course and returns true if successful.
     * Returns false if: Course not in school, or Student not in Course.
     */
    public boolean unenroll(Student kid, Course someCourse) {
        for (int i = 0; i < schoolCourses.length; i++) {
            if (schoolCourses[i] == null)
                break;
            if (schoolCourses[i].equals(someCourse))
                someCourse.unenroll(kid);
                return true;
        }
        return false;
    }
}
