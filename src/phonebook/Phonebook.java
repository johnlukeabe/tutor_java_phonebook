/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Jungsu Sohn
 */
public class Phonebook {
    List newList;
    
    Phonebook() {
        this.newList = new List();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Person> newList = new List<Person>();
        String input;
	boolean exit = false;

        do {
            System.out.println();
            System.out.format("****************************************%n");
            System.out.format("(A)dd \n(P)rint List \nSearch by (N)ame \nSearch by (E)mail \n(D)elete \n(S)ave \n(Q)uit%n");
            System.out.format("****************************************%n");
            System.out.format("Please Enter a command: ");
            input = in.nextLine().toUpperCase();
            
            switch (input) {
                case "A":
                    System.out.println("Add an entry");
                    System.out.print("Enter a Name: ");
                    String name = in.nextLine();
                    
                    System.out.print("Enter a Phone Number: ");
                    String phoneNumber = in.nextLine();
                    
                    System.out.print("Enter an Email: ");
                    String email = in.nextLine();
                    
                    Person newNode = new Person();		
                    newNode.setName(name);	
                    newNode.setNumber(phoneNumber);
                    newNode.setEmail(email);
                    newList.add(newNode);
                    break;                      
                case "P": 
                    System.out.println("Print Phonebook");
                    newList.printList();
                    break; 
                case "N":
                    System.out.println("Enter a name to search: ");
                    name = in.nextLine();
                    boolean isFound = false;
                    for(int i = 0; i < newList.getLength(); i++) {
                        Person p = newList.getIdx(i);
                        if(p != null && p.getName().equals(name)) {
                            System.out.println(p);
                            isFound = true;
                        }
                    }
                    if(isFound == false) System.out.println("Not Found");
                    break;
                case "E":
                    System.out.println("Enter an Email to search: ");
                    email = in.nextLine();
                    isFound = false;
                    for(int i = 0; i < newList.getLength(); i++) {
                        Person p = newList.getIdx(i);
                        if(p != null && p.getEmail().equals(email)) {
                            System.out.println(p);
                            isFound = true;
                        }
                    }
                    if(isFound == false) System.out.println("Not Found");
                    break;                    
                case "D":
                    System.out.println("Enter a name to delete: ");
                    name = in.nextLine();
                    isFound = false;
                    for(int i = 0; i < newList.getLength(); i++) {
                        Person p = newList.getIdx(i);
                        if(p != null && p.getName().equals(name)) {
                            newList.delete(i);
                            isFound = true;
                        }
                    }
                    if(isFound == false) System.out.println("Not Found");
                    break;
                case "Q": 
                    System.out.println("Exiting Phonebook");
                    exit = true;
                    break;
                case "S":
                    BufferedWriter wr = null;
                    try { 
                        wr = new BufferedWriter(new FileWriter("phoneBook.txt", true));
                        if (newList.isEmpty()) {
                            System.out.println("Nothing on the Phonebook");
                        } else {
                            for(int i = 0 ; i < newList.getLength(); i++) {
                                wr.append(newList.getNode(i).toString());
                                wr.newLine();
                            }
                        }
                    } catch (IOException ex) {
                        System.out.println(ex);
                    } finally {
                        if (wr != null) {
                            try {
                                wr.close();
                            } catch (IOException ex) {
                            }
                        }
                    }
                    break;
                default: 
                    System.out.println("Unknown command");
            }
        }  while (!exit);
    }
}
