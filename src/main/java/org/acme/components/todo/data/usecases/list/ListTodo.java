package org.acme.components.todo.data.usecases.list;

import org.acme.components.todo.data.repositories.ITodoRepository;
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
