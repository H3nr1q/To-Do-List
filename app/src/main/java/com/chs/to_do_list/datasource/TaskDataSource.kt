package com.chs.to_do_list.datasource

import com.chs.to_do_list.model.Task

object TaskDataSource {
    private val list = arrayListOf<Task>()

    fun getList() = list.toList()

    fun insertTask(task: Task) {
        if (task.id == 0) {
            list.add(task.copy(id = list.size + 1))
        } else {
            val taskToRemove = list.find { task.id == it.id }
            list.remove(taskToRemove)
            list.add(task)
        }
    }

    fun findByid(taskId: Int) = list.find { it.id == taskId }

    fun deleteTask(task: Task) {
        list.remove(task)
    }
}