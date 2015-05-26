package br.com.serviceControl.dao;

import android.content.Context;
import br.com.servicesControl.entity.Funcionario;

public class FuncionarioDAO extends GenericDAO<Funcionario> {

	public FuncionarioDAO(Context context) {
		super(context, Funcionario.class);
	}

}
