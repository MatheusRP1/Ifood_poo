import java.time.LocalDateTime;
import java.util.Date;

public class Entrega {
    private int idEntrega;
    private Pedido pedido;
    private Entregador entregador;
    private Date dataEntrega;
    private boolean concluida;

    public Entrega(int idEntrega, Pedido pedido, Entregador entregador, LocalDateTime plusHours) {
        this.idEntrega = idEntrega;
        setPedido(pedido);
        setEntregador(entregador);
        this.dataEntrega = null; // Definida apenas ao concluir a entrega
        this.concluida = false;
    }

    public int getIdEntrega() {
        return idEntrega;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não pode ser nulo.");
        }
        this.pedido = pedido;
    }

    public Entregador getEntregador() {
        return entregador;
    }

    public void setEntregador(Entregador entregador) {
        if (entregador == null) {
            throw new IllegalArgumentException("Entregador não pode ser nulo.");
        }
        this.entregador = entregador;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void concluirEntrega() {
        if (!concluida) {
            this.dataEntrega = new Date();
            this.concluida = true;
            pedido.setStatus(false); // Marca o pedido como entregue
            System.out.println("Entrega concluída em " + dataEntrega);
        } else {
            System.out.println("A entrega já foi concluída.");
        }
    }

    public String getEnderecoCliente() {
        return pedido.getEnderecoCliente();
    }

    public String getEnderecoRestaurante() {
        return pedido.getEnderecoRestaurante();
    }
}
