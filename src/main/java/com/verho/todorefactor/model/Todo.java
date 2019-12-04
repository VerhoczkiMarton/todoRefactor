package com.verho.todorefactor.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Todo {

    private String title;
    private static Long _idCounter = 0L;
    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    private Status status;

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isCompleted() {
        return this.status == Status.COMPLETE;
    }

    public static Todo create(String title) {
        _idCounter++;
        return new Todo(title, _idCounter, Status.ACTIVE);
    }

}
