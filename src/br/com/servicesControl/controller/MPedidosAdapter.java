package br.com.servicesControl.controller;

import java.io.Serializable;
import java.util.List;

import br.com.servicesControl.R;
import br.com.servicesControl.entity.Pedido;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MPedidosAdapter extends BaseAdapter implements Serializable {

	private static final long serialVersionUID = 1681578298865327151L;
	private List<Pedido> listaPedidos;
	private LayoutInflater mInflater;

	public MPedidosAdapter(List<Pedido> listaPedidos, Context c) {
		this.listaPedidos = listaPedidos;
		mInflater = LayoutInflater.from(c);
	}

	@Override
	public int getCount() {
		return listaPedidos.size();
	}

	@Override
	public Object getItem(int position) {
		return listaPedidos.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, final View view, ViewGroup parent) {
		final Pedido pedido = listaPedidos.get(position);
		View v = mInflater.inflate(R.layout.m_item_pedidos, null);

		TextView prioridade = (TextView) v
				.findViewById(R.id.m_pedido_prioridade);
		if (pedido.getPrioridade() == 1)
			prioridade.setBackgroundColor(Color.parseColor("#000fff"));
		else if (pedido.getPrioridade() == 2)
			prioridade.setBackgroundColor(Color.parseColor("#fff000"));
		else if (pedido.getPrioridade() == 3)
			prioridade.setBackgroundColor(Color.parseColor("#000000"));
		else if (pedido.getPrioridade() == 4)
			prioridade.setBackgroundColor(Color.parseColor("#ffffff"));
		else if (pedido.getPrioridade() == 5)
			prioridade.setBackgroundColor(Color.parseColor("#ffffff"));

		TextView cliente = (TextView) v.findViewById(R.id.m_pedido_cliente);
		// cliente.setText(pedido.getCliente().getNome());
		cliente.setText(pedido.getNome());

		TextView placa = (TextView) v.findViewById(R.id.m_pedido_placa);
		placa.setText(pedido.getPlaca());

		TextView dataInicio = (TextView) v
				.findViewById(R.id.m_pedido_datainicio);
		dataInicio.setText(pedido.getDataInicio());

		return v;
	}
}
