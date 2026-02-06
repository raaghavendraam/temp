package node;
public class student {
    int roll;
    String name;
    double cgpa;
    String branch;
    student next;
    student left;
    student right;
    student(){

    }
    student(int roll,String name,double cgpa,String branch){
        this.roll = roll;
        this.name = name;
        this.cgpa = cgpa;
        this.branch = branch;
    }
}
