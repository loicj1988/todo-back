package org.loic.todo.adapter.web;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;
import java.util.Arrays;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.loic.todo.domain.data.Todo;

import io.quarkus.oidc.IdToken;

@Path("/todo")
public class TodoController {

    @Inject
    @IdToken
    JsonWebToken idToken;

    @GET
    public List<Todo> getTodo() {
        System.out.println("XXXXXXXXX");
        return Arrays.asList(new Todo("1", "loicj", "my todo", true));
    }
}
