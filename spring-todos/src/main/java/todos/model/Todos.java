package todos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todos {
	
	private String userId;
	private String title;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	private String completed;

	public Todos() {}
	public Todos(String id){ this.id = id;}

	public String getUserId() {
		return userId;
	}

	public void setUserId() {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle() {
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId() {
		this.id = id;
	}

	public String getCompleted() {
		return completed;
	}

	public void setCompleted() {
		this.completed = completed;
	}

	@Override
	 public String toString() {
        return "Todos{" +
                "userId='" + userId + '\'' +
                "id='" + id + '\'' +
                 "completed='" + completed + '\'' +
                ", title=" + title +
                '}';
    }
} 