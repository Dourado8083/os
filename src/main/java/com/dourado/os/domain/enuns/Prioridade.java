package com.dourado.os.domain.enuns;

public enum Prioridade {
//Definindo a número desse ENUM, pois quando ira rodar não se perder ou mudar a ordem tipo 0 alta, 2 media
BAIXA(0,"BAIXA"),MEDIA(1,"MEDIA"),ALTA(2,"ALTA");
private Integer cod;
private String descricao;

private Prioridade(Integer cod, String descricao) {
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
public static Prioridade toEnum(Integer cod) {
if(cod ==null) {
return null;
}
for(Prioridade x: Prioridade.values()) {
if(cod.equals(x.getCod())) {
	return x;
}
}
throw new IllegalArgumentException("Prioridade invalida!" + cod);
}
}
