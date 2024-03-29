/*
 * CS2050 - Computer Science II - Summer 2021
 * Instructor: Thyago Mota
 * Student Name: Lena Hamilton
 * Description: Prg01 - MoleculeDriver Class
 */

package Project.Project1;

public class MoleculeDriver {

    public static void main(String[] args) {

        // creating "Carbon Dioxide: CO_2"
        Element C = new Element("C", "carbon");
        Element O = new Element("O", "oxygen");
        Molecule co2 = new Molecule("Carbon Dioxide");
        co2.add(O, 2);
        co2.add(C);
        System.out.println(co2);

        // creating "Caffeine: C_8H_10N_4O_2"
        Element N = new Element("N", "nitrogen");
        Element H = new Element("H", "hydrogen");
        Molecule caffeine = new Molecule("Caffeine");
        caffeine.add(N, 4);
        caffeine.add(O, 2);
        caffeine.add(H, 10);
        caffeine.add(C, 8);
        System.out.println(caffeine);

        // TODO: create your favorite molecule
        // I will create Tetrodotixin: C_11H_17N_3O_8
        Molecule tetrodotoxin = new Molecule("Tetrodotoxin");
        tetrodotoxin.add(C, 11);
        tetrodotoxin.add(H, 17);
        tetrodotoxin.add(N, 3);
        tetrodotoxin.add(O, 8);
        System.out.println(tetrodotoxin);
    }

}