package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Family {
    Scanner input = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);
    ArrayList<Person> list;
    private int quantity = 0;
    private String andres;

    private int count = 0;

    public Family( String andres) {
        this.andres = andres;
        list = new ArrayList<>();

    }

    public String getAndres() {
        return andres;
    }

    public void setAndres(String andres) {
        this.andres = andres;
    }

    public void addPerson(Person person){
        list.add(person);
        quantity ++;
    }
    public void removePerson(int idPerson){
        int choice1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIdNumber() == idPerson){
                System.out.println("\nAre you sure to delete member with ID " +idPerson+ " ?");
                System.out.println("1. To delete this member \n2. To go back \nEnter your choice : ");
                choice1 = input.nextInt();
                if (choice1 == 1){
                    list.remove(i);
                    quantity--;
                    System.out.println("==== Completed removing member whith ID "+ idPerson +" ====");
                    return;
                }
                return;

            }
        }
    }
    public void edit(int idPerson){
        for (Person person : list) {
            if (person.getIdNumber() == idPerson) {
                System.out.println("Enter the new name : ");
                person.setFullName(inputString.nextLine());
                System.out.println("Enter the new age : ");
                person.setAge(input.nextInt());
                System.out.println("Enter the new job : ");
                person.setJob(inputString.nextLine());
                System.out.println("Enter the new Id : ");
                person.setIdNumber(input.nextInt());
                System.out.println("===== Completed changing this member information =====");
                return;
            }
        }
    }
    public void showAll(){
        System.out.println("Andres : "+ andres);
        System.out.println("Number of family members : " +quantity);
        System.out.println("\n==> Information about family members : <==");
        for (int i = 0; i <list.size(); i++) {
            System.out.println(":::::  Member thứ "+(i+1) +"  :::::: ");
            list.get(i).showInfo();
        }
    }

}
