package hust.soict.dsai.aims.cart;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.Comparator;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.MediaComparatorByCostTitle;
import hust.soict.dsai.aims.media.MediaComparatorByTitleCost;

public class Cart {
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public Cart(){}

    public  void addMedia(Media media){
        itemsOrdered.add(media);
        System.out.println("Added successfully");
    }

    public void removeMedia(Media media){
        int indexOfRemoved = itemsOrdered.indexOf(media);
        if(indexOfRemoved == -1){
            System.out.println(" Not found in the list");
        } else {
            itemsOrdered.remove(indexOfRemoved);
            System.out.println(" Removed successfully");
        }
    }
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void print(){
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for(Media media : itemsOrdered){
            System.out.println(" " + media.toString());
        }
        System.out.println("Total cost: " + totalCost() + "$");
        System.out.println("***************************************************");
    }

    public void searchById(int id){
        boolean isFound = false;
        for(Media media : itemsOrdered){
            if(media.getId() == id){
                System.out.println(" Found media: " + media.toString());
                isFound = true;
                break;
            }
        }
        if(!isFound){
            System.out.println(" Cannot found DVD with id " + id);
        }
    }


    public Media searchByTitle(String title){
        for(Media media : itemsOrdered){
            if(media.isMatch(title)){
                return media;
            }
        }
        return null;
    }

    public boolean checkInCart(int id){
        for(Media media : itemsOrdered){
            if(media.getId() == id){
                return true;
            }
        }
        return false;
    }

    public boolean checkInCart(String title){
        for(Media media : itemsOrdered){
            if(media.isMatch(title)){
                return true;
            }
        }
        return false;
    }

    public void cartEmpty(){
        itemsOrdered.clear();
    }

    public void sortTitle(){
        itemsOrdered.sort(COMPARE_BY_TITLE_COST);
    }

    public void sortCost(){
        itemsOrdered.sort(COMPARE_BY_COST_TITLE);
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
}
