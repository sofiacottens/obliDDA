package dominio;
import dominio.Sector.SectorException;
import dominio.Sector.SistemaSector;
import dominio.trabajador.SistemaTrabajador;
import dominio.trabajador.TrabajadorException;
import dominio.sistema.Llamada;
import dominio.sistema.PuestoDeTrabajo;
import dominio.sistema.Sector;
import dominio.sistema.SistemaLlamada;
import dominio.trabajador.Sesion;
import dominio.trabajador.Trabajador;
import java.util.Date;
import java.util.List;
import observer.Observable;

public class Sistema extends Observable {

    private static Sistema instancia = new Sistema();
    private SistemaTrabajador st = new SistemaTrabajador();
    private SistemaSector ss = new SistemaSector();
    private SistemaLlamada sl = new SistemaLlamada();

    public static Sistema getInstancia() {
        return instancia;
    }

    public Sesion loginTrabajador(String usuario, String password) throws TrabajadorException {
        return st.login(usuario, password);
    }
    public Trabajador crearTrabajador(String cedula, String password, String nombreCompleto, Sector sector) throws TrabajadorException {
        return st.crearTrabajador(cedula, password, nombreCompleto, sector);
    }
    
    public PuestoDeTrabajo crearPuestoDeTrabajo(double tiempoPromedio, int llamadasAtendidas){
        return ss.crearPuestoDeTrabajo(tiempoPromedio, llamadasAtendidas);
    }
    
    public Sector crearSector(String nombre, int numero, int cantidadPuestos){
        return ss.crearSector(nombre, numero, cantidadPuestos);
    }
    
    public List<Sector> getSectores() {
        return ss.getSectores();
    }

    public void agregarPuestoEnSector(PuestoDeTrabajo p, Sector s) {
        ss.agregarPuestoEnSector(p,s);
    }

    public Llamada crearLlamada(Date fechaInicio, Sector s) {
        return ss.crearLlamada(fechaInicio, s);

    }
    public void registrarUsuario(
            String cedula,
            String password,
            String nombreCompleto, 
            Sector sector) throws TrabajadorException {
        st.crearTrabajador(cedula, password, nombreCompleto, sector);
    }
   
    public List<Sesion> getLogueados() {
        return st.getLogueados();

    }

    public int numeroDePuestoDeTrabajo(Trabajador trabajador) {
        return ss.numeroDePuestoDeTrabajo(trabajador);
    }

    public String cantidadLlamadasAtendidas(Trabajador trabajador) {
        return ss.cantidadLlamadasAtendidas(trabajador);
    }

    public String tiempoPromedioLlamada(Trabajador trabajador) {
        return ss.tiempoPromedioLlamada(trabajador);

    }


    public void finalizarLlamada(Trabajador trabajador, Llamada llamada, String descripcion) {
        sl.finalizarLlamada(trabajador, llamada, descripcion);
    }

    public String costoLlamada(Llamada llamada) {
        return sl.costoLlamada(llamada);
    }

    public void agregarSectorATrabajador(Trabajador t, Sector sector) throws SectorException {
        ss.agregarSectorATrabajador(t,sector);

    }
}
