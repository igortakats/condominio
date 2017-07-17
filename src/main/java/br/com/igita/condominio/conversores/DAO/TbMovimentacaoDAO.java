package br.com.igita.condominio.conversores.DAO;

import java.io.Serializable;
import java.sql.SQLException;

import br.com.igita.condominio.conversores.entities.TbMovimentacao;

public interface TbMovimentacaoDAO extends Serializable {
	
	public abstract TbMovimentacao insert(TbMovimentacao tbTaxaCondominial) throws Exception;
	
	public abstract void closeConnection() throws SQLException;
	

}
