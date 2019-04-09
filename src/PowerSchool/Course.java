package PowerSchool;

import java.util.Arrays;

public class Course {

    String courseTitle;
    String teacher;
    Student[] enrolledStudents = new Student[20];
    Grade[] grades;
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
        for(int i = 0; i < enrolledStudents.length; i++){
            if(enrolledStudents[i].equals(someStudent)){
                return grades[i];
            }
        }
        return grades[0];
    }

    public int numberEnrolled(){
        return enrolledStudents.length;
    }

    public Student[] enrolledStudents(){
        Student[] ret = new Student[enrolledStudents.length];

        for(int i = 0; i < ret.length; i++){
            ret[i] = new Student(enrolledStudents[i].name, enrolledStudents[i].gradYear, enrolledStudents[i].Academy);
        }

        return ret;
    }

    public Student topStudent(){
        int highestGradeIndex = 0;
        for(int i = 1; i < grades.length; i++){
            if(grades[i].gradeValue() > grades[highestGradeIndex].gradeValue()){
                highestGradeIndex = i;
            }
        }

        return enrolledStudents[highestGradeIndex];
    }

    public void setGrade(Student someStudent, int grade){
        for(int i = 0; i < enrolledStudents.length; i++){
            if(someStudent.equals(enrolledStudents[i])){
                grades[i].grade = grade;
            }
        }
    }

    public boolean enroll(Student someStudent, boolean audited){

        // where am i supposed to include audited??

        if (enrolledStudents[enrolledStudents.length-1] != null)
            return false;

        if (someStudent.schedule[someStudent.schedule.length-1] != null)
            return false;

        for (int i=0; i<someStudent.schedule.length; i++) {
            if (someStudent.schedule[i] == null) {
                someStudent.schedule[i] = new Course(teacher, courseTitle, honors);

                for (int j=0; j<enrolledStudents.length; j++) {
                    if (enrolledStudents[j] == null)
                        enrolledStudents[j] = new Student(someStudent.name, someStudent.gradYear, someStudent.Academy);
                }
                return true;
            }

            else if (someStudent.schedule[i].equals(new Course(teacher, courseTitle, honors)))
                return false;
        }
        return false;
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
