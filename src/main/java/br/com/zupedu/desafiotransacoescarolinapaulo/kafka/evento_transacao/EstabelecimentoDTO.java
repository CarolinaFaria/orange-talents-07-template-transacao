package br.com.zupedu.desafiotransacoescarolinapaulo.kafka.evento_transacao;

import br.com.zupedu.desafiotransacoescarolinapaulo.kafka.transacao_recebida.infos_transacao.Estabelecimento;

public class EstabelecimentoDTO {

    private String nome;
    private String cidade;
    private String endereco;

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public Estabelecimento toEstabelecimento() {
        return new Estabelecimento(nome, cidade, endereco);
    }
}
