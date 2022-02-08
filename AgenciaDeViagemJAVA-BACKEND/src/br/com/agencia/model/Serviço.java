package br.com.agencia.model;

import java.util.Date;

public class Serviço {
	
	private int idservico;
	private String pais;
	private String cidade;
	private Date data_ida;
	private Date data_volta;
	private int qtd_passageiros;
	private int preco;
	
	public int getIdservico() {
		return idservico;
	}
	public void setIdservico(int idservico) {
		this.idservico = idservico;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public Date getData_ida() {
		return data_ida;
	}
	public void setData_ida(Date data_ida) {
		this.data_ida = data_ida;
	}
	public Date getData_volta() {
		return data_volta;
	}
	public void setData_volta(Date data_volta) {
		this.data_volta = data_volta;
	}
	public int getQtd_passageiros() {
		return qtd_passageiros;
	}
	public void setQtd_passageiros(int qtd_passageiros) {
		this.qtd_passageiros = qtd_passageiros;
	}
	public int getPreco() {
		return preco;
	}
	public void setPreco(int preco) {
		this.preco = preco;
	}
}
