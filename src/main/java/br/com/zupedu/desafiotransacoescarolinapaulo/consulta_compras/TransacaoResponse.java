package br.com.zupedu.desafiotransacoescarolinapaulo.consulta_compras;

import br.com.zupedu.desafiotransacoescarolinapaulo.transacao_recebida.TransacaoRecebida;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponse {

    private String id;
    private BigDecimal valor;
    private EstabelecimentoResponse estabelecimento;
    private CartaoResponse cartao;
    private LocalDateTime efetivadaEm;

    @Deprecated
    public TransacaoResponse() {
    }

    public TransacaoResponse(TransacaoRecebida transacaoRecebida) {
        this.id = transacaoRecebida.getApiId();
        this.valor = transacaoRecebida.getValor();
        this.estabelecimento = EstabelecimentoResponse.converte(transacaoRecebida.getEstabelecimento());
        this.cartao = CartaoResponse.converte(transacaoRecebida.getCartao());
        this.efetivadaEm =transacaoRecebida.getEfetivadaEm();
    }

    public static Page<TransacaoResponse> toResponse(Page<TransacaoRecebida> transacaosPaginadas) {
        return transacaosPaginadas.map(TransacaoResponse::new);
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoResponse getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoResponse getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
