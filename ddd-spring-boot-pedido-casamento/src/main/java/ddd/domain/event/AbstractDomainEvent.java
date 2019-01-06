package ddd.domain.event;

import java.util.UUID;

public abstract class AbstractDomainEvent {

    private UUID usuario;

    public AbstractDomainEvent(UUID usuario) {
        this.usuario = usuario;
    }

    public UUID getUsuario() {
        return usuario;
    }

    public void setUsuario(UUID usuario) {
        this.usuario = usuario;
    }

}
