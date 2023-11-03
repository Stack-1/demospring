package it.uniroma2.sc.demospringhibernate.control;

import it.uniroma2.sc.demospringhibernate.entity.Cane;
import it.uniroma2.sc.demospringhibernate.entity.Persona;

import java.util.List;

public interface IControllerDiCreazioneERetrieval {
    Cane creaCane(Cane c);

    boolean cancellaCane(long idCane);

    Persona creaPersona(Persona p);

    List<Persona> leggiPersone();

    Cane leggiCanePerId(Long idCane);

    List<Cane> leggiCani();

    List<Cane> cercaCaniPerNome(String nome);

    List<Cane> cercaCaniPerPadrone(Long idPadrone) throws Exception;

    void creazioniDiProva();
}
