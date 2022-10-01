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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "fornecedor")
@NamedQueries({
    @NamedQuery(name = "Fornecedor.findAll", query = "SELECT f FROM Fornecedor f")})
public class Fornecedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idfornecedor")
    private Integer idfornecedor;
    @Basic(optional = false)
    @Column(name = "nomefornecedor")
    private String nomefornecedor;
    @Basic(optional = false)
    @Column(name = "inicio_da_parceria")
    @Temporal(TemporalType.DATE)
    private Date inicioDaParceria;
    @Basic(optional = false)
    @Column(name = "porte_da_empresa")
    private String porteDaEmpresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fornecedoridfornecedor")
    private List<Ingredientes> ingredientesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fornecedoridfornecedor")
    private List<Acompanhamentos> acompanhamentosList;

    public Fornecedor() {
    }

    public Fornecedor(Integer idfornecedor) {
        this.idfornecedor = idfornecedor;
    }

    public Fornecedor(Integer idfornecedor, String nomefornecedor, Date inicioDaParceria, String porteDaEmpresa) {
        this.idfornecedor = idfornecedor;
        this.nomefornecedor = nomefornecedor;
        this.inicioDaParceria = inicioDaParceria;
        this.porteDaEmpresa = porteDaEmpresa;
    }

    public Integer getIdfornecedor() {
        return idfornecedor;
    }

    public void setIdfornecedor(Integer idfornecedor) {
        this.idfornecedor = idfornecedor;
    }

    public String getNomefornecedor() {
        return nomefornecedor;
    }

    public void setNomefornecedor(String nomefornecedor) {
        this.nomefornecedor = nomefornecedor;
    }

    public Date getInicioDaParceria() {
        return inicioDaParceria;
    }

    public void setInicioDaParceria(Date inicioDaParceria) {
        this.inicioDaParceria = inicioDaParceria;
    }

    public String getPorteDaEmpresa() {
        return porteDaEmpresa;
    }

    public void setPorteDaEmpresa(String porteDaEmpresa) {
        this.porteDaEmpresa = porteDaEmpresa;
    }

    public List<Ingredientes> getIngredientesList() {
        return ingredientesList;
    }

    public void setIngredientesList(List<Ingredientes> ingredientesList) {
        this.ingredientesList = ingredientesList;
    }

    public List<Acompanhamentos> getAcompanhamentosList() {
        return acompanhamentosList;
    }

    public void setAcompanhamentosList(List<Acompanhamentos> acompanhamentosList) {
        this.acompanhamentosList = acompanhamentosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfornecedor != null ? idfornecedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.idfornecedor == null && other.idfornecedor != null) || (this.idfornecedor != null && !this.idfornecedor.equals(other.idfornecedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Fornecedor[ idfornecedor=" + idfornecedor + " ]";
    }
    
}
