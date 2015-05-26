package br.com.servicesControl;

import java.io.Serializable;
import java.util.List;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import br.com.serviceControl.dao.ClienteDAO;
import br.com.servicesControl.entity.Cliente;

public class ClienteAdapter extends BaseAdapter implements Serializable {

	private static final long serialVersionUID = 1681578298865327151L;
	private List<Cliente> listaClientes;
	private LayoutInflater mInflater;
	private Context c;

	public ClienteAdapter(List<Cliente> listaClientes, Context c) {
		this.listaClientes = listaClientes;
		this.c = c;
		mInflater = LayoutInflater.from(c);
	}

	@Override
	public int getCount() {
		return listaClientes.size();
	}

	@Override
	public Object getItem(int position) {
		return listaClientes.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, final View view, ViewGroup parent) {
		final Cliente cliente = listaClientes.get(position);
		View v = mInflater.inflate(R.layout.item_cliente, null);
		final ClienteDAO clientedao = new ClienteDAO(c);

		TextView nome = (TextView) v.findViewById(R.id.cliente_nome);
		nome.setText(cliente.getNome());
		
		Button editar = (Button)v.findViewById(R.id.editar);
		editar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(c, NovoCliente.class);
				i.putExtra("cliente", cliente);
				c.startActivity(i);
			}
		});

		Button deletar = (Button)v.findViewById(R.id.deletar);
		deletar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clientedao.delete(cliente);
				listaClientes.clear();
				listaClientes = clientedao.getAll();
				notifyDataSetChanged();
			}
		});
		
		return v;
	}
}
