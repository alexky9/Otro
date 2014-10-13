/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barmex;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Alejandro Pacheco
 */
@Entity
@Table(name = "datos_envio")
@NamedQueries({
    @NamedQuery(name = "DatosEnvio.findAll", query = "SELECT d FROM DatosEnvio d")})
public class DatosEnvio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_datos_en")
    private Integer iddatosen;
    @Column(name = "fecha_llegada")
    @Temporal(TemporalType.DATE)
    private Date fechaLlegada;
    @Column(name = "fecha_envio")
    @Temporal(TemporalType.DATE)
    private Date fechaEnvio;
    @Column(name = "fecha_recepcion")
    @Temporal(TemporalType.DATE)
    private Date fechaRecepcion;
    @Column(name = "correo")
    private String correo;
    @Column(name = "registro")
    @Temporal(TemporalType.DATE)
    private Date registro;
    @OneToMany(mappedBy = "datosEnvio")
    private List<Equipo> equipoList;

    public DatosEnvio() {
    }

    public DatosEnvio(Integer iddatosen) {
        this.iddatosen = iddatosen;
    }

    public Integer getIddatosen() {
        return iddatosen;
    }

    public void setIddatosen(Integer iddatosen) {
        this.iddatosen = iddatosen;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getRegistro() {
        return registro;
    }

    public void setRegistro(Date registro) {
        this.registro = registro;
    }

    public List<Equipo> getEquipoList() {
        return equipoList;
    }

    public void setEquipoList(List<Equipo> equipoList) {
        this.equipoList = equipoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddatosen != null ? iddatosen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatosEnvio)) {
            return false;
        }
        DatosEnvio other = (DatosEnvio) object;
        if ((this.iddatosen == null && other.iddatosen != null) || (this.iddatosen != null && !this.iddatosen.equals(other.iddatosen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "barmex.DatosEnvio[ iddatosen=" + iddatosen + " ]";
    }
    
}
