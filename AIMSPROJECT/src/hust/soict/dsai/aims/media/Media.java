package hust.soict.dsai.aims.media;
import java.util.Comparator;
public abstract class Media implements Comparable<Media>{
 
    private int id;
    private String title;
    private String category;
    private float cost;
    private static int nbMedia = 0;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();


    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;

        nbMedia++;
        this.setId(nbMedia);
    }

    public Media(String title) {
        this.title = title;
        nbMedia++;
        this.setId(nbMedia);
    }
    public Media(String title,float cost) {
        this.title = title;
        this.cost =cost;
        nbMedia++;
        this.setId(nbMedia);
    }

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbMedia++;
        this.setId(nbMedia);
    }

    public Media() {

    }



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {return title;}
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }


    public String toString(){
        return getId() + ". Media - " + getTitle() + " - " + getCategory() + " : " + getCost() + "$";
    }

    public boolean isMatch(String title){
        if(getTitle() == null || title == null){
            return false;
        }
        if (getTitle().equalsIgnoreCase(title)) {
            return true;
        }
        return getTitle().toLowerCase().contains(title.toLowerCase());
    }

    @Override
    public boolean equals(Object obj) {
        Media media = (Media) obj;
        try{
            String title = media.getTitle();
            return title.equals(this.getTitle());
        } catch (NullPointerException e){
            return false;
        }
    }

    @Override
    public int compareTo(Media o) {
        int titleComparison = this.title.compareTo(o.getTitle());

        return (titleComparison == 0) ? Float.compare(this.cost, o.getCost()) : titleComparison;
    }
}
