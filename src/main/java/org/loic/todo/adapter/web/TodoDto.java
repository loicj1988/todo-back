package org.loic.todo.adapter.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto {
    private String title;
    private boolean completed;
}
