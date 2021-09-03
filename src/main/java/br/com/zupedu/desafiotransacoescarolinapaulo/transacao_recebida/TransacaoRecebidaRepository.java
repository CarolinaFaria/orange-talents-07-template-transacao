package br.com.zupedu.desafiotransacoescarolinapaulo.transacao_recebida;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRecebidaRepository extends JpaRepository<TransacaoRecebida, String> {

    Page<TransacaoRecebida> findAllByCartaoApiId(String id, Pageable pageable);
}
