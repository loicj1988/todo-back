package org.loic.todo.adapter.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;
import java.util.Arrays;

import org.loic.todo.domain.data.Todo;

@Path("/todo")
public class TodoController {

    @GET
    public List<Todo> getTodo() {
        System.out.println("XXXXXXXXX");
        return Arrays.asList(new Todo("1", "loicj", "my todo", true));
    }
}
