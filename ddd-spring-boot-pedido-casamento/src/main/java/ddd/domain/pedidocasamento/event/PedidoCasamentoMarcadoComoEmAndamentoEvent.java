package ddd.domain.pedidocasamento.event;

import ddd.domain.pedidocasamento.command.PedidoCasamentoMarcarEmAndamentoCommand;

import java.util.UUID;

public class PedidoCasamentoMarcadoComoEmAndamentoEvent extends PedidoCasamentoEvent {



    public PedidoCasamentoMarcadoComoEmAndamentoEvent(UUID usuario, UUID pedidoId) {
        super(usuario, pedidoId);
    }

    public PedidoCasamentoMarcadoComoEmAndamentoEvent(PedidoCasamentoMarcarEmAndamentoCommand command) {
        super(command.getUsuario(), command.getPedidoId());
    }
}
