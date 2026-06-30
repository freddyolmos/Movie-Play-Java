package content;

public enum Category {
    FANTASIA(1, "Fantasía"),
    CIENCIA_FICCION(2, "Ciencia ficción"),
    ACCION(3, "Acción"),
    TERROR(4, "Terror");

    private int id;
    private String name;

    Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
