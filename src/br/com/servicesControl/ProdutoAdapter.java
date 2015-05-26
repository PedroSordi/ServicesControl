package br.com.servicesControl;

import java.io.Serializable;
import java.util.List;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import br.com.serviceControl.dao.ClienteDAO;
import br.com.serviceControl.dao.ProdutoDAO;
import br.com.servicesControl.entity.Cliente;
import br.com.servicesControl.entity.Produto;

public class ProdutoAdapter extends BaseAdapter implements Serializable {

	private static final long serialVersionUID = 1681578298865327151L;
	private List<Produto> listaProdutos;
	private LayoutInflater mInflater;
	private Context c;

	public ProdutoAdapter(List<Produto> listaProdutos, Context c) {
		this.listaProdutos = listaProdutos;
		this.c = c;
		mInflater = LayoutInflater.from(c);
	}

	@Override
	public int getCount() {
		return listaProdutos.size();
	}

	@Override
	public Object getItem(int position) {
		return listaProdutos.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, final View view, ViewGroup parent) {
		final Produto produto = listaProdutos.get(position);
		View v = mInflater.inflate(R.layout.item_produto, null);
		final ProdutoDAO produtoDao = new ProdutoDAO(c);

		TextView nome = (TextView) v.findViewById(R.id.produto_nome);
		nome.setText(produto.getNome());

		TextView quantidade = (TextView) v
				.findViewById(R.id.produto_quantidade);
		quantidade.setText(String.valueOf(produto.getQuantidade()));

		TextView preco = (TextView) v.findViewById(R.id.produto_preco);
		preco.setText("R$" + String.valueOf(produto.getValorCusto()));

		Button editar = (Button) v.findViewById(R.id.editar);
		editar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});

		Button deletar = (Button) v.findViewById(R.id.deletar);
		deletar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				produtoDao.delete(produto);
				listaProdutos.clear();
				listaProdutos = produtoDao.getAll();
				notifyDataSetChanged();
			}
		});

		return v;
	}
}
