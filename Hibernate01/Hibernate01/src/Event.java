
import java.util.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author caio
 */
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

}