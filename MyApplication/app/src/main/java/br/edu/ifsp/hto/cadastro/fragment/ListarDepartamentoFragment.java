package br.edu.ifsp.hto.cadastro.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import br.edu.ifsp.hto.cadastro.R;
import br.edu.ifsp.hto.cadastro.presenter.ListarDepartamentosPresenter;
import br.edu.ifsp.hto.cadastro.presenter.ListarFuncionariosPresenter;



public class ListarDepartamentoFragment extends Fragment {
    private ListView mList;

    public ListarDepartamentoFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_listar_departamento, container, false);

        mList = (ListView) view.findViewById(R.id.listView);

        ListarDepartamentosPresenter.listarDepartamentos(getContext(), mList);

        return view;
    }

}
