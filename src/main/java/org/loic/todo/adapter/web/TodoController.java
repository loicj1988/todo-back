package org.loic.todo.adapter.web;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import java.util.List;

import org.bson.types.ObjectId;
import org.loic.todo.domain.data.Todo;

@Path("/todo")
public class TodoController {

    // TODO, get identify from id token

    @GET
    public List<Todo> listTodo() {
        return Todo.listAll();
    }

    @GET
    @Path("/{id}")
    public TodoDto getTodo(@PathParam("id") String id) {

        Todo todo = Todo.findById(new ObjectId(id));
        if (todo == null) {
            throw new NotFoundException("Todo not found");
        }

        return new TodoDto(todo.getTitle(), todo.isCompleted());
    }

    @DELETE
    @Path("/{id}")
    public void deleteTodo(@PathParam("id") String id) {

        Todo todo = Todo.findById(new ObjectId(id));
        if (todo == null) {
            throw new NotFoundException("Todo not found");
        }

        todo.delete();
    }

    @POST
    public void addTodo(TodoDto todo) {
        Todo todoToInsert = new Todo("loicj", todo.getTitle(), todo.isCompleted());
        todoToInsert.persist();
    }

    @PUT
    @Path("/{id}")
    public void updateTodo(TodoDto todo, @PathParam("id") String id) {

        Todo todoToUpdate = Todo.findById(new ObjectId(id));

        if (todoToUpdate == null) {
            throw new NotFoundException("Todo not found");
        }

        todoToUpdate.setTitle(todo.getTitle());
        todoToUpdate.setCompleted(todo.isCompleted());

        todoToUpdate.update();
    }
}
