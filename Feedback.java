public class Feedback {
    private int idFeedback;
    private Pedido pedido;
    private Cliente cliente;
    private int avaliacao;
    private String comentario;

    public Feedback(int idFeedback, Pedido pedido, Cliente cliente, int avaliacao, String comentario) {
        this.idFeedback = idFeedback;
        setPedido(pedido);
        setCliente(cliente);
        setAvaliacao(avaliacao);
        setComentario(comentario);
    }

    public int getIdFeedback() {
        return idFeedback;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo.");
        }
        this.cliente = cliente;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        if (avaliacao < 1 || avaliacao > 5) {
            throw new IllegalArgumentException("A avaliação deve estar entre 1 e 5.");
        }
        this.avaliacao = avaliacao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        if (comentario == null || comentario.isEmpty()) {
            throw new IllegalArgumentException("Comentário não pode ser vazio.");
        }
        this.comentario = comentario;
    }

    public void deixarFeedback() {
        System.out.println("Feedback deixado com sucesso para o pedido ID " + pedido.getIdPedido() + ": Avaliação - " + avaliacao + ", Comentário - " + comentario);
    }
}
