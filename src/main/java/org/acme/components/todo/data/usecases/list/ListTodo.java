package org.acme.components.todo.data.usecases.list;

import java.time.LocalDate;

import org.acme.components.todo.data.repositories.ITodoRepository;
import org.acme.components.todo.domain.entity.Todo;
import org.acme.components.todo.domain.usecases.ICreateTodo;
import org.acme.components.todo.domain.usecases.IListTodo;

public class ListTodo implements IListTodo {

    private final ITodoRepository todoRepository;

    public ListTodo(ITodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Output execute(Input input) {

        return new Output(this.todoRepository.getAll());
        
    }

}
