/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package generardordepoblacion;

/**
 *
 * @author Edson
 */
public class ProductosVendidos {
    private String id;
    private String idVenta;
    private String idProducto;
    private int cantidad,precio;
    private static  int SEMILLA=0;

    public ProductosVendidos() {
    }

    public ProductosVendidos(String id,String idProducto, String idVenta, int cantidad, int precio) {
        setId(id);
        setIdVenta(idVenta);
        setCantidad(cantidad);
        setIdProducto(idProducto);
        setPrecio(precio);
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public ProductosVendidos generarProductosVendidos(String id_venta, String id_producto, int precioPro)
    {
    ProductosVendidos productosVendido= new ProductosVendidos(Integer.toString(SEMILLA+1),id_producto, id_venta,(int) (Math.floor(Math.random() * (1 - 0 + 1)) +1),precioPro);
    SEMILLA+=1;
    return  productosVendido;
    }

    @Override
    public String toString() {
        return "Insert into productos_vendidos values('" +  id + "','" + idVenta + "','" + idProducto + "','" + cantidad + "', '" + precio + "');";
    }

    

    
    
   
    
    
}
