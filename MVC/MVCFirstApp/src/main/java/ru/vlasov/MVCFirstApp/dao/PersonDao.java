package ru.vlasov.MVCFirstApp.dao;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import org.springframework.stereotype.Component;
import ru.vlasov.MVCFirstApp.models.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class PersonDao {
    private static int PEOPLE_COUNT;
    private List<Person> people;
    private List<String> names;
    {
        people=new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT,"Tom "));
        people.add(new Person(++PEOPLE_COUNT,"Bob"));
        people.add(new Person(++PEOPLE_COUNT,"Mike"));
        people.add(new Person(++PEOPLE_COUNT,"Katy"));
        names= new ArrayList<>();
        names.add(new String("Egor"));
        names.add(new String("Michael"));
        names.add(new String("Sheldon"));
        names.add(new String("Leonard"));
    }
    public List<Person> index(){
        return people;
    }
    public Person show(int id){
        return people.stream().filter(person -> person.getId()==id).findAny().orElse(null);
    }
    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
    public void update(int id,Person person){
       Person personToBeUpdated = show(id);
       personToBeUpdated.setName(person.getName());
       personToBeUpdated.setAge(person.getAge());
    }
    public void delete(int id){
        people.removeIf(p->p.getId()==id);
    }
    public void clone(int id){
        Person personToBeCloned = show(id);
        personToBeCloned.setId(++PEOPLE_COUNT);
        people.add(personToBeCloned);
    }
    public void createRandom(){
        Person personToAdd= new Person();
        personToAdd.setName("Egor");
        save(personToAdd);
    }
}
