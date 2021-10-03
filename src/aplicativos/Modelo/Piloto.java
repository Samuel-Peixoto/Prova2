package aplicativos.Modelo;

import aplicativos.Pessoa;

public class Piloto extends Pessoa{
    
    private int matricula;
    private String cadrasto;
      
       public int getMatricula() {
         return matricula;
       }
       public void setMatricula(int matricula) {
         this.matricula = matricula;
       }
       public String getCadrasto() {
         return cadrasto;
       }
       public void setCadrasto(String cadrasto) {
       this.cadrasto = cadrasto;
       }    
      
  }

