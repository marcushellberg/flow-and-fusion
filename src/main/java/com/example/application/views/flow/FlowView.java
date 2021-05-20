package com.example.application.views.flow;

import com.example.application.data.entity.Todo;
import com.example.application.data.service.TodoRepo;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "flow")
@PageTitle("Flow")
public class FlowView extends Div {

  UnorderedList todos = new UnorderedList();
  private TodoRepo repo;

  public FlowView(TodoRepo repo) {
    this.repo = repo;
    addClassName("flow-view");

    var task = new TextField();
    var button = new Button("Add", click -> {
      repo.save(new Todo(task.getValue()));
      updateTodos();
      task.clear();
    });

    add(new H1("Flow todo"), new HorizontalLayout(task, button), todos);
    updateTodos();
  }

  private void updateTodos() {
    todos.removeAll();
    repo.findAll().forEach(todo -> {
      todos.add(new ListItem(todo.getTask()));
    });

  }

}
