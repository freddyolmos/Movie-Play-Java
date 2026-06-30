package platform;

import content.Category;
import content.Movie;
import content.MovieSummary;
import exceptions.ExistingMovieException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Platform {
    private String name;
    private List<Movie> movies;

    public Platform(String name) {
        this.name = name;
        this.movies = new ArrayList<>();
    }

    public void addItem(Movie item) {

        Movie content = this.searchByTitle(item.getTitle());

        if(content != null) {
            throw new ExistingMovieException(item.getTitle());
        }

        movies.add(item);
    }

    public void deleteItem(Movie item) {
        movies.remove(item);
    }

    public List<MovieSummary> getSummary() {
        return movies.stream().
                map(movie -> new MovieSummary(movie.getTitle(),
                        movie.getDuration(),
                        movie.getCategory()))
                .toList();
    }

    public List<String> showTitles() {
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

    public List<Movie> orderByQualification(String order) {
        if (Objects.equals(order, "DESCENDENTE")) {
            return movies.stream()
                    .sorted(Comparator.comparingDouble(Movie::getQualification))
                    .toList();
        }
        else return movies.stream()
                .sorted(Comparator.comparingDouble(Movie::getQualification).reversed())
                .toList();
    }

    public String getName() {
        return name;
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
