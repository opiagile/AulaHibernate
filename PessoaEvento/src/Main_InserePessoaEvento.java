/*
 * Main.java
 *
 * Created on 12 de Julho de 2006, 20:07
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */



import java.util.Calendar;
import java.util.Date;

import org.hibernate.*;
import org.hibernate.cfg.*;
//import org.hibernate.Transaction;
//import org.hibernate.Session;


/**
 *
 * @author Administrador
 */
public class Main_InserePessoaEvento {
    
    /** Creates a new instance of Main */
    public Main_InserePessoaEvento() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          SessionFactory sf;
          try{
             sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
             Session session = sf.openSession(); //Abre sessã         
             Transaction tx = session.beginTransaction(); //Cria transaç
             // Insere uma pessoa
             Pessoa pessoa = new Pessoa();
             pessoa.setNome("Um Francisco");
             Calendar data =  Calendar.getInstance();
             data.set(2006, 11, 18, 20, 0, 0);
             System.out.println(data);
             pessoa.setDataNascimento(data);
             pessoa.setSexo('M');
             session.save(pessoa);             
             // Insere uma segunda pessoa
             Pessoa pessoa1 = new Pessoa();
             pessoa1.setNome("Dois Francisco");
             data.set(2006, 11, 18, 20, 0, 0);
             System.out.println(data);
             pessoa1.setDataNascimento(data);
             pessoa1.setSexo('M');
             session.save(pessoa1);
             //Cria objeto Evento
             Event theEvent = new Event();
             theEvent.setTitle("Evento Novo de Pos Java");
             theEvent.setDate(new Date());
             session.save(theEvent);             
             //Busca uma pessoa
             Long pes_id = new Long(2);
             Pessoa pessoa2 = (Pessoa) session.get(Pessoa.class, pes_id);
             System.out.println("Pessoa "+pessoa2.getNome());
             //Busca uma evento
             Long event_id = new Long(1);
             Event evento = (Event) session.load(Event.class, event_id);
             System.out.println("Evento "+evento.getTitle());
             pessoa2.getEvents().add(evento);
             tx.commit(); //Fecha transaç
             session.close(); //Fecha sessã    
           }
           catch (Throwable ex) {
                // Make sure you log the exception, as it might be swallowed
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
           }
         }        
}

