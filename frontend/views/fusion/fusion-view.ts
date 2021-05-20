import Todo from "Frontend/generated/com/example/application/data/entity/Todo";
import { findAllTodos, saveTodo } from "Frontend/generated/TodoEndpoint";
import { customElement, html, state } from "lit-element";
import { View } from "../../views/view";
import "@vaadin/vaadin-text-field";
import "@vaadin/vaadin-button";

@customElement("fusion-view")
export class FusionView extends View {
  @state()
  private todos: Todo[] = [];
  @state()
  private task = "";

  render() {
    return html`
      <h1>Fusion todo</h1>
      <div class="form">
        <vaadin-text-field
          .value=${this.task}
          @value-changed=${this.updateTask}
        ></vaadin-text-field>
        <vaadin-button @click=${this.save}>Add</vaadin-button>
        <ul>
          ${this.todos.map((todo) => html` <li>${todo.task}</li> `)}
        </ul>
      </div>
    `;
  }

  async connectedCallback() {
    super.connectedCallback();
    this.todos = await findAllTodos();
  }

  async save() {
    const saved = await saveTodo(this.task);
    if (saved) {
      this.todos = [...this.todos, saved];
      this.task = "";
    }
  }

  updateTask(e: CustomEvent) {
    this.task = e.detail.value;
  }
}
