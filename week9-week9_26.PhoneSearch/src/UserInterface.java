
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/*1
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael
 */
public class UserInterface {
    private Phonebook phonebook;
    
    public void initilize(){
        phonebook = new Phonebook();
    }
    
    public void printMenuChoices(){
        System.out.println("phone search\n" + "available operations:\n" + " 1 add a number\n" + " 2 search for a number\n" + " 3 search for a person by phone number\n" + " 4 add an address\n" + " 5 search for personal information\n" + " 6 delete personal information\n" + " 7 filtered listing\n" + " x quit");
    }
    
    public void addingPhoneToPerson( Scanner reader ){
        System.out.print("whose number: ");
        String name = reader.nextLine();
        System.out.print(" ");
        String phone = reader.nextLine();
        phonebook.addPersonAndPhoneNumber(name, phone);
    }
    
    public void searchPhoneByName( Scanner reader ){
        System.out.print("whose number: ");
        String name = reader.nextLine();
        boolean found = true;
        for (Person person : phonebook.getPersonAndTheirNumber().keySet()) {
            if ( person.getName().equals(name)) {
                found = false;
                for (String phone : phonebook.getPersonAndTheirNumber().get(person)) {
                    phone = " " + phone;
                    System.out.println(phone);
                }
            }
        }
        if (found) {
            System.out.println("  not found");
        }
    }
    
    public void searchNameByPhone( Scanner reader ){
        System.out.print("number: ");
        String phone = reader.nextLine();
        if ( !phonebook.getPhoneMatchedToPerson().containsKey(phone)) {
            System.out.println(" not found");
        } else {
            System.out.println(" " + phonebook.getPhoneMatchedToPerson().get(phone));
        }
    }
    
    public void addingAddress( Scanner reader ){
        System.out.print("whose address: ");
        String name = reader.nextLine();
        boolean notFound = true;
        for (Person person : phonebook.getPersonAndTheirNumber().keySet()) {
            if ( person.getName().equals(name)) {
                notFound = false;
                System.out.print("street: ");
                String street = reader.nextLine();
                System.out.print("city: ");
                String city = reader.nextLine();
                person.setAddress(street);
                person.setCity(city);
            }
        }
        if (notFound) {
            System.out.print("street: ");
            String street = reader.nextLine();
            System.out.print("city: ");
            String city = reader.nextLine();
            Person person = new Person(name, street, city);
            phonebook.addPersonWithPersonalInformation(person);
        }
    }
    
    public void findInfo( Scanner reader ){
        System.out.print("whose information: ");
        String name = reader.nextLine();
        boolean notFound = true;
        for (Person person : phonebook.getPersonAndTheirNumber().keySet()) {
            if ( person.getName().equals(name) ) {
                notFound = false;
                if ( !person.getAddress().isEmpty()) {
                    System.out.println("  address: " + person.getAddress() + " " + person.getCity());
                } else{
                    System.out.println("  address unknown");
                }
                if ( !phonebook.getPersonAndTheirNumber().get(person).isEmpty()) {
                    System.out.println("  phone numbers:");
                    for (String phoneNumber : phonebook.getPersonAndTheirNumber().get(person)) {
                        System.out.println("   " + phoneNumber);
                    }
                } else {
                    System.out.println("  phone number not found");
                }
            }
        }
        if (notFound) {
            System.out.println("  not found");
        }
    }
    
    public void deletePersonalInformation( Scanner reader ){
        System.out.print("whose information: ");
        String name = reader.nextLine();
        Set<String> onePersonNum = null;
        Person removedPerson = null;
        for (Person person : phonebook.getPersonAndTheirNumber().keySet()) {
            if ( person.getName().equals(name)) {
                onePersonNum = phonebook.getPersonAndTheirNumber().get(person);
                removedPerson = person;
            }
        }
        phonebook.getPersonAndTheirNumber().remove(removedPerson);
        if (onePersonNum != null) {
            for (String number : onePersonNum) {
                phonebook.getPhoneMatchedToPerson().remove(number);
            }
        }
        /*
        for ( String phone : phonebook.getPhoneMatchedToPerson().keySet()) {
            if ( phonebook.getPhoneMatchedToPerson().get(phone).equals(name)) {
                phonebook.getPhoneMatchedToPerson().remove(phone);
            }
        }
        for ( Person person : phonebook.getPersonAndTheirNumber().keySet()) {
            if ( person.getName().equals(name)) {
                phonebook.getPersonAndTheirNumber().remove(person);
            }
        }
        */
    }
    
    public void filteredSearch( Scanner reader ){
        System.out.print("keyword (if empty, all listed): ");
        String word = reader.nextLine();
        System.out.println("");
        boolean notFound = true;
        List<Person> personsMatchingKeyword = new ArrayList<Person>();
        for (Person person : phonebook.getPersonAndTheirNumber().keySet()) {
            if ( person.getName().contains(word) || person.getAddress().contains(word) || person.getCity().contains(word)) {
                notFound = false;
                personsMatchingKeyword.add(person);
                /*
                System.out.println(" " + person.getName());
                if ( person.getAddress().isEmpty() || person.getCity().isEmpty()) {
                    System.out.println("  address unknown");
                } else {
                    System.out.println("  address: " + person.getAddress() + " " + person.getCity());
                }
                if ( phonebook.getPersonAndTheirNumber().get(person).isEmpty()) {
                    System.out.println("  phone number not found");
                } else {
                    System.out.println("  phone numbers:");
                    for (String phoneNum : phonebook.getPersonAndTheirNumber().get(person)) {
                        System.out.println("   " + phoneNum );
                    }
                }
                */
                
            }
        }
        Collections.sort(personsMatchingKeyword);
        for (Person person : personsMatchingKeyword) {
            System.out.println(" " + person.getName());
            if ( person.getAddress().equals("")) {
                System.out.println("  address unknown");
            } else {
            System.out.println("  address: " + person.getAddress() + " " + person.getCity());
            }
            if (phonebook.getPersonAndTheirNumber().get(person).isEmpty()) {
                System.out.println("  phone number not found");
            } else {
                System.out.println("  phone numbers:");
                for (String phoneNum : phonebook.getPersonAndTheirNumber().get(person)) {
                    System.out.println("   " + phoneNum);
                }
            }
        }
        if (notFound) {
            System.out.println("  not found");
        }
    }
}
