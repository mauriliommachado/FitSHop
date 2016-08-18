/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauri
 */
@Entity
@Table(name = "alineas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alineas.findAll", query = "SELECT a FROM Alineas a"),
    @NamedQuery(name = "Alineas.findByCodAlinea", query = "SELECT a FROM Alineas a WHERE a.codAlinea = :codAlinea"),
    @NamedQuery(name = "Alineas.findByAliDescricao", query = "SELECT a FROM Alineas a WHERE a.aliDescricao = :aliDescricao")})
public class Alineas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Cod_Alinea")
    private Short codAlinea;
    @Basic(optional = false)
    @Column(name = "aliDescricao")
    private String aliDescricao;

    public Alineas() {
    }

    public Alineas(Short codAlinea) {
        this.codAlinea = codAlinea;
    }

    public Alineas(Short codAlinea, String aliDescricao) {
        this.codAlinea = codAlinea;
        this.aliDescricao = aliDescricao;
    }

    public Short getCodAlinea() {
        return codAlinea;
    }

    public void setCodAlinea(Short codAlinea) {
        this.codAlinea = codAlinea;
    }

    public String getAliDescricao() {
        return aliDescricao;
    }

    public void setAliDescricao(String aliDescricao) {
        this.aliDescricao = aliDescricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAlinea != null ? codAlinea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alineas)) {
            return false;
        }
        Alineas other = (Alineas) object;
        if ((this.codAlinea == null && other.codAlinea != null) || (this.codAlinea != null && !this.codAlinea.equals(other.codAlinea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Alineas[ codAlinea=" + codAlinea + " ]";
    }
    
}
