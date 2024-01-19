package br.com.matsoft.matsoft.repositories;

import br.com.matsoft.matsoft.models.PersonTESTE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonTESTE, Long> {
}