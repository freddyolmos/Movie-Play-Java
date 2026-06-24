package content;

public class Movie {

    private String title;
    private String description;
    private double calification;
    private String category;
    private int releaseYear;
    private boolean available;
    private int duration;

    public Movie(String title, String description, String category, int duration) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.duration = duration;
    }

    public void play() {
        System.out.println("Reproduciendo... " + title);
    }

    public String getTechnicalDatasheet() {
        return title + ", Duración: " + duration + ", Categoria: " + category;
    }

    public void qualify(double calification) {
        if (calification > 0  && calification <= 5) this.calification = calification;
    }

    public boolean isPopular() {
        return calification >= 4;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getCalification() {
        return calification;
    }

    public String getCategory() {
        return category;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getDuration() {
        return duration;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
