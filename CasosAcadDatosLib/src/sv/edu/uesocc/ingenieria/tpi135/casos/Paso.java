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
@Table(name = "paso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paso.findAll", query = "SELECT p FROM Paso p")
    , @NamedQuery(name = "Paso.findByIdPaso", query = "SELECT p FROM Paso p WHERE p.idPaso = :idPaso")
    , @NamedQuery(name = "Paso.findByNombrePaso", query = "SELECT p FROM Paso p WHERE p.nombrePaso = :nombrePaso")
    , @NamedQuery(name = "Paso.findByDescripcion", query = "SELECT p FROM Paso p WHERE p.descripcion = :descripcion")})
public class Paso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_paso", nullable = false)
    private Integer idPaso;
    @Column(name = "nombre_paso", length = 45)
    private String nombrePaso;
    @Column(name = "descripcion", length = 80)
    private String descripcion;
    @OneToMany(mappedBy = "idPaso", fetch = FetchType.EAGER)
    private List<ProcesoDetalle> procesoDetalleList;
    @JoinColumn(name = "id_tipo_paso", referencedColumnName = "id_tipo_paso")
    @ManyToOne(fetch = FetchType.EAGER)
    private TipoPaso idTipoPaso;
    @OneToMany(mappedBy = "idPaso", fetch = FetchType.EAGER)
    private List<PasoRequisito> pasoRequisitoList;

    public Paso() {
    }

    public Paso(Integer idPaso) {
        this.idPaso = idPaso;
    }

    public Integer getIdPaso() {
        return idPaso;
    }

    public void setIdPaso(Integer idPaso) {
        this.idPaso = idPaso;
    }

    public String getNombrePaso() {
        return nombrePaso;
    }

    public void setNombrePaso(String nombrePaso) {
        this.nombrePaso = nombrePaso;
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

    public TipoPaso getIdTipoPaso() {
        return idTipoPaso;
    }

    public void setIdTipoPaso(TipoPaso idTipoPaso) {
        this.idTipoPaso = idTipoPaso;
    }

    @XmlTransient
    public List<PasoRequisito> getPasoRequisitoList() {
        return pasoRequisitoList;
    }

    public void setPasoRequisitoList(List<PasoRequisito> pasoRequisitoList) {
        this.pasoRequisitoList = pasoRequisitoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaso != null ? idPaso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paso)) {
            return false;
        }
        Paso other = (Paso) object;
        if ((this.idPaso == null && other.idPaso != null) || (this.idPaso != null && !this.idPaso.equals(other.idPaso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi135.casos.Paso[ idPaso=" + idPaso + " ]";
    }
    
}
