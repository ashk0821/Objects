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

        this.grade = Math.max(Math.min(grade, 1000), 0);

        if(honors())
            this.grade = (int) (this.grade * 1.05);
    }

    public int gradeValue(){
        return grade;
    }

    public boolean honors(){
        return honors;
    }

    public boolean audited(){
        return audited;
    }
}
