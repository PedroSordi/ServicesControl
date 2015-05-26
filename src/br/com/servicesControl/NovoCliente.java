package br.com.servicesControl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import br.com.serviceControl.dao.ClienteDAO;
import br.com.servicesControl.entity.Cliente;

public class NovoCliente extends Activity {
	private EditText campoNome;
	private EditText campoCpf;
	private EditText campoTelefone;
	private Button cancelar;
	private Button salvar;
	private TextView titulo;
	private Button abrirLista;
	private boolean editar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.novo_cliente);
		campoNome = (EditText) findViewById(R.id.campo_nome);
		campoCpf = (EditText) findViewById(R.id.campo_cpf);
		campoTelefone = (EditText) findViewById(R.id.campo_telefone);
		cancelar = (Button) findViewById(R.id.botao_cancelar);
		salvar = (Button) findViewById(R.id.botao_salvar);

		if (getIntent().hasExtra("cliente")) {
			editar = true;
			Cliente cliente = (Cliente) getIntent().getExtras().get("cliente");
			campoNome.setText(cliente.getNome());
			campoCpf.setText(cliente.getCpf());
			campoTelefone.setText(cliente.getTelefone());
			// pegar cliente e colocar na tela
		}

		titulo = (TextView) findViewById(R.id.campo_titulo);
		titulo.setText("Novo Cliente");
		abrirLista = (Button) findViewById(R.id.menu);
		abrirLista.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(NovoCliente.this, ListarClientes.class);
				startActivity(i);
				finish();
			}
		});

		cancelar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});

		salvar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String nome = campoNome.getText().toString();
				String cpf = campoCpf.getText().toString();
				String telefone = campoTelefone.getText().toString();

				if (nome.equals("") || telefone.equals("") || cpf.equals("")) {
					Toast.makeText(getApplicationContext(),
							"Preencha todos os campos!", Toast.LENGTH_SHORT)
							.show();
				} else {
					Cliente c = new Cliente(nome, cpf, telefone);
					ClienteDAO cDao = new ClienteDAO(NovoCliente.this);
					if (editar) {
						Toast.makeText(getApplicationContext(),
								"Editado com sucesso!", Toast.LENGTH_SHORT)
								.show();
						cDao.update(c);
					} else {
						Toast.makeText(getApplicationContext(),
								"Salvo com sucesso!", Toast.LENGTH_SHORT)
								.show();
						cDao.insert(c);
					}
					finish();
				}

			}
		});
	}
}
