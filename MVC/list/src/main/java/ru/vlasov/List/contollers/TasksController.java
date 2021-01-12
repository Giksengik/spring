package ru.vlasov.List.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    @GetMapping("/new")
    public String newTask(@ModelAttribute("task") Task task){
        return "list/new";
    }
    @PostMapping()
    public String create(@ModelAttribute("task") Task task){
        tasksDao.save(task);
        return("redirect:/list");
    }
    @GetMapping("/{id}/edit")
    public String update(Model model,@PathVariable("id") int id){
        model.addAttribute("task",tasksDao.show(id));
        return "/list/edit";
    }
    @PatchMapping("/{id}")
    public String edit(@ModelAttribute("task") Task task,@PathVariable("id") int id){
        tasksDao.edit(id,task);
        return"redirect:/list";
    }
    @DeleteMapping("/{id}")
    public String delete(@ModelAttribute("task") Task task,
                         @PathVariable("id") int id){
        tasksDao.delete(id);
        return "redirect:/list";
    }


}
