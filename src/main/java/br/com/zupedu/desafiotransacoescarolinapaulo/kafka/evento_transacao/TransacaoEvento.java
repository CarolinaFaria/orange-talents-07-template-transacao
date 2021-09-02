package br.com.zupedu.desafiotransacoescarolinapaulo.kafka.evento_transacao;

import br.com.zupedu.desafiotransacoescarolinapaulo.kafka.transacao_recebida.TransacaoRecebida;
import br.com.zupedu.desafiotransacoescarolinapaulo.kafka.transacao_recebida.infos_transacao.Cartao;
import br.com.zupedu.desafiotransacoescarolinapaulo.kafka.transacao_recebida.infos_transacao.Estabelecimento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoEvento {

    private String id;
    private BigDecimal valor;
    private EstabelecimentoDTO estabelecimento;
    private CartaoDTO cartao;
    private String efetivadaEm;

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoDTO getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoDTO getCartao() {
        return cartao;
    }

    public String getEfetivadaEm() {
        return efetivadaEm;
    }

    @Deprecated
    public TransacaoEvento() {
    }

    public TransacaoRecebida toTransacao() {
        Estabelecimento estabelecimento = this.estabelecimento.toEstabelecimento();
        Cartao cartao = this.cartao.toCartao();
        return new TransacaoRecebida(id, valor, estabelecimento, cartao, LocalDateTime.parse(efetivadaEm));
    }
}
