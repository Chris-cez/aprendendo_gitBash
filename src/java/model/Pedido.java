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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "pedido")
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idpedido")
    private Integer idpedido;
    @Basic(optional = false)
    @Column(name = "datapedido")
    @Temporal(TemporalType.DATE)
    private Date datapedido;
    @Basic(optional = false)
    @Column(name = "entregue")
    private short entregue;
    @JoinTable(name = "pedido_has_pizza", joinColumns = {
        @JoinColumn(name = "Pedido_idpedido", referencedColumnName = "idpedido")}, inverseJoinColumns = {
        @JoinColumn(name = "Pizza_idtable1", referencedColumnName = "idtable1")})
    @ManyToMany
    private List<Pizza> pizzaList;
    @JoinColumn(name = "Acompanhamentos_idacompanhamentos", referencedColumnName = "idacompanhamentos")
    @ManyToOne
    private Acompanhamentos acompanhamentosidacompanhamentos;
    @JoinColumn(name = "cliente_idcliente", referencedColumnName = "idcliente")
    @ManyToOne(optional = false)
    private Cliente clienteIdcliente;

    public Pedido() {
    }

    public Pedido(Integer idpedido) {
        this.idpedido = idpedido;
    }

    public Pedido(Integer idpedido, Date datapedido, short entregue) {
        this.idpedido = idpedido;
        this.datapedido = datapedido;
        this.entregue = entregue;
    }

    public Integer getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(Integer idpedido) {
        this.idpedido = idpedido;
    }

    public Date getDatapedido() {
        return datapedido;
    }

    public void setDatapedido(Date datapedido) {
        this.datapedido = datapedido;
    }

    public short getEntregue() {
        return entregue;
    }

    public void setEntregue(short entregue) {
        this.entregue = entregue;
    }

    public List<Pizza> getPizzaList() {
        return pizzaList;
    }

    public void setPizzaList(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }

    public Acompanhamentos getAcompanhamentosidacompanhamentos() {
        return acompanhamentosidacompanhamentos;
    }

    public void setAcompanhamentosidacompanhamentos(Acompanhamentos acompanhamentosidacompanhamentos) {
        this.acompanhamentosidacompanhamentos = acompanhamentosidacompanhamentos;
    }

    public Cliente getClienteIdcliente() {
        return clienteIdcliente;
    }

    public void setClienteIdcliente(Cliente clienteIdcliente) {
        this.clienteIdcliente = clienteIdcliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpedido != null ? idpedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.idpedido == null && other.idpedido != null) || (this.idpedido != null && !this.idpedido.equals(other.idpedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Pedido[ idpedido=" + idpedido + " ]";
    }
    
}
