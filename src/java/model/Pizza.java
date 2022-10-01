/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "pizza")
@NamedQueries({
    @NamedQuery(name = "Pizza.findAll", query = "SELECT p FROM Pizza p")})
public class Pizza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idtable1")
    private Integer idtable1;
    @Basic(optional = false)
    @Column(name = "nomepizza")
    private String nomepizza;
    @Basic(optional = false)
    @Column(name = "sabor")
    private String sabor;
    @Basic(optional = false)
    @Column(name = "preco")
    private double preco;
    @Basic(optional = false)
    @Column(name = "tamanho")
    private String tamanho;
    @ManyToMany(mappedBy = "pizzaList")
    private List<Ingredientes> ingredientesList;
    @ManyToMany(mappedBy = "pizzaList")
    private List<Pedido> pedidoList;

    public Pizza() {
    }

    public Pizza(Integer idtable1) {
        this.idtable1 = idtable1;
    }

    public Pizza(Integer idtable1, String nomepizza, String sabor, double preco, String tamanho) {
        this.idtable1 = idtable1;
        this.nomepizza = nomepizza;
        this.sabor = sabor;
        this.preco = preco;
        this.tamanho = tamanho;
    }

    public Integer getIdtable1() {
        return idtable1;
    }

    public void setIdtable1(Integer idtable1) {
        this.idtable1 = idtable1;
    }

    public String getNomepizza() {
        return nomepizza;
    }

    public void setNomepizza(String nomepizza) {
        this.nomepizza = nomepizza;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public List<Ingredientes> getIngredientesList() {
        return ingredientesList;
    }

    public void setIngredientesList(List<Ingredientes> ingredientesList) {
        this.ingredientesList = ingredientesList;
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
        hash += (idtable1 != null ? idtable1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pizza)) {
            return false;
        }
        Pizza other = (Pizza) object;
        if ((this.idtable1 == null && other.idtable1 != null) || (this.idtable1 != null && !this.idtable1.equals(other.idtable1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Pizza[ idtable1=" + idtable1 + " ]";
    }
    
}
