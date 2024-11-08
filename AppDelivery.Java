import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AppDelivery {

    public static void main(String[] args) {
        
        // Criando uma categoria
        Categoria categoriaComida = new Categoria("Comida");

        // Criando um restaurante
        Restaurante restaurante = new Restaurante("Restaurante Central", "Rua das Flores, 123", categoriaComida);

        // Criando itens
        Item item1 = new Item("Pizza", 40.00, categoriaComida);
        Item item2 = new Item("Hambúrguer", 25.00, categoriaComida);

        // Adicionando itens a uma lista para o pedido
        List<Item> itensPedido = new ArrayList<>();
        itensPedido.add(item1);
        itensPedido.add(item2);

        // Criando um cliente
        Cliente cliente = new Cliente(1, "João Silva", "Rua das Palmeiras, 456", "joao@email.com", 12345678);

        // Criando um pedido
        Pedido pedido = new Pedido(101, cliente, restaurante, itensPedido, false);
        
        // Criando um entregador
        Entregador entregador = new Entregador(1, "Carlos Motta", "Moto", "carros.mota@email.com", 87654321);

        // Criando uma entrega para o pedido
        Entrega entrega = new Entrega(201, pedido, entregador, LocalDateTime.now().plusHours(1));

        // Concluindo a entrega
        entrega.concluirEntrega();
        System.out.println("Status do pedido após a entrega: " + (pedido.isStatus() ? "Entregue" : "Pendente"));

        // Cliente deixa um feedback
        Feedback feedback = new Feedback(301, pedido, cliente, 5, "Ótimo serviço!");
        feedback.deixarFeedback();

        // Exibindo informações finais
        System.out.println("Resumo do Pedido:");
        System.out.println("Cliente: " + cliente.getNome() + ", Endereço: " + cliente.getEndereco());
        System.out.println("Restaurante: " + restaurante.getNome() + ", Endereço: " + restaurante.getEndereco());
        System.out.println("Itens do Pedido:");
        for (Item item : pedido.getItens()) {
            System.out.println(" - " + item.getNome() + ": R$" + item.getPreco());
        }
        System.out.println("Feedback do Cliente: " + feedback.getAvaliacao() + " estrelas - " + feedback.getComentario());
    }
}
