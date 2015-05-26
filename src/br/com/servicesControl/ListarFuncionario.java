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
import br.com.serviceControl.dao.FuncionarioDAO;
import br.com.servicesControl.entity.Cliente;
import br.com.servicesControl.entity.Funcionario;

public class ListarFuncionario extends Activity {

	private FuncionarioAdapter funcionarioAdapter;
	private List<Funcionario> listaFuncionario;
	private ListView listaView;
	private TextView titulo;
	private Button abrirLista;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.listar_funcionario);
		
		titulo = (TextView) findViewById(R.id.campo_titulo);
		titulo.setText("Funcinarios");
		abrirLista = (Button) findViewById(R.id.menu);
		abrirLista.setText("N");
		abrirLista.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(ListarFuncionario.this, NovoFuncionario.class);
				startActivity(i);
				finish();
			}
		});
		
		criarListView();

	}

	private void criarListView() {
		FuncionarioDAO fDao = new FuncionarioDAO(ListarFuncionario.this);
		listaFuncionario = fDao.getAll();
		listaView = (ListView) findViewById(R.id.lista_cliente);

		funcionarioAdapter = new FuncionarioAdapter(listaFuncionario, ListarFuncionario.this);
		listaView.setAdapter(funcionarioAdapter);
	}

}
