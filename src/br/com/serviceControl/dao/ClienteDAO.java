package br.com.serviceControl.dao;

import android.content.Context;
import br.com.servicesControl.entity.Cliente;

public class ClienteDAO extends GenericDAO<Cliente> {

	public ClienteDAO(Context context) {
		super(context, Cliente.class);
	}

}
