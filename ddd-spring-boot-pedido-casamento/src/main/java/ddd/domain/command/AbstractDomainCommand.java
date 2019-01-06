package ddd.domain.command;

import java.util.UUID;

public abstract class AbstractDomainCommand {

    private UUID usuario;

    public AbstractDomainCommand(UUID usuario) {
        this.usuario = usuario;
    }

    public UUID getUsuario() {
        return usuario;
    }

    public void setUsuario(UUID usuario) {
        this.usuario = usuario;
    }
}
