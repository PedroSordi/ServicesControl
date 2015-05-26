package br.com.servicesControl;

import java.io.Serializable;
import java.util.List;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import br.com.serviceControl.dao.ClienteDAO;
import br.com.serviceControl.dao.FuncionarioDAO;
import br.com.servicesControl.entity.Cliente;
import br.com.servicesControl.entity.Funcionario;

public class FuncionarioAdapter extends BaseAdapter implements Serializable {

	private static final long serialVersionUID = 1681578298865327151L;
	private List<Funcionario> listaFuncionarios;
	private LayoutInflater mInflater;
	private Context c;

	public FuncionarioAdapter(List<Funcionario> listaFuncionarios, Context c) {
		this.listaFuncionarios = listaFuncionarios;
		this.c = c;
		mInflater = LayoutInflater.from(c);
	}

	@Override
	public int getCount() {
		return listaFuncionarios.size();
	}

	@Override
	public Object getItem(int position) {
		return listaFuncionarios.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, final View view, ViewGroup parent) {
		final Funcionario funcionario = listaFuncionarios.get(position);
		View v = mInflater.inflate(R.layout.item_funcionario, null);
		final FuncionarioDAO funcionarioDao = new FuncionarioDAO(c);

		TextView nome = (TextView) v.findViewById(R.id.funcionario_nome);
		nome.setText(funcionario.getNome());
		
		Button editar = (Button)v.findViewById(R.id.editar);
		editar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			}
		});

		Button deletar = (Button)v.findViewById(R.id.deletar);
		deletar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				funcionarioDao.delete(funcionario);
				listaFuncionarios.clear();
				listaFuncionarios = funcionarioDao.getAll();
				notifyDataSetChanged();
			}
		});
		
		return v;
	}
}
