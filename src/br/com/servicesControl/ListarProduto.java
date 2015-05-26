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
import br.com.serviceControl.dao.ProdutoDAO;
import br.com.servicesControl.entity.Cliente;
import br.com.servicesControl.entity.Produto;

public class ListarProduto extends Activity {

	private ProdutoAdapter produtosAdapter;
	private List<Produto> listaProdutos;
	private ListView listaView;
	private TextView titulo;
	private Button abrirLista;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.listar_produto);

		titulo = (TextView) findViewById(R.id.campo_titulo);
		titulo.setText("Produtos");
		abrirLista = (Button) findViewById(R.id.menu);
		abrirLista.setText("N");
		abrirLista.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(ListarProduto.this, NovoProduto.class);
				startActivity(i);
				finish();
			}
		});

		criarListView();

	}

	private void criarListView() {
		ProdutoDAO pDao = new ProdutoDAO(ListarProduto.this);
		listaProdutos = pDao.getAll();
		listaView = (ListView) findViewById(R.id.lista_produto);

		produtosAdapter = new ProdutoAdapter(listaProdutos, ListarProduto.this);
		listaView.setAdapter(produtosAdapter);
	}

}
