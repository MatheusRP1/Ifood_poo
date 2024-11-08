import java.time.LocalDateTime; 
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
    private int id;
    private String email;
    private LocalDateTime dataCadastro;
    private LocalDateTime ultimaAtividade;
    private List<Pedido> historicoPedidos;

    public Cliente(int id, String nome, String endereco, String email, int telefone) {
        super(nome, endereco, telefone);
        this.id = id;
        setEmail(email);
        this.dataCadastro = LocalDateTime.now();
        this.ultimaAtividade = LocalDateTime.now();
        this.historicoPedidos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.isEmpty() || !email.contains("@")) {
            throw new IllegalArgumentException("E-mail inválido.");
        }
        this.email = email;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public LocalDateTime getUltimaAtividade() {
        return ultimaAtividade;
    }

    public List<Pedido> getHistoricoPedidos() {
        return historicoPedidos;
    }

    public void adicionarPedido(Pedido pedido) {
        historicoPedidos.add(pedido);
        this.ultimaAtividade = LocalDateTime.now();
    }

    public void fazerPedido(Pedido pedido) {
        adicionarPedido(pedido);
        System.out.println("Pedido realizado com sucesso!");
    }

    @Override
    public String toString() {
        return "Cliente: " + getNome() + " (ID: " + id + ", E-mail: " + email + ")";
    }
}
