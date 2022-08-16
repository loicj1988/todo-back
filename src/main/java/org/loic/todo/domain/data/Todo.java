package org.loic.todo.domain.data;

import org.bson.codecs.pojo.annotations.BsonId;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MongoEntity(collection = "todo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Todo extends PanacheMongoEntity {
    private String username;
    private String title;
    private boolean completed;
}
