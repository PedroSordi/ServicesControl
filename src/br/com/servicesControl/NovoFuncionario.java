package br.com.servicesControl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import br.com.serviceControl.dao.FuncionarioDAO;
import br.com.servicesControl.entity.Funcionario;

public class NovoFuncionario extends Activity {

	private EditText campoNome;
	private EditText campoCpf;
	private EditText campoTelefone;
	private EditText campoSenha;
	private EditText campoRepSenha;
	private Button cancelar;
	private Button salvar;
	private ArrayAdapter<CharSequence> adapter;
	private Spinner spinner;
	private TextView titulo;
	private Button abrirLista;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.novo_funcionario);

		titulo = (TextView) findViewById(R.id.campo_titulo);
		titulo.setText("Novo Funcionario");
		
		abrirLista = (Button) findViewById(R.id.menu);
		abrirLista.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(NovoFuncionario.this, ListarFuncionario.class);
				startActivity(i);
				finish();
			}
		});

		campoNome = (EditText) findViewById(R.id.campo_nome);
		campoCpf = (EditText) findViewById(R.id.campo_cpf);
		campoTelefone = (EditText) findViewById(R.id.campo_telefone);
		campoSenha = (EditText) findViewById(R.id.campo_senha);
		campoRepSenha = (EditText) findViewById(R.id.campo_senhanovamente);
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
				String senha = campoSenha.getText().toString();
				String repSenha = campoRepSenha.getText().toString();
				if (senha.equals(repSenha)) {

					String nome = campoNome.getText().toString();
					String cpf = campoCpf.getText().toString();
					String telefone = campoTelefone.getText().toString();
					String cargo = (String) spinner.getSelectedItem();

					if (nome.equals("") || telefone.equals("")
							|| cpf.equals("")) {
						Toast.makeText(getApplicationContext(),
								"Preencha todos os campos!", Toast.LENGTH_SHORT)
								.show();
					} else {
						Funcionario f = new Funcionario(nome, cpf, telefone,
								cargo, senha);
						FuncionarioDAO fDao = new FuncionarioDAO(
								NovoFuncionario.this);
						fDao.insert(f);
						finish();
						Toast.makeText(getApplicationContext(),
								"Salvo com sucesso!", Toast.LENGTH_SHORT)
								.show();
						finish();
						Toast.makeText(getApplicationContext(),fDao.getAll().toString(), Toast.LENGTH_SHORT).show();
					}

				} else {
					Toast.makeText(NovoFuncionario.this, "Senhas não conferem",
							Toast.LENGTH_LONG).show();
				}
			}
		});

		criarSpinnerCargos();
	}

	private void criarSpinnerCargos() {
		spinner = (Spinner) findViewById(R.id.cargos_spinner);
		adapter = ArrayAdapter.createFromResource(this, R.array.cargos_array,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
	}
}
