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
import br.com.serviceControl.dao.ServicoDAO;
import br.com.servicesControl.entity.Cliente;
import br.com.servicesControl.entity.Servico;

public class ListarServicos extends Activity {

	private ServicoAdapter servicoAdapter;
	private List<Servico> listaServico;
	private ListView listaView;
	private TextView titulo;
	private Button abrirLista;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.listar_servico);
		
		titulo = (TextView) findViewById(R.id.campo_titulo);
		titulo.setText("Serviços");
		abrirLista = (Button) findViewById(R.id.menu);
		abrirLista.setText("N");
		abrirLista.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(ListarServicos.this, NovoServico.class);
				startActivity(i);
				finish();
			}
		});
		
		criarListView();

	}

	private void criarListView() {
		ServicoDAO sDao = new ServicoDAO(ListarServicos.this);
		listaServico = sDao.getAll();
		listaView = (ListView) findViewById(R.id.lista_servico);

		servicoAdapter = new ServicoAdapter(listaServico, ListarServicos.this);
		listaView.setAdapter(servicoAdapter);
	}

}
