package user;

import content.Movie;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name, username, email, password, plan;
    private boolean isActive;
    private List<Movie> favorites, watchHistory;

    public User(String name, String username, String email, String password, String plan) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.plan = plan;
        this.isActive = true;
        this.favorites = new ArrayList<>();
        this.watchHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPlan() {
        return plan;
    }

    public List<Movie> getFavorites() {
        return favorites;
    }

    public String getUsername() {
        return username;
    }

    public boolean isActive() {
        return isActive;
    }

    public List<Movie> getWatchHistory() {
        return watchHistory;
    }

    public void addFavorite(Movie movie) {
        favorites.add(movie);
    }

    public void removeFavorite(Movie movie) {
        for (int i = 0; i < favorites.size(); i++) {
            if (movie.getTitle().equals(favorites.get(i).getTitle())) {
                favorites.remove(i);
                break;
            }
        }
    }

    public void watch(Movie movie) {
        System.out.printf("Reproduciendo..." + movie.getTitle());
    }

    public void changePlan(String plan) {
        this.plan = plan;
        System.out.println(name + " tu plan cambio a " + plan);
    }

    public void deactivate() {
        this.isActive = false;
    }

    public void activate() {
        this.isActive = true;
    }
}
