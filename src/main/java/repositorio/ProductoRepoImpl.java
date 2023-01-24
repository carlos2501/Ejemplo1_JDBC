package repositorio;


import modelos.Producto;
import utilidades.ConexionBD;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepoImpl implements ProductoRepositorio <Producto>{

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
    public void guardar(Producto p) {
        // INSERT INTO `jardineria`.`producto` (`codigo_producto`, `nombre`, `gama`, `cantidad_en_stock`, `precio_venta`, `precio_proveedor`) VALUES ('12345', 'Producto de prueba', 'Ornamentales', '10', '25', '15');
        // UPDATE `jardineria`.`producto` SET `cantidad_en_stock` = '50', `precio_venta` = '20', `precio_proveedor` = '13' WHERE (`codigo_producto` = 'OR-99');
        String qry;
        /*
            Si el producto existe, es una modificación (UPDATE). Si el producto no existe es una inserción (INSERT)
         */
        if(porCodigo(p.getCodigo_producto()) != null) {
            qry = "UPDATE producto SET nombre=?, cantidad_en_stock=?, precio_venta=?, precio_proveedor=? WHERE codigo_producto=?";
        } else {
            qry="INSERT INTO producto(codigo_producto,nombre,cantidad_en_stock,precio_venta,precio_proveedor) VALUES(?,?,?,?,?)";
        }
        try(PreparedStatement stmt = getConexion().prepareStatement(qry)){
            if(porCodigo(p.getCodigo_producto()) != null) {
                stmt.setString(1,p.getNombre() );
                stmt.setInt(2, p.getCantidad_en_stock());
                stmt.setFloat(3, p.getPrecio());
                stmt.setFloat(4, p.getPrecio_proveedor());
                stmt.setString(5, p.getCodigo_producto());
            } else {
                stmt.setString(1,p.getCodigo_producto());
                stmt.setString(2,p.getNombre() );
                stmt.setInt(3, p.getCantidad_en_stock());
                stmt.setFloat(4, p.getPrecio());
                stmt.setFloat(5, p.getPrecio_proveedor());
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        p.setCantidad_en_stock(rs.getInt("cantidad_en_stock"));
        return p;
    }
}
