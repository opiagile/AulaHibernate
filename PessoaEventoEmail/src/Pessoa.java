/*
 * Pessoa.java
 *
 * Created on 12 de Julho de 2006, 20:28
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */


/**
 *
 * @author Administrador
 */
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
    
    // Associando a um conjunto de email.
    private Set email = new HashSet();
    public Set getEmail () {
      return email;
    }
    public void setEmail (Set email) {
      this.email = email;
    }

    
}    


    

    

