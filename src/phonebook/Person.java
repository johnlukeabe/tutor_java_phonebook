/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;

/**
 *
 * @author John
 */
public class Person {   
    private String name;
    private String number;

    Person (){ }
    
    String getName(){
        return this.name;
    }
    
    void setName(String name){
        this.name = name;
    }
    
    String getNumber(){
        return this.number;
    }
    
    void setNumber(String number){
        this.number = number;
    }
    
    @Override
    public String toString() {
        return "Name   : " + this.name + ", " + "Number : " + this.number;
    }
}
