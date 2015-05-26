package br.com.servicesControl;

import br.com.serviceControl.dao.ServicoDAO;
import br.com.servicesControl.entity.Servico;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NovoServico extends Activity {
	private EditText campoNome;
	private EditText campoDescricao;
	private Button cancelar;
	private Button salvar;
	private TextView titulo;
	private Button abrirLista;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.novo_servico);

		titulo = (TextView) findViewById(R.id.campo_titulo);
		titulo.setText("Novo Serviço");

		abrirLista = (Button) findViewById(R.id.menu);
		abrirLista.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(NovoServico.this, ListarServicos.class);
				startActivity(i);
				finish();
			}
		});

		campoNome = (EditText) findViewById(R.id.campo_nome);
		campoDescricao = (EditText) findViewById(R.id.campo_descricao);
		cancelar = (Button) findViewById(R.id.botao_cancelar);
		salvar = (Button) findViewById(R.id.botao_salvar);

		cancelar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});

		salvar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String nome = campoNome.getText().toString();
				String descricao = campoDescricao.getText().toString();

				Servico s = new Servico(nome, descricao);
				ServicoDAO sDao = new ServicoDAO(NovoServico.this);
				sDao.insert(s);
				finish();
				Toast.makeText(getApplicationContext(), "Salvo com sucesso!",
						Toast.LENGTH_SHORT).show();
				Toast.makeText(getApplicationContext(),
						sDao.getAll().toString(), Toast.LENGTH_SHORT).show();

			}
		});

	}
}
