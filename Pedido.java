import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int idPedido;
    private Cliente cliente;
    private Restaurante restaurante;
    private List<Item> itens;
    private boolean status; // true = ativo, false = entregue

    public Pedido(int idPedido, Cliente cliente, Restaurante restaurante, List<Item> itensPedido, boolean par1) {
        this.idPedido = idPedido;
        setCliente(cliente);
        setRestaurante(restaurante);
        this.itens = new ArrayList<>();
        this.status = true; // Pedido começa como ativo
    }

    public int getIdPedido() {
        return idPedido;
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

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        if (restaurante == null) {
            throw new IllegalArgumentException("Restaurante não pode ser nulo.");
        }
        this.restaurante = restaurante;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void adicionarItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item não pode ser nulo.");
        }
        itens.add(item);
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    // Métodos para o entregador acessar os endereços
    public String getEnderecoCliente() {
        return cliente.getEndereco();
    }

    public String getEnderecoRestaurante() {
        return restaurante.getEndereco();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido ID: ").append(idPedido)
          .append("\nCliente: ").append(cliente.getNome())
          .append("\nRestaurante: ").append(restaurante.getNome())
          .append("\nStatus: ").append(status ? "Ativo" : "Entregue")
          .append("\nItens:\n");
        for (Item item : itens) {
            sb.append("- ").append(item.getNome()).append(": R$").append(item.getPreco()).append("\n");
        }
        return sb.toString();
    }

    boolean isStatus() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
