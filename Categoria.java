import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private int id;
    private String nome;
    private boolean ativo;
    private LocalDateTime dataCriacao;
    private LocalDateTime ultimaModificacao;
    private List<Categoria> subcategorias;
    private TipoCategoria tipo;

    public enum TipoCategoria {
        ALIMENTACAO, BEBIDAS, LIMPEZA, OUTROS
    }

    public Categoria(int id, String nome, TipoCategoria tipo) {
        this.id = id;
        setNome(nome);
        this.tipo = tipo;
        this.ativo = true;
        this.dataCriacao = LocalDateTime.now();
        this.ultimaModificacao = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome da categoria não pode ser nulo ou vazio.");
        }
        this.nome = nome;
        this.ultimaModificacao = LocalDateTime.now();
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void desativarCategoria() {
        this.ativo = false;
        this.ultimaModificacao = LocalDateTime.now();
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getUltimaModificacao() {
        return ultimaModificacao;
    }

    public TipoCategoria getTipo() {
        return tipo;
    }

    public void setTipo(TipoCategoria tipo) {
        this.tipo = tipo;
        this.ultimaModificacao = LocalDateTime.now();
    }

    public List<Categoria> getSubcategorias() {
        return subcategorias;
    }

    public void adicionarSubcategoria(Categoria subcategoria) {
        if (subcategorias == null) {
            subcategorias = new ArrayList<>();
        }
        subcategorias.add(subcategoria);
        this.ultimaModificacao = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Categoria: " + nome + " (ID: " + id + ", Tipo: " + tipo + ", Ativo: " + ativo + ")";
    }
}
