package com.example.todo_list.ui.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo_list.domain.model.Todo
import com.example.todo_list.domain.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val repository: TodoRepository
) : ViewModel() {

    var todo: Todo by mutableStateOf(Todo(0,"","", isCompleted = false ))

        private set
    val getAllTodos: Flow<List<Todo>> = repository.getAllTodos()
    private var deletedTodo: Todo? = null

    fun insertTodo(todo:Todo){
        viewModelScope.launch(Dispatchers.IO){
            repository.insertTodo(todo = todo)
        }
    }

    fun updateTodo(todo:Todo){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateTodo(todo = todo)
        }
    }

    fun deleteTodo(todo: Todo){
        viewModelScope.launch(Dispatchers.IO){
            deletedTodo = todo
            repository.deleteTodo(todo= todo )
        }
    }

    fun unDoDeletedTodo(){
        deletedTodo?.let { todo: Todo ->
            viewModelScope.launch(Dispatchers.IO){
                repository.insertTodo(todo = todo)
            }
        }
    }

    fun getTodoById(id: Int){
        viewModelScope.launch (Dispatchers.IO){
            todo = repository.getAllTodoById(id = id)!!
        }
    }

    fun updateTask(newValue: String){
        todo = todo.copy(title = newValue, subtitle = newValue)
    }

    fun updateIsCompleted(newValue: Boolean){
        todo = todo.copy(isCompleted = newValue)
    }
}