
package Capibatchi;

import java.util.Objects;

public class Alimento extends ArticuloInventario{
    
    private int hambreRecuperada;

    public Alimento(String nombre, int costo, int cantidad,int hambreRecuperada, String path) {
        super(nombre, costo, cantidad, path);
        this.hambreRecuperada = hambreRecuperada;
    }

    public Alimento(String nombre, int cantidad,int hambreRecuperada,String path) {
        super(nombre, cantidad, path);
        this.hambreRecuperada = hambreRecuperada;
    }
    
    public int gethambreRecuperada() {
        return this.hambreRecuperada;
    }
    
}