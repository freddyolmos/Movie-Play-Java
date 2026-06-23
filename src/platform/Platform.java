package platform;

import content.Movie;

import java.util.ArrayList;
import java.util.List;

public class Platform {
    private String name;
    private List<Movie> content;

    public Platform(String name) {
        this.name = name;
        this.content = new ArrayList<>();
    }

    public void addItem(Movie item) {
        content.add(item);
    }

    public String getName() {
        return name;
    }

    public List<Movie> getContent() {
        return content;
    }
}
