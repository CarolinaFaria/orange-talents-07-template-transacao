package br.com.zupedu.desafiotransacoescarolinapaulo.consulta_compras;

import br.com.zupedu.desafiotransacoescarolinapaulo.transacao_recebida.infos_transacao.Cartao;

public class CartaoResponse {

    private String id;
    private String email;

    public CartaoResponse(Cartao cartao) {
        this.id = cartao.getApiId();
        this.email = cartao.getEmail();
    }

    public static CartaoResponse converte(Cartao cartao) {
        return new CartaoResponse(cartao);
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
