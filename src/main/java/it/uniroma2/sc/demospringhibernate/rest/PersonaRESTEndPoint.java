package it.uniroma2.sc.demospringhibernate.rest;

import it.uniroma2.sc.demospringhibernate.control.IControllerDiCreazioneERetrieval;
import it.uniroma2.sc.demospringhibernate.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persona/")
public class PersonaRESTEndPoint {
    @Autowired
    private IControllerDiCreazioneERetrieval controllerDiCreazioneERetrieval;

    @RequestMapping(method = RequestMethod.POST, path = "")
    public ResponseEntity<?> creaPersona(@RequestBody(required = true) Persona p) {
        if (p != null) {
            Persona newPerson = controllerDiCreazioneERetrieval.creaPersona(p);
            ResponseEntity<Persona> response = new ResponseEntity<>(newPerson, HttpStatus.CREATED);
            return response;
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.GET, path = "")
    public ResponseEntity<?> leggiPersone() {
        List<Persona> persone = controllerDiCreazioneERetrieval.leggiPersone();
        return new ResponseEntity<>(persone, HttpStatus.FOUND);
    }
}
