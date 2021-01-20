import java.util.Date;
import java.util.HashSet;
import java.util.Set;
public class Event {
  private Long id;
  private String title;
  private Date date;
          
  Event() {}
  public Long getId() {
    return id;
  }
  private void setId(Long id) {
    this.id = id;
  }
  public Date getDate() {
    return date;
  }
  public void setDate(Date date) {
    this.date = date;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  
  private Set pessoa = new HashSet();
  public Set getPessoa() {
    return pessoa;
  }
  public void setPessoa(Set Pessoa) {
    this.pessoa = Pessoa;
  }
  
}

