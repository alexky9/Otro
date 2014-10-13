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
@Table(name = "agregado")
@NamedQueries({
    @NamedQuery(name = "Agregado.findAll", query = "SELECT a FROM Agregado a")})
public class Agregado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_agregado")
    private Integer idagregado;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "agregado")
    private List<Equipo> equipoList;

    public Agregado() {
    }

    public Agregado(Integer idagregado) {
        this.idagregado = idagregado;
    }

    public Integer getIdagregado() {
        return idagregado;
    }

    public void setIdagregado(Integer idagregado) {
        this.idagregado = idagregado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (idagregado != null ? idagregado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agregado)) {
            return false;
        }
        Agregado other = (Agregado) object;
        if ((this.idagregado == null && other.idagregado != null) || (this.idagregado != null && !this.idagregado.equals(other.idagregado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "barmex.Agregado[ idagregado=" + idagregado + " ]";
    }
    
}
