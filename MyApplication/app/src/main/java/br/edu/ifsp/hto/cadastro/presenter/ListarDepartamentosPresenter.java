package br.edu.ifsp.hto.cadastro.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.ListView;

import java.util.List;

import br.edu.ifsp.hto.cadastro.adapter.DepartamentoAdapter;
import br.edu.ifsp.hto.cadastro.adapter.FuncionarioAdapter;
import br.edu.ifsp.hto.cadastro.domain.Departamento;
import br.edu.ifsp.hto.cadastro.domain.Funcionario;
import br.edu.ifsp.hto.cadastro.service.DepartamentoService;
import br.edu.ifsp.hto.cadastro.service.FuncionarioService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by paulo on 06/02/16.
 */
public class ListarDepartamentosPresenter {
    public static String baseURL = "http://192.168.30.10:8090/";
    public static void listarDepartamentos(final Context context, final ListView listView){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DepartamentoService service = retrofit.create(DepartamentoService.class);
        Call<List<Departamento>> call = service.listarDepartamentos();


        call.enqueue(new retrofit2.Callback<List<Departamento>>() {
            @Override
            public void onResponse(Call<List<Departamento>> call, Response<List<Departamento>> response) {
                List<Departamento> list = response.body();

                listView.setAdapter(new DepartamentoAdapter(context, list));
            }

            @Override
            public void onFailure(Call<List<Departamento>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}

