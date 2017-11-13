package DAO;

import java.sql.SQLException;
import java.util.List;

public interface DAO <T> { //Nesse T pode ser qualquer letra. É um parâmetro recebido.
    
    public boolean insert(T obj) throws SQLException; //Recebe uma variável obj do tipo T. A princípio "T" não existe.
    public List<T> list() throws SQLException; //Coleção do tipo T.
    
}