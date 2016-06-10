package br.edu.ifsp.hto.cadastro.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import br.edu.ifsp.hto.cadastro.R;
import br.edu.ifsp.hto.cadastro.domain.Departamento;
import br.edu.ifsp.hto.cadastro.domain.Funcionario;
import br.edu.ifsp.hto.cadastro.service.DepartamentoService;
import br.edu.ifsp.hto.cadastro.service.FuncionarioService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class AddDepartamentoFragment extends Fragment {
    private Context context;

    public AddDepartamentoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_departamento, container, false);

        Button btGravarDepartamento = (Button) view.findViewById(R.id.btGravarDepartamento);
        btGravarDepartamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gravarDepartamento();
            }
        });
        return view;
    }

    public void gravarDepartamento() {
        String baseURL = "http://192.168.30.10:8090/";

        EditText eNome = (EditText) getView().findViewById(R.id.eNome);
        EditText eLocal = (EditText) getView().findViewById(R.id.eLocal);

        Departamento departamento = new Departamento();
        departamento.setNome(eNome.getText().toString());
        departamento.setLocal(eLocal.getText().toString());


        eNome.setText("");
        eLocal.setText("");

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        DepartamentoService service = retrofit.create(DepartamentoService.class);

        Call<Departamento> call = service.criarDepartamento(departamento.getNome(),departamento.getLocal());

        call.enqueue(new Callback<Departamento>() {
            @Override
            public void onResponse(Call<Departamento> call, Response<Departamento> response) {

            }

            @Override
            public void onFailure(Call<Departamento> call, Throwable t) {

            }


        });
    }
}