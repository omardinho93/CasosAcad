/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.casos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author omar
 */
@Entity
@Table(name = "caso_detalle_requisito_atestado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CasoDetalleRequisitoAtestado.findAll", query = "SELECT c FROM CasoDetalleRequisitoAtestado c")
    , @NamedQuery(name = "CasoDetalleRequisitoAtestado.findByIdcasoDetalleRequisitoAtestado", query = "SELECT c FROM CasoDetalleRequisitoAtestado c WHERE c.idcasoDetalleRequisitoAtestado = :idcasoDetalleRequisitoAtestado")})
public class CasoDetalleRequisitoAtestado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idcaso_detalle_requisito_atestado", nullable = false)
    private Integer idcasoDetalleRequisitoAtestado;
    @JoinColumn(name = "id_caso_detalle_requisito", referencedColumnName = "id_caso_detalle_requisito")
    @ManyToOne(fetch = FetchType.EAGER)
    private CasoDetalleRequisito idCasoDetalleRequisito;

    public CasoDetalleRequisitoAtestado() {
    }

    public CasoDetalleRequisitoAtestado(Integer idcasoDetalleRequisitoAtestado) {
        this.idcasoDetalleRequisitoAtestado = idcasoDetalleRequisitoAtestado;
    }

    public Integer getIdcasoDetalleRequisitoAtestado() {
        return idcasoDetalleRequisitoAtestado;
    }

    public void setIdcasoDetalleRequisitoAtestado(Integer idcasoDetalleRequisitoAtestado) {
        this.idcasoDetalleRequisitoAtestado = idcasoDetalleRequisitoAtestado;
    }

    public CasoDetalleRequisito getIdCasoDetalleRequisito() {
        return idCasoDetalleRequisito;
    }

    public void setIdCasoDetalleRequisito(CasoDetalleRequisito idCasoDetalleRequisito) {
        this.idCasoDetalleRequisito = idCasoDetalleRequisito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcasoDetalleRequisitoAtestado != null ? idcasoDetalleRequisitoAtestado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CasoDetalleRequisitoAtestado)) {
            return false;
        }
        CasoDetalleRequisitoAtestado other = (CasoDetalleRequisitoAtestado) object;
        if ((this.idcasoDetalleRequisitoAtestado == null && other.idcasoDetalleRequisitoAtestado != null) || (this.idcasoDetalleRequisitoAtestado != null && !this.idcasoDetalleRequisitoAtestado.equals(other.idcasoDetalleRequisitoAtestado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi135.casos.CasoDetalleRequisitoAtestado[ idcasoDetalleRequisitoAtestado=" + idcasoDetalleRequisitoAtestado + " ]";
    }
    
}
