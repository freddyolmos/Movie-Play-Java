package content;

public class Movie {

    private String title;
    private String description;
    private double qualification;
    private Category category;
    private int releaseYear;
    private boolean available;
    private int duration;

    public Movie(String title, String description, Category category, int duration, double qualification) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.duration = duration;
        this.qualification = qualification;
    }

    public void play() {
        System.out.println("Reproduciendo... " + title);
    }

    public String getTechnicalDatasheet() {
        return title + ", Categoria: "
                + category + ", Duración: "
                + duration + ", Calificacion: " + qualification + "/5.";
    }

    public void qualify(double qualification) {
        if (qualification > 0  && qualification <= 5) this.qualification = qualification;
    }

    public boolean isPopular() {
        return qualification >= 4;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getQualification() {
        return qualification;
    }

    public Category getCategory() {
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
