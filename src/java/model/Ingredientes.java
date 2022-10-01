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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "ingredientes")
@NamedQueries({
    @NamedQuery(name = "Ingredientes.findAll", query = "SELECT i FROM Ingredientes i")})
public class Ingredientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idingredientes")
    private Integer idingredientes;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @JoinTable(name = "ingredientes_has_pizza", joinColumns = {
        @JoinColumn(name = "Ingredientes_idingredientes", referencedColumnName = "idingredientes")}, inverseJoinColumns = {
        @JoinColumn(name = "Pizza_idtable1", referencedColumnName = "idtable1")})
    @ManyToMany
    private List<Pizza> pizzaList;
    @JoinColumn(name = "Fornecedor_idfornecedor", referencedColumnName = "idfornecedor")
    @ManyToOne(optional = false)
    private Fornecedor fornecedoridfornecedor;

    public Ingredientes() {
    }

    public Ingredientes(Integer idingredientes) {
        this.idingredientes = idingredientes;
    }

    public Ingredientes(Integer idingredientes, String nome) {
        this.idingredientes = idingredientes;
        this.nome = nome;
    }

    public Integer getIdingredientes() {
        return idingredientes;
    }

    public void setIdingredientes(Integer idingredientes) {
        this.idingredientes = idingredientes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Pizza> getPizzaList() {
        return pizzaList;
    }

    public void setPizzaList(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }

    public Fornecedor getFornecedoridfornecedor() {
        return fornecedoridfornecedor;
    }

    public void setFornecedoridfornecedor(Fornecedor fornecedoridfornecedor) {
        this.fornecedoridfornecedor = fornecedoridfornecedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idingredientes != null ? idingredientes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingredientes)) {
            return false;
        }
        Ingredientes other = (Ingredientes) object;
        if ((this.idingredientes == null && other.idingredientes != null) || (this.idingredientes != null && !this.idingredientes.equals(other.idingredientes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Ingredientes[ idingredientes=" + idingredientes + " ]";
    }
    
}
