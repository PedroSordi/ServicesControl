package br.com.serviceControl.dao;

import android.content.Context;
import br.com.servicesControl.entity.Servico;

public class ServicoDAO extends GenericDAO<Servico> {

	public ServicoDAO(Context context) {
		super(context, Servico.class);
	}

}
