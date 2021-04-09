package leerpersona;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JMalagon
 */
public class Controlador extends Conexion {

    public Controlador() {

    }

    public boolean insertarPersona(String NOMBRE, String USERNAME, String PASWORD, int Id) {
        Persona persona = new Persona(Id,NOMBRE,USERNAME,PASWORD);
        return this.Insertar(persona);
    }

    public boolean actualizarPersona(String NOMBRE, String USERNAME, String PASWORD, int Id) {
        Persona personaNueva = new Persona(Id,NOMBRE,USERNAME,PASWORD);        
        return this.Actualizar(personaNueva);
    }

    public DefaultTableModel personas() {
        String titulos[] = {"ID", "NOMBRE", "USERNAME","ID"};
        DefaultTableModel dtm = new DefaultTableModel(null, titulos);
        Persona persona = null;
        Persona[] p = this.Consultar(persona);
        if (p != null) {
            for (Persona per : p) {
                Object[] cli = new Object[3];
                cli[0] = per.getId();
                cli[1] = per.getNOMBRE();
                cli[2] = per.getUSERNAME();
                cli[3] = per.getPASWORD();
                dtm.addRow(cli);
            }
        }
        return dtm;
    }

    public boolean eliminarPersona(int id) {
        if (id > 0) {
            Persona persona = new Persona(null, null, null, id);
            return this.Eliminar(persona);
        } else {
            return false;
        }
    }
}
