import org.hibernate.Transaction;
import org.hibernate.Session;
import java.util.Date;
public class EventManager {
  public static void main(String[] args) {
    EventManager mgr = new EventManager();
    //if (args[0].equals("store")) {
      mgr.createAndStoreEvent("My Event", new Date());
    //}
    HibernateUtil.sessionFactory.close();
  }
  private void createAndStoreEvent(String title, Date theDate){
    Session session = HibernateUtil.currentSession();
    Transaction tx = session.beginTransaction();
    Event theEvent = new Event();
    theEvent.setTitle(title);
    theEvent.setDate(theDate);
    session.save(theEvent);
    tx.commit();
    HibernateUtil.closeSession();
  }
}
