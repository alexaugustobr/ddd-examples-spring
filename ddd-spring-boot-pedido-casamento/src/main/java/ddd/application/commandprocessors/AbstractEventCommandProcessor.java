package ddd.application.commandprocessors;


import ddd.domain.event.AbstractDomainEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;

public abstract class AbstractEventCommandProcessor {

    private ApplicationEventPublisher publisher;

    private static final Logger log = LoggerFactory.getLogger(AbstractEventCommandProcessor.class);

    public AbstractEventCommandProcessor(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    protected void publicarEvento(AbstractDomainEvent event) {
        this.publisher.publishEvent(event);
        log.info(new StringBuilder("Evento ").append(event.getClass().getSimpleName().toCharArray()).append(" publicado.").toString());
    }
}
