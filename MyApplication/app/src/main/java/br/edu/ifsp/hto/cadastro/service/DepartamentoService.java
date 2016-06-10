package br.edu.ifsp.hto.cadastro.service;

import java.util.List;

import br.edu.ifsp.hto.cadastro.domain.Departamento;
import br.edu.ifsp.hto.cadastro.domain.Funcionario;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface DepartamentoService {
    @GET("departamento/list")
    Call<List<Departamento>> listarDepartamentos();


    @FormUrlEncoded
    @POST("departamento/new")
    Call<Departamento> criarDepartamento(@Field("nome_dep")String nome_dep, @Field("local_dep")String local_dep);
}