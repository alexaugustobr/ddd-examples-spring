package ddd.domain.pedidocasamento.command;

import ddd.domain.pedidocasamento.event.PedidoCasamentoEvent;

import java.util.UUID;

public class PedidoCasamentoEnviarEmailCriacaoCommand extends PedidoCasamentoCommnad {

    public PedidoCasamentoEnviarEmailCriacaoCommand(PedidoCasamentoEvent event) {
        super(event.getUsuario(), event.getPedidoId());
    }

    public PedidoCasamentoEnviarEmailCriacaoCommand(UUID usuario, UUID pedidoId) {
        super(usuario, pedidoId);
    }
}
