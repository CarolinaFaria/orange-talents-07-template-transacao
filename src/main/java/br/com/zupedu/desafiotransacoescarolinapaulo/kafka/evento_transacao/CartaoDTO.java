package br.com.zupedu.desafiotransacoescarolinapaulo.kafka.evento_transacao;

import br.com.zupedu.desafiotransacoescarolinapaulo.kafka.transacao_recebida.infos_transacao.Cartao;

public class CartaoDTO {

    private String id;
    private String email;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Cartao toCartao() {
        return new Cartao(id, email);
    }
}
