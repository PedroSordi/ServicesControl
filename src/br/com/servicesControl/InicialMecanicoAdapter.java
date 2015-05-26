package br.com.servicesControl;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.serviceControl.dao.PedidoDAO;
import br.com.servicesControl.entity.Pedido;

public class InicialMecanicoAdapter extends BaseAdapter implements Serializable {

	private static final long serialVersionUID = 1681578298865327151L;
	private List<Pedido> listaPedidos;
	private LayoutInflater mInflater;
	private Context c;

	public InicialMecanicoAdapter(List<Pedido> listaPedidos, Context c) {
		this.listaPedidos = listaPedidos;
		this.c = c;
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
		View v = mInflater.inflate(R.layout.item_pedido_aberto, null);
		final PedidoDAO pedidoDao = new PedidoDAO(c);

		String dataFormatada = new SimpleDateFormat("dd/MM/yy HH:mm:ss")
				.format(pedido.getDataInicio());

		ImageView cor = (ImageView) v.findViewById(R.id.prioridade);
		int prioridade = pedido.getPrioridade();
		if (prioridade == 1) {
			cor.setBackgroundColor(Color.parseColor("#859CA4"));
		} else if (prioridade == 2) {
			cor.setBackgroundColor(Color.parseColor("#698495"));
		} else if (prioridade == 3) {
			cor.setBackgroundColor(Color.parseColor("#587585"));
		} else if (prioridade == 4) {
			cor.setBackgroundColor(Color.parseColor("#4B616F"));
		} else {
			cor.setBackgroundColor(Color.parseColor("#172D3A"));
		}

		TextView data = (TextView) v.findViewById(R.id.data_inicio);
		data.setText(dataFormatada);

		TextView placa = (TextView) v.findViewById(R.id.placa_veiculo);
		placa.setText(pedido.getPlaca());

		return v;
	}
}
