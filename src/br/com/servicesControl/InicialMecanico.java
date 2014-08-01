package br.com.servicesControl;

import java.util.List;

import br.com.servicesControl.controller.MPedidosAdapter;
import br.com.servicesControl.entity.Pedido;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class InicialMecanico extends Activity {

	private MPedidosAdapter pedidosAdapter;
	private List<Pedido> listaPedidosTeste;
	private ListView listaView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.m_pedidos);

		adicionarItensFakes();
	}

	private void criarListView() {
		listaView = (ListView) findViewById(R.id.m_pedidos_lista);

		pedidosAdapter = new MPedidosAdapter(listaPedidosTeste,
				InicialMecanico.this);
		listaView.setAdapter(pedidosAdapter);
	}

	private void adicionarItensFakes() {
		Pedido p = new Pedido("123", "Nome1", "data1", 1);
		Pedido p2 = new Pedido("456", "Nome2", "data2", 2);
		Pedido p3 = new Pedido("789", "Nome3", "data3", 3);

		listaPedidosTeste.add(p);
		listaPedidosTeste.add(p2);
		listaPedidosTeste.add(p3);

		criarListView();
	}
}
