package lab7_diegomatamoros;

import java.io.Serializable;
import javax.swing.table.DefaultTableModel;

public class lugar extends Thread implements Serializable {

    String nombre, clima, extension, zona, año;
    int habitantes;
    private static final long SerialVersionUID = 777L;

    public lugar() {
    }

    public lugar(String nombre, String clima, String extension, String zona, String año, int habitantes) {
        this.nombre = nombre;
        this.clima = clima;
        this.extension = extension;
        this.zona = zona;
        this.año = año;
        this.habitantes = habitantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public int getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public void run() {

        try {

            Principal p = new Principal();
            tabla tabla = new tabla();
            tabla.setVisible(true);

            while (true) {
                tabla.jt_personas.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][]{},
                        new String[]{
                            "nombre", "Id", "lugar", "edad", "estatura", "profesion"
                        }) {
                    boolean[] canEdit = new boolean[]{
                        false, false, false, false, false, false
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });
                DefaultTableModel model = (DefaultTableModel) tabla.jt_personas.getModel();
                String titulo = nombre;
                tabla.lable_tabla.setText(nombre);

                administrarPersona ap = new administrarPersona("./persona.cbm");
                ap.cargarArchivo();

                //String nombre,id,lugar,edad,estatura,profesion;
                for (int i = 0; i < ap.listaPersonas.size(); i++) {
                    if (ap.listaPersonas.get(i).lugar.equals(titulo)) {
                        model.addRow(new Object[]{ap.listaPersonas.get(i).getNombre(), ap.listaPersonas.get(i).getId(), ap.listaPersonas.get(i).getLugar(),
                            ap.listaPersonas.get(i).getEdad(), ap.listaPersonas.get(i).getEstatura(), ap.listaPersonas.get(i).getProfesion()});
                    }
                }

                try {
                    Thread.sleep(1000);

                } catch (Exception e) {
                }
            }

        } catch (Exception e) {
        }

    }
}
