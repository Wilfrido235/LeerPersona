package leerpersona;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JMalagon
 */
public class Controlador extends Conexion {

    public Controlador() {

    }

     boolean insertarPersona(int Id,String NOMBRE, String USERNAME, String PASWORD) {
        Persona persona = new Persona(Id,NOMBRE,USERNAME,PASWORD);
        return this.Insertar(persona);
    }

    public boolean actualizarPersona(int Id,String NOMBRE, String USERNAME, String PASWORD) {
        Persona personaNueva = new Persona(Id,NOMBRE,USERNAME,PASWORD);        
        return this.Actualizar(personaNueva);
    }

    public DefaultTableModel personas() {
        String titulos[] = {"Id", "NOMBRE", "USERNAME","PASWORD"};
        DefaultTableModel dtm = new DefaultTableModel(null,titulos);
        Persona persona = null;
        Persona[] p = this.Consultar(persona);
        if (p != null) {
            for (Persona per : p) {
                Object[] cli = new Object[4];
                cli[0] = per.getId();
                cli[1] = per.getNOMBRE();
                cli[2] = per.getUSERNAME();
                cli[3] = per.getPASWORD();
                dtm.addRow(cli);
            }
        }
        return dtm;
    }
}
