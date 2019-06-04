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

        if (comp_sci.addStudent(alan))
            System.out.println("Passed 2");
        else
            System.out.println("Failed 2");

        if (!comp_sci.addStudent(alan))
            System.out.println("Passed 3");
        else
            System.out.println("Failed 3");

        if (comp_sci.addStudent(ansh))
            System.out.println("Passed 4");
        else
            System.out.println("Failed 4");

        comp_sci.addStudent(aashir);
        comp_sci.addStudent(chris);
        comp_sci.addStudent(amani);

        comp_sci.unenrollStudent(amani);

        if (comp_sci.addStudent(amani))
            System.out.println("Passed 5");
        else
            System.out.println("Failed 5");

        if (comp_sci.enrolledStudents() == 5)
            System.out.println("Passed 6");
        else
            System.out.println("Failed 6");

        Course intro = new Course("Mr. Respass", "Intro to Comp Sci", false);
        Course scratch = new Course ("Mr. Billy", "Intro to Scratch", false);
        Course cData = new Course ("Mr. Wang", "C and Data Structures", true);
        Course ap = new Course ("Mr. Isecke", "AP Comp Sci", true);
        Course advanced = new Course ("Mr. Isecke", "Advanced Topics", true);

        if (comp_sci.createClass( "Mr. Respass", "Intro to Comp Sci", false))
            System.out.println("Passed 7");
        else
            System.out.println("Failed 7");



        comp_sci.createClass("Mr. Wang", "C and Data Structures", true);
        comp_sci.createClass("Mr. Isecke", "AP Comp Sci", true);
        comp_sci.createClass("Mr. Isecke", "Advanced Topics", true);

        if (comp_sci.createClass("Mr. Respass", "Intro to Comp Sci", false))
            System.out.println("Failed 8");
        else
            System.out.println("Passed 8");

        if (comp_sci.enroll(alan, intro, true))
            System.out.println("Passed 9");
        else
            System.out.println("Failed 9");

        if (comp_sci.enroll(aashir, intro, true))
            System.out.println("Passed 10");
        else
            System.out.println("Failed 10");

        comp_sci.enroll(amani, intro, false);
        comp_sci.enroll(aashir, intro, false);
        comp_sci.enroll(chris, intro, false);

        if (comp_sci.enroll(alan, scratch, false))
            System.out.println("Failed 11");
        else
            System.out.println("Passed 11");

        if (comp_sci.unenroll(alan, intro))
            System.out.println("Passed 12");
        else
            System.out.println("Failed 12");

        if (alan.getName().equals("Alan"))
            System.out.println("Passed 13");
        else
            System.out.println("Failed 13");

        if (aashir.getName().equals("Amani"))
            System.out.println("Failed 14");
        else
            System.out.println("Passed 14");

        if (chris.getGradyear() == 2022)
            System.out.println("Failed 15");
        else
            System.out.println("Passed 15");

        if (ansh.getGradyear() == 2021)
            System.out.println("Passed 16");
        else
            System.out.println("Failed 16");

        if (alan.getAcademy() == comp_sci)
            System.out.println("Passed 17");
        else
            System.out.println("Failed 17");


        if (intro.courseTitle().equals("Intro to Comp Sci"))
            System.out.println("Passed 18");
        else
            System.out.println("Failed 18");

        if (intro.courseTeacher().equals("Mr. Respass"))
            System.out.println("Passed 19");
        else
            System.out.println("Failed 19");


        comp_sci.enroll(alan, cData, false);
        comp_sci.enroll(alan, ap, false);
        comp_sci.enroll(alan, advanced, false);

        intro.setGrade(alan, 1000);
        cData.setGrade(alan, 1000);
        ap.setGrade(alan, 890);
        advanced.setGrade(alan, 860);

        if ((int)alan.getGPA() == 916)
            System.out.println("Passed 20");
        else
            System.out.println("Failed 20");

        cData.enroll(ansh, false);
        ap.enroll(ansh,false);
        advanced.enroll(ansh, false);

        cData.setGrade(ansh, 1000);
        ap.setGrade(ansh, 690);
        advanced.setGrade(ansh, 760);

        ap.enroll(chris, false);
        ap.setGrade(chris, 780);
        intro.setGrade(chris, 780);

        if (ap.numberEnrolled() == 3)
            System.out.println("Passed 21");
        else
            System.out.println("Failed 21");

        if(ansh.compareTo(alan) == -100)
            System.out.println("Passed 22");
        else
            System.out.println("Failed 22");

        if(alan.compareTo(chris) == 136)
            System.out.println("Passed 23");
        else
            System.out.println("Failed 23");

        if (ap.gradeOf(chris).gradeValue() == 780)
            System.out.println("Passed 24");
        else
            System.out.println("Failed 24");


        /*if(comp_sci.kidWithClassRank(1).equals(ansh))
            System.out.println("Passed 25");
        else
            System.out.println("Failed 25");
            */


        if (ap.topStudent().equals(alan))
            System.out.println("Passed 26");
        else
            System.out.println("Failed 26");

        ap.setGrade(chris, 781);
        if (ap.gradeOf(chris).gradeValue() == 781)
            System.out.println("Passed 27");
        else
            System.out.println("Failed 27");

        Course[] temp_arr = comp_sci.getCourses();

        if(temp_arr.length == 4)
            System.out.println("Passed 28");
        else
            System.out.println("Failed 28");

        if (temp_arr[0].equals(comp_sci.getCourses()[0]))
            System.out.println("Passed 28a");
        else
            System.out.println("Failed 28a");


    }
}