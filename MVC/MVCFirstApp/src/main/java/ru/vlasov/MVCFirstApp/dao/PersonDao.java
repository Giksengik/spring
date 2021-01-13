package ru.vlasov.MVCFirstApp.dao;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import org.springframework.stereotype.Component;
import ru.vlasov.MVCFirstApp.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class PersonDao {
    private static int PEOPLE_COUNT;

    private static final String URL="jdbc:postgresql://localhost:5432/first_db";
    private static final String USERNAME="postgres";
    private static final String PASSWORD="qe231002";
    private static Connection connection ;
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public List<Person> index() {
        List<Person> people = new ArrayList<Person>();
        try {
            Statement statement= connection.createStatement();
            String CMND="SELECT MAX(id)as max FROM Person";
            ResultSet resultSet = statement.executeQuery(CMND);
            resultSet.next();
            PEOPLE_COUNT=resultSet.getInt("max");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            Statement statement= connection.createStatement();
            String SQL="SELECT * FROM Person";
            ResultSet resultSet = statement.executeQuery(SQL);
            while(resultSet.next()){
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));
                people.add(person);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return people;
    }

    public Person show(int id) {
        Person person=null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM PERSON WHERE id=?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet =preparedStatement.executeQuery();
            resultSet.next();
            person=new Person();
            person.setId(resultSet.getInt("id"));
            person.setAge(resultSet.getInt("age"));
            person.setEmail(resultSet.getString("email"));
            person.setName(resultSet.getString("name"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return person;

    }

    public void save(Person person) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO Person VALUES(?,?,?,?)");
            preparedStatement.setInt(1,++PEOPLE_COUNT);
            preparedStatement.setString(2,person.getName());
            preparedStatement.setInt(3,person.getAge());
            preparedStatement.setString(4,person.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void update(int id, Person updatedPerson) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE Person SET name=?, age=?,email=? WHERE id=?");
            preparedStatement.setString(1,updatedPerson.getName());
            preparedStatement.setInt(2,updatedPerson.getAge());
            preparedStatement.setString(3,updatedPerson.getEmail());
            preparedStatement.setInt(4,id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(int id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "DELETE FROM Person WHERE id=?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
