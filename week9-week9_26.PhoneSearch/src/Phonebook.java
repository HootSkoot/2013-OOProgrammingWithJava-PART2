
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael
 */
public class Phonebook {
    private Map<Person, Set<String>> personAndTheirNumber;
    private Map<String, String> phoneMatchedToPerson;

    public Phonebook() {
        personAndTheirNumber = new HashMap<Person, Set<String>>();
        phoneMatchedToPerson = new HashMap<String, String>();
    }
    
    public void addPersonAndPhoneNumber( String name, String phone){
        boolean notFound = true;
        for (Person person : personAndTheirNumber.keySet()) {
            if ( person.getName().equals(name)) {
                notFound = false;
                personAndTheirNumber.get(person).add(phone);
            }
        }
        if (notFound) {
                personAndTheirNumber.put( new Person(name), new HashSet<String>());
                for (Person person : personAndTheirNumber.keySet()) {
                    if ( person.getName().equals(name)) {
                        personAndTheirNumber.get(person).add(phone);
                    }
                }
        }
        
        /*
        if ( !personAndTheirNumber.containsKey(name)) {
            personAndTheirNumber.put( new Person(name), new HashSet<String>());
        }
        for (Person person : personAndTheirNumber.keySet()) {
            if (person.getName().equals(name)) {
                personAndTheirNumber.get(person).add(phone);
            }
        }
        */
        phoneMatchedToPerson.put(phone, name);
        
    }
    
    public void addPersonWithPersonalInformation( Person person ){
        personAndTheirNumber.put(person, new HashSet<String>());
    }

    public Map<Person, Set<String>> getPersonAndTheirNumber() {
        return personAndTheirNumber;
    }

    public Map<String, String> getPhoneMatchedToPerson() {
        return phoneMatchedToPerson;
    }
    
    
}
