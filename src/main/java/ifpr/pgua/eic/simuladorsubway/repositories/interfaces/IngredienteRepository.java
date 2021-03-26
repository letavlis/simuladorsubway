package ifpr.pgua.eic.simuladorsubway.repositories.interfaces;

import ifpr.pgua.eic.simuladorsubway.models.Ingrediente;
import javafx.collections.ObservableList;

public interface IngredienteRepository {

    boolean adicionar(Ingrediente ingrediente);
    boolean editar(int id, Ingrediente ingredienteAntigo);

    Ingrediente buscarIngrediente(String nome, String descricao, double valor);

    ObservableList<Ingrediente> lista();
}
