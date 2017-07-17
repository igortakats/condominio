package br.com.igita.condominio.conversores.DAO;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.igita.condominio.conversores.entities.TbMovimentacao;


public class TbMovimentacaoDAOImpl extends DAO<TbMovimentacao> implements TbMovimentacaoDAO {

	private static final long serialVersionUID = 7421434754206584676L;
	private Connection connection = null;
	
	
	public TbMovimentacaoDAOImpl() throws Exception {
		super();
		this.connection = super.getConnection();
	}
	
	public TbMovimentacao insert(TbMovimentacao tbTaxaCondominial) throws Exception {
		
		this.connection = super.getConnection();
		
		StringBuffer sql = new StringBuffer(); 
		
		sql.append("insert into tb_movimentacao values(");
		sql.append("?,?,?,?,?,?,?,?,?,?");
		sql.append(")");
		
		PreparedStatement stmt = connection.prepareStatement(sql.toString());
		
		stmt.setString(1, null);
		stmt.setInt(2, new Integer(0));
		stmt.setString(3, tbTaxaCondominial.getAnoReferencia());
		stmt.setString(4, tbTaxaCondominial.getMesReferencia());
		stmt.setDate(5, new Date(tbTaxaCondominial.getDataLancamento().getTimeInMillis()));
		stmt.setBigDecimal(6, tbTaxaCondominial.getValor());
		stmt.setString(7, tbTaxaCondominial.getTipoLancamento());
		stmt.setString(8, tbTaxaCondominial.getRegistroOrigem());
		stmt.setDate(9, new Date(tbTaxaCondominial.getDataInclusao().getTimeInMillis()));
		stmt.setDate(10, new Date(tbTaxaCondominial.getDataAlteracao().getTimeInMillis()));
		
		stmt.execute();

		stmt.close();
		
		return null;
	}

	public void closeConnection() throws SQLException {
		super.close();
	}
	
		
}
