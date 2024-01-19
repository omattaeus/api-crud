package br.com.matsoft.matsoft.controller;

import br.com.matsoft.matsoft.models.PersonTESTE;
import br.com.matsoft.matsoft.services.PersonServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/person", produces = {"application/json"})
@Tag(name = "person")
public class PersonController {

    @Autowired
    private PersonServices service;

    @Operation(summary = "Realiza consulta de todas as pessoas", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta de pessoas realizado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a consulta de pessoas"),})
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonTESTE> findAll(@RequestBody PersonTESTE person) {
        return service.findAll();
    }

    @Operation(summary = "Realiza consulta de uma as pessoa por ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta de pessoa por ID realizado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a consulta de uma pessoa por ID"),})
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonTESTE findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }


    @Operation(summary = "Realiza o cadastro de pessoa", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cadastro de pessoas realizado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar o cadastro de pessoas"),})
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonTESTE create(@RequestBody PersonTESTE personTESTE){
        return service.create(personTESTE);
    }

    @Operation(summary = "Realiza a alteração de dados de pessoas", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Alteração de dados realizado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a altereção de dados"),})
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonTESTE update(@RequestBody PersonTESTE person){
        return service.update(person);
    }


    @Operation(summary = "Realiza a exclusão de dados", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Exclusão dados realizado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a exclusão de dados"),})
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
    }
}