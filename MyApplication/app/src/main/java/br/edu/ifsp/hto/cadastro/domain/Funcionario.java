package br.edu.ifsp.hto.cadastro.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by paulo on 05/30/16.
 */
public class Funcionario {
    @SerializedName("n_emp")
    private long id;
    @SerializedName("nome_emp")
    private String nome;
    @SerializedName("cargo")
    private String cargo;
    @SerializedName("data_adm")
    private String data_adm;
    @SerializedName("sal")
    private double sal;
    @SerializedName("com")
    private double com;
    @SerializedName("chefe")
    private Chefe chefe;
    @SerializedName("departamento")
    private Departamento departamento;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getData_adm() {
        return data_adm;
    }

    public void setData_adm(String data_adm) {
        this.data_adm = data_adm;
    }

    public Chefe getChefe() {
        return chefe;
    }

    public void setChefe(Chefe chefe) {
        this.chefe = chefe;
    }

    public double getCom() {
        return com;
    }

    public void setCom(double com) {
        this.com = com;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
