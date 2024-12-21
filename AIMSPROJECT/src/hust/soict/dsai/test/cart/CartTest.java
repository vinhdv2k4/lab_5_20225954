package hust.soict.dsai.test.cart;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();
        List<String> authors = new ArrayList<>();

        Track track1 = new Track("track1", 1);
        Track track2 = new Track("track2", 2);
        Track track3 = new Track("track3", 3);

        ArrayList<Track>  tracks= new ArrayList<>();
        DigitalVideoDisc dvd =
                new DigitalVideoDisc("The Lion King", "animation",
                        "Roger Allers", 87, 19.95f);
        CompactDisc cd =
                new CompactDisc("Star wars", "Science Fiction",
                        24.95f, tracks , "George Lucas");
        Book book =
                new Book("Aladin", "fairytail", 18.99f, authors );

        cd.addTrack(track1);
        cd.addTrack(track2);
        cd.addTrack(track3);

        book.addAuthor("Christian");

        cart.addMedia(dvd);
        cart.addMedia(cd);
        cart.addMedia(book);

   
        System.out.println(" Print cart");
        cart.print();
        System.out.println("Search Media by ID:");
        cart.searchById(2);
        cart.searchById(10);
        System.out.println("Search Media by title:");
        cart.searchByTitle("Aladin");
        cart.searchByTitle("Naruto");
        cart.searchByTitle("Star");
    }
}
