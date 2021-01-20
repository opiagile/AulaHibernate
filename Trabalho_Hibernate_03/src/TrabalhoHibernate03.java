
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;

public class TrabalhoHibernate03 {
    
    public static Session session;
    public static Pessoa pess = new Pessoa();
    public static Transaction tx;
    
    public static void main(String[] args) {
        SessionFactory sf;
        sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        session = sf.openSession(); 
        Transaction tx = session.beginTransaction();
        mostrarMenuPrincipal();  
    }
    private static void mostrarMenuPrincipal(){        
      System.out.print("\r\n");    
      Scanner sc = new Scanner(System.in);
      int opcao;
      System.out.println("1 - Dados Pessoais"); 
      System.out.println("2 - Eventos");         
      System.out.println("3 - Salvar");
      System.out.println("4 - Sair");         
      opcao = sc.nextInt();        
      if (opcao == 1) {
          mostrarMenuPessoa();
      } else if (opcao == 2) {
          mostrarMenuEvento();
      } else {
        tx.commit(); 
        session.close(); 

      }
    }
    
    private static void mostrarMenuPessoa(){        
      System.out.print("\r\n");    
      Scanner sc = new Scanner(System.in);
      int opcao;
      System.out.println("1 - Para Cadastrar Dados Pessoais"); 
      System.out.println("2 - Para Alterar Dados Pessoais"); 
      System.out.println("3 - Para Excluir Dados Pessoais");
      System.out.println("0 - Voltar para o menu anterior");;         
      opcao = sc.nextInt();        
      if (opcao == 1) {
          cadastrarPessoa();
      } else if (opcao == 2) {
          alterarPessoa();
      } else if (opcao == 3) {
          excluirPessoa();
      } else {
          mostrarMenuPrincipal();
      }
    }
    
    private static void cadastrarPessoa(){
      System.out.print("\r\n");    
      Scanner sc = new Scanner(System.in);       
      System.out.println("Digite o nome da pessoa:"); 
      pess.setNome(sc.next()); 
      System.out.println("Digite o sexo da pessoa:"); 
      pess.setSexo(sc.next());             
      System.out.println("Digite a data de nascimento da pessoa (dd/mm/yyyy):"); 
      String data_1 = sc.next();
      String[] valores = data_1.split("/");
      Calendar data = Calendar.getInstance();
      data.set(Integer.parseInt(valores[2]), Integer.parseInt(valores[0]), Integer.parseInt(valores[1]), 0, 0, 0);
      pess.setData_nascimento(data);  

      Telefone tel = new Telefone();
      System.out.println("Digite o tipo do telefone:"); 
      tel.setTipotelefone(sc.next()); 
      System.out.println("Digite o número do telefone:"); 
      tel.setNumerotelefone(sc.next());             

      Email mail = new Email();
      System.out.println("Digite o Email:"); 
      mail.setEmail(sc.next()); 
      
      session.save(pess);
      
      mostrarMenuPessoa();
    }

    private static void alterarPessoa(){
      Pessoa pess_upd = new Pessoa();
      System.out.print("\r\n");    
      Scanner sc = new Scanner(System.in);       
      System.out.println("Digite o Código da pessoa:"); 
      pess_upd.setId(sc.nextLong()); 
      System.out.println("Digite o novo nome da pessoa:"); 
      pess_upd.setNome(sc.next()); 
      System.out.println("Digite o novo sexo da pessoa:"); 
      pess_upd.setNome(sc.next());             
      System.out.println("Digite a nova data de nascimento da pessoa (dd/mm/yyyy):"); 
      String data_1 = sc.next();
      String[] valores = data_1.split("/");
      Calendar data = Calendar.getInstance();
      data.set(Integer.parseInt(valores[2]), Integer.parseInt(valores[0]), Integer.parseInt(valores[1]), 0, 0, 0);
      pess_upd.setData_nascimento(data);  

      Telefone tel = new Telefone();
      System.out.println("Digite o novo tipo do telefone:"); 
      tel.setTipotelefone(sc.next()); 
      System.out.println("Digite o novo número do telefone:"); 
      tel.setNumerotelefone(sc.next());             

      Email mail = new Email();
      System.out.println("Digite o novo Email:"); 
      mail.setEmail(sc.next()); 
      
      session.update(pess);
      
      mostrarMenuPessoa();
    }
    
    private static void excluirPessoa(){
      Pessoa pess_del = new Pessoa();
      System.out.print("\r\n");    
      Scanner sc = new Scanner(System.in);       
      System.out.println("Digite o Código da pessoa:"); 
      pess_del.setId(sc.nextLong()); 

      session.delete(pess_del);
      
      mostrarMenuPessoa();
    }

    private static void mostrarMenuEvento(){        
      System.out.print("\r\n");    
      Scanner sc = new Scanner(System.in);
      int opcao;
      System.out.println("1 - Para Cadastrar Evento"); 
      System.out.println("2 - Para Alterar Evento"); 
      System.out.println("3 - Para Excluir Evento");
      System.out.println("0 - Voltar para o menu anterior");;         
      opcao = sc.nextInt();        
      if (opcao == 1) {
          cadastrarEvento();
      } else if (opcao == 2) {
          alterarEvento();
      } else if (opcao == 3) {
          excluirEvento();
      } else {
          mostrarMenuPrincipal();
      }
    }
    
    private static void cadastrarEvento(){
      System.out.print("\r\n");    
      Eventos event = new Eventos();
      Scanner sc = new Scanner(System.in);       
      System.out.println("Digite o título do evento:"); 
      event.setTitulo(sc.next()); 
      System.out.println("Digite a data do evento (dd/mm/yyyy):"); 
      String data_1 = sc.next();
      String[] valores = data_1.split("/");
      Calendar data = Calendar.getInstance();
      data.set(Integer.parseInt(valores[2]), Integer.parseInt(valores[0]), Integer.parseInt(valores[1]), 0, 0, 0);
      event.setDataevento(data);  

      System.out.println("Digite o endereço do evento:"); 
      event.setEndereco(sc.next()); 

      session.save(event);
      
      mostrarMenuEvento();
    }

    private static void alterarEvento(){
      System.out.print("\r\n");    
      Eventos event_upd = new Eventos();
      Scanner sc = new Scanner(System.in);       
      System.out.println("Digite o novo título do evento:"); 
      event_upd.setTitulo(sc.next()); 
      System.out.println("Digite a nova data do evento (dd/mm/yyyy):"); 
      String data_1 = sc.next();
      String[] valores = data_1.split("/");
      Calendar data = Calendar.getInstance();
      data.set(Integer.parseInt(valores[2]), Integer.parseInt(valores[0]), Integer.parseInt(valores[1]), 0, 0, 0);
      event_upd.setDataevento(data);  
      System.out.println("Digite o novo endereço do evento:"); 
      event_upd.setEndereco(sc.next()); 

      session.update(event_upd);
      
      mostrarMenuEvento();
    }
    
    private static void excluirEvento(){
      Eventos event_del = new Eventos();
      System.out.print("\r\n");    
      Scanner sc = new Scanner(System.in);       
      System.out.println("Digite o Código da evento:"); 
      event_del.setId(sc.nextLong()); 

      session.delete(event_del);
      
      mostrarMenuEvento();
    }    
        
}
