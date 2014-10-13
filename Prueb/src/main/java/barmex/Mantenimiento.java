/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barmex;

import java.io.Serializable;
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

/**
 *
 * @author Alejandro Pacheco
 */
@Entity
@Table(name = "mantenimiento")
@NamedQueries({
    @NamedQuery(name = "Mantenimiento.findAll", query = "SELECT m FROM Mantenimiento m")})
public class Mantenimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_mantenimiento")
    private Integer idmantenimiento;
    @Column(name = "limpiar")
    private String limpiar;
    @Column(name = "empacar")
    private String empacar;
    @Column(name = "cargador")
    private String cargador;
    @Column(name = "etiqueta")
    private String etiqueta;
    @OneToMany(mappedBy = "mantenimiento")
    private List<Equipo> equipoList;

    public Mantenimiento() {
    }

    public Mantenimiento(Integer idmantenimiento) {
        this.idmantenimiento = idmantenimiento;
    }

    public Integer getIdmantenimiento() {
        return idmantenimiento;
    }

    public void setIdmantenimiento(Integer idmantenimiento) {
        this.idmantenimiento = idmantenimiento;
    }

    public String getLimpiar() {
        return limpiar;
    }

    public void setLimpiar(String limpiar) {
        this.limpiar = limpiar;
    }

    public String getEmpacar() {
        return empacar;
    }

    public void setEmpacar(String empacar) {
        this.empacar = empacar;
    }

    public String getCargador() {
        return cargador;
    }

    public void setCargador(String cargador) {
        this.cargador = cargador;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
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
        hash += (idmantenimiento != null ? idmantenimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mantenimiento)) {
            return false;
        }
        Mantenimiento other = (Mantenimiento) object;
        if ((this.idmantenimiento == null && other.idmantenimiento != null) || (this.idmantenimiento != null && !this.idmantenimiento.equals(other.idmantenimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "barmex.Mantenimiento[ idmantenimiento=" + idmantenimiento + " ]";
    }
    
}
