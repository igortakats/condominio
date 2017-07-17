package br.com.igita.condominio.conversores.service;

import java.sql.SQLException;

import br.com.igita.condominio.conversores.DAO.TbMovimentacaoDAO;
import br.com.igita.condominio.conversores.DAO.TbMovimentacaoDAOImpl;
import br.com.igita.condominio.conversores.entities.TbMovimentacao;

public class MovimentacaoServiceImpl implements MovimentacaoService {

	private static final long serialVersionUID = 8953559213228486343L;
	
	private TbMovimentacaoDAO dao;
	
	public MovimentacaoServiceImpl() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see br.com.igita.condominio.conversores.service.TaxaCondominialService#insert(br.com.igita.condominio.conversores.entities.TbTaxaCondominial)
	 */
	public TbMovimentacao insert(TbMovimentacao tbTaxaCondominial) throws Exception {
		
		dao = new TbMovimentacaoDAOImpl();
		
		dao.insert(tbTaxaCondominial);
		
		return tbTaxaCondominial;
	}
	
	public void closeDBConnection() throws SQLException {
		
		dao.closeConnection();
		
	}

}
