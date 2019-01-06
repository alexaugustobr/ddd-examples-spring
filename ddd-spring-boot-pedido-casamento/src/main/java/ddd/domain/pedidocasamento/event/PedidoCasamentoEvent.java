package ddd.domain.pedidocasamento.event;

import ddd.domain.event.AbstractDomainEvent;

import java.util.UUID;

public abstract class PedidoCasamentoEvent extends AbstractDomainEvent {

    private UUID pedidoId;

    public PedidoCasamentoEvent(UUID usuario, UUID pedidoId) {
        super(usuario);
        this.pedidoId = pedidoId;
    }

    public UUID getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(UUID pedidoId) {
        this.pedidoId = pedidoId;
    }
}
