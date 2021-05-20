package com.example.application.data.endpoint;

import java.util.List;

import com.example.application.data.entity.Todo;
import com.example.application.data.service.TodoRepo;
import com.vaadin.flow.server.connect.Endpoint;
import com.vaadin.flow.server.connect.auth.AnonymousAllowed;

@Endpoint
@AnonymousAllowed
public class TodoEndpoint {
  private TodoRepo repo;

  public TodoEndpoint(TodoRepo repo) {
    this.repo = repo;
  }

  public List<Todo> findAllTodos() {
    return repo.findAll();
  }

  public Todo saveTodo(String task) {
    return repo.save(new Todo(task));
  }

}
