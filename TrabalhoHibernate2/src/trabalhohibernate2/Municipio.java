package trabalhohibernate2;

public class Municipio {
  private Long ibge;
  private int uf;
  private String nome;
  private double area;
  Municipio() {}

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Long getIbge() {
        return ibge;
    }

    public void setIbge(Long ibge) {
        this.ibge = ibge;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getUf() {
        return uf;
    }

    public void setUf(int uf) {
        this.uf = uf;
    }
  
  
}