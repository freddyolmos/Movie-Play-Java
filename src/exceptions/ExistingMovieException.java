package exceptions;

public class ExistingMovieException extends RuntimeException{
    public ExistingMovieException(String title) {
        super("La pelicula " + title + " ya existe.");
    }
}
