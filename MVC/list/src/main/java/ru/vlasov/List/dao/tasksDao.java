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

}
