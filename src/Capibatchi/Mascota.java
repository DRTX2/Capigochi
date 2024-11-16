
package Capibatchi;

import Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Mascota {
    private String nombre;
    
    private Estado estadoSalud;
    private Estado estadoHambre;
    private Estado estadoDiversion;
    private Estado estadoEnergia;
    private Estado estadoHigiene;
    
    public  Mascota(){
        this.estadoDiversion = new Estado(100);
        this.estadoEnergia = new Estado(100);
        this.estadoHambre = new Estado(100);
        this.estadoHigiene = new Estado(100);
        this.estadoSalud = new Estado(100);
       //Inicializar los valores por algún error que pueda suceder
        this.estadoDiversion = new Estado(100);
        this.estadoEnergia = new Estado(100);
        this.estadoHambre = new Estado(100);
        this.estadoHigiene = new Estado(100);
        this.estadoSalud = new Estado(100);
        // Consulta la base de datos para obtener los valores y asignarlos
     Conexion objConexion = Conexion.obtenerConexion();
  

        ResultSet valoresResultSet = objConexion.obtenerValoresCapibara();

        try {
            if (valoresResultSet.next()) {
                int energia = valoresResultSet.getInt("Energia");
                int hambre = valoresResultSet.getInt("Hambre");
                int higiene = valoresResultSet.getInt("Higiene");
                int salud = valoresResultSet.getInt("Salud");
                int diversion = valoresResultSet.getInt("Diversion");

                // Lógica para asignar estos valores a los estados de la clase Animal, por ejemplo:
                this.estadoEnergia = new Estado(energia);
                this.estadoHambre = new Estado(hambre);
                this.estadoHigiene = new Estado(higiene);
                this.estadoSalud = new Estado(salud);
                this.estadoDiversion = new Estado(diversion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        objConexion.close();
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Estado getEstadoSalud() {
        return estadoSalud;
    }

    public void setEstadoSalud(Estado estadoSalud) {
        this.estadoSalud = estadoSalud;
    }

    public Estado getEstadoHambre() {
        return estadoHambre;
    }

    public void setEstadoHambre(Estado estadoHambre) {
        this.estadoHambre = estadoHambre;
    }

    public Estado getEstadoDiversion() {
        return estadoDiversion;
    }

    public void setEstadoDiversion(Estado estadoDiversion) {
        this.estadoDiversion = estadoDiversion;
    }

    public Estado getEstadoEnergia() {
        return estadoEnergia;
    }

    public void setEstadoEnergia(Estado estadoEnergia) {
        this.estadoEnergia = estadoEnergia;
    }

    public Estado getEstadoHigiene() {
        return estadoHigiene;
    }

    public void setEstadoHigiene(Estado estadoHigiene) {
        this.estadoHigiene = estadoHigiene;
    }
    
    public void aumentarHambre(int cantidad){
        this.estadoHambre.incrementarEstado(cantidad);
    }
    
    public void decrementarHambre(int cantidad){
        this.estadoHambre.decrementarEstado(cantidad);
    }
    
    public void aumentarDiversion(int cantidad){
        this.estadoDiversion.incrementarEstado(cantidad);
    }
    
    public void decrementarDiversion(int cantidad){
        this.estadoDiversion.decrementarEstado(cantidad);
    }
    
    public void aumentarEnergia(int cantidad){
        this.estadoEnergia.incrementarEstado(cantidad);
    }
    
    public void decrementarEnergia(int cantidad){
        this.estadoEnergia.decrementarEstado(cantidad);
    }
    
    public void aumentarSalud(int cantidad){
        this.estadoSalud.incrementarEstado(cantidad);
    }
    
    public void decrementarSalud(int cantidad){
        this.estadoSalud.decrementarEstado(cantidad);
    }
    
    public void aumentarHigiene(int cantidad){
        this.estadoHigiene.incrementarEstado(cantidad);
    }
    
    public void decrementarHigiene(int cantidad){
        this.estadoHigiene.decrementarEstado(cantidad);
    }

    public String getNombre() {
        return nombre;
    }
    
    public static String pedirNombre() {
        String nombre = null;
        boolean nombreValido = false;
        do {
            nombre = JOptionPane.showInputDialog("Ponle un nuevo nombre a tu mascota:");
            if (!nombre.trim().isEmpty()) {
                nombreValido = true;
            } else {
                JOptionPane.showMessageDialog(null, "Debes ingresar un nombre válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (!nombreValido);
        return nombre;
    }
    
}
