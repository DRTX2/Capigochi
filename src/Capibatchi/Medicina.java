package Capibatchi;

public class Medicina extends ArticuloInventario{

    private int saludRecuperada;

    public Medicina(String nombre, int costo, int cantidad, int saludRecuperada, String path) {
        super(nombre, costo, cantidad, path);
        this.saludRecuperada = saludRecuperada;
    }

    public Medicina(String nombre, int cantidad, int saludRecuperada, String path) {
        super(nombre, cantidad, path);
        this.saludRecuperada = saludRecuperada;
    }

    public int getSaludRecuperada() {
        return this.saludRecuperada;
    }

    public void setSaludRecuperada(int saludRecuperada) {
        this.saludRecuperada = saludRecuperada;
    }
    
}
