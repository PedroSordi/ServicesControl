package br.com.servicesControl;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import br.com.serviceControl.dao.PedidoDAO;
import br.com.servicesControl.entity.Pedido;

public class InicialMecanico extends Activity {

	private InicialMecanicoAdapter adapter;
	private List<Pedido> listaPedidos;
	private ListView listaView;
	private TextView titulo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.inicial_mecanico);

		titulo = (TextView) findViewById(R.id.campo_titulo);
		titulo.setText("Pedidos");
		findViewById(R.id.menu).setVisibility(View.INVISIBLE);

		criarListView();
		listaView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Pedido pedido = (Pedido) adapter.getItem(position);
				Toast.makeText(getApplicationContext(), pedido.toString(),
						Toast.LENGTH_LONG).show();
				Intent i = new Intent(getApplicationContext(),
						PedidoMecanico.class);
				i.putExtra("pedido", pedido);
				startActivity(i);
			}
		});
	}

	private void criarListView() {
		PedidoDAO pDao = new PedidoDAO(InicialMecanico.this);
		listaPedidos = pDao.getAll();
		listaView = (ListView) findViewById(R.id.lista_pedido);

		adapter = new InicialMecanicoAdapter(listaPedidos, InicialMecanico.this);
		listaView.setAdapter(adapter);
	}

}
