package todos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TodosRepository extends CrudRepository<Todos, String> {

}