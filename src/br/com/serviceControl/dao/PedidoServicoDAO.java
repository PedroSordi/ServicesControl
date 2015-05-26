package br.com.serviceControl.dao;

import android.content.Context;
import br.com.servicesControl.entity.PedidoServico;

public class PedidoServicoDAO extends GenericDAO<PedidoServico> {

	public PedidoServicoDAO(Context context) {
		super(context, PedidoServico.class);
	}

}
