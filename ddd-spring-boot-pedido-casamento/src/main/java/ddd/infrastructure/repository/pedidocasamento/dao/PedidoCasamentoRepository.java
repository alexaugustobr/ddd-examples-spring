package ddd.infrastructure.repository.pedidocasamento.dao;

import ddd.domain.pedidocasamento.model.PedidoCasamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.UUID;

public interface PedidoCasamentoRepository extends JpaRepository<PedidoCasamento, UUID> {
    @Modifying
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    @Query(value = "UPDATE PEDIDO_CASAMENTO SET USUARIO = :usuario, STATUS = :status WHERE ID = :pedidoId ", nativeQuery = true)
    void aletarStatusPara(@Param("pedidoId") UUID pedidoId, @Param("usuario") UUID usuario, @Param("status") PedidoCasamento.Status status);
}
