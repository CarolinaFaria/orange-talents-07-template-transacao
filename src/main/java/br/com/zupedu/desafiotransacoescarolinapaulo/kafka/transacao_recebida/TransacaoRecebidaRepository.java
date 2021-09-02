package br.com.zupedu.desafiotransacoescarolinapaulo.kafka.transacao_recebida;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransacaoRecebidaRepository extends JpaRepository<TransacaoRecebida, UUID> {

}
