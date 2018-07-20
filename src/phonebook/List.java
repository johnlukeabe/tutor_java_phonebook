/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package phonebook;

/**
 *
 * @author Jungsu Sohn
 */

class Node<Object> {
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

public class List<Object> {
    private Node<Object> head;
    private Node<Object> tail;
    private int length;

    List() {
	head = null;
        tail = null;
	length = 0;
    }

    void add(Object input) {
        Node<Object> n = new Node<Object>(input);
        
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
            Node<Object> n = head;
            for (int i = 0; i < length; i++) {
		System.out.print("Index = " + (i+1) + " ");
		System.out.println(n);
		n = n.next;
            }
            System.out.println();
	}
    }

    Object getHeadData() {
        return head.data;
    }
    
    Object getIdx(int n) {
        Node<Object> temp = head;
        if(n == 0) return head.data;
        for(int i = 1; i < n; i++) {
           temp = temp.next;
           if(n >= length) return null;
        }
        return temp.data;
    }

    int getLength() {
        return length;
    }

    boolean isEmpty() {
	return (length == 0);
    }
}
