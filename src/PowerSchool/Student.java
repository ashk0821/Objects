package PowerSchool;

public class Student implements Comparable<Student>{
    String name;
    int gradYear;
    School academy;
    Course[] schedule = new Course[10];

    public Student(String name, int gradYear, School Academy){
        this.name = name;
        this.gradYear = gradYear;
        this.academy = Academy;
    }

    public String getName(){
        return name;
    }

    public int getGradyear(){
        return gradYear;
    }

    public School getAcademy(){
        return academy;
    }

    public double getGPA(){
        Grade g;
        for(int i = 0; i < schedule.length; i++){
            //g = schedule[i].gradeOf();
        }

        return 0;
    }

    public int compareTo(Student someOtherKid){
        // don't know what comapreTo value needs to be returned, have to check
        if(getGPA() < someOtherKid.getGPA()){
            return 1;
        }
        return 0;
    }

    /* Adds course and returns true if successful.
     * Returns false if: course would brings classes to more than
     * 10, or student is already enrolled. */
    public boolean addCourse(Course someCourse) {
        boolean audited = false;
        Student student = new Student(name, gradYear, academy);
        if (schedule[schedule.length-1] != null)
            return false;

        someCourse.enroll(student, audited);
        return true;
    }
    /* Removes course and returns true if successful.
     * Returns false if: course was not on student’s schedule.
     */
    public boolean dropCourse(Course someCourse) {
        Student student = new Student(name, gradYear, academy);

        for (int i=0; i<schedule.length; i++) {
            if (schedule[i] == null)
                return false;
            if (schedule[i] == someCourse)
                break;
        }

        someCourse.unenroll(student);
        return true;
    }
}
