
package controlDb;
import java.io.Serializable;
import java.util.*;
import modelo.ProductoCarro; 

public class Carro implements Serializable{
    private  List<ProductoCarro> productos;
    public  Carro ()
    {
      productos= new ArrayList<ProductoCarro>();
    }
    
    
    public boolean repetido(ProductoCarro productoCarro)
    {
        for (int i = 0; i < productos.size(); i++) {
            if(productoCarro.getId().equals(productos.get(i).getId()))
            {
                productos.get(i).setCantidad(productos.get(i).getCantidad()+productoCarro.getCantidad());
                return true;
            }
        }
        
        return false;
    }
    public  boolean agregar(ProductoCarro producto)
    {
        if(repetido(producto))
            return true;
        else if( productos.add(producto))
            return true;
 
        
        else
            return false;
    }
    
    public  ProductoCarro buscar(int id_producto)
    {
        for (int i = 0; i < productos.size(); i++) {
            if(productos.get(i).getId().equals(id_producto))
                return productos.get(i);
        }
        return null;
    }
    
    public  boolean eliminar(int id)
    {
        for (int i = 0; i < productos.size(); i++) {
            if(productos.get(i).getId().equals(id)){
                productos.remove(i);
                return true;
            }  
        }
        return false;
    }
    
    public  boolean modificar(ProductoCarro producto)
    {
        for (int i = 0; i < productos.size(); i++) {
            if(producto.getId().equals(productos.get(i).getId()))
            {
                productos.remove(i);
                productos.add(i, producto);
                return true;
            }
            
        }
        return false;
    }
    
     public  int modificarCantidad(Integer id,Integer cantidad)
    {
        
        MantenedoraProductos produc= new MantenedoraProductos();
        
        int aux=0;
        for (int i = 0; i < productos.size(); i++) {
            
            if(productos.get(i).getId()==id && cantidad<=produc.buscar(productos.get(i).getId()).getStock() )
            {
                aux= productos.get(i).getPrecio()/productos.get(i).getCantidad();
                productos.get(i).setCantidad(cantidad);
                productos.get(i).setPrecio(aux * productos.get(i).getCantidad());
                return productos.get(i).getPrecio() ;
            }
            
        }
        return 0;
    }
    
    public List<ProductoCarro> listar()
    {
        return productos;
    }
    
    public  void vaciarCarro()
    {
        productos= new ArrayList<ProductoCarro>();
    }
    
    public void ordenar()
    {
         int i, j;
         ProductoCarro aux;
         for(i=0;i<productos.size()-1;i++)
              for(j=0;j<productos.size()-i-1;j++)
                   if(productos.get(j+1).getId()<productos.get(j).getId()){
                      aux=productos.get(j+1);
                      productos.add(j+1, productos.get(j));
                      productos.add(j,aux);
                   }
    }
}
