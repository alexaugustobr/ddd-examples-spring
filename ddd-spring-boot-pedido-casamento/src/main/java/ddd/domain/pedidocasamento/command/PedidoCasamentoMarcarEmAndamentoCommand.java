package ddd.domain.pedidocasamento.command;

import java.util.UUID;

public class PedidoCasamentoMarcarEmAndamentoCommand extends PedidoCasamentoCommnad {

    public PedidoCasamentoMarcarEmAndamentoCommand(UUID usuario, UUID pedidoId) {
        super(usuario, pedidoId);
    }
}
