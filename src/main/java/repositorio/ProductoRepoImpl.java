package repositorio;

import modelos.Producto;
import utilidades.ConexionBD;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepoImpl implements ProductoRepositorio{

    private static Connection getConexion() throws SQLException {
        return ConexionBD.abreConexion();
    }

    @Override
    public List listar() {
        List<Producto> productos = new ArrayList<>();

        try(Statement stmt = getConexion().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM producto")) {
            while (rs.next()) {
                Producto p = crearProducto(rs);
                productos.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    @Override
    public Producto porCodigo(String cod) {
        Producto producto = null;

        try(PreparedStatement stmt = getConexion().
                prepareStatement("SELECT * FROM producto WHERE codigo_producto = ?")){
            stmt.setString(1,cod);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                producto = crearProducto(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }

    @Override
    public void guardar(Object p) {

    }

    @Override
    public void borrar(String cod) {
        try(PreparedStatement stmt = getConexion().
                prepareStatement("DELETE FROM producto WHERE codigo_producto= ?")){
            stmt.setString(1, cod);
            int rs = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Producto crearProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setCodigo_producto(rs.getString("codigo_producto"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getFloat("precio_venta"));
        p.setPrecio_proveedor(rs.getFloat("precio_proveedor"));
        return p;
    }
}
