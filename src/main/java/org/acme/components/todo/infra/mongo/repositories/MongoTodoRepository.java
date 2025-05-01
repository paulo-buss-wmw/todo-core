package org.acme.components.todo.infra.mongo.repositories;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.acme.components.todo.data.repositories.ITodoRepository;
import org.acme.components.todo.domain.entity.Todo;
import org.acme.components.todo.infra.mongo.entity.MongoTodo;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.inject.Singleton;

@Singleton
public class MongoTodoRepository implements ITodoRepository, PanacheMongoRepository<MongoTodo> {

    @Override
    public Todo insertTodo(Todo todo) {
        MongoTodo mongoTodo = MongoTodo.createMongoTodo(todo);
        this.persist(mongoTodo);
        return mongoTodo.convertToTodo();
    }
    
    @Override
    public List<Todo> getAll() {
        List<MongoTodo> mongoTodos = findAll().list();

        if (mongoTodos != null && ! mongoTodos.isEmpty()) {
            return mongoTodos.stream().map(MongoTodo::convertToTodo).toList();
        } else {
            return Collections.emptyList();
        }
    }

}
