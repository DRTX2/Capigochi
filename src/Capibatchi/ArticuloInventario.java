
package Capibatchi;

public class ArticuloInventario {
    
    private String nombre;//sirve como id
    private int cantidad;
    private int costo;
    private String path="/Imagenes/";

    public ArticuloInventario(String nombre, int costo,int cantidad,String path) {
        this.nombre = nombre;
        this.costo=costo;
        this.cantidad=cantidad;
        this.path+=path+".jpg";
    }
    
    public ArticuloInventario(String nombre,int cantidad,String path) {
        this.nombre = nombre;
        this.cantidad=cantidad;    
        this.path=path;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getCantidad() {
        return this.cantidad;
    }
/*
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
*/
    public void increaseCantidad() {
        this.cantidad++;
    }
    
    public void deacreaseCantidad() {
        this.cantidad--;
    }
    
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getCosto() {
        return costo;
    }

    
    public String toStringData() {
        return this.getNombre() + "," + this.getCantidad() + "," + this.getPath();
    }
    /*
    private String getId(){
        //10 ...sze-4
        return this.getPath().substring(10, this.getPath().length()-4);
    }
    */
   @Override
    public String toString() {
        return this.getNombre() + " [x" + this.getCantidad() + "]";
    }
    
    public boolean equals(Alimento a) {
        //String nombre, int costo, int energiaRecuperada, int saludRecuperada,String path
        return this.path.equalsIgnoreCase(a.getPath());//se puede hacer con el nombre o con el path porq no s repetirian
    }
    
}
