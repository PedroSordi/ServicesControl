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
import br.com.serviceControl.dao.ProdutoDAO;
import br.com.servicesControl.entity.Produto;

public class NovoProduto extends Activity {
	private EditText campoNome;
	private EditText campoDescricao;
	private EditText campoMarca;
	private EditText campoValor;
	private EditText campoQuantidade;
	private Button cancelar;
	private Button salvar;
	private TextView titulo;
	private Button abrirLista;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.novo_produto);

		titulo = (TextView) findViewById(R.id.campo_titulo);
		titulo.setText("Novo Produto");

		abrirLista = (Button) findViewById(R.id.menu);
		abrirLista.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(NovoProduto.this, ListarProduto.class);
				startActivity(i);
				finish();
			}
		});

		campoNome = (EditText) findViewById(R.id.campo_nome);
		campoDescricao = (EditText) findViewById(R.id.campo_descricao);
		campoMarca = (EditText) findViewById(R.id.campo_marca);
		campoValor = (EditText) findViewById(R.id.campo_valor);
		campoQuantidade = (EditText) findViewById(R.id.campo_quantidade);
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
				String nome = campoNome.getText().toString();
				String descricao = campoDescricao.getText().toString();
				String marca = campoMarca.getText().toString();
				String valor = campoValor.getText().toString();
				String quantidade = campoQuantidade.getText().toString();

				if (nome.equals("") || descricao.equals("") || marca.equals("")
						|| valor.equals("") || quantidade.equals("")) {
					Toast.makeText(getApplicationContext(),
							"Preencha todos os campos!", Toast.LENGTH_SHORT)
							.show();
				} else {
					double val = Double.parseDouble(valor);
					int quant = Integer.parseInt(quantidade);

					Produto p = new Produto(nome, descricao, marca, val, quant);
					ProdutoDAO pDao = new ProdutoDAO(NovoProduto.this);
					pDao.insert(p);
					finish();
					Toast.makeText(getApplicationContext(),
							"Salvo com sucesso!", Toast.LENGTH_SHORT).show();
					Toast.makeText(getApplicationContext(),
							pDao.getAll().toString(), Toast.LENGTH_SHORT)
							.show();
				}

			}
		});

	}
}
