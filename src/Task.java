import java.time.LocalDate;
import java.util.Set;

public class Task {
    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean isComplete;
    private int priority;
    private Set<String> tags;

    public Task(String title,String description,int priority,Set<String> tags){
        this.title = title;
        this.description = description;
        this.dueDate = LocalDate.now();
        this.priority = priority;
        this.tags = tags;

    }
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public Set<String> getTags() {
        return tags;
    }
    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isComplete() {
        return isComplete;
    }
    public void setComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }
    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", complete=" + isComplete +
                ", creationDate=" + dueDate +
                '}';
    }
}
