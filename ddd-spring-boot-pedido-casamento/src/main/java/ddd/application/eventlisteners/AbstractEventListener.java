package ddd.application.eventlisteners;


import ddd.domain.command.AbstractDomainCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;

public abstract class AbstractEventListener {

    private ApplicationEventPublisher publisher;

    private static final Logger log = LoggerFactory.getLogger(AbstractEventListener.class);

    public AbstractEventListener(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    protected void enviarComando(AbstractDomainCommand command) {
        this.publisher.publishEvent(command);
        log.info(new StringBuilder("Comando ").append(command.getClass().getSimpleName().toCharArray()).append(" publicado.").toString());
    }
}
