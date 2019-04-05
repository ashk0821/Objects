package PowerSchool;
// Alan Salnikov

public class SchoolRunner {
    public static void main(String[] args) {
        School comp_sci = new School("ATCS");
        Student alan = new Student("Alan", 2021, comp_sci);
        Student ansh = new Student("Ansh", 2021, comp_sci);
        Student aashir = new Student("Aashir", 2021, comp_sci);
        Student chris = new Student("Chris", 2021, comp_sci);
        Student amani = new Student("Amani", 2021, comp_sci);

        if (comp_sci.getName().equals("ATCS"))
            System.out.println("Passed 1");
        else
            System.out.println("Failed 1");

        comp_sci.addStudent(alan);

        if (!comp_sci.addStudent(alan))
            System.out.println("Passed 2a");
        else
            System.out.println("Failed 2a");

        comp_sci.addStudent(ansh);
        comp_sci.addStudent(aashir);
        comp_sci.addStudent(chris);
        comp_sci.addStudent(amani);

        if (comp_sci.enrolledStudents() == 5)
            System.out.println("Passed 2");
        else
            System.out.println("Failed 2");

        Course intro = new Course("Mr. Respass", "Intro to Comp Sci", false);
        Course c_and_data_structures = new Course("Mr. Wang", "C and Data Structures", true);
        Course ap = new Course("Mr. Isecke", "AP Comp Sci", true);
        Course advanced = new Course ("Mr. Isecke", "Advanced Topics", true);

        comp_sci.schoolCourses[0] = intro;
        comp_sci.schoolCourses[1] = c_and_data_structures;
        comp_sci.schoolCourses[2] = ap;
        comp_sci.schoolCourses[3] = advanced;

        Course [] atcs_courses = comp_sci.getCourses();

        if (atcs_courses[1].equals(c_and_data_structures))
            System.out.println("Passed 3");
        else {
            System.out.println("Failed 3");
            System.out.println(atcs_courses[1]);
        }

        if (atcs_courses[3].equals(advanced))
            System.out.println("Passed 4");
        else {
            System.out.println("Failed 4");
            System.out.println(atcs_courses[3]);
        }

        if (atcs_courses[5] == null)
            System.out.println("Passed 5");
        else
            System.out.println("Failed 5");


    }
}
