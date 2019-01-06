package ddd.application.commandprocessors.pedidocasamento;

import ddd.application.commandprocessors.AbstractEventCommandProcessor;
import ddd.application.commandprocessors.DomainCommandListener;
import ddd.domain.fatura.FaturaService;
import ddd.domain.pedidocasamento.command.PedidoCasamentoEnviarEmailCriacaoCommand;
import ddd.domain.pedidocasamento.command.PedidoCasamentoGerarFaturaCommand;
import ddd.infrastructure.email.pedidocasamento.PedidoCasamentoEmailSender;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class PedidoCasamentoCommandProcessor extends AbstractEventCommandProcessor {

    private PedidoCasamentoEmailSender pedidoCasamentoEmailSender;
    private FaturaService faturaService;

    public PedidoCasamentoCommandProcessor(ApplicationEventPublisher publisher, PedidoCasamentoEmailSender pedidoCasamentoEmailSender, FaturaService faturaService) {
        super(publisher);
        this.pedidoCasamentoEmailSender = pedidoCasamentoEmailSender;
        this.faturaService = faturaService;
    }

    @DomainCommandListener
    public void handle(PedidoCasamentoEnviarEmailCriacaoCommand command) {
        pedidoCasamentoEmailSender.enviarEmail(command);
    }

    @DomainCommandListener
    public void handle(PedidoCasamentoGerarFaturaCommand command) {
        faturaService.gerarFatura(command);
    }
}
