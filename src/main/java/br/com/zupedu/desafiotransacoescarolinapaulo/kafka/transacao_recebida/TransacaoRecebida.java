package br.com.zupedu.desafiotransacoescarolinapaulo.kafka.transacao_recebida;

import br.com.zupedu.desafiotransacoescarolinapaulo.kafka.transacao_recebida.infos_transacao.Cartao;
import br.com.zupedu.desafiotransacoescarolinapaulo.kafka.transacao_recebida.infos_transacao.Estabelecimento;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_transacao")
public class TransacaoRecebida {

        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        private UUID id;

        private String apiId;

        private BigDecimal valor;

        @Embedded
        private Estabelecimento estabelecimento;

        @ManyToOne(cascade = CascadeType.PERSIST)
        private Cartao cartao;

        private LocalDateTime efetivadaEm;

        @Deprecated
        public TransacaoRecebida() {
        }

        public TransacaoRecebida(String apiId, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao, LocalDateTime efetivadaEm) {
                this.apiId = apiId;
                this.valor = valor;
                this.estabelecimento = estabelecimento;
                this.cartao = cartao;
                this.efetivadaEm = efetivadaEm;
        }
}
