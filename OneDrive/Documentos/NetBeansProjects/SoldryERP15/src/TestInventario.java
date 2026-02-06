

import dao.InventarioDAO;

public class TestInventario {

    public static void main(String[] args) {

        InventarioDAO dao = new InventarioDAO();

        // INSERTAR
        dao.insertarProducto("Aceite 20W50", 10, 35000);

        // LISTAR
        dao.listarProductos();

        // ACTUALIZAR
        dao.actualizarProducto(1, "Aceite 20W50 Premium", 15, 40000);

        // LISTAR
        dao.listarProductos();

        // ELIMINAR
        dao.eliminarProducto(1);

        // LISTAR
        dao.listarProductos();
    }
}
