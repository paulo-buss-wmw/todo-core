package org.acme.web.todo;

import org.acme.components.todo.data.repositories.ITodoRepository;
import org.acme.components.todo.data.usecases.create.CreateTodo;
import org.acme.components.todo.domain.usecases.ICreateTodo;

public class TodoController {

    private final ITodoRepository iTodoRepository;

    public TodoController(ITodoRepository iTodoRepository) {
        this.iTodoRepository = iTodoRepository;
    }

    public String createTodo(String name, String limitDate) {
        ICreateTodo createTodo = new CreateTodo(iTodoRepository);
        ICreateTodo.Output output = createTodo.execute(new ICreateTodo.Input(name, limitDate));
        return output.message();
    }
}
