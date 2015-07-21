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
import modelo.Cliente;

/**
 *
 * @author EdsonAlexander
 */
public class MantenedoraClientes {
    private List<Cliente> clientes;
    private  EntityManager em;
    EntityManagerFactory factory;
    private Cliente cl;

    public  MantenedoraClientes()
    {
      clientes= new ArrayList<Cliente>();
    }
    
    protected  void init()
    {
    factory = Persistence.createEntityManagerFactory("Tienda_lolein_WebPU", System.getProperties());
    em = factory.createEntityManager();
    em.getTransaction().begin();
    }
    
    
    public  List<Cliente> listar()
    {
        
        init();
        javax.persistence.Query q;
        q = em.createQuery("SELECT c FROM Cliente c ");
        clientes= q.getResultList();
        em.close();
        
        return  clientes;         
    }
    
    
     public void agregar(Cliente cliente)
    {
          init();

        cl=cliente;
        em.persist(cl);
        em.flush();
        em.getTransaction().commit();
        em.close();
    }
     
    public  Cliente buscar(String rut)
    {
        init();
        cl = em.find(Cliente.class, rut); 
        em.close();
        return cl;
    }    
        
    public  void  eliminar(String rut)
    {
         init();
        
        
        cl = em.find(Cliente.class, rut); 
        em.remove(cl);
        em.flush();
        em.getTransaction().commit();
        em.close();
        
    }     
        
}
