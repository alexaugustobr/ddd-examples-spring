package ddd.application.eventlisteners.pedidocasamento;

import ddd.application.eventlisteners.AbstractEventListener;
import ddd.application.eventlisteners.DomainEventListener;
import ddd.domain.pedidocasamento.command.PedidoCasamentoEnviarEmailCriacaoCommand;
import ddd.domain.pedidocasamento.command.PedidoCasamentoGerarFaturaCommand;
import ddd.domain.pedidocasamento.event.PedidoCasamentoCriadoEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class PedidoCasamentoEventListener extends AbstractEventListener {

    public PedidoCasamentoEventListener(ApplicationEventPublisher publisher) {
        super(publisher);
    }

    @DomainEventListener
    public void handle(PedidoCasamentoCriadoEvent event) {
        this.enviarComando(new PedidoCasamentoEnviarEmailCriacaoCommand(event));
        this.enviarComando(new PedidoCasamentoGerarFaturaCommand(event.getUsuario(), event.getPedidoId()));
    }

}
