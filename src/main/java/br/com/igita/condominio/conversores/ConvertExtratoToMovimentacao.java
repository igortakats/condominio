package br.com.igita.condominio.conversores;

import java.math.BigDecimal;
import java.util.Calendar;

import org.apache.log4j.Logger;

import br.com.igita.condominio.conversores.entities.TbMovimentacao;
import br.com.igita.condominio.conversores.service.MovimentacaoService;
import br.com.igita.condominio.conversores.service.MovimentacaoServiceImpl;

public class ConvertExtratoToMovimentacao implements IConverterExtrato {
	
	private static String KEY_TO_PROCESS = "Condominio";
	
	private MovimentacaoService movimentacaoService;
	
	Logger logger = Logger.getLogger(ConvertExtratoToMovimentacao.class);
	
	/* (non-Javadoc)
	 * @see br.com.igita.condominio.conversores.IConverterExtrato#process(java.lang.String)
	 */
	public final String  process(String record) throws Exception {
		
		BigDecimal valRef = new BigDecimal(235.00D);
		
		if (record == null) {
			System.out.println("Registro nulo invalido.");
			return record;
		}
		
		if (!record.contains(KEY_TO_PROCESS)) {
			logger.debug("Registro sem " + KEY_TO_PROCESS + ": " + record);
			return record;
		}
		
		if (record.trim().length() < 25) {
			logger.debug("Registro de tamanho invalido: " + record);
			return record;
		}

		TbMovimentacao tbMovimentacao = new TbMovimentacao();
		Calendar dataAtual = Calendar.getInstance();
		
		
		int indexStart = KEY_TO_PROCESS.length() + 1;
		int indexEnd = indexStart + 9;
		
		String[] mesAno = (record.substring(indexStart, indexEnd)).split("/");
		
		tbMovimentacao.setMesReferencia(mesAno[0]);
		tbMovimentacao.setAnoReferencia(mesAno[1]);
		
		indexStart = indexEnd + 1;
		
		BigDecimal valor = null;
		
		try {
			String v = (record.substring(indexStart).trim()).replace(",", ".");
			valor = new BigDecimal(v);
		} catch (Exception e) {
			logger.error("Nao foi possivel converter o valor "+record.substring(indexStart).trim()+" para BigDecimal");
			logger.error("Registro: " + record);
			return null;
		}

		if (valor.doubleValue() < valRef.doubleValue()) return null;
		
		movimentacaoService = new MovimentacaoServiceImpl();
		
		tbMovimentacao.setValor(valor);
		tbMovimentacao.setDataAlteracao(dataAtual);
		tbMovimentacao.setDataInclusao(dataAtual);
		tbMovimentacao.setDataLancamento(dataAtual);
		tbMovimentacao.setRegistroOrigem(record);
		tbMovimentacao.setTipoLancamento("TAXA_CONDOMINIAL");
		tbMovimentacao.setUnidadeResidencial(new String());
		
		movimentacaoService.insert(tbMovimentacao);
		
		return null;
	}

}
