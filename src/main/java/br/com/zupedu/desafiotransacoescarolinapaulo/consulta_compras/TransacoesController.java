package br.com.zupedu.desafiotransacoescarolinapaulo.consulta_compras;


import br.com.zupedu.desafiotransacoescarolinapaulo.transacao_recebida.TransacaoRecebida;
import br.com.zupedu.desafiotransacoescarolinapaulo.transacao_recebida.TransacaoRecebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/transacoes")
public class TransacoesController {

    @Autowired
    TransacaoRecebidaRepository transacaoRecebidaRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Page<TransacaoResponse>> consultaTransacoes(@PathVariable String id,
                                                                      @PageableDefault(sort = "efetivadaEm",
                                                                              direction = Sort.Direction.ASC,
                                                                              page = 0, size = 10) Pageable pageable){

        Page<TransacaoRecebida> transacaosPaginadas = transacaoRecebidaRepository.findAllByCartaoApiId(id,pageable);

        if(transacaosPaginadas.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Page<TransacaoResponse> response =  TransacaoResponse.toResponse(transacaosPaginadas);

        return ResponseEntity.ok(response);
    }


}
