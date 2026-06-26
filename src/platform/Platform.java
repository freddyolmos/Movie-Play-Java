package platform;

import content.Category;
import content.Movie;

import java.util.ArrayList;
import java.util.List;

public class Platform {
    private String name;
    private List<Movie> movies;

    public Platform(String name) {
        this.name = name;
        this.movies = new ArrayList<>();
    }

    public void addItem(Movie item) {
        movies.add(item);
    }

    public void deleteItem(Movie item) {
        movies.remove(item);
    }

    public List<String> showTitles() {
        movies.forEach(content  -> System.out.println(content.getTitle()));
        return movies.stream().map(Movie::getTitle).toList();
    }

    public List<Movie> getMoviesByCategory(Category category) {
        return movies.stream().filter(content -> content.getCategory()
                .equals(category))
                .toList();
    }

    public Movie searchByTitle(String title) {
        return movies.stream().filter(content -> content.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    public String getName() {
        return name;
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
