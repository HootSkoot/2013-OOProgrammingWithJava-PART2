/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael
 */
public class Person implements Comparable<Person>{
    private String name;
    private String address;
    private String city;

    public Person(String name, String address, String city) {
        this.name = name;
        this.address = address;
        this.city = city;
    }

    public Person(String name) {
        this.name = name;
        this.address = "";
        this.city = "";
    }
    
    public void setAddress(String address){
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    @Override
    public int compareTo(Person person) {
        return name.compareTo(person.getName());
    }

}
