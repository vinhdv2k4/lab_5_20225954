package hust.soict.dsai.test.store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
   

        Track track1 = new Track("track1", 1);
        Track track2 = new Track("track2", 2);
        Track track3 = new Track("track3", 3);

        List<String> authors = new ArrayList<>();
        ArrayList<Track> tracks= new ArrayList<>();
        DigitalVideoDisc dvd =
                new DigitalVideoDisc("The Lion King", "animation",
                        "Roger Allers", 87, 19.95f);
        CompactDisc cd =
                new CompactDisc("Star wars", "Science Fiction",
                        24.95f, tracks , "George Lucas");
        Book book =
                new Book("Aladin", "fairytail", 18.99f, authors );

        Store store = new Store();
        cd.addTrack(track1);
        cd.addTrack(track2);
        cd.addTrack(track3);

        book.addAuthor("Christian");

        store.addMedia(dvd);
        store.addMedia(cd);
        store.addMedia(book);

        System.out.println();

        store.removeMedia(cd);
        store.removeMedia(cd);
    }
}
