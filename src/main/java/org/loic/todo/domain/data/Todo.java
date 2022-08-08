package org.loic.todo.domain.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Todo {
    private String _id;
    private String username;
    private String title;
    private Boolean completed;
}
