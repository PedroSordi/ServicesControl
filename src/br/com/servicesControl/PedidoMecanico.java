package br.com.servicesControl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import br.com.serviceControl.dao.PedidoDAO;
import br.com.serviceControl.dao.ProdutoDAO;
import br.com.serviceControl.dao.ServicoDAO;
import br.com.servicesControl.entity.Pedido;
import br.com.servicesControl.entity.PedidoProduto;
import br.com.servicesControl.entity.PedidoServico;
import br.com.servicesControl.entity.Produto;
import br.com.servicesControl.entity.Servico;

public class PedidoMecanico extends Activity {
	private Button BotaoServico;
	private Button BotaoProduto;
	private Button botaoOk;
	private TextView titulo;
	private TextView dataInicio;
	private TextView cliente;
	private TextView placa;
	private TextView descricao;
	private EditText quantidadePop;
	private Spinner spinner;
	private Produto produtoSelecionado;
	private Servico servicoSelecionado;
	private TextView listagem;
	private List<Produto> listaProdutos;
	private List<Servico> listaServicos;

	private List<PedidoProduto> pedidoProdutos;
	private List<PedidoServico> pedidoServicos;
	PedidoServico pedidoServico;
	PedidoProduto pedidoProduto;

	private Button botaoFinalizar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.pedido_mecanico);

		titulo = (TextView) findViewById(R.id.campo_titulo);
		titulo.setText("Pedido");
		findViewById(R.id.menu).setVisibility(View.INVISIBLE);

		dataInicio = (TextView) findViewById(R.id.data_inicio);
		cliente = (TextView) findViewById(R.id.cliente);
		placa = (TextView) findViewById(R.id.placa);
		descricao = (TextView) findViewById(R.id.descricao);
		BotaoServico = (Button) findViewById(R.id.adicionar_servico);
		BotaoProduto = (Button) findViewById(R.id.adicionar_produto);
		botaoFinalizar = (Button) findViewById(R.id.finalizar_pedido);
		listagem = (TextView) findViewById(R.id.listagem);

		Pedido pedido = (Pedido) getIntent().getExtras().get("pedido");
		String dataFormatada = new SimpleDateFormat("dd/MM/yy HH:mm:ss")
				.format(pedido.getDataInicio());
		dataInicio.setText(dataFormatada.toString());
		cliente.setText(pedido.getCliente().toString());
		placa.setText(pedido.getPlaca());
		descricao.setText(pedido.getDescricao());

		listaProdutos = new ArrayList<Produto>();
		ProdutoDAO pDao = new ProdutoDAO(getApplicationContext());
		listaProdutos = pDao.getAll();

		listaServicos = new ArrayList<Servico>();
		ServicoDAO sDao = new ServicoDAO(getApplicationContext());
		listaServicos = sDao.getAll();

		pedidoServicos = new ArrayList<PedidoServico>();
		pedidoProdutos = new ArrayList<PedidoProduto>();

		BotaoServico.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				criarPopUpServico();
			}
		});

		BotaoProduto.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				criarPopUpProduto();
			}
		});

		botaoFinalizar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});

	}

	private void criarPopUpServico() {
		final Dialog popupServico = new Dialog(PedidoMecanico.this);
		popupServico.setContentView(R.layout.popup_servico);
		popupServico.setCancelable(true);
		popupServico.setTitle("Selecione o serviço");
		popupServico.show();

		ServicoDAO sDao = new ServicoDAO(getApplicationContext());

		spinner = (Spinner) popupServico.findViewById(R.id.servicos_spinner);
		ArrayAdapter<Servico> dataAdapter = new ArrayAdapter<Servico>(this,
				android.R.layout.simple_spinner_item, listaServicos);

		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		spinner.setAdapter(dataAdapter);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {

				servicoSelecionado = (Servico) spinner.getSelectedItem();

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});

		botaoOk = (Button) popupServico.findViewById(R.id.botao_ok);
		botaoOk.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (listaServicos.size() > 0) {
					listagem.setText(listagem.getText() + "\n" + "Serviço: "
							+ servicoSelecionado.getNome());
					listaServicos.remove(servicoSelecionado);
					pedidoServico = new PedidoServico();
					pedidoServico.setServico(servicoSelecionado);
					pedidoServicos.add(pedidoServico);
				}
				popupServico.dismiss();
			}

		});
	}

	private void criarPopUpProduto() {
		final Dialog popupProduto = new Dialog(PedidoMecanico.this);
		popupProduto.setContentView(R.layout.popup_produto);
		popupProduto.setCancelable(true);
		popupProduto.setTitle("Selecione o produto");
		popupProduto.show();

		spinner = (Spinner) popupProduto.findViewById(R.id.produtos_spinner);
		ArrayAdapter<Produto> dataAdapter = new ArrayAdapter<Produto>(this,
				android.R.layout.simple_spinner_item, listaProdutos);

		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		spinner.setAdapter(dataAdapter);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {

				produtoSelecionado = (Produto) spinner.getSelectedItem();
				quantidadePop = (EditText) popupProduto
						.findViewById(R.id.quantidade);
				quantidadePop.setText(String.valueOf(produtoSelecionado
						.getQuantidade()));

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});

		botaoOk = (Button) popupProduto.findViewById(R.id.botao_ok);
		botaoOk.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (listaProdutos.size() > 0) {
					if (produtoSelecionado.getQuantidade() >= Integer
							.parseInt(quantidadePop.getText().toString())) {
						popupProduto.dismiss();

						listagem.setText(listagem.getText()
								+ "\n"
								+ String.valueOf("Produto: "
										+ produtoSelecionado.getNome()
										+ " Quant: "
										+ quantidadePop.getText().toString()));
						listaProdutos.remove(produtoSelecionado);

						pedidoProduto = new PedidoProduto();
						pedidoProduto.setProduto(produtoSelecionado);
						pedidoProduto.setQuantidade(Integer
								.parseInt(quantidadePop.getText().toString()));
						pedidoProdutos.add(pedidoProduto);
					} else {
						Toast.makeText(
								getApplicationContext(),
								"Qauntidade informada é maior que a em estoque!",
								Toast.LENGTH_LONG).show();
					}

				} else {
					popupProduto.dismiss();
				}
			}
		});

	}
}
