
public class Email {
  private String email;
  private int id;
  private Pessoa pessoa;
  public Email(){}
  public String getEmail (){
	  return this.email;
  }
  public void setEmail (String pEmail){
	  this.email = pEmail;
  }
  public int getId (){
	  return this.id;
  }
  public void setId (int pPessoa){
	  this.id = pPessoa;
  }
  public Pessoa getPessoa (){
	  return this.pessoa;
  }
  public void setPessoa (Pessoa pPessoa){
	  this.pessoa = pPessoa;
  }
}
