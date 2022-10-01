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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "funcionario")
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f")})
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idfuncionario")
    private Integer idfuncionario;
    @Basic(optional = false)
    @Column(name = "salario")
    private double salario;
    @Basic(optional = false)
    @Column(name = "trabalhando")
    private short trabalhando;
    @JoinColumn(name = "Cargos_idcargos", referencedColumnName = "idcargos")
    @ManyToOne(optional = false)
    private Cargos cargosidcargos;
    @JoinColumn(name = "Pessoa_idpessoa", referencedColumnName = "idpessoa")
    @ManyToOne(optional = false)
    private Pessoa pessoaidpessoa;

    public Funcionario() {
    }

    public Funcionario(Integer idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public Funcionario(Integer idfuncionario, double salario, short trabalhando) {
        this.idfuncionario = idfuncionario;
        this.salario = salario;
        this.trabalhando = trabalhando;
    }

    public Integer getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(Integer idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public short getTrabalhando() {
        return trabalhando;
    }

    public void setTrabalhando(short trabalhando) {
        this.trabalhando = trabalhando;
    }

    public Cargos getCargosidcargos() {
        return cargosidcargos;
    }

    public void setCargosidcargos(Cargos cargosidcargos) {
        this.cargosidcargos = cargosidcargos;
    }

    public Pessoa getPessoaidpessoa() {
        return pessoaidpessoa;
    }

    public void setPessoaidpessoa(Pessoa pessoaidpessoa) {
        this.pessoaidpessoa = pessoaidpessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfuncionario != null ? idfuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.idfuncionario == null && other.idfuncionario != null) || (this.idfuncionario != null && !this.idfuncionario.equals(other.idfuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Funcionario[ idfuncionario=" + idfuncionario + " ]";
    }
    
}
