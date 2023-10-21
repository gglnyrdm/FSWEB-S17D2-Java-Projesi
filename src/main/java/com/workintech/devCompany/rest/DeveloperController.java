package com.workintech.devCompany.rest;

import com.workintech.devCompany.model.Developer;
import com.workintech.devCompany.model.DeveloperFactory;
import com.workintech.devCompany.task.Taxable;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/developers")
public class DeveloperController {
    private Map<Integer, Developer> developers;
    private Taxable taxable;

    @PostConstruct
    public void init(){
        developers = new HashMap<>();
    }
    @Autowired
    public DeveloperController(Taxable taxable) {
        this.taxable = taxable;
    }
    @GetMapping("/")
    public List<Developer> getAll(){
        return  developers.values().stream().toList();
    }
    @GetMapping("/{id}")
    public Developer getById(@PathVariable int id){
        return developers.get(id);
    }
    @PostMapping("/")
    public Developer create(@RequestBody Developer developer){
        Developer savedDeveloper = DeveloperFactory.createDeveloper(developer,taxable);
        if (savedDeveloper != null){
            developers.put(savedDeveloper.getId(),savedDeveloper);
        }
        return developers.get(savedDeveloper.getId());
    }
    @PutMapping("/{id}")
    public Developer update (@PathVariable int id, @RequestBody Developer developer){
        return developers.put(developer.getId(),developer);
    }
    @DeleteMapping("/{id}")
    public Developer delete(@PathVariable int id){
        return developers.remove(id);
    }
}
