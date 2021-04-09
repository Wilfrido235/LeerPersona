package leerpersona;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseReadOnlyException;

public class Conexion {

    private ObjectContainer oc;

    private void open() {
        this.oc = Db4o.openFile("database.yap");
    }

    public boolean Insertar(Persona objeto) {
        try {
            this.open();
            oc.set(objeto);
            this.oc.close();
            return true;
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("bdoo.Controlador.insertarPersona():" + e);
            return false;
        }
    }
    public Persona buscarPersona(Persona objeto){
        this.open();
        Persona encontrado=null;
        ObjectSet resultados = this.oc.get(objeto);
        
        if (resultados.hasNext()){
            encontrado = (Persona) resultados.next();
        }
        this.oc.close();
        return encontrado;
    }
    
    public boolean Actualizar(Persona objeto) {
        try {
            //BUSCAMOS SI EXISTE EL OBJETO, SI ES ASÍ LO ACTUALIZAMOS EN LA BASE DE DATOS
            this.open();
            ObjectSet resultados = this.oc.get(new Persona(null, null, null, objeto.getID()));
            if (resultados.size() > 0) {                
                Persona resultado = (Persona) resultados.next();
                resultado.setNOMBRE(objeto.getNOMBRE());
                resultado.setUSERNAME(objeto.getUSERNAME());
                resultado.setPASWORD(objeto.getPASWORD());
                this.oc.set(resultado);
                this.oc.close();
                return true;
            } else {
                this.oc.close();
                return false;
            }
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("bdoo.Controlador.insertarPersona() : " + e);
            return false;
        }
    }

    public Persona[] Consultar(Persona objeto) {
        try {
            //CONSULTAMOS LOS OBJETOS ALMACENADOS EN LA BASE DE DATOS Y LOS RETORNAMOS EN UN ARREGLO DE TIPO Persona
            Persona[] personas = null;
            this.open();
            ObjectSet resultados = this.oc.get(objeto);
            int i = 0;
            if (resultados.hasNext()) {
                personas = new Persona[resultados.size()];
                while (resultados.hasNext()) {
                    personas[i] = (Persona) resultados.next();
                    i++;
                }
            }
            this.oc.close();
            return personas;
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("bdoo.Controlador.insertarPersona() : " + e);
            return null;
        }
    }

    public boolean Eliminar(Persona objeto) {
        try {
            //CONSULTAMOS LOS OBJETOS ALMACENADOS EN LA BASE DE DATOS Y SI EXISTE UNA COINCIDENCIA LA ELIMINAMOS            
            this.open();
            ObjectSet resultados = this.oc.get(objeto);
            if (resultados.size() > 0) {
                Persona persona = (Persona) resultados.next();
                this.oc.delete(persona);
                this.oc.close();
                return true;
            } else {
                this.oc.close();
                return false;
            }
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("bdoo.Controlador.insertarPersona() : " + e);
            return false;
        }
    }
}
