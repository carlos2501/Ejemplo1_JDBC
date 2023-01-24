package modelos;

public class Categoria {
    private Integer id;
    private String categoria;
    private Integer idMadre;

    public Categoria() {
    }

    public Categoria(Integer id, String categoria, Integer idMadre) {
        this.id = id;
        this.categoria = categoria;
        this.idMadre = idMadre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getIdMadre() {
        return idMadre;
    }

    public void setIdMadre(Integer idMadre) {
        this.idMadre = idMadre;
    }

    @Override
    public String toString() {
        return id + " | " + categoria + " | " + idMadre;
    }
}
