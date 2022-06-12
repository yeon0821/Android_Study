package org.techtown.todolist;

public class Todo {
    private String todoName;

    //생성자
    public Todo(String todoName) {
        this.todoName = todoName;
    }

    //getter
    public String getTodoName() {
        return todoName;
    }
}
