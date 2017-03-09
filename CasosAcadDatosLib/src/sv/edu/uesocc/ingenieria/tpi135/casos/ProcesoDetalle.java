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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "proceso_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcesoDetalle.findAll", query = "SELECT p FROM ProcesoDetalle p")
    , @NamedQuery(name = "ProcesoDetalle.findByIdprocesoDetalle", query = "SELECT p FROM ProcesoDetalle p WHERE p.idprocesoDetalle = :idprocesoDetalle")})
public class ProcesoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idproceso_detalle", nullable = false)
    private Integer idprocesoDetalle;
    @OneToMany(mappedBy = "idPadre", fetch = FetchType.EAGER)
    private List<ProcesoDetalle> procesoDetalleList;
    @JoinColumn(name = "id_padre", referencedColumnName = "idproceso_detalle")
    @ManyToOne(fetch = FetchType.EAGER)
    private ProcesoDetalle idPadre;
    @JoinColumn(name = "id_paso", referencedColumnName = "id_paso")
    @ManyToOne(fetch = FetchType.EAGER)
    private Paso idPaso;
    @JoinColumn(name = "id_proceso", referencedColumnName = "id_proceso")
    @ManyToOne(fetch = FetchType.EAGER)
    private Proceso idProceso;

    public ProcesoDetalle() {
    }

    public ProcesoDetalle(Integer idprocesoDetalle) {
        this.idprocesoDetalle = idprocesoDetalle;
    }

    public Integer getIdprocesoDetalle() {
        return idprocesoDetalle;
    }

    public void setIdprocesoDetalle(Integer idprocesoDetalle) {
        this.idprocesoDetalle = idprocesoDetalle;
    }

    @XmlTransient
    public List<ProcesoDetalle> getProcesoDetalleList() {
        return procesoDetalleList;
    }

    public void setProcesoDetalleList(List<ProcesoDetalle> procesoDetalleList) {
        this.procesoDetalleList = procesoDetalleList;
    }

    public ProcesoDetalle getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(ProcesoDetalle idPadre) {
        this.idPadre = idPadre;
    }

    public Paso getIdPaso() {
        return idPaso;
    }

    public void setIdPaso(Paso idPaso) {
        this.idPaso = idPaso;
    }

    public Proceso getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Proceso idProceso) {
        this.idProceso = idProceso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprocesoDetalle != null ? idprocesoDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcesoDetalle)) {
            return false;
        }
        ProcesoDetalle other = (ProcesoDetalle) object;
        if ((this.idprocesoDetalle == null && other.idprocesoDetalle != null) || (this.idprocesoDetalle != null && !this.idprocesoDetalle.equals(other.idprocesoDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi135.casos.ProcesoDetalle[ idprocesoDetalle=" + idprocesoDetalle + " ]";
    }
    
}
