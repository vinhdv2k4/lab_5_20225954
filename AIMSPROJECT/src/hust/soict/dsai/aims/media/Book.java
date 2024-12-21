package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{

    private List<String> authors = new ArrayList<String>();

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }



    public List<String> getAuthors() {
        return authors;
    }


    public Book(int id, String title, String category, float cost, List<String> authors) {
        super(id, title, category,cost);
        this.authors = authors;
    }

    public Book(String title, String category, float cost, List<String> authors) {
        super(title, category, cost);
        this.authors = authors;
    }

    public void addAuthor(String authorName){
        if(authors.contains(authorName)){
            System.out.println(" This author is already in the list");
        } else {
            authors.add(authorName);
            System.out.println(" Author added successfully");
        }
    }

    public void removeAuthor(String authorName){
        if(!authors.contains(authorName)){
            System.out.println(" There is no author name " + authorName + "in the list");
        } else {
            authors.remove(authorName);
            System.out.println(" Author removed successfully");
        }
    }

    @Override
    public String toString() {
        return super.getId() + ". Book - " + super.getTitle() + " - " + super.getCategory() + " - " + getAuthors() + " - : "
                + super.getCost() + "$";
    }
}
