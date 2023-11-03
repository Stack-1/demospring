package it.uniroma2.sc.demospringhibernate.rest;


import it.uniroma2.sc.demospringhibernate.control.IControllerDiCreazioneERetrieval;
import it.uniroma2.sc.demospringhibernate.entity.Cane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cane/")
public class CaneRESTEndpoint {

    Logger logger =  LoggerFactory.getLogger(CaneRESTEndpoint.class);

    @Autowired
    private IControllerDiCreazioneERetrieval controllerDiCreazioneERetrieval;

    @RequestMapping(method = RequestMethod.POST, path = "")
    public ResponseEntity<?> creaCane(@RequestBody(required = true) Cane c) {
        if (c != null) {
            Cane newCane = controllerDiCreazioneERetrieval.creaCane(c);
            ResponseEntity<Cane> response = new ResponseEntity<>(newCane, HttpStatus.CREATED);
            return response;
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.GET, path = "{idCane}")
    public ResponseEntity<?> leggiCane(@PathVariable Long idCane) {
        if (idCane != null) {
            Cane c = controllerDiCreazioneERetrieval.leggiCanePerId(idCane);
            if (c == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(c, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.GET, path = "")
    public ResponseEntity<?> leggiCani() {
        List<Cane> tuttiICani = controllerDiCreazioneERetrieval.leggiCani();
        // mapping dto/entità e viceversa
        return new ResponseEntity<>(tuttiICani, HttpStatus.FOUND);
    }

    @RequestMapping(method = RequestMethod.POST, path = "cancella/{idCane}")
    public ResponseEntity<?> cancellaCane(@PathVariable Long idCane) {
        if(controllerDiCreazioneERetrieval.cancellaCane(idCane)){
            logger.info("Deleted successfully dog with id: " + idCane);
        }else{
            logger.info("Error in deleting dog with id: " + idCane);
        }
        // mapping dto/entità e viceversa
        return null;
    }


    /*@RequestMapping(method = RequestMethod.GET, path = "")
    public List<Cane> leggiCani() {
        return controllerDiCreazioneERetrieval.leggiCani();
    }*/

    @RequestMapping(method = RequestMethod.GET, path = "search") // /api/cane/search?nomeCane=Bobby
    public ResponseEntity<?> cercaCaniPerNome(@RequestParam(name = "nomeCane", required = false) String nome) {
        if (nome != null) {
            return new ResponseEntity<>(controllerDiCreazioneERetrieval.cercaCaniPerNome(nome), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }



    @RequestMapping(method = RequestMethod.PUT, path = "generate")
    public ResponseEntity<Void> generateSampleData() {
        controllerDiCreazioneERetrieval.creazioniDiProva();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
