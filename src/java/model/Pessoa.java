/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Maurílio
 */
@Entity
@Table(name = "pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findByCodPessoa", query = "SELECT p FROM Pessoa p WHERE p.codPessoa = :codPessoa"),
    @NamedQuery(name = "Pessoa.findByCodTipoPessoa", query = "SELECT p FROM Pessoa p WHERE p.codTipoPessoa = :codTipoPessoa"),
    @NamedQuery(name = "Pessoa.findByPesFisica", query = "SELECT p FROM Pessoa p WHERE p.pesFisica = :pesFisica"),
    @NamedQuery(name = "Pessoa.findByPesNome", query = "SELECT p FROM Pessoa p WHERE p.pesNome = :pesNome"),
    @NamedQuery(name = "Pessoa.findByPesSexo", query = "SELECT p FROM Pessoa p WHERE p.pesSexo = :pesSexo")})
public class Pessoa implements Serializable {
    @Column(name = "pesCPF")
    private Integer pesCPF;
    @Column(name = "pesDtCadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pesDtCadastro;
    @Basic(optional = false)
    @Column(name = "pesAtivo")
    private boolean pesAtivo;
    @Basic(optional = false)
    @Column(name = "pesEmail")
    private String pesEmail;
    @Basic(optional = false)
    @Column(name = "pesSenha")
    private String pesSenha;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_Pessoa")
    private Integer codPessoa;
    @Basic(optional = false)
    @Column(name = "Cod_Tipo_Pessoa")
    private short codTipoPessoa;
    @Basic(optional = false)
    @Column(name = "pesFisica")
    private boolean pesFisica;
    @Basic(optional = false)
    @Column(name = "pesNome")
    private String pesNome;
    @Column(name = "pesSexo")
    private Boolean pesSexo;
    @JoinColumn(name = "Cod_Empresa", referencedColumnName = "Cod_Empresa")
    @ManyToOne(optional = false)
    private Empresa codEmpresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPessoa")
    private List<Endereco> enderecoList;

    public Pessoa() {
    }

    public Pessoa(Integer codPessoa) {
        this.codPessoa = codPessoa;
    }

    public Pessoa(Integer codPessoa, short codTipoPessoa, boolean pesFisica, String pesNome) {
        this.codPessoa = codPessoa;
        this.codTipoPessoa = codTipoPessoa;
        this.pesFisica = pesFisica;
        this.pesNome = pesNome;
    }

    public Integer getCodPessoa() {
        return codPessoa;
    }

    public void setCodPessoa(Integer codPessoa) {
        this.codPessoa = codPessoa;
    }

    public short getCodTipoPessoa() {
        return codTipoPessoa;
    }

    public void setCodTipoPessoa(short codTipoPessoa) {
        this.codTipoPessoa = codTipoPessoa;
    }

    public boolean getPesFisica() {
        return pesFisica;
    }

    public void setPesFisica(boolean pesFisica) {
        this.pesFisica = pesFisica;
    }

    public String getPesNome() {
        return pesNome;
    }

    public void setPesNome(String pesNome) {
        this.pesNome = pesNome;
    }

    public Boolean getPesSexo() {
        return pesSexo;
    }

    public void setPesSexo(Boolean pesSexo) {
        this.pesSexo = pesSexo;
    }

    public Empresa getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(Empresa codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    @XmlTransient
    public List<Endereco> getEnderecoList() {
        return enderecoList;
    }

    public void setEnderecoList(List<Endereco> enderecoList) {
        this.enderecoList = enderecoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPessoa != null ? codPessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.codPessoa == null && other.codPessoa != null) || (this.codPessoa != null && !this.codPessoa.equals(other.codPessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Pessoa[ codPessoa=" + codPessoa + " ]";
    }

    public Integer getPesCPF() {
        return pesCPF;
    }

    public void setPesCPF(Integer pesCPF) {
        this.pesCPF = pesCPF;
    }

    public Date getPesDtCadastro() {
        return pesDtCadastro;
    }

    public void setPesDtCadastro(Date pesDtCadastro) {
        this.pesDtCadastro = pesDtCadastro;
    }

    public boolean getPesAtivo() {
        return pesAtivo;
    }

    public void setPesAtivo(boolean pesAtivo) {
        this.pesAtivo = pesAtivo;
    }

    public String getPesEmail() {
        return pesEmail;
    }

    public void setPesEmail(String pesEmail) {
        this.pesEmail = pesEmail;
    }

    public String getPesSenha() {
        return pesSenha;
    }

    public void setPesSenha(String pesSenha) {
        this.pesSenha = pesSenha;
    }
    
}
