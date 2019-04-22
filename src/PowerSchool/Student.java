package PowerSchool;

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

    public int getGPA(){
        int GPA = 0;
        int numberOfCourses = 0;

        for (int i = 0; i < schedule.length; i++){
            if (schedule[i] == null) {
                numberOfCourses = i;
                break;
            }
            if (schedule[i].gradeOf(this).gradeValue() > -1)
                GPA += schedule[i].gradeOf(this).gradeValue();

        }

        if (numberOfCourses == 0)
            return 0;
        return GPA / numberOfCourses;
    }

    public int compareTo(Student someOtherKid){
        if(getGPA() < someOtherKid.getGPA()){
            return -1;
        }
        else if(getGPA() > someOtherKid.getGPA()){
            return 1;
        }

        return 0;
    }

    /* Adds course and returns true if successful.
     * Returns false if: course would brings classes to more than
     * 10, or student is already enrolled. */
    public boolean addCourse(Course someCourse) {
        for (int i = 0; i < Academy.schoolCourses.length; i++) {
            if (Academy.schoolCourses[i] == null)
                return false;

            if (Academy.schoolCourses[i].teacher.equals(someCourse.teacher) && Academy.getCourses()[i].courseTitle.equals(someCourse.courseTitle))
                break;
        }

        if (someCourse.enrolledStudents[someCourse.enrolledStudents.length - 1] != null)
            return false;

        if (schedule[schedule.length - 1] != null)
            return false;

        for (int i = 0; i < schedule.length; i++) {
            if (schedule[i] == someCourse)
                return false;

            if (schedule[i] == null) {
                schedule[i] = someCourse;
                break;
            }
        }
        return true;
    }

    /* Removes course and returns true if successful.
     * Returns false if: course was not on student’s schedule.
     */
    public boolean dropCourse(Course someCourse) {
        Student student = new Student(name, gradYear, Academy);

        for (int i=0; i<schedule.length; i++) {
            if (schedule[i] == null)
                return false;
            if (schedule[i].teacher.equals(someCourse.teacher) && schedule[i].courseTitle.equals(someCourse.courseTitle))
                break;
        }

        someCourse.unenroll(student);
        return true;
    }
}
