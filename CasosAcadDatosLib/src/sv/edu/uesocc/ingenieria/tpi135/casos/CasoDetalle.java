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
@Table(name = "caso_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CasoDetalle.findAll", query = "SELECT c FROM CasoDetalle c")
    , @NamedQuery(name = "CasoDetalle.findByIdCasoDetalle", query = "SELECT c FROM CasoDetalle c WHERE c.idCasoDetalle = :idCasoDetalle")})
public class CasoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_caso_detalle", nullable = false)
    private Integer idCasoDetalle;
    @OneToMany(mappedBy = "idCasoDetalle", fetch = FetchType.EAGER)
    private List<CasoDetalleRequisito> casoDetalleRequisitoList;
    @JoinColumn(name = "id_caso", referencedColumnName = "id_caso")
    @ManyToOne(fetch = FetchType.EAGER)
    private Caso idCaso;

    public CasoDetalle() {
    }

    public CasoDetalle(Integer idCasoDetalle) {
        this.idCasoDetalle = idCasoDetalle;
    }

    public Integer getIdCasoDetalle() {
        return idCasoDetalle;
    }

    public void setIdCasoDetalle(Integer idCasoDetalle) {
        this.idCasoDetalle = idCasoDetalle;
    }

    @XmlTransient
    public List<CasoDetalleRequisito> getCasoDetalleRequisitoList() {
        return casoDetalleRequisitoList;
    }

    public void setCasoDetalleRequisitoList(List<CasoDetalleRequisito> casoDetalleRequisitoList) {
        this.casoDetalleRequisitoList = casoDetalleRequisitoList;
    }

    public Caso getIdCaso() {
        return idCaso;
    }

    public void setIdCaso(Caso idCaso) {
        this.idCaso = idCaso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCasoDetalle != null ? idCasoDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CasoDetalle)) {
            return false;
        }
        CasoDetalle other = (CasoDetalle) object;
        if ((this.idCasoDetalle == null && other.idCasoDetalle != null) || (this.idCasoDetalle != null && !this.idCasoDetalle.equals(other.idCasoDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi135.casos.CasoDetalle[ idCasoDetalle=" + idCasoDetalle + " ]";
    }
    
}
