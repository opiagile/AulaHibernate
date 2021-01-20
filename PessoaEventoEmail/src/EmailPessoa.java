
/*
 * Main.java
 *
 * Created on 12 de Julho de 2006, 20:07
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.Calendar;
//import org.hibernate.Transaction;
//import org.hibernate.Session;


/**
 *
 * @author Administrador
 */
public class EmailPessoa {
    
    /** Creates a new instance of Main */
    public EmailPessoa() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          SessionFactory sf;
          try{
             sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
             Session session = sf.openSession(); //Abre sessão
             Transaction tx = session.beginTransaction(); //Cria transação
             Email email = new Email();              
             tx.commit(); //Fecha transação
             session.close(); //Fecha sessão
           }
           catch (Throwable ex) {
                // Make sure you log the exception, as it might be swallowed
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
           }
         }        
}
