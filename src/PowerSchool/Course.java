package PowerSchool;

import java.util.Arrays;

public class Course {
    String courseTitle;
    String teacher;
    Student[] enrolledStudents;
    Grade[] grades;
    boolean honors;

    public Course(String teacher, String title, boolean honors){
        this.teacher = teacher;
        this.courseTitle = title;
        this.honors = honors;
        this.enrolledStudents = new Student[20];
        this.grades = new Grade[20];
    }

    public String courseTitle(){
        return courseTitle;
    }

    public String courseTeacher(){
        return teacher;
    }

    public Grade gradeOf(Student someStudent){
        for(int i = 0; i < enrolledStudents.length; i++){
            if (enrolledStudents[i] == null)
                break;
            if(enrolledStudents[i].equals(someStudent)){
                return grades[i];
            }
        }
        return null;
    }

    public int numberEnrolled(){
        int length = 0;
        for (int i = 0; i < enrolledStudents.length; i++) {
            if (enrolledStudents[i] == null)
                break;
            length++;
        }

        return length;
    }

    public Student[] enrolledStudents(){
        int length = 0;


        for (int i=0; i<enrolledStudents.length; i++) {
            while (enrolledStudents[i] != null)
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
                break;

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

    public boolean enroll(Student someStudent, boolean audited) {
        if (enrolledStudents[enrolledStudents.length - 1] != null)
            return false;

        boolean temp = someStudent.addCourse(this);

        if (temp){
            for (int i =0; i < enrolledStudents.length; i++){
                if (enrolledStudents[i] ==null){
                    enrolledStudents[i] = someStudent;
                    grades[i] = new Grade(honors, audited, 0, this);
                    break;
                }
            }
        }
        return temp;
    }

    public void unenroll (Student someStudent) {
        for (int i=0; i<enrolledStudents.length; i++) {
            if (enrolledStudents[i] == null)
                break;
            if (enrolledStudents[i].equals(someStudent)) {
                enrolledStudents[i] = null;
                grades[i] = null;
                Arrays.sort(enrolledStudents);
                Arrays.sort(grades);
                someStudent.dropCourse(this);
                break;
            }
        }

    }
}
