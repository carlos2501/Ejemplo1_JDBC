package repositorio;

import modelos.Categoria;
import modelos.Producto;
import utilidades.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepoImpl implements Repositorio <Categoria>{
    private static Connection getConexion() throws SQLException {
        return ConexionBD.abreConexion();
    }

    public List<Categoria> listar() {
         List<Categoria> cats = new ArrayList<>();

        try(Statement stmt = getConexion().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM categorias")) {
            while (rs.next()) {
                Categoria c = crearCategoria(rs);
                cats.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cats;
    }


    @Override
    public Categoria porId(Integer id) {
        Categoria cat = null;

        try(PreparedStatement stmt = getConexion().
                prepareStatement("SELECT * FROM categoria WHERE id = ?")){
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                cat = crearCategoria(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cat;
    }

    @Override
    public void guardar(Categoria categoria) {

    }

    @Override
    public Categoria porCodigo(String cod) {
        return null;
    }

    @Override
    public void borrar(String cod) {

    }

    @Override
    public void borrarId(Integer id) {
        try(PreparedStatement stmt = getConexion().
                prepareStatement("DELETE FROM categoria WHERE id= ?")){
            stmt.setInt(1, id);
            int rs = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Categoria crearCategoria(ResultSet rs) throws SQLException {
        Categoria c = new Categoria();
        c.setCategoria(rs.getString("categoria"));
        c.setId(rs.getInt("id"));
        c.setIdMadre(rs.getInt("idMadre"));
        return c;
    }
}
