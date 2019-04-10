package PowerSchool;

public class Grade {
    int grade;
    boolean audited;
    boolean honors;
    Course course;

    public Grade(boolean honors, boolean audited, int grade, Course course){
        if(grade > 1000){
            grade = 1000;
        }
        if(grade < 0){
            grade = 0;
        }

        this.grade = grade;
        this.honors = honors;
        this.audited = audited;
        this.course = course;


    }

    public int gradeValue(){
        if (audited())
            grade = -1;

        if(honors())
            grade += grade * 0.05;

        return grade;
    }

    public boolean honors(){
        return honors;
    }

    public boolean audited(){
        return audited;
    }
}
