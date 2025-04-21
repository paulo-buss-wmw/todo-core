package org.acme.components.todo.data.usecases.create;

import org.acme.components.todo.Infra.memory.repositories.MemoryTodoRepository;
import org.acme.components.todo.domain.usecases.ICreateTodo;
import org.acme.components.todo.domain.usecases.ICreateTodo.Output;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
class CreateTodoTest {

    @Inject
    MemoryTodoRepository todoRepository;

    @Test
    void testRightExecute() {
        ICreateTodo createTodo = new CreateTodo(this.todoRepository);
        Output output = createTodo.execute(new ICreateTodo.Input("Fazer café", "2025-04-21"));
        Assertions.assertEquals("Todo criado.", output.message()); 
    }

    @Test
    void testWrongExecute() {
        ICreateTodo createTodo = new CreateTodo(this.todoRepository);
        Assertions.assertThrows(Exception.class, () -> createTodo.execute(new ICreateTodo.Input("Fazer café", "2025-00-21")));
    }
}
