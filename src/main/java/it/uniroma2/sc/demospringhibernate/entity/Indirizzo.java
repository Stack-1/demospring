package it.uniroma2.sc.demospringhibernate.entity;

import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Indirizzo {
    @Id
    @GeneratedValue
    private Long id;

    private String viaENumero;
    //private CAP cap;
    private String cap;

    @Embedded
    private Citta citta;

    protected Indirizzo() {

    }

    public Indirizzo(String viaENumero, String cap) {
        this.viaENumero = viaENumero;
        this.cap = cap;
    }
}
