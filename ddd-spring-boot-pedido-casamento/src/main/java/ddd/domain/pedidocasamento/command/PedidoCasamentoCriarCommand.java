package ddd.domain.pedidocasamento.command;

import ddd.domain.command.AbstractDomainCommand;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class PedidoCasamentoCriarCommand extends AbstractDomainCommand {

    @NotBlank
    private String nomeNoivo;
    @NotBlank
    private String nomeNoiva;

    public PedidoCasamentoCriarCommand(UUID usuarioExecucaoComando, @NotBlank String nomeNoivo, @NotBlank String nomeNoiva) {
        super(usuarioExecucaoComando);
        this.nomeNoivo = nomeNoivo;
        this.nomeNoiva = nomeNoiva;
    }

    public String getNomeNoivo() {
        return nomeNoivo;
    }

    public void setNomeNoivo(String nomeNoivo) {
        this.nomeNoivo = nomeNoivo;
    }

    public String getNomeNoiva() {
        return nomeNoiva;
    }

    public void setNomeNoiva(String nomeNoiva) {
        this.nomeNoiva = nomeNoiva;
    }
}
