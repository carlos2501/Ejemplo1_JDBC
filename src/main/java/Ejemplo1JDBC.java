import modelos.Categoria;
import modelos.Producto;
import repositorio.CategoriaRepoImpl;
import repositorio.ProductoRepoImpl;
import repositorio.Repositorio;


public class Ejemplo1JDBC {
    public static void main(String[] args)  {

        Repositorio<Producto> repo = new ProductoRepoImpl();
        Repositorio<Categoria> repocat = new CategoriaRepoImpl();

        System.out.println("======================  Listar productos ====================");
        repo.listar().forEach(System.out::println);

        System.out.println("======================  Buscar producto ====================");
        System.out.println(repo.porCodigo("AR-145"));

        System.out.println("======================  Borrar producto ====================");
        repo.borrar("12345");
        System.out.println("buscando 12345");
        System.out.println(repo.porCodigo("12345"));
        System.out.println("Producto borrado");
        /*
        System.out.println("======================  Añadir producto ====================");
        Producto p = new Producto();
        p.setCodigo_producto("98766");
        p.setNombre("Otro producto 2 de prueba");
        p.setCantidad_en_stock(50);
        p.setPrecio(65F);
        p.setPrecio_proveedor(25F);
        repo.guardar(p);
        System.out.println("Buscando " + p.getCodigo_producto());
        System.out.println(repo.porCodigo(p.getCodigo_producto()));
        */
        System.out.println("======================  Modificar producto ====================");
        Producto p = repo.porCodigo("98766");
        p.setCantidad_en_stock(80);
        repo.guardar(p);
        System.out.println("Buscando " + p.getCodigo_producto());
        System.out.println(repo.porCodigo(p.getCodigo_producto()));
        System.out.println("======================  Listar Categorias ====================");
        repocat.listar().forEach(System.out::println);

    }
}
