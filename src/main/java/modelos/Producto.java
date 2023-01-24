package modelos;

public class Producto {
    private String codigo_producto;
    private String nombre;
    private String gama;
    private String proveedor;
    private String descripcion;
    private Float precio;
    private Float precio_proveedor;

    public Producto(String codigo_producto, String nombre, String proveedor, Float precio, Float precio_proveedor) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.proveedor = proveedor;
        this.precio = precio;
        this.precio_proveedor = precio_proveedor;
    }

    public Producto() {
    }

    public String getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Float getPrecio_proveedor() {
        return precio_proveedor;
    }

    public void setPrecio_proveedor(Float precio_proveedor) {
        this.precio_proveedor = precio_proveedor;
    }

    @Override
    public String toString() {
        return codigo_producto + " | " +
                nombre + " | " +
                precio + " | " +
                precio_proveedor;
    }
}
