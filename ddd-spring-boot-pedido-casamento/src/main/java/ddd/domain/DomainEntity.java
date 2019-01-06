package ddd.domain;

import ddd.domain.event.AbstractDomainEvent;
import org.springframework.data.domain.AbstractAggregateRoot;

public class DomainEntity extends AbstractAggregateRoot {

    public AbstractDomainEvent publicarEvento(AbstractDomainEvent event) {
        return (AbstractDomainEvent) super.registerEvent(event);
    }
}
