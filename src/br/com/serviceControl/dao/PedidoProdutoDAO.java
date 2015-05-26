package br.com.serviceControl.dao;

import android.content.Context;
import br.com.servicesControl.entity.PedidoProduto;

public class PedidoProdutoDAO extends GenericDAO<PedidoProduto> {

	public PedidoProdutoDAO(Context context) {
		super(context, PedidoProduto.class);
	}

}
