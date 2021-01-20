/*
 * InserePessoaTelefone.java
 *
 * Created on 12 de Julho de 2006, 20:07
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.Calendar;
import java.util.*;
//import org.hibernate.Transaction;
//import org.hibernate.Session;
import java.util.HashSet;


/**
 *
 * @author Administrador
 */
public class InserePessoaTelefone {
    
    /** Creates a new instance of InserePessoaTelefone */
    public InserePessoaTelefone() {
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
 
             //Insere um telefone
             Telefones telefone = new Telefones();
             telefone.setNumero("3333-3333");
             telefone.setTipo("comercial");
             pessoa.getTelefones().add(telefone);
            // session.save(pessoa);             
             //Insere segundo telefone
             Telefones telefoneCel = new Telefones();
             telefoneCel.setNumero("4444-4444");
             telefoneCel.setTipo("celular");
             

             pessoa.getTelefones().add(telefoneCel);
             //Fecha transação
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
