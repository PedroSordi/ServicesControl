package br.com.servicesControl;

import br.com.serviceControl.dao.FuncionarioDAO;
import br.com.servicesControl.entity.Funcionario;
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
import android.widget.Toast;

public class Login extends Activity {

	private EditText campoSenha;
	private Button logar;
	private Spinner spinner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);

		campoSenha = (EditText) findViewById(R.id.campo_senha);
		logar = (Button) findViewById(R.id.entrar);

		findViewById(R.id.menu).setVisibility(View.INVISIBLE);

		logar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Funcionario f = (Funcionario) spinner.getSelectedItem();
				if (f.getSenha().equals(campoSenha.getText().toString())) {
					if (f.getCargo().equals("Atendente")) {
						Intent i = new Intent(Login.this, AtendenteMenu.class);
						startActivity(i);
						finish();
					} else if (f.getCargo().equals("Mecanico")) {
						Intent i = new Intent(Login.this, InicialMecanico.class);
						startActivity(i);
						finish();
					}
				} else {
					Toast.makeText(Login.this, "Senhas não conferem",
							Toast.LENGTH_SHORT).show();
				}
			}
		});
		criarSpinnerFuncionarios();
	}

	private void criarSpinnerFuncionarios() {
		FuncionarioDAO fDao = new FuncionarioDAO(getApplicationContext());
		spinner = (Spinner) findViewById(R.id.funcionarios_spinner);
		ArrayAdapter<Funcionario> dataAdapter = new ArrayAdapter<Funcionario>(
				this, android.R.layout.simple_spinner_item, fDao.getAll());

		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		spinner.setAdapter(dataAdapter);
	}

}
