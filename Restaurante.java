import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private String nome;
    private String endereco;
    private Categoria categoria;
    private List<Item> itensCardapio;

    public Restaurante(String nome, String endereco, Categoria categoria) {
        setNome(nome);
        setEndereco(endereco);
        this.categoria = categoria;
        this.itensCardapio = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome do restaurante não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if (endereco == null || endereco.isEmpty()) {
            throw new IllegalArgumentException("Endereço do restaurante não pode ser nulo ou vazio.");
        }
        this.endereco = endereco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Item> getItensCardapio() {
        return itensCardapio;
    }

    public void adicionarItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item não pode ser nulo.");
        }
        itensCardapio.add(item);
    }

    public void listarItens() {
        System.out.println("Cardápio de " + nome + ":");
        for (Item item : itensCardapio) {
            System.out.println("- " + item.getNome() + ": " + item.getPreco());
        }
    }

    @Override
    public String toString() {
        return "Restaurante: " + nome + " (Categoria: " + categoria.getNome() + ", Endereço: " + endereco + ")";
    }
}
