package leerpersona;

public class Persona {

    private String NOMBRE, USERNAME, PASWORD;
    private int Id;

    public Persona(String NOMBRE, String USERNAME, String PASWORD, int Id) {
        this.NOMBRE = NOMBRE;
        this.USERNAME = USERNAME;
        this.PASWORD = PASWORD;
        this.Id = Id;
    }

    Persona(int Id, String NOMBRE, String USERNAME, String PASWORD) {
        
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getPASWORD() {
        return PASWORD;
    }

    public void setPASWORD(String PASWORD) {
        this.PASWORD = PASWORD;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    @Override
    public String toString() {
        return "Persona{" + "NOMBRE=" + NOMBRE + ", USERNAME=" + USERNAME + ", PASWORD=" + PASWORD + ", Id=" + Id + '}';
    }

   
}
