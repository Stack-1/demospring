package it.uniroma2.sc.demospringhibernate.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Citta {

    private String nome;
    private String codiceIstat;
    private String codiceCatastale;

}

