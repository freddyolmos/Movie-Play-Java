import content.Category;
import content.Movie;
import content.MovieSummary;
import exceptions.ExistingMovieException;
import platform.Platform;
import util.ScannerUtils;

import java.util.List;

public class Main {

    public static final String NAME_PLATFORM = "PLATZI PLAY";
    public static final int ADD_CONTENT = 1;
    public static final int SHOW_TITLES = 2;
    public static final int SEARCH_BY_TITLE = 3;
    public static final int FILTER_BY_CATEGORY = 4;
    public static final int ORDER_BY_QUALIFICATION = 5;
    public static final int DELETE = 7;
    public static final int EXIT = 8;

    public static void main(String[] args) {

        Platform platform = new Platform(NAME_PLATFORM);

        loadMovies(platform);

        while (true) {
            int chooseOption = ScannerUtils.captureInt("""
                    Elige una opcion: 
                    1. Agregar pelicula
                    2. Mostrar titulos
                    3. Buscar por titulo
                    4. Filtrar por genero
                    5. Ordenar por calificación
                    7. Eliminar pelicula
                    8. Salir""");

            System.out.println("Opcion elegida: " + chooseOption);

            switch (chooseOption) {

                case ADD_CONTENT -> {

                    String title = ScannerUtils.captureText("Nombre de la pelicula: ");
                    String description = ScannerUtils.captureText("Descripcion de la pelicula: ");
                    Category category = ScannerUtils.captureCategory("Categoria de la pelicula: ");
                    int duration = ScannerUtils.captureInt("Duracion de la pelicula (min): ");

                    boolean available = true;
                    int releaseYear = ScannerUtils.captureInt("Año de estreno: ");
                    double qualification = ScannerUtils.captureDouble("Calificacion: ");

                    Movie movie = new Movie(title, description, category, duration, qualification);
                    movie.setAvailable(available);
                    movie.setReleaseYear(releaseYear);
                    movie.qualify(qualification);

                    try {
                        platform.addItem(movie);
                    } catch (ExistingMovieException e) {
                        System.out.println(e.getMessage());
                    }
                }

                case SHOW_TITLES -> {
                    List<MovieSummary> movies = platform.getSummary();
                    movies.forEach(movie -> System.out.println(movie.title()));
                }

                case SEARCH_BY_TITLE -> {
                    String title = ScannerUtils.captureText("Buscar pelicula: ");
                    Movie movie = platform.searchByTitle(title);
                    if (movie != null) System.out.println(movie.getTechnicalDatasheet());
                    else System.out.println("Pelicula no encontrada.");
                }

                case FILTER_BY_CATEGORY -> {
                    Category[] categories = Category.values();
                    for (int i = 0; i < categories.length; i++) {
                        System.out.printf("|" + (i + 1) + ". " + categories[i] + "|");
                    }
                    System.out.println();
                    Category category = ScannerUtils.captureCategory("Menciona la categoria: ");
                    List<Movie> movies = platform.getMoviesByCategory(category);
                    movies.forEach(movie -> System.out.println(movie.getTechnicalDatasheet()));
                }

                case ORDER_BY_QUALIFICATION -> {
                    String order = ScannerUtils.captureText("Que orden desea?(ASCENDENTE o DESCENDENTE): ");
                    List<Movie> movies = platform.orderByQualification(order);
                    movies.forEach(movie -> System.out.println(movie.getTechnicalDatasheet()));
                }

                case DELETE -> {
                    String deleteMovie = ScannerUtils.captureText("Que pelicula desea eliminar?: ");
                    Movie movie = platform.searchByTitle(deleteMovie);
                    if (movie != null) platform.deleteItem(movie);
                    else System.out.println("Pelicula no encontrada.");
                }

                case EXIT -> System.exit(0);
            }
        }
    }

    private static void loadMovies(Platform platform) {
        platform.addItem(new Movie("El señor de los anillos", "Destruir el anillo es lo mas importante",
                Category.FANTASIA, 200, 3.8));
        platform.addItem(new Movie("Harry Potter", "Harry debe eliminar los horrocruxes",
                Category.FANTASIA, 180, 4.6));
        platform.addItem(new Movie("Interestellar", "Es imprescindible hallar un nuevo mundo",
                Category.CIENCIA_FICCION, 180, 4.9));
        platform.addItem(new Movie("Rapidos y Furiosos", "Los autos mas rapidos en Rio de Janeiro",
                Category.ACCION, 170, 2.2));
        platform.addItem(new Movie("El Conjuro", "Historias de los Warren.",
                Category.TERROR, 170, 4.5));
    }
}