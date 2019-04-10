package PowerSchool;

import java.util.Arrays;

public class Course {

    String courseTitle;
    String teacher;
    Student[] enrolledStudents = new Student[20];
    Grade[] grades = new Grade[20];
    boolean honors;

    public Course(String teacher, String title, boolean honors){
        this.teacher = teacher;
        this.courseTitle = title;
        this.honors = honors;
    }

    public String courseTitle(){
        return courseTitle;
    }

    public String courseTeacher(){
        return teacher;
    }

    public Grade gradeOf(Student someStudent){
        for(int i = 0; i < enrolledStudents().length; i++){
            if(enrolledStudents()[i].equals(someStudent)){
                return grades[i];
            }
        }
        return grades[0];
    }

    public int numberEnrolled(){
        return enrolledStudents().length;
    }

    public Student[] enrolledStudents(){
        int length = 0;

        for (int i=0; i<enrolledStudents.length; i++) {
            if (enrolledStudents[i] != null)
                length++;
        }

        Student[] ret = new Student[length];

        for (int i = 0; i < ret.length; i++) {
            ret[i] = enrolledStudents[i];
        }

        return ret;
    }

    public Student topStudent(){
        int highestGradeIndex = 0;
        for(int i = 1; i < grades.length; i++){
            if (grades[i] == null)
                return null;

            if(grades[i].gradeValue() > grades[highestGradeIndex].gradeValue()){
                highestGradeIndex = i;
            }
        }

        return enrolledStudents()[highestGradeIndex];
    }

    public void setGrade(Student someStudent, int grade){
        for(int i = 0; i < enrolledStudents().length; i++){
            if(someStudent.equals(enrolledStudents()[i])){
                grades[i].grade = grade;
            }
        }
    }

    public boolean enroll(Student someStudent, boolean audited) {
        if (enrolledStudents[enrolledStudents.length-1] != null)
            return false;
        return someStudent.addCourse(new Course(teacher, courseTitle, honors));
    }

    public void unenroll (Student someStudent) {
        for (int i=0; i<enrolledStudents.length; i++) {
            if (enrolledStudents[i].equals(someStudent)) {
                enrolledStudents[i] = null;
                Arrays.sort(enrolledStudents);
            }
        }
    }
}
