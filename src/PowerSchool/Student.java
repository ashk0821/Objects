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
        Grade g;
        for(int i = 0; i < schedule.length; i++){
            g = schedule[i].gradeOf()
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
}
