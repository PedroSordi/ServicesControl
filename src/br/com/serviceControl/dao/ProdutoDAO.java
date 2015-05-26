package br.com.serviceControl.dao;

import android.content.Context;
import br.com.servicesControl.entity.Produto;

public class ProdutoDAO extends GenericDAO<Produto> {

	public ProdutoDAO(Context context) {
		super(context, Produto.class);
	}

}
