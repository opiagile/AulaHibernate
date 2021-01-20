

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Pessoa {

    private Long id;
    private String nome;
    private String sexo;
    private Calendar data_nascimento;

    public Pessoa() {
    }

    public Calendar getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Calendar data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    } 
    
    // Associando a um conjunto de eventos.
    private Set Eventos = new HashSet();
    public Set getEventos() {
      return Eventos;
    }
    public void setEventos(Set eventos) {
      this.Eventos = eventos;
    }

    // Associando a um conjunto de palestras.
    private Set Palestras = new HashSet();
    public Set getPalestras() {
      return Palestras;
    }
    public void setPalestras(Set Palestras) {
      this.Palestras = Palestras;
    }

    // Associando a um conjunto de telefone.
    private Set Telefone = new HashSet();
    public Set getTelefone() {
      return Telefone;
    }
    public void setTelefone(Set Telefone) {
      this.Telefone = Telefone;
    }

    // Associando a um conjunto de telefone.
    private Set Email = new HashSet();
    public Set getEmail() {
      return Email;
    }
    public void setEmail(Set Email) {
      this.Email = Email;
    }
    
}
