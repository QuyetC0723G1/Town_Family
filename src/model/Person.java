package model;

public class Person {
    private String fullName;
    private int age;
    private String job;
    private int idNumber;

    public Person(String fullName, int age, String job, int idNumber) {
        this.fullName = fullName;
        this.age = age;
        this.job = job;
        this.idNumber = idNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public void showInfo(){
        System.out.println("Full name : " + fullName);
        System.out.println("Age : " +age);
        System.out.println("Job : "+job);
        System.out.println("Id Number : "+idNumber);
    }
}
