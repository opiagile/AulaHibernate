package exemploestadolista;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.Session;
import java.util.*;

public class TesteEstado
{
//  public static final SessionFactory sf;
  public static void main (String args[])
  {
   SessionFactory sf;
  try{
     //SessionFactory deve ser criado uma �nica vez durante a execu��o
     //da aplica��o
     sf = new Configuration().configure("HibernateDerby.cfg.xml").buildSessionFactory();
     Session session = sf.openSession(); //Abre sess�o
     //session.beginTransaction();
     List relEstados = session.createQuery("from Estado").list();
     //session.getTransaction().commit();

     for (int i = 0; i < relEstados.size(); i++) {
    	 Estado oEstado = (Estado) relEstados.get(i);
    	 System.out.println("Estado: " + oEstado.getNome() +
    	 " IBGE: " + oEstado.getIbge()+" Area:"+oEstado.getArea());
     }
     //tx.commit(); //Fecha transa��o
     session.close(); //Fecha sess�o
   }
   catch (Throwable ex) {
        // Make sure you log the exception, as it might be swallowed
        System.err.println("Initial SessionFactory creation failed." + ex);
        throw new ExceptionInInitializerError(ex);
   }
  }
}
