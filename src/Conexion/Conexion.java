package Conexion;

import Capibatchi.Alimento;
import Capibatchi.Mascota;
import static Capibatchi.Mascota.pedirNombre;
import Capibatchi.Estado;
import Capibatchi.Medicina;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static Views.Lobby.articulosDisponibles;

public class Conexion {

    private static Conexion conexion;
    private Connection conn;
    private String strConexion = "jdbc:sqlite:capibara.s3db";
private Conexion()  {
}
    // crear coneccion
     public static Conexion obtenerConexion() {
        if (conexion == null) {
            conexion = new Conexion();
        }
        conexion.establecerConexion();
        return conexion;
   
    }

    // Método para establecer la conexión
    public void establecerConexion() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(strConexion);
            System.out.println("Conexión Establecida");
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }
    }


    //cerrar conecccion
    public void close() {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //procesar sql
    public int ejecutarSentenciaSQL(String strSentenciaSQL) {
        try {
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            pstm.execute();
            return 1;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
            return 0;
        }
    }

    //consulta registro a tabla
    public ResultSet consultarRegistros(String strSentenciaSQL) {
        try {
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    //consulta de tabla capibara
    public boolean consultarExistenciaTablaCapibara() {
        String nomTabla = "Capibara";
        try {
            // Consulta si la tabla ya existe
            String consultaTablaSQL = "SELECT name FROM sqlite_master WHERE type='table' AND name='" + nomTabla + "';";
            ResultSet resultSet = this.consultarRegistros(consultaTablaSQL);

            if (!resultSet.next()) {
                // La tabla no existe, por lo que puedes crearla
                String crearTablaSQL = "CREATE TABLE " + nomTabla + " (Energia INTEGER, Hambre INTEGER, Higiene INTEGER, Salud INTEGER, Diversion INTEGER, Monedas INTEGER , Nombre  VARCHAR(50));";
                this.ejecutarSentenciaSQL(crearTablaSQL);

                // Insertar valores iniciales
                String insertarValoresSQL = "INSERT INTO " + nomTabla + " (Energia, Hambre, Higiene, Salud, Diversion, Monedas, Nombre) VALUES (100, 100, 100, 100, 100, 50, '');";
                this.ejecutarSentenciaSQL(insertarValoresSQL);
                System.out.println("Tabla creada con valores iniciales.");
                return false;
            } else {
                System.out.println("La tabla ya existe, no se creará una nueva tabla.");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    //creacion y uso de la tabla
    public boolean consultarExistenciaTablaAlimentos() {
        String nombreTabla = "Alimentos";
        try {
            // Consulta si la tabla ya existe
            String consultaTablaSQL = "SELECT name FROM sqlite_master WHERE type='table' AND name='" + nombreTabla + "';";
            ResultSet resultSet = this.consultarRegistros(consultaTablaSQL);
            if (!resultSet.next()) {
                // La tabla no existe, por lo que puedes crearla
                String crearTablaSQL = "CREATE TABLE " + nombreTabla + " (Nombre VARCHAR(50), Cantidad INTEGER, Costo INTEGER, EnergiaRecuperada INTEGER, Path VARCHAR(50));";
                this.ejecutarSentenciaSQL(crearTablaSQL);
                // Insertar valores iniciales
                String[] nombres = {
                    "Guayaba", "Pollo", "Pastel", "Dona", "Huevo", "Zanahoria", "Sandwitch",
                    "Pera", "Queso", "Helado", "Banana", "Cereza", "Aguacate", "Cafe", "Quiwi", "Fresa", "Pan con mermelada",
                    "Agua", "Sandia", "Pancakes", "Sushi", "Hot dog", "Coctel de fresa", "Coctel de cereza",
                    "Jugo de naranja", "Manzana roja", "Manzana amarilla"
                };

                int[] costos = {7, 9, 9, 10, 10, 8, 13, 7, 9, 7, 7, 13, 11, 12, 12, 15, 8, 7, 9, 9, 15, 10, 15, 13, 15, 8, 7};
                int[] hambreRecuperada = {14, 15, 18, 19, 6, 18, 8, 12, 13, 18, 17, 16, 15, 14, 13, 12, 11, 10, 10, 12, 14, 10, 20, 15, 30, 16, 10};

                for (int i = 0; i < nombres.length; i++) {
                    String insertarValoresSQL = "INSERT INTO " + nombreTabla + " (Nombre, Cantidad, Costo, EnergiaRecuperada, Path) "
                            + "VALUES ('" + nombres[i] + "', 0, " + costos[i] + ", " + hambreRecuperada[i] + ", '" + String.format("%02d", i) + "');";
                    this.ejecutarSentenciaSQL(insertarValoresSQL);
                }

                System.out.println("Tabla creada con valores iniciales.");
                return false;
            } else {
                System.out.println("La tabla ya existe, no se creará una nueva tabla.");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean consultarExistenciaTablaMedicina() {
        String nombreTabla = "Medicina";
        try {
            // Consulta si la tabla ya existe
            String consultaTablaSQL = "SELECT name FROM sqlite_master WHERE type='table' AND name='" + nombreTabla + "';";
            ResultSet resultSet = this.consultarRegistros(consultaTablaSQL);
            if (!resultSet.next()) {//si no hay un siguiente, es decir si no hay algun registro disponible q iterar
                // La tabla no existe, por lo que puedes crearla
                String crearTablaSQL = "CREATE TABLE " + nombreTabla + " (Nombre VARCHAR(50), Cantidad INTEGER, Costo INTEGER, SaludRecuperada INTEGER, Path VARCHAR(50));";
                this.ejecutarSentenciaSQL(crearTablaSQL);
                // Insertar valores iniciales
                String[] nombres = {///lo lleno luego
                    "Pastillas", "Frasco de pastillas", "Inyeccion", "Botiquin"
                };

                int[] costos = {10, 15, 20, 25}; 
                int[] saludRecuperada = {25, 35, 60, 80};
                    
                for (int i = 0; i < nombres.length; i++) {
                    String insertarValoresSQL = "INSERT INTO " + nombreTabla + " (Nombre, Cantidad, Costo, SaludRecuperada, Path) "
                    + "VALUES ('" + nombres[i] + "', 0, " + costos[i] + ", " + saludRecuperada[i] + ", '5" + i + "');";
                    this.ejecutarSentenciaSQL(insertarValoresSQL);
                }

                System.out.println("Tabla creada con valores iniciales.");
                return false;
            } else {
                System.out.println("La tabla ya existe, no se creará una nueva tabla.");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ResultSet obtenerValoresCapibara() {
        String nombreTabla = "Capibara";
        String consultaValoresSQL = "SELECT Energia, Hambre, Higiene, Salud, Diversion FROM " + nombreTabla + ";";
        return consultarRegistros(consultaValoresSQL);
    }

    public void actualizarValoresMascotaEnBD(int energia, int hambre, int diversion, int higiene, int salud) {
        String nombreTabla = "Capibara";
        String actualizarValoresSQL = "UPDATE " + nombreTabla
                + " SET Energia = " + energia
                + ", Hambre = " + hambre
                + ", Diversion = " + diversion
                + ", Higiene = " + higiene
                + ", Salud = " + salud
                + ";";

        ejecutarSentenciaSQL(actualizarValoresSQL);
        this.close();
    }

    public String obtenerNombreMascota() {
        String nombre = null;
        try {
            String nombreTabla = "Capibara";
            String consultaNombreSQL = "SELECT Nombre FROM " + nombreTabla + ";";
            ResultSet resultado = this.consultarRegistros(consultaNombreSQL);
            if (resultado != null && resultado.next()) {
                nombre = resultado.getString("Nombre");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nombre;
    }

    public void actualizarNombreMascota(String nuevoNombre) {
        String nombreTabla = "Capibara";
        String actualizarNombreSQL = "UPDATE " + nombreTabla + " SET Nombre = '" + nuevoNombre + "';";
        this.ejecutarSentenciaSQL(actualizarNombreSQL);
    }

    public Integer obtenerMonedasMascota() {
        String monedas = null;
        try {
            String nombreTabla = "Capibara";
            String consultaNombreSQL = "SELECT Monedas FROM " + nombreTabla + ";";
            ResultSet resultado = this.consultarRegistros(consultaNombreSQL);

            if (resultado != null && resultado.next()) {
                monedas = resultado.getString("Monedas");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(monedas);
    }

    public void actualizarMonedasMascota(int nuevasMonedas) {
        try {
            String nombreTabla = "Capibara";
            String actualizarMonedasSQL = "UPDATE " + nombreTabla + " SET Monedas = " + nuevasMonedas + ";";
            PreparedStatement pstm = conn.prepareStatement(actualizarMonedasSQL);
            pstm.executeUpdate();
            System.out.println("Monedas actualizadas en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar las monedas: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public int obtenerHambreCapibara() {
        int hambre = 0;
        try {
            String consultaSQL = "SELECT Hambre FROM Capibara";
            ResultSet resultado = this.consultarRegistros(consultaSQL);

            if (resultado != null && resultado.next()) {
                hambre = resultado.getInt("Hambre");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hambre;
    }

    public int obtenerSaludCapibara() {
        int salud = 0;
        try {
            String consultaSQL = "SELECT Salud FROM Capibara";
            ResultSet resultado = this.consultarRegistros(consultaSQL);

            if (resultado != null && resultado.next()) {
                salud = resultado.getInt("Salud");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salud;
    }

    public void actualizarHambreCapibaras(int nuevaEnergia) {
        String actualizacionSQL = "UPDATE Capibara SET Hambre = " + nuevaEnergia;
        ejecutarSentenciaSQL(actualizacionSQL);
    }

    public void actualizarSaludCapibaras(int nuevaSalud) {
        String actualizacionSQL = "UPDATE Capibara SET Salud = " + nuevaSalud;
        ejecutarSentenciaSQL(actualizacionSQL);
    }

    public int obtenerEnergiaRecuperadaAlimento(String nombreAlimento) {
        int energia = 0;
        try {
            String consultaSQL = "SELECT EnergiaRecuperada FROM Alimentos WHERE Nombre = '" + nombreAlimento + "';";
            ResultSet resultado = this.consultarRegistros(consultaSQL);
            if (resultado != null && resultado.next()) {
                energia = resultado.getInt("EnergiaRecuperada");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return energia;
    }

    public int obtenerSaludRecuperadaMedicina(String nombreAlimento) {
        try {
            String consultaSQL = "SELECT SaludRecuperada FROM Medicina WHERE Nombre = '" + nombreAlimento + "';";
            ResultSet resultado = this.consultarRegistros(consultaSQL);
            if (resultado != null && resultado.next()) {
                return resultado.getInt("SaludRecuperada");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int obtenerValorArticulo(String nombreAlimento, String tabla) {
        try {
            String consultaSQL = "SELECT Cantidad FROM " + tabla + " WHERE Nombre = '" + nombreAlimento + "';";
            ResultSet resultado = this.consultarRegistros(consultaSQL);
            if (resultado != null && resultado.next()) {
                return resultado.getInt("Cantidad");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void actualizarValorArticulo(String nombreArticulo, int nuevaCantidad, String tabla) {
        String actualizacionSQL = "UPDATE " + tabla + " SET Cantidad = " + nuevaCantidad + " WHERE Nombre = '" + nombreArticulo + "';";
        ejecutarSentenciaSQL(actualizacionSQL);
        System.out.println("Cantidad de " + nombreArticulo + " actualizada en la base de datos.");
    }

    public int obtenerCostoArticulo(String nombreArticulo, String tabla) {
        try {
            String consultaSQL = "SELECT Costo FROM " + tabla + " WHERE Nombre = '" + nombreArticulo + "';";
            ResultSet resultado = this.consultarRegistros(consultaSQL);
            if (resultado != null && resultado.next()) {
                return resultado.getInt("Costo");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void cargarArticulosDesdeBaseDeDatos() {
        // Suponiendo que 'consultarRegistros' y 'ejecutarSentenciaSQL' son métodos válidos para manejar la base de datos
        String nombreTabla = "Alimentos";
        try {
            String consultaSQL = "SELECT * FROM " + nombreTabla + ";";
            ResultSet resultSet = this.consultarRegistros(consultaSQL);
            while (resultSet.next()) {
                int cantidad = resultSet.getInt("Cantidad");
                if (cantidad > 0) {
                    // Verificar si la cantidad de este alimento es mayor que cero antes de agregarlo
                    String nombre = resultSet.getString("Nombre");
                    int costo = resultSet.getInt("Costo");
                    int energiaRecuperada = resultSet.getInt("EnergiaRecuperada");
                    String path = resultSet.getString("Path");
                    System.out.println(cantidad);
                    Alimento alimento = new Alimento(nombre, costo, cantidad, energiaRecuperada, path);
                    articulosDisponibles.add(alimento);
                }
            }
            //ahora para la medicina
            nombreTabla = "Medicina";
            consultaSQL = "SELECT * FROM " + nombreTabla + ";";
            resultSet = this.consultarRegistros(consultaSQL);
            while (resultSet.next()) {
                int cantidad = resultSet.getInt("Cantidad");
                if (cantidad > 0) {
                    // Verificar si la cantidad de este alimento es mayor que cero antes de agregarlo
                    String nombre = resultSet.getString("Nombre");
                    int costo = resultSet.getInt("Costo");
                    int saludRecuperada = resultSet.getInt("SaludRecuperada");
                    String path = resultSet.getString("Path");
                    System.out.println(cantidad);
                    Medicina med = new Medicina(nombre, costo, cantidad, saludRecuperada, path);
                    articulosDisponibles.add(med);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //repetido, añadir parametros y dinamizarlo
    public void borrarTabla(String tabla) {
        String borrarTablaSQL = "DROP TABLE IF EXISTS " + tabla + ";";
        ejecutarSentenciaSQL(borrarTablaSQL);
        System.out.println("Tabla '" + tabla + "' borrada correctamente.");
    }

}
