
public class Telefone {
  private Long id;
  private String numerotelefone;
  private String tipotelefone;

    public Telefone() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumerotelefone() {
        return numerotelefone;
    }

    public void setNumerotelefone(String numerotelefone) {
        this.numerotelefone = numerotelefone;
    }

    public String getTipotelefone() {
        return tipotelefone;
    }

    public void setTipotelefone(String tipotelefone) {
        this.tipotelefone = tipotelefone;
    }      
}
