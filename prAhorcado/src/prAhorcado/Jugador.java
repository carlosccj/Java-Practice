package prAhorcado;

public class Jugador {
	
	private int id;
	private String nombre;
	private String apellidos;
	private String email;
	private String password;
	private String nick;
	private boolean logeado;
	private int bandejaEntrada;
	private Estadisticas estadisticas;
	
	 //Aquí hay que comprobar que el id, el email o la contraseña no se encuentran ya en la base de datos (Exception)
	
	public Jugador(int id, String nombre, String apellidos, String email, String password, String nick) throws Exception {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.nick = nick;
		this.logeado = false;
		this.bandejaEntrada = 0;
		this.estadisticas = new Estadisticas(); //constructor por defecto para un jugador que nunca ha jugado antes
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getApellidos() {
		return this.apellidos;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNick() {
		return this.nick;
	}
	
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public boolean getLogueado() {
		return this.logeado;
	}
	
	public void setLogueado(boolean logueado) {
		this.logeado = logueado;
	}
	
	public int getBandejaEntrada() {
		return this.bandejaEntrada;
	}
	
	public void ganarPartida() {
		this.estadisticas.incPartidasGanadas();
	}
	
	public void perderPartida() {
		this.estadisticas.incPartidasPerdidas();
	}
	
	// ¿Dos jugadores pueden tener el mismo nick?
	
	@Override
	public boolean equals(Object x) {
		boolean ok = false;
		if (x instanceof Jugador) {
			Jugador other = (Jugador) x;
			ok = (this.getId() == other.getId() 
					|| this.getEmail().equalsIgnoreCase( other.getEmail()) 
					|| this.getPassword().equalsIgnoreCase(other.getPassword()));
		}
		return ok;
	}
	
	@Override
	public int hashCode() {
		return this.getId() + this.getEmail().toLowerCase().hashCode() + this.getPassword().toLowerCase().hashCode();
	}
}
