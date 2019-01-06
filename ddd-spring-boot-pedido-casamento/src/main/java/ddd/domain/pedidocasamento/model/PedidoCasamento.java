package ddd.domain.pedidocasamento.model;

import ddd.domain.DomainEntity;
import ddd.domain.pedidocasamento.command.PedidoCasamentoCriarCommand;
import ddd.domain.pedidocasamento.command.PedidoCasamentoFinalizarCommand;
import ddd.domain.pedidocasamento.command.PedidoCasamentoMarcarEmAndamentoCommand;
import ddd.domain.pedidocasamento.event.PedidoCasamentoFinalizadoEvent;
import ddd.domain.pedidocasamento.event.PedidoCasamentoMarcadoComoEmAndamentoEvent;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

@Entity
public class PedidoCasamento extends DomainEntity {

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Id
    private UUID id;

    private String nomeNoivo;

    private String nomeNoiva;

    private UUID usuarioCriacao;

    private UUID usuarioFinalizacao;

    @Enumerated
    private Status status;

    public PedidoCasamento() {
    }

    public PedidoCasamento(@Validated @NotNull PedidoCasamentoCriarCommand command) {
        this.nomeNoiva = command.getNomeNoiva();
        this.nomeNoivo = command.getNomeNoivo();
        this.status = Status.NOVO;
        this.usuarioCriacao = command.getUsuario();
    }

    public PedidoCasamento(UUID id, String nomeNoivo, String nomeNoiva, Status status) {
        this.id = id;
        this.nomeNoivo = nomeNoivo;
        this.nomeNoiva = nomeNoiva;
        this.status = status;
    }

    public static PedidoCasamento criar(@Validated @NotNull PedidoCasamentoCriarCommand command) {
        return new PedidoCasamento(command);
    }

    public PedidoCasamento finalizar(@Validated @NotNull PedidoCasamentoFinalizarCommand command) {
        this.usuarioFinalizacao = command.getUsuario();
        this.status = Status.FINALIZADO;
        publicarEvento(new PedidoCasamentoFinalizadoEvent(this.getUsuarioCriacao(), this.getId()));
        return this;
    }

    public PedidoCasamento marcarComoEmAndamento(@Validated @NotNull PedidoCasamentoMarcarEmAndamentoCommand command){
        this.status = Status.EM_ANDAMENTO;
        publicarEvento(new PedidoCasamentoMarcadoComoEmAndamentoEvent(command));
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNomeNoivo() {
        return nomeNoivo;
    }

    public void setNomeNoivo(String nomeNoivo) {
        this.nomeNoivo = nomeNoivo;
    }

    public String getNomeNoiva() {
        return nomeNoiva;
    }

    public void setNomeNoiva(String nomeNoiva) {
        this.nomeNoiva = nomeNoiva;
    }

    public UUID getUsuarioCriacao() {
        return usuarioCriacao;
    }

    public void setUsuarioCriacao(UUID usuarioCriacao) {
        this.usuarioCriacao = usuarioCriacao;
    }

    public UUID getUsuarioFinalizacao() {
        return usuarioFinalizacao;
    }

    public void setUsuarioFinalizacao(UUID usuarioFinalizacao) {
        this.usuarioFinalizacao = usuarioFinalizacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoCasamento that = (PedidoCasamento) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public enum Status {
        NOVO,EM_ANDAMENTO,FINALIZADO;
    }
}
