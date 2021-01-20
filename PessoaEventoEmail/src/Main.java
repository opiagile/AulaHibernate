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
             Session session = sf.openSession(); //Abre sessão
             Transaction tx = session.beginTransaction(); //Cria transação
             //Insere uma pessoa
             Pessoa pessoa = new Pessoa();
             pessoa.setNome("Caio Nakashima");
             pessoa.setSexo('M');
             Calendar pData = Calendar.getInstance();
             pData.set(1967, 3, 14, 0, 0, 0);
             pessoa.setDataNascimento(pData);
             //Insere um email
             String email = "caionakashima@gmail.com";
             pessoa.getEmail().add(email);
             //Insere email dois
             String email2 = "caio.nakashima@mds.gov.br";
             pessoa.getEmail().add(email2);
             session.save(pessoa);
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
