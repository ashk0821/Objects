package PowerSchool;

public class Student implements Comparable<Student>{
    String name;
    int gradYear;
    School Academy;
    Course[] schedule = new Course[10];

    public Student(String name, int gradYear, School Academy){
        this.name = name;
        this.gradYear = gradYear;
        this.Academy = Academy;
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
        Student student = new Student(name, gradYear, Academy);

        double GPA = 0.0;
        double numberOfCourses = 0.0;

        for (int i = 0; i < schedule.length; i++){
            if (schedule[i] == null) {
                numberOfCourses = i;
                break;
            }
            if (schedule[i].gradeOf(student).gradeValue() > -1)
                GPA += schedule[i].gradeOf(student).gradeValue();
        }

        return GPA / numberOfCourses;
    }

    public int compareTo(Student someOtherKid){
        // don't know what comapreTo value needs to be returned, have to check
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
        for (int i=0; i<Academy.schoolCourses.length; i++) {
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
                schedule[i] = new Course(someCourse.teacher, someCourse.courseTitle, someCourse.honors);

                for (int j = 0; j < someCourse.enrolledStudents.length; j++) {
                    if (someCourse.enrolledStudents[j] == null) {
                        someCourse.enrolledStudents[j] = new Student(name, gradYear, Academy);
                        return true;
                    }
                }
            }
        }
        return false;
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
