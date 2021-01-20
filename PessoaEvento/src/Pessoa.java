import java.util.*;
import java.util.Calendar;

public class Pessoa {
    private Long id;
    private Calendar dataNascimento;
    private String nome;
    private char   sexo;    
    /** Creates a new instance of Pessoa */
    public Pessoa() {
    }
    public Long getId() {
        return id;
    }
    private void setId(Long pId) {
        this.id = pId;
    }
    public Calendar getDataNascimento()
    {
        return dataNascimento;
    }
    public void setDataNascimento (Calendar pData)
    {
        this.dataNascimento = pData;
    }
    public String getNome ()
    {
        return nome;
    }
    public void setNome (String pNome)
    {
        this.nome = pNome;
    }    
    public char getSexo ()
    {
        return sexo;
    }
    public void setSexo (char pSexo)
    {
        this.sexo = pSexo;
    }
    
    // Associando a um conjunto de eventos.
    private Set events = new HashSet();
    public Set getEvents() {
      return events;
    }
    public void setEvents(Set events) {
      this.events = events;
    }
    
}    


    

    

