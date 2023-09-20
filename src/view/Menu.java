package view;

import manager.TownManager;
import model.Family;
import model.Person;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    TownManager townManager = new TownManager();
    Scanner inputNumber = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);

    public void showMenu(){
        addTest();

        int choice;
        do{
            try {
                System.out.println("========> Menu <===========");
                System.out.println("1 : Add new Family");
                System.out.println("2 : Add new Member To Family");
                System.out.println("3 : Remove Family - Members");
                System.out.println("4 : Change Family Address - Members Information");
                System.out.println("5 : Find Family by address");
                System.out.println("6 : List Family in Town ");
                System.out.println("7 : Exit ");
                System.out.println("Enter your choice :");
                choice = inputNumber.nextInt();
                switch (choice){
                    case 1:
                        showAddMenu();
                        break;
                    case 2:
                        showMenuAddMemberToFamily();
                        break;
                    case 3:
                        showRemoveMenu();
                        break;
                    case 4:
                        showEditMenu();
                        break;
                    case 5:
                        findFamilyByAndres();
                        break;
                    case 6:
                        showAllMenu();
                        break;
                    case 7:
                        System.exit(0);
                        break;
                }
            }catch (InputMismatchException e) {
                System.out.println("Please only enter numbers from 1 to 7 ");
                inputNumber.nextLine();
            }
            System.out.println();
        }while (true);
    }

    public void showAddMenu(){
        System.out.println("Enter address of Family :");
        String andres = inputString.nextLine();
        Family family = new Family(andres);
        System.out.println("The number of member you want to add to the family :");
        int numberOfMember = inputNumber.nextInt();
        for (int i = 0; i < numberOfMember; i++) {
            System.out.println("Enter full name member "+(i+1)+" : ");
            String fullName = inputString.nextLine();
            System.out.println("Enter age member "+(i+1)+" : ");
            int age = inputNumber.nextInt();
            System.out.println("Enter job of member "+(i+1)+" : ");
            String job = inputString.nextLine();
            System.out.println("Enter id number of member "+(i+1)+" : ");
            int idNumber = inputNumber.nextInt();
            Person person = new Person(fullName,age,job,idNumber);
            family.addPerson(person);
            System.out.println("==== Completed adding this member ====");
        }
        townManager.addFamily(family);
    }

    public void showAllMenu(){
        townManager.showAllFamily();
    }
    public void findFamilyByAndres(){
        System.out.println("Enter address of Family : ");
        String andresFind = inputString.nextLine();
        townManager.findFamily(andresFind);

    }

    public void addTest(){
        Family family = new Family("Thai Binh");
        Family family1 = new Family("Phu Yen");
        Person person1 = new Person("Pham Dang Quyet", 31, "Free", 19002009);
        Person person2 = new Person("Pham Dang A", 21, "Free", 19002008);
        Person person3 = new Person("Pham Dang B", 41, "Free", 19002007);
        family.addPerson(person1);
        family.addPerson(person2);
        family.addPerson(person3);


        Person person4 = new Person("Nguyen Tan A", 41, "Free", 2002007);
        Person person5 = new Person("Nguyen Tan B", 21, "Free", 2002008);
        family1.addPerson(person4);
        family1.addPerson(person5);

        townManager.addFamily(family);
        townManager.addFamily(family1);
    }
    public void showEditMenu(){
        System.out.println("Enter address of Family : ");
        String address = inputString.nextLine();
        townManager.editFamily(address);

    }
    public void showRemoveMenu(){
        System.out.println("Enter the address of the family you want to remove : ");
        String andresFind = inputString.nextLine();
        townManager.removeFamily(andresFind);

    }
    public void showMenuAddMemberToFamily(){
        System.out.println("Enter the address of the family you want to add : ");
        String addressFind = inputString.nextLine();
        townManager.findFamilyToAddMember(addressFind);
    }
}
