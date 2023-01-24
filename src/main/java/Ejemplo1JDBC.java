import modelos.Producto;
import repositorio.ProductoRepoImpl;
import repositorio.ProductoRepositorio;
import utilidades.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Ejemplo1JDBC {
    public static void main(String[] args)  {

        ProductoRepositorio repo = new ProductoRepoImpl();
        System.out.println("======================  Listar productos ====================");
        repo.listar().forEach(System.out::println);
    }
}
