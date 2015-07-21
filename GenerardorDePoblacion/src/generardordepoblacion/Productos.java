/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package generardordepoblacion;

import java.awt.Image;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author cetecom
 */
public class Productos {
    private String id, nombre,detalle,foto;
    private int stock, precio;
    static int SEMILLA=0;
   

    public Productos() {
    }

    public Productos(String id, String nombre,  int stock, int precio,String dellate,String foto) {
        setId(id);
        setNombre(nombre);
        setStock(stock);
        setPrecio(precio);
        setDetalle(dellate);
        setFoto(foto);
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    public Productos generarProductos()
    {
        String[] frases= new String[4];
        String[] nombres= new String[10];
        nombres=crearNombres(nombres);
        
        frases[0]="Una prenda muy bella para la vida";
        frases[1]="Una atuendo espectacular para las fiestas";
        frases[2]="La mejor ropa, diseñada por grandes artistas";
        frases[3]="Echa con lana de primer nivel";
        
        Productos newProducto= new Productos( Integer.toString(SEMILLA+1), nombres[(int)(Math.random()*10-0)+0], (int) (Math.random () * (100-1) + 1), (int) (Math.random () * (25-5) + 5)*1000, frases[(int)(Math.random()*4-0)+0],"foto"+((int)(Math.random()*17-0)+0)+".jpg");
        SEMILLA+=1;
        return  newProducto;
    
    }
    
     public String[] crearNombres(String[] nombres)
    {
        nombres[0]="Polera";
        nombres[1]="Pantalon";
        nombres[2]="Vestido";
        nombres[3]="Chaqueta";
        nombres[4]="Poleron";
        nombres[5]="Shores";
        nombres[6]="Sweater";
        nombres[7]="Chalas";
        nombres[8]="Buzo";
        nombres[9]="Camisa";
      
        
        
        return nombres;
    }
    
    
    
    @Override
    public String toString() {
        return "Insert into producto values('"+ id + "','" + nombre + "','" + foto + "','" + detalle + "','" + precio + "','" + stock + "');";
    }
    
    
}
