package ifpr.pgua.eic.simuladorsubway.repositories;

import ifpr.pgua.eic.simuladorsubway.models.Cliente;
import ifpr.pgua.eic.simuladorsubway.models.Ingrediente;
import ifpr.pgua.eic.simuladorsubway.repositories.interfaces.IngredienteRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Optional;

public class IngredienteRepositoryImpl implements IngredienteRepository {

    private ObservableList<Ingrediente> ingredientes;


    public IngredienteRepositoryImpl(){

        ingredientes = FXCollections.observableArrayList();
    }

    public boolean adicionar(Ingrediente ingrediente){
        ingredientes.add(new Ingrediente(ingredientes.size(),ingrediente.getNome(),ingrediente.getDescricao(), ingrediente.getValor()));
        return true;
    }

    public boolean editar(int id, Ingrediente ingrediente){

        for(Ingrediente i:ingredientes){
            if(i.getId() == id){
                i.setNome(ingrediente.getNome());
                i.setDescricao(ingrediente.getDescricao());
                i.setValor(ingrediente.getValor());

                return true;
            }
        }

        return false;
    }
    @Override
    public Ingrediente buscarIngrediente(String nome, String descricao, double valor){
        Optional<Ingrediente> ret = ingredientes.stream()
                .filter((i -> i.getNome().equals(nome)))
                .findFirst();
        Optional<Ingrediente> ret1 = ingredientes.stream()
                .filter((i -> i.getDescricao().equals(descricao)))
                .findFirst();
        Optional<Ingrediente> ret2 = ingredientes.stream()
                .filter((i -> i.getValor()==valor))
                .findFirst();
        if(ret.isPresent()){
            return ret.get();
        }
        else if( ret1.isPresent()){
            return ret1.get();
        }
        else if( ret2.isPresent()){
            return ret2.get();
        }
        return null;
    }

    public ObservableList<Ingrediente> lista(){
        return FXCollections.unmodifiableObservableList(ingredientes);
    }


}
