import content.Movie;
import platform.Platform;
import util.ScannerUtils;

import java.util.List;

public class Main {

    public static final String NAME_PLATFORM = "PLATZI PLAY";
    public static final int ADD_CONTENT = 1;
    public static final int SHOW_TITLES = 2;
    public static final int SEARCH_BY_TITLE = 3;
    public static final int DELETE = 4;
    public static final int EXIT = 5;

    public static void main(String[] args) {

        Platform platform = new Platform(NAME_PLATFORM);

        loadMovies(platform);

        while (true) {
            int chooseOption = ScannerUtils.captureInt("""
                    Elige una opcion: 
                    1. Agregar pelicula
                    2. Mostrar peliculas
                    3. Buscar por titulo
                    4. Eliminar pelicula
                    5. Salir""");

            System.out.println("Opcion elegida: " + chooseOption);

            switch (chooseOption) {

                case ADD_CONTENT -> {

                    String title = ScannerUtils.captureText("Nombre de la pelicula: ");
                    String description = ScannerUtils.captureText("Descripcion de la pelicula: ");
                    String category = ScannerUtils.captureText("Categoria de la pelicula: ");
                    int duration = ScannerUtils.captureInt("Duracion de la pelicula (min): ");

                    boolean available = true;
                    int releaseYear = ScannerUtils.captureInt("Año de estreno: ");
                    double qualify = ScannerUtils.captureDouble("Calificacion: ");

                    Movie movie = new Movie(title, description, category,duration);
                    movie.setAvailable(available);
                    movie.setReleaseYear(releaseYear);
                    movie.qualify(qualify);

                    platform.addItem(movie);
                }

                case SHOW_TITLES -> platform.showTitles();

                case SEARCH_BY_TITLE -> {
                    String title = ScannerUtils.captureText("Buscar pelicula: ");
                    Movie movie = platform.searchByTitle(title);
                    if (movie != null) System.out.println(movie.getTechnicalDatasheet());
                    else System.out.println("Pelicula no encontrada.");
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
                "Fantasia", 200));
        platform.addItem(new Movie("Harry Potter", "Harry debe eliminar los horrocruxes",
                "Fantasia", 180));
        platform.addItem(new Movie("Interestellar", "Es imprescindible hallar un nuevo mundo",
                "Ciencia Ficcion", 180));
        platform.addItem(new Movie("Rapidos y Furiosos", "Los autos mas rapidos en Rio de Janeiro",
                "Acción", 170));
    }
}