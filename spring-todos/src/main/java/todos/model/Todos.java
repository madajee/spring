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

	public Todos(String id, String userId, String title, String completed) {
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.completed = completed;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompleted() {
		return completed;
	}

	public void setCompleted(String completed) {
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