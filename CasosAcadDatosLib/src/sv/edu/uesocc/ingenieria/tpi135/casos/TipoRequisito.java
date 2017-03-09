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
@Table(name = "tipo_requisito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoRequisito.findAll", query = "SELECT t FROM TipoRequisito t")
    , @NamedQuery(name = "TipoRequisito.findByIdTipoRequisito", query = "SELECT t FROM TipoRequisito t WHERE t.idTipoRequisito = :idTipoRequisito")
    , @NamedQuery(name = "TipoRequisito.findByNombre", query = "SELECT t FROM TipoRequisito t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TipoRequisito.findByDescripcion", query = "SELECT t FROM TipoRequisito t WHERE t.descripcion = :descripcion")})
public class TipoRequisito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_tipo_requisito", nullable = false)
    private Integer idTipoRequisito;
    @Column(name = "nombre", length = 20)
    private String nombre;
    @Column(name = "descripcion", length = 60)
    private String descripcion;
    @OneToMany(mappedBy = "idTipoRequisito", fetch = FetchType.EAGER)
    private List<Requisito> requisitoList;

    public TipoRequisito() {
    }

    public TipoRequisito(Integer idTipoRequisito) {
        this.idTipoRequisito = idTipoRequisito;
    }

    public Integer getIdTipoRequisito() {
        return idTipoRequisito;
    }

    public void setIdTipoRequisito(Integer idTipoRequisito) {
        this.idTipoRequisito = idTipoRequisito;
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
    public List<Requisito> getRequisitoList() {
        return requisitoList;
    }

    public void setRequisitoList(List<Requisito> requisitoList) {
        this.requisitoList = requisitoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoRequisito != null ? idTipoRequisito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoRequisito)) {
            return false;
        }
        TipoRequisito other = (TipoRequisito) object;
        if ((this.idTipoRequisito == null && other.idTipoRequisito != null) || (this.idTipoRequisito != null && !this.idTipoRequisito.equals(other.idTipoRequisito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi135.casos.TipoRequisito[ idTipoRequisito=" + idTipoRequisito + " ]";
    }
    
}
