package ru.vlasov.List.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.vlasov.List.models.Task;

@Controller
@RequestMapping("/list")
public class TasksController {
    private final ru.vlasov.List.dao.tasksDao tasksDao;

    @Autowired
    public TasksController(ru.vlasov.List.dao.tasksDao tasksDao) {
        this.tasksDao = tasksDao;
    }
    @GetMapping()
    public String index(Model model){
        model.addAttribute("list",tasksDao.index());
        return("list/index");
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id,Model model){
        model.addAttribute("task",tasksDao.show(id));
        return("list/show");
    }

}
