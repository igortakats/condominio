package br.com.igita.condominio.conversores.service;

import java.io.Serializable;
import java.sql.SQLException;

import br.com.igita.condominio.conversores.entities.TbMovimentacao;

public interface MovimentacaoService extends Serializable{

	public abstract TbMovimentacao insert(TbMovimentacao tbTaxaCondominial) throws Exception;
	
	public void closeDBConnection() throws SQLException;

}