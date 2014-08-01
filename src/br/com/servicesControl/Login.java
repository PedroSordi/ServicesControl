package br.com.servicesControl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {

	private EditText campoUsuario;
	private EditText campoSenha;
	private Button logar;
	private Button novo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);

		campoUsuario = (EditText) findViewById(R.id.campo_usuario);
		campoSenha = (EditText) findViewById(R.id.campo_senha);
		logar = (Button) findViewById(R.id.entrar);
		novo = (Button) findViewById(R.id.novo);

		novo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(Login.this, NovoFuncionario.class);
				startActivity(i);
			}
		});

		logar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
			}
		});
	}

}
