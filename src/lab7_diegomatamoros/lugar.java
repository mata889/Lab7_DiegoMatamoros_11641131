
package lab7_diegomatamoros;

public class lugar extends Thread {
String nombre,clima,extension,zona,año;
int habitantes;

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
        return nombre ;
    }

    @Override
    public void run() {
        
    }
    
}
