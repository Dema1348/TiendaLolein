/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlDb;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Producto;

/**
 *
 * @author EdsonAlexander
 */
public class MantenedoraProductos {
    private List<Producto> productos;
    private  EntityManager em;
    private EntityManagerFactory factory;
    private Producto p;

    public  MantenedoraProductos()
    {
      productos= new ArrayList<Producto>();
    }
    
    protected  void init()
    {
    factory = Persistence.createEntityManagerFactory("Tienda_lolein_WebPU", System.getProperties());
    em = factory.createEntityManager();
    em.getTransaction().begin();
    }
    
    
    public  List<Producto> listar()
    {
        
        init();
        javax.persistence.Query q;
        q = em.createQuery("SELECT c FROM Producto c ");
        productos= q.getResultList();
        em.close();
        
        return productos;         
    }
    
    
     public void agregar(Producto producto)
    {
          init();

        p=producto;
        em.persist(p);
        em.flush();
        em.getTransaction().commit();
        em.close();
    }
     
    public  Producto buscar(Integer id_producto)
    {
         init();
        p = em.find(Producto.class, id_producto); 
        em.close();
         return p;
    }    
        
    public  void  eliminar(Integer id)
    {
         init();
        
        
        p = em.find(Producto.class, id); 
        em.remove(p);
        em.flush();
        em.getTransaction().commit();
        em.close();
        
    }     
    
    public void restarStock(int cantidad, Integer id_producto)
    {
        init();
        p=em.find(Producto.class, id_producto);
        p.setStock(p.getStock()-cantidad);
        em.merge(p);
        em.getTransaction().commit();
        em.close();
    }
    
    
    public void sumarStock(int cantidad, Integer id_producto)
    {
        init();
        p=em.find(Producto.class, id_producto);
        p.setStock(p.getStock()+cantidad);
        em.merge(p);
        em.getTransaction().commit();
        em.close();
    }
    
    public void modificar(Producto producto)
    {
        init();
        p=em.find(Producto.class, producto.getId());
        p= producto;
        em.merge(p);
        em.getTransaction().commit();
        em.close();
    }
        
}
