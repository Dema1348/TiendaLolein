/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlDb;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.*;

/**
 *
 * @author EdsonAlexander
 */
public class MantenedoraVentas {
    private List<Venta> ventas;
    private  EntityManager em;
    private EntityManagerFactory factory;
    private Venta p;

    public  MantenedoraVentas()
    {
      ventas= new ArrayList<Venta>();
    }
    
    protected  void init()
    {
    factory = Persistence.createEntityManagerFactory("Tienda_lolein_WebPU", System.getProperties());
    em = factory.createEntityManager();
    em.getTransaction().begin();
    }
    
    
    public  List<Venta> listar()
    {
        
        init();
        javax.persistence.Query q;
        q = em.createQuery("SELECT c FROM Venta c ");
        ventas= q.getResultList();
        em.close();
        
        return ventas;         
    }
    
    
     public void agregar(Venta venta)
    {
          init();
          
        p=venta;
        em.persist(p);
        em.flush();
        em.getTransaction().commit();
        em.close();
                 
    }
     
    public  Venta buscar(Integer id_venta)
    {
         init();
        p = em.find(Venta.class, id_venta); 
        em.close();
         return p;
    }    
        
    public  void  eliminar(String id)
    {
         init();
        
        
        p = em.find(Venta.class, id); 
        em.remove(p);
        em.flush();
        em.getTransaction().commit();
        em.close();
        
    }     

    public List<Venta> buscarPorFecha(Calendar fecha)
    {
        List<Venta> ven= new ArrayList<Venta>();
        
        init();
        javax.persistence.Query q;
        q = em.createQuery("SELECT c FROM Venta c ");
        ventas=q.getResultList();
        Calendar busqueda= new GregorianCalendar();
        for (int i = 0; i < ventas.size(); i++) {
                busqueda.setTime(ventas.get(i).getFecha());
                 
                if(fecha.get(Calendar.YEAR)==busqueda.get(Calendar.YEAR) && fecha.get(Calendar.DATE)==busqueda.get(Calendar.DATE) && fecha.get(Calendar.MONTH)==busqueda.get(Calendar.MONTH))
                ven.add(ventas.get(i));
                   
               
             
        }
      
        em.close();
   
        return ven;
    }
    
    
    public  List<Venta> buscarPorFecha2(Calendar fecha, Calendar fecha2)  
    {
        List<Venta> ven= new ArrayList<Venta>();  
        Calendar busqueda= new GregorianCalendar();
        init();
        javax.persistence.Query q;
        q = em.createQuery("SELECT c FROM Venta c ");
        ventas=q.getResultList();
        for (int i = 0; i < ventas.size(); i++) {
            busqueda.setTime(ventas.get(i).getFecha());
            if(fecha2.after(busqueda) && fecha.before(busqueda) ){
                ven.add(ventas.get(i));
            }

        }
        
        return ven;     
    }
}
