
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {

private static  String URL="jdbc:mysql://localhost:3306/Database1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=flase&serverTimezone=UTC";
 private static final String usuario="root";
private static final String contraseña="Kantus067";

static {
	try {Class.forName("com.mysql.cj.jdbc.Driver");
		
	}catch (ClassNotFoundException e) {
		 System.out.println("ERROR al cagar la conexion");
		e.printStackTrace();
	}
}
	
			public Connection conectar() {
	Connection conexion=null;
		 try {
			 
			 conexion=DriverManager.getConnection(URL,usuario,contraseña);
			 System.out.println("conexion ok");
		 }catch(SQLException e){
				 System.out.println("ERROR al cagar la conexion");
				 e.printStackTrace();
		 }
		return conexion;
	}

}