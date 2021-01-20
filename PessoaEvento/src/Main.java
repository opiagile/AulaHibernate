/*
 * Main.java
 *
 * Created on 12 de Julho de 2006, 20:07
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */



import java.util.Iterator;
import org.hibernate.*;
import org.hibernate.cfg.*;
//import org.hibernate.Transaction;
//import org.hibernate.Session;


/**
 *
 * @author Administrador
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          SessionFactory sf;
          try{
             sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
             Session session = sf.openSession(); //Abre sess�o
             Transaction tx = session.beginTransaction(); //Cria transa��o
             //Busca uma pessoa
             Long pes_id = new Long(2);
             Pessoa pessoa = (Pessoa) session.get(Pessoa.class, pes_id);
             System.out.println("Pessoa "+pessoa.getNome());
             Iterator relEventos = pessoa.getEvents().iterator();
             //session.getTransaction().commit();

             for (int i = 0;  relEventos.hasNext(); i++) {
            	 Event oEvento = (Event) relEventos.next();
            	 System.out.println("Evento: " + oEvento.getTitle());
             }
             //Busca uma evento
             Long event_id = new Long(1);
             Event evento = (Event) session.load(Event.class, event_id);
             System.out.println("Evento "+evento.getTitle());
             //pessoa.getEvents().add(evento);
             tx.commit(); //Fecha transa��o
             session.close(); //Fecha sess�o
           }
           catch (Throwable ex) {
                // Make sure you log the exception, as it might be swallowed
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
           }
         }        
}
