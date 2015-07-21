/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package generardordepoblacion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author cetecom
 */
public class Clientes {
    private String rut, nombre, correo, pass;
    private Date fechaNac;
   

    public Clientes() {
    }

    public Clientes(String rut, String nombre, String correo, String pass, Date fechaNac) {
        setRut(rut);
        setNombre(nombre);
        setCorreo(correo);
        setPass(pass);
        setFechaNac(fechaNac);
      
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }
    
    public Clientes generarUsuario(ArrayList<String> ruts)
    {
        String[] nombres= new String[10];
        nombres=crearNombres(nombres);
        boolean ok=false;
        String rut= Integer.toString((int) (Math.random () * (20000000-10000000) + 10000000))+"-"+Integer.toString((int) (Math.random () * (9) + 0));
       do{
        for (int i = 0; i < ruts.size(); i++) {
            if(ruts.get(i).equals(rut))
            {
                ok=true;
                break;
            }
        }
       }while(ok);
        
        Clientes newCliente= new Clientes(  rut, nombres[(int) (Math.random()*10-0)], creaPalabra(5).toLowerCase()+"@gmail.com", Integer.toString((int) (Math.random () * (9999) + 1)), generarFecha());
        return  newCliente;
    
    }
    
    public String[] crearNombres(String[] nombres)
    {
        nombres[0]="Diego";
        nombres[1]="Nicolas";
        nombres[2]="Maria";
        nombres[3]="Alberto";
        nombres[4]="Juan";
        nombres[5]="David";
        nombres[6]="Jesus";
        nombres[7]="Cristina";
        nombres[8]="Sherezade";
        nombres[9]="Fatmagul";
      
        
        
        return nombres;
    }
    
    public  String creaPalabra(int largo){
        
        String palabra="";
        String [] abecedario = {"A","B", "C", "D","E", "F", "G", "H","I", "J", 
        "K", "L", "M","N","O","P","Q","R","S","T","U","V","W", "X","Y","Z" };
        
            
            for (int i = 0; i <largo; i++) {
                int letra=(int)(Math.random()*(26));
                palabra+=abecedario[letra];
                
             
            }
   
            return palabra;
            
        }
    
    public Date generarFecha(){
    Calendar calendario= Calendar.getInstance();
     calendario.set((int) (Math.floor(Math.random() * (1995 - 1900 + 1)) + 1900), (int) (Math.floor(Math.random() * (12 - 1 + 1)) + 1),(int) (Math.floor(Math.random() * (31 - 1 + 1)) + 1));
     Date fecha= calendario.getTime();
     return  fecha;
    }

    public String invertir(String fecha)
    { //la fecha debe llegar en formato dd/mm/aaaa
    String fecha2 = "";
    fecha2 += fecha.substring(6) + "/";
    fecha2 += fecha.substring(3,5) + "/";
    fecha2 += fecha.substring(0,2);
    return fecha2;
    }
    
    
    @Override
    public String toString() {
        
        DateFormat df = DateFormat.getDateInstance();
        String s =  df.format(fechaNac);
        

        return "Insert into cliente values ('"+rut + "', '" + nombre + "', '" + correo + "','" + invertir(s) + "', '" + pass + "');";
    }
    
    
}
