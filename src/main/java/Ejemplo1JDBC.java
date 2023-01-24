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

        System.out.println("======================  Buscar producto ====================");
        System.out.println(repo.porCodigo("AR-145"));

        System.out.println("======================  Borrar producto ====================");
        repo.borrar("12345");
        System.out.println("buscando 12345");
        System.out.println(repo.porCodigo("12345"));
        System.out.println("Producto borrado");
    }
}
