/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "cliente")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idcliente")
    private Integer idcliente;
    @Basic(optional = false)
    @Column(name = "total_de_compras")
    private int totalDeCompras;
    @Basic(optional = false)
    @Column(name = "avaliacao_do_servico")
    private int avaliacaoDoServico;
    @JoinColumn(name = "Pessoa_idpessoa", referencedColumnName = "idpessoa")
    @ManyToOne(optional = false)
    private Pessoa pessoaidpessoa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteIdcliente")
    private List<Pedido> pedidoList;

    public Cliente() {
    }

    public Cliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Cliente(Integer idcliente, int totalDeCompras, int avaliacaoDoServico) {
        this.idcliente = idcliente;
        this.totalDeCompras = totalDeCompras;
        this.avaliacaoDoServico = avaliacaoDoServico;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public int getTotalDeCompras() {
        return totalDeCompras;
    }

    public void setTotalDeCompras(int totalDeCompras) {
        this.totalDeCompras = totalDeCompras;
    }

    public int getAvaliacaoDoServico() {
        return avaliacaoDoServico;
    }

    public void setAvaliacaoDoServico(int avaliacaoDoServico) {
        this.avaliacaoDoServico = avaliacaoDoServico;
    }

    public Pessoa getPessoaidpessoa() {
        return pessoaidpessoa;
    }

    public void setPessoaidpessoa(Pessoa pessoaidpessoa) {
        this.pessoaidpessoa = pessoaidpessoa;
    }

    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcliente != null ? idcliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idcliente == null && other.idcliente != null) || (this.idcliente != null && !this.idcliente.equals(other.idcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Cliente[ idcliente=" + idcliente + " ]";
    }
    
}
