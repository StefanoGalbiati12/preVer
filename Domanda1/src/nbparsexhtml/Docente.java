package nbparsexhtml;

public class Docente {
    private int codice;
    private String docente;
    private String giorno;
    private String ora;
   

    public Docente() {
        this.codice = 0;
        this.docente = "";
        this.giorno = "";
        this.ora = "";
        
    }

      public Docente( int codice,String docente, String giorno, String ora) {
         this.codice = codice;
          this.docente = docente;
        this.giorno = giorno;
        this.ora = ora;
       
    }
      
       public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getGiorno() {
        return giorno;
    }

    public void setGiorno(String giorno) {
        this.giorno = giorno;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }
    
      public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

   
    
    public String toString() {
        return "[" + codice + "] " + docente + ", " + giorno + " (" + ora + ")";
    }
}
