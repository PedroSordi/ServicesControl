package br.com.servicesControl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AtendenteMenu extends Activity {
	private Button pedido;
	private Button cliente;
	private Button produto;
	private Button servico;
	private Button funcionario;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.atendente_menu);

		pedido = (Button) findViewById(R.id.botao_pedido);
		cliente = (Button) findViewById(R.id.botao_cliente);
		produto = (Button) findViewById(R.id.botao_produto);
		servico = (Button) findViewById(R.id.botao_servico);
		funcionario = (Button) findViewById(R.id.botao_funcionario);

		pedido.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), NovoPedido.class);
				startActivity(i);
			}
		});

		cliente.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(),
						NovoCliente.class);
				startActivity(i);
			}
		});

		produto.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(),
						NovoProduto.class);
				startActivity(i);
			}
		});

		servico.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(),
						NovoServico.class);
				startActivity(i);
			}
		});

		funcionario.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(),
						NovoFuncionario.class);
				startActivity(i);
			}
		});
	}
}
