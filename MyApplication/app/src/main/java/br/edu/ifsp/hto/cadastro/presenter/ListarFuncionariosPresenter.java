package br.edu.ifsp.hto.cadastro.presenter;

import android.content.Context;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import javax.security.auth.callback.Callback;

import br.edu.ifsp.hto.cadastro.adapter.FuncionarioAdapter;
import br.edu.ifsp.hto.cadastro.domain.Funcionario;
import br.edu.ifsp.hto.cadastro.service.FuncionarioService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class ListarFuncionariosPresenter {
    public static String baseURL = "http://192.168.30.10:8090/";

    public static void listarFuncionarios(final Context context, final ListView listView){
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        FuncionarioService service = retrofit.create(FuncionarioService.class);
        Call<List<Funcionario>> call = service.listarFuncionarios();

        call.enqueue(new retrofit2.Callback<List<Funcionario>>() {
            @Override
            public void onResponse(Call<List<Funcionario>> call, Response<List<Funcionario>> response) {
                List<Funcionario> list = response.body();

                listView.setAdapter(new FuncionarioAdapter(context, list));
            }

            @Override
            public void onFailure(Call<List<Funcionario>> call, Throwable t) {

            }
        });
    }
}

