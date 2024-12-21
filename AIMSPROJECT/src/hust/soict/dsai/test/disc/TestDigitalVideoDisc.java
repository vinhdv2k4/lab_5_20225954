package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestDigitalVideoDisc {
    public static void main(String[] args) {
        DigitalVideoDisc dvd1 =
                new DigitalVideoDisc("Jungle", "Adventure", "John Doe", 120, 15.99f);
        DigitalVideoDisc dvd2 =
                new DigitalVideoDisc("Cinderella");
        DigitalVideoDisc dvd3 =
                new DigitalVideoDisc("The Lion King", "Animation", "Jane Doe", 90, 12.99f);

        System.out.println(" ID: " + dvd1.getId() + ", Title: " + dvd1.getTitle());
        System.out.println(" ID: " + dvd2.getId() + ", Title: " + dvd2.getTitle());
        System.out.println(" 20225784 - ID: " + dvd3.getId() + ", Title: " + dvd3.getTitle());

        System.out.println("Total DVDs created: ");
    }
}
