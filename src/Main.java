import content.Movie;
import platform.Platform;
import util.ScannerUtils;

public class Main {

    public static final String NAME_PLATFORM = "PLATZI PLAY";
    public static final int ADD_CONTENT = 1;
    public static final int VIEW_ALL = 2;
    public static final int SEARCH_BY_TITLE = 3;
    public static final int DELETE = 4;
    public static final int EXIT = 5;

    public static void main(String[] args) {

        Platform platform = new Platform(NAME_PLATFORM);

        while (true) {
            int chooseOption = ScannerUtils.captureInt("""
                    Elige una opcion: 
                    1. Agregar contenido
                    2. Mostrar todo
                    3. Buscar por titulo
                    4. Eliminar
                    5. Salir""");

            System.out.println("Opcion elegida: " + chooseOption);

            switch (chooseOption) {
                case ADD_CONTENT -> {
                    boolean available = true;
                    String title = ScannerUtils.captureText("Nombre de la pelicula: ");
                    String description = ScannerUtils.captureText("Descripcion de la pelicula: ");
                    String category = ScannerUtils.captureText("Categoria de la pelicula: ");
                    int duration = ScannerUtils.captureInt("Duracion de la pelicula (min): ");
                    int releaseYear = ScannerUtils.captureInt("Año de estreno: ");
                    double qualify = ScannerUtils.captureDouble("Calificacion: ");

                    platform.addItem(new Movie(title, description, category, duration));
                }
            }

            if (chooseOption == EXIT) System.exit(0);
        }

        boolean available = true;
        String title = ScannerUtils.captureText("Nombre de la pelicula: ");
        String description = ScannerUtils.captureText("Descripcion de la pelicula: ");
        String category = ScannerUtils.captureText("Categoria de la pelicula: ");
        int duration = ScannerUtils.captureInt("Duracion de la pelicula (min): ");
        int releaseYear = ScannerUtils.captureInt("Año de estreno: ");
        double qualify = ScannerUtils.captureDouble("Calificacion: ");

        Movie movie = new Movie(title, description, category,duration);
        movie.setAvailable(available);
        movie.setDescription(description);
        movie.setReleaseYear(releaseYear);

        movie.qualify(qualify);
        movie.play();
        System.out.println(movie.getTechnicalDatasheet());
        System.out.println(movie.isPopular());
    }
}