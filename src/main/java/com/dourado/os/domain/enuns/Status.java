package com.dourado.os.domain.enuns;

public enum Status {
	//Definindo a número desse ENUM, pois quando ira rodar não se perder ou mudar a ordem tipo 0 alta, 2 media
	ABERTO(0,"ABERTO"),ANDAMENTO(1,"ANDAMENTO"),ENCERRADO(2,"ENCERRADO");
	private Integer cod;
	private String descricao;

	private Status(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	} 
	//ele é static para não precisar instanciar outra prioridade para chamar esse metodo;
	//ele vai rodar a prioridade e vai verificar se existe um dos codigos que foi passado acima,se existe retorna a prioridade,caso não entrar no tratamento throw... 
	public static Status toEnum(Integer cod) {
	if(cod ==null) {
	return null;
	}
	for(Status x: Status.values()) {
	if(cod.equals(x.getCod())) {
		return x;
	}
	}
	throw new IllegalArgumentException("Status invalida!" + cod);
	}
}
