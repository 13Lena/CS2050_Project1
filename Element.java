/*
 * CS2050 - Computer Science II - Summer 2021
 * Instructor: Thyago Mota
 * Student Name: Lena Hamilton
 * Description: Prg01 - Element Class
 */

/**
 * A chemical element is a pure substance that consists of one type of atom. Users can create an element by informing its atom letter and (optionally) a name. Atom letters are always written in upper case. For example, element "C" is named "carbon".
 */

package Project.Project1;

public class Element {

    private String atomLetter;
    private String name;

    public Element(String atomLetter, String name) {
        this.atomLetter = atomLetter.toUpperCase();
        this.name = name.toLowerCase();
    }

    public Element(String atomLetter) {
        this(atomLetter, "");
    }

    public String getAtomLetter() {
        return atomLetter;
    }

    public String getName() {
        return name;
    }

    // TODO: two elements are considered to be equal if they have the same atom letter.
    @Override
    public boolean equals(final Object obj) {
        if ((obj == null) || (!(obj instanceof Element))) {
            return false;
        }
        else {
        Element other = (Element)obj;
        return atomLetter.equals(other.atomLetter);
        }
     }
    

    @Override
    public String toString() {
        return "Element{'" + atomLetter + "', " +
                "name = '" + name + "'}";
    }

    //testing Element output

    //  public static void main(String[] args) {
    //      Element c1 = new Element("b", "boron");
    //      Element c2 = new Element("c", "carbon");
    //      System.out.println(c1.equals(c2));
    //  }
}
