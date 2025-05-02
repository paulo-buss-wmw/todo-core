package org.acme.web.todo;

import java.util.List;

import org.acme.components.todo.data.repositories.ITodoRepository;
import org.acme.components.todo.data.usecases.create.CreateTodo;
import org.acme.components.todo.data.usecases.list.ListTodo;
import org.acme.components.todo.domain.entity.Todo;
import org.acme.components.todo.domain.usecases.ICreateTodo;
import org.acme.components.todo.domain.usecases.IListTodo;

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

    public List<Todo> listTodo() {
        IListTodo listTodo = new ListTodo(iTodoRepository);
        IListTodo.Output output = listTodo.execute(new IListTodo.Input(null));
        return output.todos();
    }
}
