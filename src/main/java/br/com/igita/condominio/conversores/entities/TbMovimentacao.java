package br.com.igita.condominio.conversores.entities;

import java.math.BigDecimal;
import java.util.Calendar;

public class TbMovimentacao {

	private String id;
	
	private String unidadeResidencial;
	
	private String anoReferencia;
	
	private String mesReferencia;
	
	private Calendar dataLancamento;
	
	private BigDecimal valor;
	
	private String tipoLancamento;
	
	private String registroOrigem;
	
	private Calendar dataInclusao;
	
	private Calendar dataAlteracao;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUnidadeResidencial() {
		return unidadeResidencial;
	}

	public void setUnidadeResidencial(String unidadeResidencial) {
		this.unidadeResidencial = unidadeResidencial;
	}



	public String getAnoReferencia() {
		return anoReferencia;
	}

	public void setAnoReferencia(String anoReferencia) {
		this.anoReferencia = anoReferencia;
	}

	public String getMesReferencia() {
		return mesReferencia;
	}

	public void setMesReferencia(String mesReferencia) {
		this.mesReferencia = mesReferencia;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(String tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

	public String getRegistroOrigem() {
		return registroOrigem;
	}

	public void setRegistroOrigem(String registroOrigem) {
		this.registroOrigem = registroOrigem;
	}

	public Calendar getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Calendar dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Calendar getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Calendar dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
	
}
