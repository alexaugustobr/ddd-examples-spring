package ddd;

import ddd.application.service.pedidocasamento.PedidoCasamentoService;
import ddd.domain.pedidocasamento.command.PedidoCasamentoCriarCommand;
import ddd.domain.pedidocasamento.command.PedidoCasamentoMarcarEmAndamentoCommand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DddApplicationTests {

	@Autowired
	private PedidoCasamentoService pedidoCasamentoService;

	@Test
	public void criarPedidoCasamento() {

		UUID usuarioId = UUID.randomUUID();

		UUID pedidoUUID = pedidoCasamentoService.criarNovoPedido(new PedidoCasamentoCriarCommand(usuarioId, "noivo", "noiva"));

		Assert.notNull("uuid", "uuid esta nulo");

		pedidoCasamentoService.marcarComoEmAndamento(new PedidoCasamentoMarcarEmAndamentoCommand(usuarioId,pedidoUUID));

		Assert.notNull("uuid", "uuid esta nulo");
	}

}

