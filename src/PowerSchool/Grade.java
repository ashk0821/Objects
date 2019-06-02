package PowerSchool;

public class Grade {
    int grade;
    boolean audited;
    boolean honors;
    Course course;

    public Grade(boolean honors, boolean audited, int grade, Course course){
        this.honors = honors;
        this.audited = audited;
        this.course = course;

        if(this.grade > 1000){
            this.grade = 1000;
        }
        else if(this.grade < 0){
            this.grade = 0;
        }
        else
            this.grade = grade;


    }

    public int gradeValue(){
        //if (audited())
          //  grade = -1;

        if(honors())
            grade += grade * 0.05;

        return grade;
    }

    public void setAudited(boolean audited) {
        this.audited = audited;
    }

    public boolean honors(){
        return honors;
    }

    public boolean audited(){
        return audited;
    }
}
