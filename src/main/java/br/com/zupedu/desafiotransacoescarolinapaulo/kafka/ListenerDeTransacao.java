package br.com.zupedu.desafiotransacoescarolinapaulo.kafka;

import br.com.zupedu.desafiotransacoescarolinapaulo.kafka.evento_transacao.TransacaoEvento;
import br.com.zupedu.desafiotransacoescarolinapaulo.transacao_recebida.TransacaoRecebida;
import br.com.zupedu.desafiotransacoescarolinapaulo.transacao_recebida.TransacaoRecebidaRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {

    private final TransacaoRecebidaRepository transacaoRepository;

    public ListenerDeTransacao(TransacaoRecebidaRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoEvento transacaoEvento) {
        TransacaoRecebida transacao = transacaoEvento.toTransacao();
        transacaoRepository.save(transacao);
        System.out.println(transacao);
    }

}
