package lab7_diegomatamoros;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class administrarLugares {
    ArrayList<lugar>lugares=new ArrayList();
    File archivo=null;

    public administrarLugares (String path) {
        archivo = new File(path);
    }

    public ArrayList<lugar> getLugares() {
        return lugares;
    }

    public void setLugares(ArrayList<lugar> lugares) {
        this.lugares = lugares;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    //extra mutador
    public void setLugar(lugar p) {
        this.lugares.add(p);
    }
     public void cargarArchivo() {
        try {
            lugares = new ArrayList();
            lugar temp;
            if (archivo.exists()) {
                FileInputStream entrada = new FileInputStream(archivo);
                ObjectInputStream objeto = new ObjectInputStream(entrada);
                try {
                    while ((temp = (lugar) objeto.readObject()) != null) {
                        lugares.add(temp);
                    }
                } catch (EOFException e) {
                    //encontro el final del archivo
                }
                objeto.close();
                entrada.close();
            }//fin if
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void escribirArchivo() {
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        try {
            fw = new FileOutputStream(archivo);
            bw = new ObjectOutputStream(fw);
            for (lugar t : lugares) {
                bw.writeObject(t);
            }
            bw.flush();
        } catch (Exception e) {
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception e) {
            }
        }
    }
}
