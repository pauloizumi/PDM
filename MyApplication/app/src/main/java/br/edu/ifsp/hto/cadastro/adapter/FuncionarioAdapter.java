package br.edu.ifsp.hto.cadastro.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.edu.ifsp.hto.cadastro.R;
import br.edu.ifsp.hto.cadastro.domain.Departamento;
import br.edu.ifsp.hto.cadastro.domain.Funcionario;

/**
 * Created by paulo on 05/30/16.
 */
public class FuncionarioAdapter extends BaseAdapter {
    private final Context context;
    private final List<Funcionario> funcionarios;

    public FuncionarioAdapter(Context context, List funcionarios) {
        this.context = context;
        this.funcionarios = funcionarios;
    }


    public int getItemCount() {

        return this.funcionarios != null ? this.funcionarios.size() : 0;
    }

    @Override
    public int getCount() {

        return this.funcionarios.size();
    }

    @Override
    public Object getItem(int position) {

        return this.funcionarios.get(position);
    }

    @Override
    public long getItemId(int position) {

        return this.funcionarios.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_funcionarios, parent, false);

        TextView tNome = (TextView) view.findViewById(R.id.tNome);
        TextView tCargo = (TextView) view.findViewById(R.id.tCargo);

        Funcionario funcionario = funcionarios.get(position);
        tNome.setText(funcionario.getNome());
        tCargo.setText(funcionario.getCargo());
        return view;
    }
}