public class Item {
    private String nome;
    private double preco;
    private Categoria categoria;

    public Item(String nome, double preco, Categoria categoria) {
        setNome(nome);
        setPreco(preco);
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome do item não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("Preço do item não pode ser negativo.");
        }
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        if (categoria == null) {
            throw new IllegalArgumentException("Categoria do item não pode ser nula.");
        }
        this.categoria = categoria;
    }

    public void adicionarAoPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não pode ser nulo.");
        }
        pedido.adicionarItem(this);
        System.out.println("Item adicionado ao pedido: " + nome);
    }

    @Override
    public String toString() {
        return "Item: " + nome + " (Preço: R$" + preco + ", Categoria: " + categoria.getNome() + ")";
    }
}
