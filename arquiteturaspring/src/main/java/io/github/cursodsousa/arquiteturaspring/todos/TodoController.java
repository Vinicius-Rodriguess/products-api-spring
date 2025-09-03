package io.github.cursodsousa.arquiteturaspring.todos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("todos")
public class TodoController {

    private TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public TodoEntity salvar(@RequestBody TodoEntity todo) {
        try {
            return this.service.salvar(todo);
        } catch (IllegalArgumentException e) {
            var mensagemError = e.getMessage();
            throw new ResponseStatusException(HttpStatus.CONFLICT, mensagemError);
        }
    }

    @PutMapping("{i}")
    public void atualizarStatus(@PathVariable("id") Integer id, @RequestBody TodoEntity todo) {
        todo.setId(id);
        service.atualizarStatus(todo);
    }

    @GetMapping
    public TodoEntity buscar(@PathVariable("id") Integer id) {
        return service.buscarPorId(id);
    }

}
