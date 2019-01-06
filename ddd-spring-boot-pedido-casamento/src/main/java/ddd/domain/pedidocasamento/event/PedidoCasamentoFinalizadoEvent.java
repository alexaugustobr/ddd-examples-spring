package ddd.domain.pedidocasamento.event;

import ddd.domain.event.AbstractDomainEvent;

import java.util.UUID;

public class PedidoCasamentoFinalizadoEvent extends PedidoCasamentoEvent {

    public PedidoCasamentoFinalizadoEvent(UUID usuario, UUID pedidoId) {
        super(usuario, pedidoId);
    }
}
