package br.com.agencia.model;

public class Pedido {
	
	private int idpedido;
	private String tipo_pagamento;
	private String cupom_desconto;
	private int promocao;
	
	public int getIdpedido() {
		return idpedido;
	}
	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}
	public String getTipo_pagamento() {
		return tipo_pagamento;
	}
	public void setTipo_pagamento(String tipo_pagamento) {
		this.tipo_pagamento = tipo_pagamento;
	}
	public String getCupom_desconto() {
		return cupom_desconto;
	}
	public void setCupom_desconto(String cupom_desconto) {
		this.cupom_desconto = cupom_desconto;
	}
	public int getPromocao() {
		return promocao;
	}
	public void setPromocao(int promocao) {
		this.promocao = promocao;
	}

	

}
