package ddd.domain.pedidocasamento.command;

import ddd.domain.command.AbstractDomainCommand;

import java.util.UUID;

public class PedidoCasamentoCommnad extends AbstractDomainCommand {

    private UUID pedidoId;

    public PedidoCasamentoCommnad(UUID usuario, UUID pedidoId) {
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
