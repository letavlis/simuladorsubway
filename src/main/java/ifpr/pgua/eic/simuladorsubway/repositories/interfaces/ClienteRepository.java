package ifpr.pgua.eic.simuladorsubway.repositories.interfaces;

import ifpr.pgua.eic.simuladorsubway.models.Cliente;
import javafx.collections.ObservableList;

public interface ClienteRepository {

    boolean adicionar(Cliente cliente);
    boolean editar(int id, Cliente cliente);

    Cliente buscarCliente(String nome, String telefone, String email);

    ObservableList<Cliente> lista();


}
