package br.edu.ifsp.hto.cadastro.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by paulo on 05/30/16.
 */
public class Departamento {
    @SerializedName("n_dep")
    private long id;
    @SerializedName("nome_dep")
    private String nome;
    @SerializedName("local_dep")
    private String local;


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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
