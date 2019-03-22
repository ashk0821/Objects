public class School {
    final String name;
    Student[] enrolledStudents;
    Course[] schoolCourses;

    public School (String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int enrolledStudents(){
        return enrolledStudents.length;
    }

    public Course[] getCourses(){
        Course[] ret = new Course[schoolCourses.length];
        for(int i = 0; i < schoolCourses.length; i++){
            ret[i] = schoolCourses[i];
        }
        return ret;
    }

    public Student kidWithClassRank(int rank){

    }

    public boolean addStudent
}
