package exemploestadolista;

public class Estado {
  private Long ibge;
  private String nome;
  private String sigla;
  private double area;
  Estado() {}
  public Long getIbge() {
    return ibge;
  }
  public void setIbge(Long pIBGE) {
    this.ibge = pIBGE;
  }
  public String getNome() {
    return nome;
  }
  public void setNome(String pNome) {
    this.nome = pNome;
  }
  public String getSigla() {
    return this.sigla;
  }
  public void setSigla(String pSigla) {
    this.sigla = pSigla;
  }
  public double getArea() {
    return area;
  }
  public void setArea(double pArea) {
    this.area = pArea;
  }
}

