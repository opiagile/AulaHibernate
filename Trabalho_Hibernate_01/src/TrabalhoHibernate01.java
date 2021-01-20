
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;

public class TrabalhoHibernate01 {
    

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int opcao;
      System.out.println("Informa o c�digo da a��o desejada:");
      System.out.println("1 - Para inserir uma pessoa");
      System.out.println("2 - Para listar pessoa(s) cadstrada(s)");
      opcao = sc.nextInt();
      if (opcao == 1) {
         Pessoa pess = new Pessoa();
         System.out.println("Digite o nome da pessoa:"); 
         pess.setNome(sc.next());
         System.out.println("Digite o sexo da pessoa:"); 
         pess.setSexo(sc.next());
         System.out.println("Digite a data de nascimento da pessoa (dd/mm/yyyy):"); 
         String data = sc.next();
         String[] valores = data.split("/");
         Date dataNascimento = new Date(Integer.parseInt(valores[2]), Integer.parseInt(valores[1]), Integer.parseInt(valores[0])); 
         pess.setData_nascimento(dataNascimento);         
         inserirPessoa(pess);
      } else if (opcao == 2) {
          listarPessoa();
      } else {
          
      }
    }
    private static void listarPessoa(){
          try{
             SessionFactory sf; 
             sf = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
             Session session = sf.openSession(); //Abre sess�o
             Transaction tx = session.beginTransaction(); //Criar transa��o
             //Busca lista de pessoas
             List relPessoas = session.createQuery("from Pessoa").list();

             for (int i = 0; i < relPessoas.size(); i++) {
                 Pessoa oPessoa = (Pessoa) relPessoas.get(i);
                 System.out.println("Nome: " + oPessoa.getNome() +
                 " Sexo: " + oPessoa.getSexo()+" Data Nascimento: "+oPessoa.getData_nascimento().toString());
             }
             tx.commit(); //Fecha trans��o
             session.close(); //Fecha sess�o
           }
           catch (Throwable ex) {
                System.err.println("Falha na cria��o da sess�o." + ex);
                throw new ExceptionInInitializerError(ex);
           }
        
    }
    public static void inserirPessoa(Pessoa pessoa){
          SessionFactory sf;
          try{
             sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
             Session session = sf.openSession(); //Abre sess�o         
             Transaction tx = session.beginTransaction(); //Cria transa��o
             // Insere uma pessoa
             session.save(pessoa);             
             tx.commit(); //Fecha transa��o
             session.close(); //Fecha sess�o    
           }
           catch (Throwable ex) {
                System.err.println("Falha ao iniciar a Sess�o." + ex);
                throw new ExceptionInInitializerError(ex);
           }        
    }    
}
