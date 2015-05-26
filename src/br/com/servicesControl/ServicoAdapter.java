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
import br.com.serviceControl.dao.ServicoDAO;
import br.com.servicesControl.entity.Cliente;
import br.com.servicesControl.entity.Servico;

public class ServicoAdapter extends BaseAdapter implements Serializable {

	private static final long serialVersionUID = 1681578298865327151L;
	private List<Servico> listaServicos;
	private LayoutInflater mInflater;
	private Context c;

	public ServicoAdapter(List<Servico> listaServicos, Context c) {
		this.listaServicos = listaServicos;
		this.c = c;
		mInflater = LayoutInflater.from(c);
	}

	@Override
	public int getCount() {
		return listaServicos.size();
	}

	@Override
	public Object getItem(int position) {
		return listaServicos.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, final View view, ViewGroup parent) {
		final Servico servico = listaServicos.get(position);
		View v = mInflater.inflate(R.layout.item_servico, null);
		final ServicoDAO servicoDao = new ServicoDAO(c);

		TextView nome = (TextView) v.findViewById(R.id.servico_nome);
		nome.setText(servico.getNome());
		
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
				servicoDao.delete(servico);
				listaServicos.clear();
				listaServicos = servicoDao.getAll();
				notifyDataSetChanged();
			}
		});
		
		return v;
	}
}
