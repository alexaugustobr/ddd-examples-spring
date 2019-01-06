package ddd.domain.fatura;

import ddd.domain.pedidocasamento.command.PedidoCasamentoGerarFaturaCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FaturaService {

    private static final Logger log = LoggerFactory.getLogger(FaturaService.class);

    public FaturaService() {

    }

    public void gerarFatura(PedidoCasamentoGerarFaturaCommand command) {
        log.info(new StringBuilder("Gerado fatura ").append(command.getClass().getSimpleName().toCharArray()).append(" enviado para o pedido ").append(command.getPedidoId()).toString());
    }

}
