package ddd.domain.pedidocasamento.command;

import ddd.domain.command.AbstractDomainCommand;
import ddd.domain.pedidocasamento.model.PedidoCasamento;

import java.util.UUID;

public class PedidoCasamentoFinalizarCommand  extends AbstractDomainCommand {

    private UUID pedidoId;

    public PedidoCasamentoFinalizarCommand(UUID usuario, UUID pedidoId) {
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


