package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Venta;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-10-23T20:52:41")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> rut;
    public static volatile SingularAttribute<Cliente, Date> fechaNac;
    public static volatile CollectionAttribute<Cliente, Venta> ventaCollection;
    public static volatile SingularAttribute<Cliente, String> pass;
    public static volatile SingularAttribute<Cliente, String> correo;
    public static volatile SingularAttribute<Cliente, String> nombre;

}