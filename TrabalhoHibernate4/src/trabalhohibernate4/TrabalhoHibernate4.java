package trabalhohibernate4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TrabalhoHibernate4 {

    /*
     * Antes de executar ajustar, no arquivo hibernate.cfg.xml, o endereco do banco 
     * contendo a tabela municipios e atualizar os valores do usuario e senha.
     */
    public static void main(String[] args) {

        int opcao = 0;
        String dado = null;
        Estado estado = null;
        Municipio municipio = null;
        SessionFactory sf;
        sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = null;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Digite uma opção");
            System.out.println("1 - Pesquisa por sigla do estado, retorno nome, código e área.");
            System.out.println("2 - Pesquisa por sigla do estado, retorno quantidade de municípios.");
            System.out.println("3 - Pesquisa por sigla do estado, retorno lista municípios.");
            System.out.println("4 - Pesquisa por código IBGE do município, retorno nome do município.");
            System.out.println("5 - Pesquisa por nome do município e sigla do estado, retorno código IBGE do município.");
            System.out.println("0 - Sair.");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite a sigla do estado e precione Enter.");
                    dado = sc.next();
                    session = sf.openSession();
                    estado = new Estado();
                    estado = (Estado) session.createQuery("from Estado where sigla = '" + dado.toUpperCase() + "'").uniqueResult();
                    if (estado != null) {
                        System.out.println("Nome: " + estado.getNome()
                                + "\nCódigo: " + estado.getIbge()
                                + "\nÁrea: " + estado.getArea() + "\n");
                    } else {
                        System.out.println("Estado não localizado");
                    }
                    session.close();
                    break;
                case 2:
                    System.out.println("Digite a sigla do estado e precione Enter.");
                    dado = sc.next();
                    session = sf.openSession();
                    estado = new Estado();
                    estado = (Estado) session.createQuery("from Estado where sigla = '" + dado.toUpperCase() + "'").uniqueResult();
                    if (estado != null) {
                        Set municipios = estado.getMunicipios();
                        System.out.println("O Estado  " + estado.getNome()
                                + " tem " + municipios.size() + " municípios.\n");
                    } else {
                        System.out.println("Estado não localizado");
                    }
                    session.close();
                    break;
                case 3:
                    System.out.println("Digite a sigla do estado e precione Enter.");
                    dado = sc.next();
                    session = sf.openSession();
                    estado = new Estado();
                    estado = (Estado) session.createQuery("from Estado where sigla = '" + dado.toUpperCase() + "'").uniqueResult();
                    if (estado != null) {
                        Set municipios = estado.getMunicipios();
                        System.out.println("Lista Municípios:");
                        for (Municipio m : (Set<Municipio>) municipios) {
                            System.out.println(m.getNome());
                        }
                    } else {
                        System.out.println("Estado não localizado");
                    }
                    session.close();
                    break;
                case 4:
                    System.out.println("Digite o códgio IBGE do Munícipio e precione Enter.");
                    dado = sc.next();
                    session = sf.openSession();
                    municipio = new Municipio();
                    municipio = (Municipio) session.createQuery("from Municipio where ibge = " + dado).uniqueResult();
                    if (municipio != null) {
                        System.out.println("Nome do Município: " + municipio.getNome());
                    } else {
                        System.out.println("Município não localizado");
                    }
                    session.close();
                    break;
                case 5:
                    System.out.println("Digite parte do nome do Munícipio e precione Enter.");
                    dado = sc.next();
                    String nome = dado;
                    System.out.println("Digite a sigla do Estado e precione Enter.");
                    dado = sc.next();
                    session = sf.openSession();
                    estado = new Estado();
                    estado = (Estado) session.createQuery("from Estado where sigla = '" + dado.toUpperCase() + "'").uniqueResult();
                    if (estado != null) {
                        List<Municipio> municipios = (ArrayList<Municipio>) session.createQuery("from Municipio where uf = " + estado.getIbge()
                                + " and upper(nome) like '%" + nome.toUpperCase() + "%'").list();
                        if (!municipios.isEmpty()) {
                            System.out.println("Foram encontrados " + municipios.size() + " municipios:");
                            for (Municipio m : municipios) {
                                System.out.println("Nome do Município: " + m.getNome());
                                System.out.println("Código IBGE do Município: " + m.getIbge());
                            }
                        } else {
                            System.out.println("Município não localizado");
                        }
                    } else {
                        System.out.println("Estado não localizado");
                    }
                    session.close();
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;

            }
        } while (opcao != 0);
    }
}
