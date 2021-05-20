package com.example.application.data.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import com.example.application.data.AbstractEntity;

@Entity
public class Todo extends AbstractEntity {

  private boolean done;
  @NotBlank
  private String task;

  public Todo() {
  }

  public Todo(String task) {
    this.task = task;
  }

  public boolean isDone() {
    return done;
  }

  public void setDone(boolean done) {
    this.done = done;
  }

  public String getTask() {
    return task;
  }

  public void setTask(String task) {
    this.task = task;
  }
}
