package hust.soict.dsai.aims.Aim;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.screen.CartScreen;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;
public class Aims {
    private static Store store;
    private static Cart cart;
    private static StoreScreen storeScreen;
    private static CartScreen cartScreen;

    public static void main(String[] args) {
        store = new Store();
        cart = new Cart();

        Media[] sampleMedia = new Media[] {
                new DigitalVideoDisc("Glory Of Outer Space", "Sci-fi", "Walter Jackson", 125, 31.5f),

                new CompactDisc("Life", "Pop", "Kim Evans", "Hope Sullivan", 30.1f) {{
                    addTrack(new Track("Sleep And Memories", 5));
                    addTrack(new Track("Brave And Story", 5));
                    addTrack(new Track("Easy And Smile", 5));
                }},

                new Book("Rain Of The Mountain", "Mystery", 0.0f) {{
                    addAuthor("Mark Castilleja");
                }},

                new CompactDisc("22", "Pop", "MONO", "Onionn", 0.0f) {{
                    addTrack(new Track("Intro", 1));
                    addTrack(new Track("Em La", 3));
                    addTrack(new Track("Waiting For You", 4));
                }},
                new Book("R.E.I.N.A", "Oneshot", 69.96f) {{
                    addAuthor("Hiten");
                }}
        };
        for (Media m : sampleMedia) {
            store.addMedia(m);
        }

        openStoreScreen();
    }

    public static Store getStore() {
        return store;
    }

    public static Cart getCart() {
        return cart;
    }

    public static StoreScreen getStoreScreen() {
        return storeScreen;
    }

    public static CartScreen getCartScreen() {
        return cartScreen;
    }

    public static void openStoreScreen() {
        storeScreen = new StoreScreen(store);
    }

    public static void closeStoreScreen() {
        storeScreen.setVisible(false);
        storeScreen = null;
    }

    public static void openCartScreen() {
        cartScreen = new CartScreen(cart);
    }

    public static void closeCartScreen() {
        cartScreen.setVisible(false);
        cartScreen = null;
    }

}
