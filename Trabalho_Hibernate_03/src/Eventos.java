import java.util.Calendar;

public class Eventos {
    
  private Long id;
  private String titulo;
  private Calendar dataevento;
  private String endereco;

    public Eventos() {
    }

    public Calendar getDataevento() {
        return dataevento;
    }

    public void setDataevento(Calendar dataevento) {
        this.dataevento = dataevento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }  
}

