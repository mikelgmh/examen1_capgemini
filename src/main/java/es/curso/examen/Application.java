package es.curso.examen;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import es.curso.examen.dao.EmpleadoDAO;
import es.curso.examen.dao.IEmpleadoDAO;
import es.curso.examen.logs.FicherosLog;
import es.curso.examen.modelo.Empleado;

public class Application {

	public static void main(String[] args) {
		ejemploGrabarEnElLog();
		pruebaConXML();
		//pruebaConAnotaciones();
	}

	private static void ejemploGrabarEnElLog() {
		// Codigo de prueba para ver como se utiliza el metodo grabarLog de la clase
		// FicherosLog

		// Grabamos una linea en el fichero de Log:
		/*
		 * FicherosLog.grabarLog("contenido de la linea de log", "src/logs/mi_log.txt");
		 * FicherosLog.grabarLog("Otra linea de log", "src/logs/mi_log.txt");
		 * FicherosLog.grabarLog("Una tercera linea de log", "src/logs/mi_log.txt");
		 */
	}

	private static void pruebaConAnotaciones() {
		ApplicationContext context;
		context = new FileSystemXmlApplicationContext("classpath:applicationContextAnnotations.xml");
		
		IEmpleadoDAO iEmpleadoDAO = (IEmpleadoDAO) context.getBean("empleadodao");
		Empleado empleado = new Empleado(0001, "Empleado1", "Capgemini", "Perfil1");
		
		// CRUD
		iEmpleadoDAO.create(empleado);
		iEmpleadoDAO.delete(0001);
		iEmpleadoDAO.update(empleado);
		
		((FileSystemXmlApplicationContext) context).close();

	}

	private static void pruebaConXML() {
		ApplicationContext context;
		context = new FileSystemXmlApplicationContext("classpath:applicationContextAnnotations.xml");
		
		IEmpleadoDAO iEmpleadoDAO = (IEmpleadoDAO) context.getBean("empleadodao");
		Empleado empleado = new Empleado(0001, "Empleado1", "Capgemini", "Perfil1");
		
		// CRUD
		iEmpleadoDAO.create(empleado);
		iEmpleadoDAO.delete(0001);
		iEmpleadoDAO.update(empleado);
		
		((FileSystemXmlApplicationContext) context).close();

	}

}
