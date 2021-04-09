package leerpersona;

public class Persona {

    private String NOMBRE, USERNAME, PASWORD;
    private int ID;

    public Persona(String NOMBRE, String USERNAME, String PASWORD, int ID) {
        this.NOMBRE = NOMBRE;
        this.USERNAME = USERNAME;
        this.PASWORD = PASWORD;
        this.ID = ID;
    }

    Persona(int ID, String NOMBRE, String USERNAME, String PASWORD) {
       
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Persona{" + "NOMBRE=" + NOMBRE + ", USERNAME=" + USERNAME + ", PASWORD=" + PASWORD + ", ID=" + ID + '}';
    }

}
