package es.joseluisgs.dam.repositories;

import es.joseluisgs.dam.models.Persona;

import java.io.IOException;
import java.sql.SQLException;

public interface IPersonasRepository extends CRUDRepository<Persona, Integer> {
    void deleteAll() throws SQLException;

    void backup() throws SQLException, IOException;

    void restore() throws SQLException, IOException;

}
