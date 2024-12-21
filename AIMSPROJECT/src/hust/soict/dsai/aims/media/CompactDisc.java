package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(String theBestHits, String cd, float cost, String variousArtists, ArrayList<Track> tracks) {
        super();
    }

    public CompactDisc(String titles, String catogy, String artist, String lead, float cost) {
        super(titles,cost);
    }

    public String getArtist() {
        return artist;
    }

    public CompactDisc(String title, ArrayList<Track> tracks, String artist, float cost) {
        super(title,cost);
        this.tracks = tracks;
        this.artist = artist;
    }

    public CompactDisc(String title, String category, float cost, ArrayList<Track> tracks, String artist) {
        super(title, category, cost);
        this.tracks = tracks;
        this.artist = artist;
    }

    public CompactDisc(String title, String category, float cost, String director, int length, String artist) {
        super(title, category, cost, director, length);
        this.artist = artist;
    }
    public void addTrack(Track track){
        int indexOfTrack = tracks.indexOf(track);
        if(indexOfTrack != -1){
            System.out.println(" This track is already in the list");
            return;
        }
        tracks.add(track);
        System.out.println("Track added successfully");
    }

    public void removeTrack(Track track){
        int indexOfTrack = tracks.indexOf(track);
        if(indexOfTrack == -1) {
            System.out.println(" This track is absent in the list");
            return;
        }
        tracks.remove(indexOfTrack);
        System.out.println("Track removed successfully");
    }

    @Override
    public int getLength() {
        int length = 0;
        for(Track track : tracks){
            length += track.getLength();
        }
        super.setLength(length);
        return length;
    }
    @Override
    public float getCost(){
        return super.getCost() ;
    }
    @Override
    public void play() {
        System.out.println(" Playing CD : " + this.getTitle());
        System.out.println(" CD artist : " + artist);
        System.out.println("CD length : " + this.getLength());
        for(Track track : tracks){
            track.play();
        }
    }

    @Override
    public String toString() {
        return super.getId() + ". CD - " + super.getTitle() + " - " + super.getCategory() + " - " + artist + " - " + getLength() + ": " + super.getCost() + "$";
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }
}
