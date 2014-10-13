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
@Table(name = "vnc")
@NamedQueries({
    @NamedQuery(name = "Vnc.findAll", query = "SELECT v FROM Vnc v")})
public class Vnc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_vnc")
    private Integer idvnc;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(mappedBy = "vnc")
    private List<Equipo> equipoList;

    public Vnc() {
    }

    public Vnc(Integer idvnc) {
        this.idvnc = idvnc;
    }

    public Integer getIdvnc() {
        return idvnc;
    }

    public void setIdvnc(Integer idvnc) {
        this.idvnc = idvnc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        hash += (idvnc != null ? idvnc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vnc)) {
            return false;
        }
        Vnc other = (Vnc) object;
        if ((this.idvnc == null && other.idvnc != null) || (this.idvnc != null && !this.idvnc.equals(other.idvnc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "barmex.Vnc[ idvnc=" + idvnc + " ]";
    }
    
}
