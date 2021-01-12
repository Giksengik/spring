package ru.vlasov.List.dao;

import org.springframework.stereotype.Component;
import ru.vlasov.List.models.Task;

import java.util.ArrayList;
import java.util.List;

@Component
public class tasksDao {
    static public int TASKS_COUNT=0;
    private final List<Task> list;
    {
        ArrayList<Task> listForStart=new ArrayList<Task>();
        listForStart.add(new Task("buy a bread",++TASKS_COUNT));
        listForStart.add(new Task("do homework",++TASKS_COUNT));
        listForStart.add(new Task("make something",++TASKS_COUNT));
        list=listForStart;
    }
    public List<Task> index(){
        return list;
    }
    public Task show(int id){
        return list.stream().filter(task -> task.getId() == id).findAny().orElse(null);
    }
    public void save(Task task){
        task.setId(++TASKS_COUNT);
        list.add(task);
    }
    public void edit(int id,Task task){
        Task taskToBeEdit = show(id);
        taskToBeEdit.setName(task.getName());
    }
    public void delete(int id){
        list.removeIf(p -> p.getId() == id);
    }
}
