package br.com.serviceControl.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import br.com.servicesControl.entity.Pedido;

public class PedidoDAO extends GenericDAO<Pedido> {

	public PedidoDAO(Context context) {
		super(context, Pedido.class);
	}

	public List<Pedido> getAll() {
		List<Pedido> lista = new ArrayList<Pedido>();
		try {
			lista = dao.queryBuilder().orderBy("prioridade", false).query();
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao buscar todos");
		}
		return lista;
	}
}
