package br.com.servicesControl;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import br.com.serviceControl.dao.ClienteDAO;
import br.com.servicesControl.entity.Cliente;

public class ListarClientes extends Activity {

	private ClienteAdapter clientesAdapter;
	private List<Cliente> listaClientes;
	private ListView listaView;
	private TextView titulo;
	private Button abrirLista;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.listar_cliente);
		
		titulo = (TextView) findViewById(R.id.campo_titulo);
		titulo.setText("Clientes");
		abrirLista = (Button) findViewById(R.id.menu);
		abrirLista.setText("N");
		abrirLista.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(ListarClientes.this, NovoCliente.class);
				startActivity(i);
				finish();
			}
		});
		
		criarListView();

	}

	private void criarListView() {
		ClienteDAO cDao = new ClienteDAO(ListarClientes.this);
		listaClientes = cDao.getAll();
		listaView = (ListView) findViewById(R.id.lista_cliente);

		clientesAdapter = new ClienteAdapter(listaClientes, ListarClientes.this);
		listaView.setAdapter(clientesAdapter);
	}

}
