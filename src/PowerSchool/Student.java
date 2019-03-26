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
        for(int i = 0; i < schedule.length; i++){

        }
    }

    public int compareTo(Student someOtherKid){

    }
}
