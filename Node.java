/*
 * CS2050 - Computer Science II - Summer 2021
 * Instructor: Thyago Mota
 * Student Name: Lena Hamilton
 * Description: Prg01 - Node Class
 */

package Project.Project1;

public class Node {

    private Element element;
    private int amount;
    private Node next;

    public static final int DEFAULT_AMOUNT = 1;

    public Node(final Element element, int amount) {
        this.element = element;
        if (amount < DEFAULT_AMOUNT)
            this.amount = DEFAULT_AMOUNT;
        else
            this.amount = amount;
        next = null;
    }

    public Node(final Element element) {
        this(element, DEFAULT_AMOUNT);
    }

    public Element getElement() {
        return element;
    }

    public int getAmount() {
        return amount;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void insert(Node newNode) {
        Node tail = getNext();
        newNode.setNext(tail);
        setNext(newNode);

    }

    @Override
    public String toString() {

        if (amount > DEFAULT_AMOUNT) {
            return element.getAtomLetter() + "_" + amount;
        } else {
            return element.getAtomLetter();
        }
    }

    // testing Node output
    
    // public static void main(String[] args) {
    // Node c = new Node(new Element("c"));
    // Node h = new Node(new Element("h"));
    // Node d = new Node(new Element("d"));
    // Node k = new Node(new Element("k"));
    // Node f = new Node(new Element("f"));

    // System.out.println(f.getElement().getAtomLetter().compareTo(d.getElement().getAtomLetter()));

    // }
}