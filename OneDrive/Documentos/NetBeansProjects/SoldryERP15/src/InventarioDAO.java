package dao;

import conexion.ConexionBD;
import java.sql.*;

public class InventarioDAO {

    // INSERTAR
    public void insertarProducto(String nombre, int cantidad, double precio) {
        try (Connection conn = ConexionBD.conectar()) {

            String sql = "INSERT INTO inventario(nombre,cantidad,precio) VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setInt(2, cantidad);
            ps.setDouble(3, precio);

            ps.executeUpdate();
            System.out.println("Producto insertado correctamente");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // LISTAR
    public void listarProductos() {
        try (Connection conn = ConexionBD.conectar()) {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM inventario");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " - " +
                        rs.getString("nombre") + " - " +
                        rs.getInt("cantidad") + " - " +
                        rs.getDouble("precio")
                );
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // ACTUALIZAR
    public void actualizarProducto(int id, String nombre, int cantidad, double precio) {
        try (Connection conn = ConexionBD.conectar()) {

            String sql = "UPDATE inventario SET nombre=?, cantidad=?, precio=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setInt(2, cantidad);
            ps.setDouble(3, precio);
            ps.setInt(4, id);

            ps.executeUpdate();
            System.out.println("Producto actualizado correctamente");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // ELIMINAR
    public void eliminarProducto(int id) {
        try (Connection conn = ConexionBD.conectar()) {

            String sql = "DELETE FROM inventario WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Producto eliminado correctamente");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
