package conexion;

import java.sql.Connection;

public class TestConexion {

    public static void main(String[] args) {

        Connection c = ConexionBD.conectar();

        if (c != null) {
            System.out.println("Todo funciona correctamente");
        }
    }
}
