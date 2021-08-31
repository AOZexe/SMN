import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class testconexion {
	static conexion conexion = new conexion();
	 static Connection cn=null;
	 static Statement stm =null;
	static ResultSet rs = null;
	public static String Consultas() {
		String c="", a="";
		try {
			 cn=conexion.conectar();
			 stm=cn.createStatement();
			 rs=stm.executeQuery("SELECT  *  FROM Escuadron");
			 while(rs.next()) {
				 int idEsc=rs.getInt(1);
				int part=rs.getInt(2);
				// String clave=rs.getString(3);
				 a="\n"+idEsc+"-"+part;
				 c=c+a;
			 }
				
			}catch(SQLException e) {
		}finally {
			try {
				if(cn!=null) {
					cn.close();
				}
				if(stm!=null) {
					stm.close();
				}
				if(rs!=null) {
					rs.close();
				}
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return c;
		
	}
	public void agregar(String nombre, String clave) {
		String c="", a="";
		try {
			 cn=conexion.conectar();
			 stm=cn.createStatement();
			 String query = "INSERT INTO Usuario (idUsuario,NombUsu,Clave)VALUES ("+0+",'"+nombre+"','"+clave+"')";
stm.executeUpdate(query);
JOptionPane.showMessageDialog(null, "Se agrego un nuevo registro");

} catch (SQLException e) {

JOptionPane.showMessageDialog(null, "ERROR!!! "+e);
e.printStackTrace();

} finally { 

try {
	
	if(cn!=null) cn.close();
	if(stm!=null) stm.close();
	
	
} catch (Exception e2) {
	e2.printStackTrace();
}

}
		
	}
	
	public void eliminar(String nombre) {
		try {

			cn = conexion.conectar();
			stm = cn.createStatement();

			String query = "DELETE FROM Usuario WHERE NombUsu = '" +nombre+ "'";
			stm.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "SE ELIMINO EL REGISTRO");
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado: "+e);
			e.printStackTrace();
			
		} finally { 
			
			try {
				
				if(cn!=null) cn.close();
				if(stm!=null) stm.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
	}
public void modificar(int id,String nombre,String clave)  {
		
		try {
			
			cn = conexion.conectar();
			stm = cn.createStatement();
			
			String query = "UPDATE usuario SET NombUsu = '"+nombre+"',clave='"+clave+"' WHERE idUsuario = "+id;
			stm.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "SE EDITO EL REGISTRO PARA EL USUARIO ["+id+"]");
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado: "+e);
			e.printStackTrace();
			
		} finally { //CERRANDO LOS OBJETOS DE CONSULTA
			
			try {
				
				if(cn!=null) cn.close();
				if(stm!=null) stm.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
	}
	
	public static void iniciaventana() {
		Formulario start =new Formulario();
		start.setVisible(true);
	}
public static void main (String[]args) {
	iniciaventana();
 /*try {
		 cn=conexion.conectar();
			stm=cn.createStatement();
			rs=stm.executeQuery("SELECT  *  FROM usuario");
			while(rs.next()) {
				int idUsuario=rs.getInt(1);
				String NombUsu= rs.getString(2);
				String clave = rs.getString(3);
				System.out.println(idUsuario + " - "+NombUsu + " - " + clave	);
			}
	 }catch(SQLException e) {
		 e.printStackTrace();
	 }finally {
		 try {
			 if(rs!=null) {
				 rs.close();
			 }
			 if(stm!=null) {
				 stm.close();
			 }
			 if(cn!=null) {
				 cn.close();
			 }
			 
		 }catch(Exception e2) {
			 e2.printStackTrace();
		 }
}*/
}
}