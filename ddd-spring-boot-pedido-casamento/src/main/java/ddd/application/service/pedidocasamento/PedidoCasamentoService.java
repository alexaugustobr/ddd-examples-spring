package ddd.application.service.pedidocasamento;

import ddd.application.service.AbstractDomainService;
import ddd.domain.pedidocasamento.command.PedidoCasamentoCriarCommand;
import ddd.domain.pedidocasamento.command.PedidoCasamentoFinalizarCommand;
import ddd.domain.pedidocasamento.command.PedidoCasamentoMarcarEmAndamentoCommand;
import ddd.domain.pedidocasamento.event.PedidoCasamentoCriadoEvent;
import ddd.domain.pedidocasamento.event.PedidoCasamentoMarcadoComoEmAndamentoEvent;
import ddd.domain.pedidocasamento.model.PedidoCasamento;
import ddd.infrastructure.repository.pedidocasamento.dao.PedidoCasamentoRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Service
public class PedidoCasamentoService extends AbstractDomainService {

    private PedidoCasamentoRepository repository;

    public PedidoCasamentoService(ApplicationEventPublisher publisher, PedidoCasamentoRepository repository) {
        super(publisher);
        this.repository = repository;
    }

    @Transactional
    public UUID criarNovoPedido(@NotNull PedidoCasamentoCriarCommand command) {
        UUID id = repository.save(PedidoCasamento.criar(command)).getId();
        publicarEvento(new PedidoCasamentoCriadoEvent(command.getUsuario(), id));
        return id;
    }

    @Transactional
    public void marcarComoEmAndamento(@NotNull PedidoCasamentoMarcarEmAndamentoCommand command) {
        if (!repository.existsById(command.getPedidoId())) {
            throw new RuntimeException();
        }
        repository.aletarStatusPara(command.getPedidoId(), command.getUsuario(), PedidoCasamento.Status.EM_ANDAMENTO);
        publicarEvento(new PedidoCasamentoMarcadoComoEmAndamentoEvent(command.getUsuario(), command.getPedidoId()));
    }

    @Transactional
    public void marcarPedidoComoFinalizado(@NotNull PedidoCasamentoFinalizarCommand command) {
        PedidoCasamento pedidoCasamento = repository.findById(command.getPedidoId()).orElseThrow(RuntimeException::new);
        repository.save(pedidoCasamento.finalizar(command));
    }

}

