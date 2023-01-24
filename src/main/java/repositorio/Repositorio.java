package repositorio;

import java.util.List;

public interface Repositorio <T>{
    List<T> listar();
    T porCodigo(String cod);

    T porId(Integer id);
    void guardar(T t);
    void borrar(String cod);
    void borrarId(Integer id);
}
