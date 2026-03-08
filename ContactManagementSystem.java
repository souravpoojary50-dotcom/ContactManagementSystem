import java.util.ArrayList;
import java.util.Scanner;
class Contact{
    String name;
    String phone;
    String email;
    Contact(String name,String phone,String email){
        this.name=name;
        this.phone=phone;
        this.email=email;
    }
}






public class ContactManagementSystem {
    public static void main(String[] args){
        ArrayList<Contact>contacts=new ArrayList<>();
        Scanner sc= new Scanner(System.in);
        while (true) {
            System.out.println("\n=======================================================");
            System.out.println("CONTACT MANAGEMENT SYSTEM");
            System.out.println("\n=======================================================");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contact");
            System.out.println("3.Search Contact");
            System.out.println("4.Update Contact");
            System.out.println("5.Delete Contact");
            System.out.println("6.Exit");
            int choice=0;
            try{
                System.out.println("Enter your choice:");
                choice=sc.nextInt();
                sc.nextLine();
            }
            catch(Exception e){
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine();
                continue;
            }
            switch (choice) {
                case 1:
                    System.out.println("Enter Name:");
                    String name=sc.nextLine();
                    System.out.println("Enter Phone");
                    String phone=sc.nextLine();
                    System.out.println("Enter Email:");
                    String email=sc.nextLine();
                    contacts.add(new Contact(name,phone,email));
                    System.out.println("Contact Added Successfully!");
                    break;
                case 2:
                    if(contacts.isEmpty()){
                        System.out.println("No contacts availabe.");
                    }
                    else{
                        for(Contact c: contacts){
                            System.out.println("-------------------------------------------------");
                            System.out.println("Name:"+c.name);
                            System.out.println("Phone:"+c.phone);
                            System.out.println("Email:"+c.email);
                        }
                    } 
                    break;
                case 3:
                    System.out.println("Enter name to search:");    
                    String searchName=sc.nextLine();
                    boolean found=false;
                    for(Contact c: contacts){
                        if(c.name.equalsIgnoreCase(searchName)){
                            System.out.println("Contact Found:");
                            System.out.println("Name:"+c.name);
                            System.out.println("Phone:"+c.phone);
                            System.out.println("Email:"+c.email);
                            found=true;
                        }
                    }
                    if(!found){
                        System.out.println("Contact not found.");
                    } break;
                    case 4:
                        System.out.println("Enter name to update:");
                        String updateName=sc.nextLine();
                        boolean updated=false;
                        for(Contact c: contacts){
                            if(c.name.equalsIgnoreCase(updateName)){
                                System.out.println("Enter neew phone:");
                                c.phone=sc.nextLine();
                                System.out.println("Enter your Email:");
                                c.email=sc.nextLine();
                                System.out.println("Contact Updated!");
                                updated=true;
                            }
                        }
                        if(!updated){
                            System.out.println("Contact not found.");
                        }
                        break;
                        case 5:
                            System.out.println("Enter name to delete:");
                            String deleteName=sc.nextLine();
                            contacts.removeIf(c->c.name.equalsIgnoreCase(deleteName));
                            System.out.println("Contact Deleted!");
                            break;
                        case 6:
                            System.out.println("Exiting program...");
                            return;
                        default:
                            System.out.println("Invalid choice!");
                    }
                    System.out.println("\nTotal Contacts:"+contacts.size());
        }
    }
}
