package manager;

import model.Family;
import model.Person;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class TownManager {
    Scanner input = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);
    ArrayList<Family> listFamily;
    private static int number = 0;

    public TownManager() {
        listFamily = new ArrayList<>();
    }
    public void addFamily(Family family){
        listFamily.add(family);
        number++;
    }
    public void editFamily(String andres){
        int check1;
        int idMember;
        String address;
        for (Family family : listFamily) {
            if (Objects.equals(family.getAndres(), andres)) {
                System.out.println("\nDo you want to change this family address or change family member information ?");
                System.out.println("1. To change address of this Family \n2. To change member information \n3. To go back \nEnter your choice : ");
                check1 = input.nextInt();
                if (check1 == 1) {
                    System.out.println("Enter new Address :");
                    input.nextLine();
                    address = input.nextLine();
                    family.setAndres(address);
                    System.out.println("==== Completed change address " + address + " to this Family ====");
                    return;
                } else if (check1 == 2) {
                    System.out.println("\nCheck info members this Family : ");
                    family.showAll();
                    System.out.println("\nEnter the Id of member want to change : ");
                    idMember = input.nextInt();
                    family.edit(idMember);
                    return;
                }
                return;
            }
        }
        System.out.println("This address could not be found");
    }
    public void showAllFamily(){
        for (int i = 0; i < listFamily.size(); i++) {
            System.out.println("\n*** Family "+ (i+1) +" info *** ");
            listFamily.get(i).showAll();
            System.out.println("---------------------------");
        }
    }
    public void findFamily(String andres){
        ArrayList<Family> familyFind = new ArrayList<>();
        for (Family value : listFamily) {
            if (Objects.equals(value.getAndres(), andres)) {
                familyFind.add(value);
            }
        }
        if (familyFind.isEmpty()){
            System.out.println("This family could not be found");
        }
        else {
            System.out.println("Search Results : ");
            for (Family family:familyFind) {
                family.showAll();
            }
        }
    }
    public void findFamilyToAddMember(String address){
        for (Family value : listFamily) {
            if (Objects.equals(value.getAndres(), address)) {
                System.out.println("Enter full name new member : ");
                String name = inputString.nextLine();
                System.out.println("Enter age of new member : ");
                int age = input.nextInt();
                System.out.println("Enter job of new member : ");
                String job = inputString.nextLine();
                System.out.println("Enter id number of new member : ");
                int idNumber = input.nextInt();
                Person person = new Person(name,age,job,idNumber);
                value.addPerson(person);
                System.out.println("==== Completed add new Member to this Family ====");
                return;
            }
        }
        System.out.println("This address could not be found");

    }
    public void removeFamily(String andres){
        int choice;
        int choiceCheck;
        int idMember;
        for (Family family: listFamily) {
            if (Objects.equals(family.getAndres(), andres)){
                System.out.println("\nDo you want to delete the whole family or just one member ?");
                System.out.println("1. To delete Family \n2. To delete member of this Family \n3. To go back \nEnter your choice : ");
                choiceCheck = input.nextInt();
                if (choiceCheck == 1){
                    System.out.println("\nAre you sure you want to delete the family whose address is in " +family.getAndres() + " ??");
                    System.out.println("1. To delete this Family \n2. To return back the Menu\nEnter your choice :   ");
                    choice = input.nextInt();
                    if (choice == 1){
                        listFamily.remove(family);
                        System.out.println("==== Completed removing this Family ====");
                    }
                    return;
                } else if (choiceCheck ==2 ) {
                    System.out.println("\nCheck info members this Family : ");
                    family.showAll();
                    System.out.println("\nEnter Id of member to delete : ");
                    idMember = input.nextInt();
                    family.removePerson(idMember);
                    return;
                }return;

            }
        }
        System.out.println("This family could not be found");
    }


}
