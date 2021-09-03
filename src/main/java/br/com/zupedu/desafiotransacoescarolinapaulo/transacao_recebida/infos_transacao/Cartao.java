package br.com.zupedu.desafiotransacoescarolinapaulo.transacao_recebida.infos_transacao;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "tb_cartao")
public class Cartao {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String apiId;
    private String email;

    @Deprecated
    public Cartao() {
    }

    public Cartao(String id, String email) {
        this.apiId = id;
        this.email = email;
    }

    public String getApiId() {
        return apiId;
    }

    public String getEmail() {
        return email;
    }
}
