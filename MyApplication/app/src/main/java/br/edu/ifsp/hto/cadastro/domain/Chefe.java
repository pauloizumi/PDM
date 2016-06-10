package br.edu.ifsp.hto.cadastro.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by paulo on 06/07/16.
 */
public class Chefe {
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

    public String getData_adm() {
        return data_adm;
    }

    public void setData_adm(String data_adm) {
        this.data_adm = data_adm;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
