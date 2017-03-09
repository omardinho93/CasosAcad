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
@Table(name = "caso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caso.findAll", query = "SELECT c FROM Caso c")
    , @NamedQuery(name = "Caso.findByIdCaso", query = "SELECT c FROM Caso c WHERE c.idCaso = :idCaso")
    , @NamedQuery(name = "Caso.findByFechaInicioCaso", query = "SELECT c FROM Caso c WHERE c.fechaInicioCaso = :fechaInicioCaso")})
public class Caso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_caso", nullable = false)
    private Integer idCaso;
    @Column(name = "fecha_inicio_caso", length = 45)
    private String fechaInicioCaso;
    @JoinColumn(name = "id_proceso", referencedColumnName = "id_proceso")
    @ManyToOne(fetch = FetchType.EAGER)
    private Proceso idProceso;
    @JoinColumn(name = "id_solicitud", referencedColumnName = "id_solicitud")
    @ManyToOne(fetch = FetchType.EAGER)
    private Solicitud idSolicitud;
    @OneToMany(mappedBy = "idCaso", fetch = FetchType.EAGER)
    private List<CasoDetalle> casoDetalleList;

    public Caso() {
    }

    public Caso(Integer idCaso) {
        this.idCaso = idCaso;
    }

    public Integer getIdCaso() {
        return idCaso;
    }

    public void setIdCaso(Integer idCaso) {
        this.idCaso = idCaso;
    }

    public String getFechaInicioCaso() {
        return fechaInicioCaso;
    }

    public void setFechaInicioCaso(String fechaInicioCaso) {
        this.fechaInicioCaso = fechaInicioCaso;
    }

    public Proceso getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Proceso idProceso) {
        this.idProceso = idProceso;
    }

    public Solicitud getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Solicitud idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    @XmlTransient
    public List<CasoDetalle> getCasoDetalleList() {
        return casoDetalleList;
    }

    public void setCasoDetalleList(List<CasoDetalle> casoDetalleList) {
        this.casoDetalleList = casoDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCaso != null ? idCaso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caso)) {
            return false;
        }
        Caso other = (Caso) object;
        if ((this.idCaso == null && other.idCaso != null) || (this.idCaso != null && !this.idCaso.equals(other.idCaso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi135.casos.Caso[ idCaso=" + idCaso + " ]";
    }
    
}
