package repositorio;


import java.util.List;

public interface ProductoRepositorio <Producto>{
    List<Producto> listar();
    Producto porCodigo(String cod);
    void guardar(Producto p);
    void borrar(String cod);
}
