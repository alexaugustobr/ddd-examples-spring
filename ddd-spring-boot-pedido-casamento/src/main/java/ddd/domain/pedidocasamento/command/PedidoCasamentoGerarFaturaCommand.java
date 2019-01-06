package ddd.domain.pedidocasamento.command;

import java.util.UUID;

public class PedidoCasamentoGerarFaturaCommand extends PedidoCasamentoCommnad {

    public PedidoCasamentoGerarFaturaCommand(UUID usuario, UUID pedidoId) {
        super(usuario, pedidoId);
    }
}
