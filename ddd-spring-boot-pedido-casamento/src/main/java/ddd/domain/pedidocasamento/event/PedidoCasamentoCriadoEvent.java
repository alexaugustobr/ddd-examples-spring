package ddd.domain.pedidocasamento.event;

import ddd.domain.event.AbstractDomainEvent;

import java.util.UUID;

public class PedidoCasamentoCriadoEvent extends PedidoCasamentoEvent {

    public PedidoCasamentoCriadoEvent(UUID usuario, UUID pedidoId) {
        super(usuario, pedidoId);
    }
}
