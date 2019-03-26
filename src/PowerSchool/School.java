package PowerSchool;

public class School {

    final String name;
    Student[] enrolledStudents = new Student[300];
    Course[] schoolCourses = new Course[300];

    // Maximum of 300 Students per school
    // Maximum of 300 Courses per school
    public School(String name){
        this.name = name;
    }

    // Returns name of school
    public String getName(){
        return name;
    }

    // Returns number of enrolled students
    public int enrolledStudents(){
        int length = 0;
        for(int i = 0; i < enrolledStudents.length; i++){
            if(enrolledStudents[i] == null){
                return length;
            }
            length++;
        }
        return length;
    }

    /* Returns the array of courses. (Deep copy)
     */
    public Course[] getCourses(){
        Course[] ret = new Course[schoolCourses.length];
        for(int i = 0; i < ret.length; i++){
            ret[i] = schoolCourses[i];
        }

        return ret;
    }

    /* returns Student with specified class rank. Since you have implemented compareTo,
     * you can use Arrays.sort to sort enrolledStudets.
     */
    public Student kidWithClassRank(int rank){

    }

    /* Adds a student to the school.
    Returns false if the school is already full or if
    * Student is already enrolled at that school.
    */
    public boolean addStudent(Student someKid){
        if(enrolledStudents.length >= 300){
            return false;
        }

        for(int i = 0; i < enrolledStudents(); i++){
            if(enrolledStudents[i].equals(someKid)){
                return false;
            }
        }

        enrolledStudents[enrolledStudents()] = someKid;
        return true;
    }

    /* Removes a student to the school.
     */
    public void unenrollStudent(Student someKid){
        for(int i = 0; i < enrolledStudents(); i++){
            if()
        }
    }

    /* Creates a class. Returns false if a class with exactly the same specifications
     * have already been made.
     */
    public boolean createClass(String Teacher, String title, boolean honors){

    }

    /* Enrolls Student in Course and returns true if successful.
     * Returns false if: Course not in school, Course would have more than 20 students, or
     * Student would have more than 10 Courses.
     */
    public boolean enroll (Student kid, Course someCourse, boolean audited){

    }

    /* Unenrolls Student in Course and returns true if successful.
     * Returns false if: Course not in school, or Student not in Course.
     */
    public boolean unenroll (Student kid, Course someCourse){

    }


}
