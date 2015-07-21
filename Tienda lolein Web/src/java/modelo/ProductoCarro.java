/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author EdsonAlexander
 */
public class ProductoCarro {
  
    private Integer id;
    private String nombreProducto;
    private String foto;
    private String detalle;
    private int precio;
     private int cantidad;

    public ProductoCarro () {
    }

    public ProductoCarro (Integer id) {
        this.id = id;
    }

    public ProductoCarro (Integer id, String nombreProducto, String foto, String detalle, int precio, int cantidad) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.foto = foto;
        this.detalle = detalle;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ProductoCarro{" + "id=" + id + ", nombreProducto=" + nombreProducto + ", foto=" + foto + ", detalle=" + detalle + ", precio=" + precio + ", cantidad=" + cantidad + '}';
    }

  
    
}
