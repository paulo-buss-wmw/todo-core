package org.acme.components.todo.data.usecases.list;

import org.acme.components.todo.Infra.memory.repositories.MemoryTodoRepository;
import org.acme.components.todo.data.usecases.create.CreateTodo;
import org.acme.components.todo.domain.usecases.ICreateTodo;
import org.acme.components.todo.domain.usecases.IListTodo;
import org.acme.components.todo.domain.usecases.IListTodo.Output;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
class ListTodoTest {

    @Inject
    MemoryTodoRepository todoRepository;

    @Test
    void testRightExecute() {
        IListTodo listTodo = new ListTodo(this.todoRepository);
        Output output = listTodo.execute(new IListTodo.Input(null));
        Assertions.assertEquals(0, output.todos().size()); 

        ICreateTodo createTodo = new CreateTodo(this.todoRepository);
        createTodo.execute(new ICreateTodo.Input("Fazer café", "2025-04-21"));

        Output secondOutput = listTodo.execute(new IListTodo.Input(null));
        Assertions.assertEquals(1, secondOutput.todos().size()); 

    }

}
