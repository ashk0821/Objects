package PowerSchool;

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
    }

    public String courstTitle(){
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
        if(enrolledStudents.length >= 20){
            return false;
        }

        if()
    }
}
