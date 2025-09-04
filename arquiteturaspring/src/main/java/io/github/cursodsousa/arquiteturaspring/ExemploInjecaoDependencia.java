package io.github.cursodsousa.arquiteturaspring;

import io.github.cursodsousa.arquiteturaspring.todos.MailSender;
import io.github.cursodsousa.arquiteturaspring.todos.TodoRepository;
import io.github.cursodsousa.arquiteturaspring.todos.TodoService;
import io.github.cursodsousa.arquiteturaspring.todos.TodoValidator;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.swing.text.html.parser.Entity;
import java.sql.Connection;

public class ExemploInjecaoDependencia {
    public static void main(String[] args) {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("url");
        dataSource.setUsername("user");
        dataSource.setPassword("password");

        Connection connection = dataSource.getConnection();

        EntityManager entityManager = null;

        TodoRepository repository = null; //new SimpleJpaRepository<TodoRepository, Integer>();
        TodoValidator todoValidator = new TodoValidator(repository);
        MailSender sender = new MailSender();

        TodoService todoService = new TodoService(repository, todoValidator, sender);


//        BeanGerenciado beanGerenciado = new BeanGerenciado(null);
//        beanGerenciado.setValidator(todoValidator);
//        if(condicao == true) {
//            beanGerenciado.setValidator();
//        }
    }
}
