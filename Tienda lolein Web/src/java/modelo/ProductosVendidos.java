/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EdsonAlexander
 */
@Entity
@Table(name = "productos_vendidos", catalog = "lolein", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductosVendidos.findAll", query = "SELECT p FROM ProductosVendidos p"),
    @NamedQuery(name = "ProductosVendidos.findById", query = "SELECT p FROM ProductosVendidos p WHERE p.id = :id"),
    @NamedQuery(name = "ProductosVendidos.findByIdVenta", query = "SELECT p FROM ProductosVendidos p WHERE p.idVenta = :idVenta"),
    @NamedQuery(name = "ProductosVendidos.findByIdproducto", query = "SELECT p FROM ProductosVendidos p WHERE p.idproducto = :idproducto"),
    @NamedQuery(name = "ProductosVendidos.findByCantidad", query = "SELECT p FROM ProductosVendidos p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "ProductosVendidos.findByPrecio", query = "SELECT p FROM ProductosVendidos p WHERE p.precio = :precio")})
public class ProductosVendidos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Id_Venta", nullable = false)
    private int idVenta;
    @Basic(optional = false)
    @Column(name = "Id_producto", nullable = false)
    private int idproducto;
    @Basic(optional = false)
    @Column(name = "Cantidad", nullable = false)
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "Precio", nullable = false)
    private int precio;

    public ProductosVendidos() {
    }

    public ProductosVendidos(Integer id) {
        this.id = id;
    }

    public ProductosVendidos(Integer id, int idVenta, int idproducto, int cantidad, int precio) {
        this.id = id;
        this.idVenta = idVenta;
        this.idproducto = idproducto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductosVendidos)) {
            return false;
        }
        ProductosVendidos other = (ProductosVendidos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ProductosVendidos[ id=" + id + " ]";
    }
    
}
