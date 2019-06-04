package PowerSchool;

import java.util.Arrays;

public class Student implements Comparable<Student>{
    String name;
    int gradYear;
    School Academy;
    Course[] schedule;

    public Student(String name, int gradYear, School Academy){
        this.name = name;
        this.gradYear = gradYear;
        this.Academy = Academy;
        this.schedule = new Course[10];
    }

    public String getName(){
        return name;
    }

    public int getGradyear(){
        return gradYear;
    }

    public School getAcademy(){
        return Academy;
    }

    public double getGPA(){
        double GPA = 0;
        double numberOfCourses = 0;
        int i = 0;
        while(schedule[i] != null) {
            for (int x =0; x < schedule[i].grades.length; x++ ){
                if (schedule[i].enrolledStudents[x] != null && schedule[i].enrolledStudents[x].equals(this)){
                    if(schedule[i].grades[x].audited == false){
                        GPA += schedule[i].gradeOf(this).gradeValue();
                        numberOfCourses++;
                    }
                }
            }
            i++;
        }

        if (numberOfCourses == 0)
            return 0;
        return GPA / numberOfCourses;
    }

    public int compareTo(Student someOtherKid){
        return (int)(this.getGPA() - someOtherKid.getGPA());

    }

    /* Adds course and returns true if successful.
     * Returns false if: course would brings classes to more than
     * 10, or student is already enrolled. */
    public boolean addCourse(Course someCourse) {
        if (schedule[schedule.length - 1] != null)
            return false;

        for (int i = 0; i < schedule.length; i++) {
            if (schedule[i] == null) {
                schedule[i] = someCourse;
                return true;
            }
            if (schedule[i].equals(someCourse))
                return false;


        }
        return false;
    }

    /* Removes course and returns true if successful.
     * Returns false if: course was not on student’s schedule.
     */
    public boolean dropCourse(Course someCourse) {
        for (int i=0; i<schedule.length; i++) {
            if (schedule[i] == null)
                return false;
            if (schedule[i].equals(someCourse))
                for(int x = i; x< schedule.length-1;x++){
                    schedule[x] = schedule[x+1];
                }
                break;
        }

        return true;
    }
}
