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

public interface FuncionarioService {
    @GET("funcionario/list")
    Call<List<Funcionario>> listarFuncionarios();

    @FormUrlEncoded
    @POST("funcionario/new")
    Call<Funcionario> criarFuncionario(@Field("nome_emp")String nome_emp, @Field("cargo")String cargo, @Field("sal")Double sal);
}
