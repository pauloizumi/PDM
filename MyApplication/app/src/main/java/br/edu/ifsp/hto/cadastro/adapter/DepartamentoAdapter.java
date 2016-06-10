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
public class DepartamentoAdapter extends BaseAdapter {
    private final Context context;
    private final List<Departamento> departamentos;


    public DepartamentoAdapter(Context context, List departamentos) {
        this.context = context;
        this.departamentos = departamentos;

    }
    public int getItemCount() {

        return this.departamentos != null ? this.departamentos.size() : 0;
    }

    @Override
    public int getCount() {
        return this.departamentos.size();
    }

    @Override
    public Object getItem(int position) {
        return this.departamentos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.departamentos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_departamentos, parent, false);

        TextView tNome = (TextView) view.findViewById(R.id.tNome);
        TextView tLocal = (TextView) view.findViewById(R.id.tLocal);

        Departamento departamento = departamentos.get(position);
        tNome.setText(departamento.getNome());
        tLocal.setText(departamento.getLocal());

        return view;
    }

}