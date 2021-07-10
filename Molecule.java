/*
 * CS2050 - Computer Science II - Summer 2021
 * Instructor: Thyago Mota
 * Student Name: Lena Hamilton
 * Description: Prg01 - Molecule Class
 */

/**
 * Molecules form when two or more atoms form chemical bonds with each other.
 */

package Project.Project1;

public class Molecule {

    private Node head;
    private String name;

    // TODO: initialize the molecule with the information provided by the user
    public Molecule(final String name) {
        this.name = name;
        head = null;
    }

    // TODO: returns the name of the molecule
    public String getName() {
        return name;
    }

    // TODO: returns true/false depending whether the molecule is empty or not
    public boolean isEmpty() {
        return head == null;
    }

    /* TODO: The elements in a molecule must be distinct; therefore, the add method should check if an element is already in the molecule before adding it; also,the elements in a molecule should respect the Hill system, which states that carbon atoms are listed first, hydrogen atoms next, and then all other elements are added in alphabetical order
    */

    public void add(final Element givenElement, int amount) {
        
        Node newNode = new Node(givenElement, amount);

        // case1, molecule is empty-create a new node from element and amount and set head to new node
        if (this.isEmpty()) {
            newNode.setNext(head);
            head = newNode;
            return;
        }

        // case2 if molecule contains given element-do nothing
        if (this.contains(givenElement))
            return;

        // case3 molecule does not contain the given element begin with carbon and hydrogen
            // given element is carbon-head insert
        if (givenElement.getAtomLetter().equals("C")) {
            newNode.setNext(head);
            head = newNode;
            return;
        }

            // hydrogen must be 2nd if carbon is present or 1st if not
        if (givenElement.getAtomLetter().equals("H")) {
            if (get(0).getAtomLetter().equals("C")) {
                head.insert(newNode);
                return;
            } else {
                newNode.setNext(head);
                head = newNode;
                return;
            }
        }

        // case4 insert all other given elements in alphabetical order 
        Node previous = null;
        Node current = head;
        while (true) {
            // use compare to if +num move on, if -num insert
            int placeNum = givenElement.getAtomLetter().compareTo(current.getElement().getAtomLetter());

            if (placeNum < 0) {
                if (previous == null) {
                    newNode.setNext(head);
                    head = newNode;
                    return;
                }
                previous.insert(newNode);
                return;

            } else {
                previous = current;
                current = current.getNext();

                if (current == null) {
                    previous.insert(newNode);
                    return;
                }
            }
        }

    }

    // TODO: adds the given element, assuming that the amount is Node.DEFAULT_AMOUNT which is 1
    public void add(final Element element) {

        //call above add and pass default amount from node
        add(element, Node.DEFAULT_AMOUNT);
    }

    // TODO: returns true/false depending whether the target element can be found in the molecule or not
    public boolean contains(final Element target) {
        
        Node current = head;
        while (current != null) {
            if (target.getAtomLetter().equals(current.getElement().getAtomLetter())) {
                return true;
            } else {
                current = current.getNext();
            }
        }
        return false;
    }

    // TODO: returns the number of elements in the molecule
    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    // TODO: returns the element at the given index location (null if the index is invalid)
    public Element get(int index) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getElement();
    }

    // TODO: returns a textual representation of the molecule
    @Override
    public String toString() {
        String out = "";
        Node current = head;
        while (current != null) {
            out += current;
            current = current.getNext();
        }
        return "\"" + name + "\" : " + out;
    }

    // testing Molecule output
    
    // public static void main(String[] args) {
    // Element C = new Element("C", "carbon");
    // Element O = new Element("O", "oxygen");

    // Element N = new Element("N", "nitrogen");
    // Molecule co2 = new Molecule("Carbon Dioxide");
    // co2.add(O, 2);
    // co2.add(C);
    // System.out.println("co2=" + co2);
    // System.out.println(co2.contains(N));
    // }
}