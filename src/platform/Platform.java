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

    public List<String> showTitles() {
        content.forEach(content  -> System.out.println(content.getTitle()));
        return content.stream().map(Movie::getTitle).toList();
    }

    public List<Movie> getMoviesByCategory(String category) {
        return content.stream().filter(content -> content.getCategory()
                .equalsIgnoreCase(category))
                .toList();
    }

    public Movie searchByTitle(String title) {
        return content.stream().filter(content -> content.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    public String getName() {
        return name;
    }

    public List<Movie> getContent() {
        return content;
    }
}
