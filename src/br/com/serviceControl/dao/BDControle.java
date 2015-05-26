package br.com.serviceControl.dao;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import br.com.servicesControl.entity.Cliente;
import br.com.servicesControl.entity.Funcionario;
import br.com.servicesControl.entity.Pedido;
import br.com.servicesControl.entity.PedidoProduto;
import br.com.servicesControl.entity.PedidoServico;
import br.com.servicesControl.entity.Produto;
import br.com.servicesControl.entity.Servico;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class BDControle<E> extends OrmLiteSqliteOpenHelper {
	private static final String NOME_BD = "servicecontroler.db";
	private static int VERSAO_BD = 2;

	public BDControle(Context context) {
		super(context, NOME_BD, null, VERSAO_BD);
	}

	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource src) {
		try {
			TableUtils.createTable(src, Cliente.class);
			TableUtils.createTable(src, Funcionario.class);
			TableUtils.createTable(src, Pedido.class);
			TableUtils.createTable(src, Produto.class);
			TableUtils.createTable(src, Servico.class);
			TableUtils.createTable(src, PedidoProduto.class);
			TableUtils.createTable(src, PedidoServico.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource src,
			int oldVersion, int newVersion) {
		try {
			TableUtils.dropTable(src, PedidoServico.class, true);
			TableUtils.dropTable(src, Servico.class, true);
			TableUtils.dropTable(src, PedidoProduto.class, true);
			TableUtils.dropTable(src, Produto.class, true);
			TableUtils.dropTable(src, Pedido.class, true);
			TableUtils.dropTable(src, Funcionario.class, true);
			TableUtils.dropTable(src, Cliente.class, true);

			onCreate(db, src);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close() {
		super.close();
	}

}
