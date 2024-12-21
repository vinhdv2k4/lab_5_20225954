package hust.soict.dsai.aims.media;
public class DigitalVideoDisc extends Disc implements Playable{
    private String director;
    private int length;

    public DigitalVideoDisc(String title, String category, float cost, String director, int length) {
        super(title, category, cost, director, length);
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }



    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);

    }

    public DigitalVideoDisc(String title, String director, String category, float cost) {
        super(title,category,cost);
        this.director = director;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }

    @Override
    public void play() {
        System.out.println(" Playing DVD : " + this.getTitle());
        System.out.println(" DVD length : " + this.getLength());
    }
    @Override
    public String toString(){
        return super.getId() + ". DVD - " + super.getTitle() + " - " + super.getCategory() + " - " + director + " - "
                + length + ": " + super.getCost() + "$";
    }
}
