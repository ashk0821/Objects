package PowerSchool;
// Alan Salnikov

import org.omg.CORBA.CODESET_INCOMPATIBLE;

import java.util.Arrays;

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

        int i=0;
        while (comp_sci.enrolledStudents[i] != null) {
            System.out.println(comp_sci.enrolledStudents[i]);
        }

        comp_sci.unenrollStudent(amani);

        if (comp_sci.addStudent(amani))
            System.out.println("Passed 2");
        else
            System.out.println("Failed 2");

        System.out.println(comp_sci.enrolledStudents());
        if (comp_sci.enrolledStudents() == 5)
            System.out.println("Passed 3");
        else
            System.out.println("Failed 3");

        Course intro = new Course ("Mr. Respass", "Intro to Comp Sci", false);
        Course scratch = new Course ("Mr. Billy", "Intro to Scratch", false);

        comp_sci.createClass("Mr. Respass", "Intro to Comp Sci", false);
        comp_sci.createClass("Mr. Wang", "C and Data Structures", true);
        comp_sci.createClass("Mr. Isecke", "AP Comp Sci", true);
        comp_sci.createClass("Mr. Isecke", "Advanced Topics", true);

        if (comp_sci.createClass("Mr. Respass", "Intro to Comp Sci", false))
            System.out.println("Failed 4a");
        else
            System.out.println("Passed 4a");

        if (Arrays.equals(comp_sci.getCourses(), comp_sci.schoolCourses))
            System.out.println("Passed 5");
        else
            System.out.println("Failed 5");

        if (comp_sci.enroll(alan, intro, false))
            System.out.println("Passed 6");
        else
            System.out.println("Failed 6");

        if (intro.enroll(aashir, false))
            System.out.println("Passed 6a");
        else
            System.out.println("Failed 6a");

        intro.enroll(amani, false);
        intro.enroll(aashir, false);
        intro.enroll(chris, false);

        if (comp_sci.enroll(alan, scratch, false))
            System.out.println("Failed 7");
        else
            System.out.println("Passed 7");

        if (comp_sci.unenroll(alan, intro))
            System.out.println("Passed 8");
        else
            System.out.println("Failed 8");

        if (alan.getName().equals("Alan"))
            System.out.println("Passed 9");
        else
            System.out.println("Failed 9");

        if (aashir.getName().equals("Amani"))
            System.out.println("Failed 10: just like Mr. Respass");
        else
            System.out.println("Passed 10");

        if (chris.getGradyear() == 2022)
            System.out.println("Failed 11, although I can see why");
        else
            System.out.println("Passed 11, but it is very unclear why");

        if (ansh.getGradyear() == 2021)
            System.out.println("Passed 11b");
        else
            System.out.println("Failed 11b");

        if (alan.getAcademy() == comp_sci)
            System.out.println("Passed 12");
        else
            System.out.println("Failed 12");

        // after get GPA are done as well as compare to, we can implement more tests

        if (intro.courseTitle().equals("Intro to Comp Sci"))
            System.out.println("Passed 13");
        else
            System.out.println("Failed 13");

        if (intro.courseTeacher().equals("Mr. Respass"))
            System.out.println("Passed 14");
        else
            System.out.println("Failed 14");

        intro.setGrade(alan, 100);
        intro.setGrade(aashir, 99);
        intro.setGrade(chris, 95);
        intro.setGrade(amani, 65);
        intro.setGrade(ansh, 73);

        if (intro.topStudent() == alan)
            System.out.println("Passed 15");
        else
            System.out.println("Failed 15");

        if (Arrays.equals(intro.enrolledStudents, intro.enrolledStudents()))
            System.out.println("Passed 16");
        else
            System.out.println("Failed 16");

        // what is gradeOf(student)?


    }
}
