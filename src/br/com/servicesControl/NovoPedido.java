package br.com.servicesControl;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import br.com.serviceControl.dao.ClienteDAO;
import br.com.serviceControl.dao.PedidoDAO;
import br.com.servicesControl.entity.Cliente;
import br.com.servicesControl.entity.Pedido;

public class NovoPedido extends Activity {
	private Button cancelar;
	private Button salvar;
	private ArrayAdapter<CharSequence> adapter;
	private Spinner spinner;
	private TextView titulo;
	private TextView campoPlaca;
	private TextView campoDescricao;
	private RatingBar ratingBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.novo_pedido);

		titulo = (TextView) findViewById(R.id.campo_titulo);
		titulo.setText("Novo Pedido");

		cancelar = (Button) findViewById(R.id.botao_cancelar);
		salvar = (Button) findViewById(R.id.botao_salvar);
		ratingBar = (RatingBar) findViewById(R.id.rating_prioridade);

		campoDescricao = (EditText) findViewById(R.id.campo_descricao);
		campoPlaca = (EditText) findViewById(R.id.campo_placa);

		salvar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String descricao = campoDescricao.getText().toString();
				String placa = campoPlaca.getText().toString();
				Cliente cliente = (Cliente) spinner.getSelectedItem();
				int prioridade = (int) ratingBar.getRating();
				Toast.makeText(getApplicationContext(), prioridade + "",
						Toast.LENGTH_SHORT).show();

				Pedido p = new Pedido(placa, descricao, cliente, prioridade);
				PedidoDAO pDao = new PedidoDAO(NovoPedido.this);
				pDao.insert(p);
				finish();
				Toast.makeText(getApplicationContext(),
						pDao.getAll().toString(), Toast.LENGTH_SHORT).show();
			}
		});

		cancelar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});

		criarSpinnerClientes();
	}

	private void criarSpinnerClientes() {
		ClienteDAO cDao = new ClienteDAO(getApplicationContext());
		spinner = (Spinner) findViewById(R.id.clientes_spinner);
		ArrayAdapter<Cliente> dataAdapter = new ArrayAdapter<Cliente>(this,
				android.R.layout.simple_spinner_item, cDao.getAll());

		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		spinner.setAdapter(dataAdapter);
	}

}
