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
import modelo.ProductosVendidos;

/**
 *
 * @author EdsonAlexander
 */
public class MantenedoraProductosVen {
    private List<ProductosVendidos> productos;
    private  EntityManager em;
    private EntityManagerFactory factory;
    private ProductosVendidos p; 
    
    public  MantenedoraProductosVen()
    {
      productos= new ArrayList<ProductosVendidos>();
    }
    
    protected  void init()
    {
    factory = Persistence.createEntityManagerFactory("Tienda_lolein_WebPU", System.getProperties());
    em = factory.createEntityManager();
    em.getTransaction().begin();
    }
    
    
    public  List<ProductosVendidos> listar()
    {
        
        init();
        javax.persistence.Query q;
        q = em.createQuery("SELECT c FROM ProductosVendidos c ");
        productos= q.getResultList();
        em.close();
        
        return productos;         
    }
    
    
     public void agregar(ProductosVendidos producto)
    {
          init();

        p=producto;
        em.persist(p);
        em.flush();
        em.getTransaction().commit();
        em.close();
    }
     
    public  ProductosVendidos buscar(Integer id_producto)
    {
         init();
        p = em.find(ProductosVendidos.class, id_producto); 
        em.close();
         return p;
    }    
        
    public  boolean eliminar(Integer id)
    {
        boolean token;
        
        try{
         init();
        p = em.find(ProductosVendidos.class, id); 
        em.remove(p);
        em.flush();
        em.getTransaction().commit();
        em.close();
        token=true;
        }
        catch(Exception exx)
        {
        token=false;
        }
        
        return token;
    }     
    
    
    
    public void modificar(ProductosVendidos producto)
    {
        init();
        p=em.find(ProductosVendidos.class, producto.getId());
        p= producto;
        em.merge(p);
        em.getTransaction().commit();
        em.close();
    }
    
    public  boolean rollback(Integer id, Integer cantidad)
    {
        MantenedoraProductos productos= new MantenedoraProductos();
        
        boolean token;
        int oldPrecio=0;
        try{
            
            
        init();
        p=em.find(ProductosVendidos.class, id);
        if(cantidad>0 && cantidad<=p.getCantidad())
        {
        oldPrecio=p.getPrecio()/p.getCantidad();
        p.setCantidad(p.getCantidad()-cantidad);
        p.setPrecio(oldPrecio*p.getCantidad());
        productos.sumarStock(cantidad, p.getIdproducto());
        em.merge(p);
        em.getTransaction().commit();
        em.close();
        token=true;
        }
        
        else
            token=false;
        }
        catch(Exception exx)
        {
        token=false;
        }
        
        return token;
    }
}
