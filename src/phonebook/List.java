/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;

class Node {
    Object data;
    Node next;
    
    Node(Object input) {
        data = input;
        next = null;
    }
    
    @Override
    public String toString(){
        return String.valueOf(this.data);
    }
}

/**
 *
 * @author John
 */
public class List {
    private Node head;
    private Node tail;
    private int length;

    List() {
	head = null;
        tail = null;
	length = 0;
    }

    void add(Object input) {
        Node n = new Node(input);
        
        if (isEmpty()) {
            head = tail = n;
            length++;
	} else {            
            tail.next = n;
            tail = tail.next;
            length++;            
        }
    }

    void printList () {	
	if (head == null) {
            System.out.println("The list is empty!");
	} else {
            // go through list and print in order
            Node n = head;
            for (int i = 0; i < length; i++) {
		System.out.print("Index = " + (i+1) + " ");
		System.out.println(n);
		n = n.next;
            }
            System.out.println();
	}
    }
    
    boolean isEmpty() {
	return (length == 0);
    }
}