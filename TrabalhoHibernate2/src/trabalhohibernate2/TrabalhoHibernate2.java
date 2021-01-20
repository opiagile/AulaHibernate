package trabalhohibernate2;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.Session;
import java.util.*;
public class TrabalhoHibernate2 {

    public static void main(String[] args) {
        /*
         * Antes de executar ajustar, no arquivo hibernate.cfg.xml, o endereco do banco 
         * contendo a tabela municipios e atualizar os valores do usuario e senha.
         */
        
        SessionFactory sf;
        try {
            //SessionFactory deve ser criado uma única vez durante a execução
            //da aplicação
            sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession(); //Abre sessão
            
            List relMunicipios = session.createQuery("from Municipio").list();
            
            System.out.println("############Lista de Municípios#############");
            for (int i = 0; i < relMunicipios.size(); i++) {
                Municipio oMunicipio = (Municipio) relMunicipios.get(i);
                System.out.println("Município: " + oMunicipio.getNome()
                        + " IBGE: " + oMunicipio.getIbge() + " Area:" + oMunicipio.getArea()
                        + " Codigo Estado: " + oMunicipio.getUf());
            }
            System.out.println("############################################");
            
            session.close(); //Fecha sessão
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}
