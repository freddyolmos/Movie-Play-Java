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

    public void deleteItem(Movie item) {
        content.remove(item);
    }

    public void showTitles() {
        for(Movie content: this.content) {
            System.out.println(content.getTitle());
        }
    }

    public Movie searchByTitle(String title) {
        for (Movie content: this.content) {
            if(content.getTitle().equalsIgnoreCase(title)) {
                return content;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public List<Movie> getContent() {
        return content;
    }
}
