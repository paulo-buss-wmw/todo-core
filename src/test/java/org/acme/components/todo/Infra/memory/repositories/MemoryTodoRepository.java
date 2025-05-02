package org.acme.components.todo.Infra.memory.repositories;

import java.util.ArrayList;
import java.util.List;

import org.acme.components.todo.data.repositories.ITodoRepository;
import org.acme.components.todo.domain.entity.Todo;

import jakarta.inject.Singleton;

@Singleton
public class MemoryTodoRepository implements ITodoRepository {

    private List<Todo> todos = new ArrayList<>();

    public MemoryTodoRepository() {
        // Empty constructor
    }

    @Override
    public Todo insertTodo(Todo todo) {
        Todo createdTodo = new Todo();
        createdTodo.setId("1L");
        createdTodo.setName(todo.getName());
        createdTodo.setLimitDate(todo.getLimitDate());
        createdTodo.setDone(todo.isDone());

        todos.add(createdTodo);

        return createdTodo;
    }

    @Override
    public List<Todo> getAll() {
        return todos;
    }

}