/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.casos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author omar
 */
@Entity
@Table(name = "proceso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proceso.findAll", query = "SELECT p FROM Proceso p")
    , @NamedQuery(name = "Proceso.findByIdProceso", query = "SELECT p FROM Proceso p WHERE p.idProceso = :idProceso")
    , @NamedQuery(name = "Proceso.findByNombre", query = "SELECT p FROM Proceso p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Proceso.findByDescripcion", query = "SELECT p FROM Proceso p WHERE p.descripcion = :descripcion")})
public class Proceso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_proceso", nullable = false)
    private Integer idProceso;
    @Column(name = "nombre", length = 45)
    private String nombre;
    @Column(name = "descripcion", length = 80)
    private String descripcion;
    @OneToMany(mappedBy = "idProceso", fetch = FetchType.EAGER)
    private List<ProcesoDetalle> procesoDetalleList;
    @OneToMany(mappedBy = "idProceso", fetch = FetchType.EAGER)
    private List<Caso> casoList;

    public Proceso() {
    }

    public Proceso(Integer idProceso) {
        this.idProceso = idProceso;
    }

    public Integer getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Integer idProceso) {
        this.idProceso = idProceso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<ProcesoDetalle> getProcesoDetalleList() {
        return procesoDetalleList;
    }

    public void setProcesoDetalleList(List<ProcesoDetalle> procesoDetalleList) {
        this.procesoDetalleList = procesoDetalleList;
    }

    @XmlTransient
    public List<Caso> getCasoList() {
        return casoList;
    }

    public void setCasoList(List<Caso> casoList) {
        this.casoList = casoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProceso != null ? idProceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proceso)) {
            return false;
        }
        Proceso other = (Proceso) object;
        if ((this.idProceso == null && other.idProceso != null) || (this.idProceso != null && !this.idProceso.equals(other.idProceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi135.casos.Proceso[ idProceso=" + idProceso + " ]";
    }
    
}
