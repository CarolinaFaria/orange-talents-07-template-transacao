package br.com.zupedu.desafiotransacoescarolinapaulo.consulta_compras;

import br.com.zupedu.desafiotransacoescarolinapaulo.transacao_recebida.infos_transacao.Estabelecimento;

public class EstabelecimentoResponse {

    private String nome;
    private String cidade;
    private String endereco;

    @Deprecated
    public EstabelecimentoResponse() {
    }

    public EstabelecimentoResponse(Estabelecimento estabelecimento) {
        this.nome = estabelecimento.getNome();
        this.cidade = estabelecimento.getCidade();
        this.endereco = estabelecimento.getEndereco();
    }

    public static EstabelecimentoResponse converte(Estabelecimento estabelecimento) {
        return new EstabelecimentoResponse(estabelecimento);
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }
}
