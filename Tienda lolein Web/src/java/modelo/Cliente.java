/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author EdsonAlexander
 */
@Entity
@Table(name = "cliente", catalog = "lolein", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByRut", query = "SELECT c FROM Cliente c WHERE c.rut = :rut"),
    @NamedQuery(name = "Cliente.findByNombre", query = "SELECT c FROM Cliente c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cliente.findByCorreo", query = "SELECT c FROM Cliente c WHERE c.correo = :correo"),
    @NamedQuery(name = "Cliente.findByFechaNac", query = "SELECT c FROM Cliente c WHERE c.fechaNac = :fechaNac"),
    @NamedQuery(name = "Cliente.findByPass", query = "SELECT c FROM Cliente c WHERE c.pass = :pass")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Rut", nullable = false, length = 15)
    private String rut;
    @Basic(optional = false)
    @Column(name = "Nombre", nullable = false, length = 50)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "Correo", nullable = false, length = 100)
    private String correo;
    @Basic(optional = false)
    @Column(name = "Fecha_Nac", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    @Basic(optional = false)
    @Column(name = "Pass", nullable = false, length = 15)
    private String pass;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutCliente")
    private Collection<Venta> ventaCollection;

    public Cliente() {
    }

    public Cliente(String rut) {
        this.rut = rut;
    }

    public Cliente(String rut, String nombre, String correo, Date fechaNac, String pass) {
        this.rut = rut;
        this.nombre = nombre;
        this.correo = correo;
        this.fechaNac = fechaNac;
        this.pass = pass;
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

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @XmlTransient
    public Collection<Venta> getVentaCollection() {
        return ventaCollection;
    }

    public void setVentaCollection(Collection<Venta> ventaCollection) {
        this.ventaCollection = ventaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rut != null ? rut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.rut == null && other.rut != null) || (this.rut != null && !this.rut.equals(other.rut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return rut ;
    }
    
}
