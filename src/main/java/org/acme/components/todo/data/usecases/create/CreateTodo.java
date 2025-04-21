package org.acme.components.todo.data.usecases.create;

import java.time.LocalDate;

import org.acme.components.todo.data.repositories.ITodoRepository;
import org.acme.components.todo.domain.entity.Todo;
import org.acme.components.todo.domain.usecases.ICreateTodo;

public class CreateTodo implements ICreateTodo {

    private final ITodoRepository todoRepository;

    public CreateTodo(ITodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Output execute(Input input) {

        Todo todo = Todo.createDefaultTodo(input.name(), LocalDate.parse(input.limitDate()));

        if (! todo.isValid()) {
            return new Output("Todo invalido");
        }

        todo = this.todoRepository.insertTodo(todo);

        if (! todo.isCorrectlyInserted()) {
            return new Output("Todo não inserido");
        }

        return new Output("Todo criado.");
        
    }

}
