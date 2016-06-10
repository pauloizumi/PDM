package br.edu.ifsp.hto.cadastro.fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import br.edu.ifsp.hto.cadastro.R;
import br.edu.ifsp.hto.cadastro.adapter.DepartamentoAdapter;
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


public class AddFuncionarioFragment extends Fragment {
    private Context context;
    private ListView listView;

    public AddFuncionarioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_funcionario, container, false);
       listView = (ListView) view.findViewById(R.id.listViewAddFuncionario);
        mostrarDepartamento();
        Button btGravarFuncionario = (Button) view.findViewById(R.id.btGravarFuncionario);
        btGravarFuncionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gravarFuncionario();
            }
        });
        return view;
    }

    private void mostrarDepartamento() {
        String baseURL = "http://192.168.30.10:8090/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DepartamentoService service = retrofit.create(DepartamentoService.class);
        Call<List<Departamento>> call = service.listarDepartamentos();
        call.enqueue(new Callback<List<Departamento>>() {
            @Override
            public void onResponse(Call<List<Departamento>> call, Response<List<Departamento>> response) {
                final List<Departamento> departamentos = response.body();

                listView.setAdapter(new DepartamentoAdapter(getContext(), departamentos));
                listView.setOnItemClickListener(new ListView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        for (int i =0 ; i < listView.getChildCount(); i++){
                            listView.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                        }
                        view.setBackgroundColor(Color.GRAY);
                        Departamento departamento = departamentos.get(position);
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Departamento>> call, Throwable t) {

            }
        });
    }

    public void gravarFuncionario() {
        String baseURL = "http://192.168.30.10:8090/";

        EditText eNome = (EditText) getView().findViewById(R.id.eNome);
        EditText eCargo = (EditText) getView().findViewById(R.id.eCargo);
       // EditText eSal = (EditText) getView().findViewById(R.id.eSal);

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(eNome.getText().toString());
        funcionario.setCargo(eCargo.getText().toString());
       // funcionario.setSal(Double.parseDouble(eSal.getText().toString()));

        eNome.setText("");
        eCargo.setText("");
        //eSal.setText("");


        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        FuncionarioService service = retrofit.create(FuncionarioService.class);

        Call<Funcionario> call = service.criarFuncionario(funcionario.getNome(),funcionario.getCargo(),funcionario.getSal());

        call.enqueue(new Callback<Funcionario>() {
            @Override
            public void onResponse(Call<Funcionario> call, Response<Funcionario> response) {

            }

            @Override
            public void onFailure(Call<Funcionario> call, Throwable t) {

            }
        });
    }
}