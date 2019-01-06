package ddd.infrastructure.email.pedidocasamento;

import ddd.application.service.pedidocasamento.PedidoCasamentoService;
import ddd.domain.pedidocasamento.command.PedidoCasamentoEnviarEmailCriacaoCommand;
import ddd.infrastructure.repository.pedidocasamento.dao.PedidoCasamentoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PedidoCasamentoEmailSender extends AbstractDomainEmailSender {

    private PedidoCasamentoRepository pedidoCasamentoRepository;
    private final Logger log = LoggerFactory.getLogger(PedidoCasamentoService.class);

    public PedidoCasamentoEmailSender(PedidoCasamentoRepository pedidoCasamentoRepository) {
        this.pedidoCasamentoRepository = pedidoCasamentoRepository;
    }

    public void enviarEmail(PedidoCasamentoEnviarEmailCriacaoCommand command) {
        log.info(new StringBuilder("Email ").append(command.getClass().getSimpleName().toCharArray()).append(" enviado para o pedido ").append(command.getPedidoId()).toString());
    }
}
