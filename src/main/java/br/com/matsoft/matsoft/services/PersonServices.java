package br.com.matsoft.matsoft.services;

import br.com.matsoft.matsoft.exceptions.ResourceNotFoundException;
import br.com.matsoft.matsoft.model.PersonTESTE;
import br.com.matsoft.matsoft.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired(required = false)
    PersonRepository repository;

    public List<PersonTESTE> findAll() {

        logger.info("Finding all people!");

        return repository.findAll();
    }

    public PersonTESTE findById(Long id) {

        logger.info("Finding one person!");
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }

    public PersonTESTE create(PersonTESTE personTESTE) {

        logger.info("Creating one person!");

        return repository.save(personTESTE);
    }

    public PersonTESTE update(PersonTESTE personTESTE) {

        logger.info("Updating one person!");

        var entity = repository.findById(personTESTE.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setNome(personTESTE.getNome());
        entity.setIdade(personTESTE.getId());
        entity.setCargo(personTESTE.getCargo());

        return repository.save(personTESTE);
    }

    public void delete(Long id) {

        logger.info("Deleting one person!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }
}
