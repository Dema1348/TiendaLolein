/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package generardordepoblacion;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.*;

/**
 *
 * @author cetecom
 */
public class Ventas {
    private int total;
    private String rut,id_venta;
    private Date fecha;
    private static int SEMILLA_VENTA=0;

    public Ventas() {
    }

    public Ventas(int total, String rut, String id_venta, Date fecha) {
        setTotal(total);
        setRut(rut);
        setId_venta(id_venta);
        setFecha(fecha); 
       
    }

 

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }



    public String getId_venta() {
        return id_venta;
    }

    public void setId_venta(String id_venta) {
        this.id_venta = id_venta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

     public Ventas generarVenta(ArrayList<String> ruts)
    {
        Ventas newVentas= new Ventas( 0,ruts.get((int)(Math.random()*ruts.size()+0)), Integer.toString(SEMILLA_VENTA+1), generarFecha());
        
        
        
        SEMILLA_VENTA+=1;
      
        return  newVentas;
    
    }
    
     public String invertir(String fecha)
    { //la fecha debe llegar en formato dd/mm/aaaa
    String fecha2 = "";
    fecha2 += fecha.substring(6) + "/";
    fecha2 += fecha.substring(3,5) + "/";
    fecha2 += fecha.substring(0,2);
    return fecha2;
    }
    
   public Date generarFecha(){
    Calendar calendario= Calendar.getInstance();
     calendario.set((int) (Math.floor(Math.random() * (2014 - 2010 + 1)) + 2010), (int) (Math.floor(Math.random() * (12 - 1 + 1)) + 1),(int) (Math.floor(Math.random() * (31 - 1 + 1)) + 1));
     Date fecha= calendario.getTime();
     return  fecha;
    }

    @Override
    public String toString() {
          DateFormat df = DateFormat.getDateInstance();
        String s =  df.format(fecha);
        
        return "Insert into venta values ('" + id_venta + "','" + rut + "','" + total +"','"+invertir(s)+"');" ;
    }

   

}
