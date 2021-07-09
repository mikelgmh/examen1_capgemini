package es.curso.examen.modelo;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import es.curso.examen.logs.FicherosLog;

@Aspect
public class Log implements ILog {

	@Autowired
	private Empleado empleado;

	public Log(Empleado empleado) {
		super();
		this.empleado = empleado;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Log() {
		super();
	}

	@Pointcut(value = "execution(* es.curso.examen.dao.IEmpleadoDAO.create(es.curso.examen.modelo.Empleado)) && args(empleado)")
	public void pointCutCreate(Empleado empleado) {
	};

	@Pointcut(value = "execution(* es.curso.examen.dao.IEmpleadoDAO.delete(int)) && args(codigo)")
	public void pointCutDelete(int id) {
	};

	@Pointcut(value = "execution(* es.curso.examen.dao.IEmpleadoDAO.update(es.curso.examen.modelo.Empleado)) && args(empleado)")
	public void pointCutUpdate(Empleado empleado) {
	};

	@AfterReturning("pointCutCreate(empleado)")
	@Override
	public void createUsuario(Empleado empleado) {
		System.out.println("Nueva línea en el log");
		FicherosLog.grabarLog("Usuario creado: " + empleado.toString(), "src/logs/mi_log.txt");
	}

	@AfterReturning("pointCutDelete(id)")
	@Override
	public void deleteUsuario(int empleado) {
		System.out.println("Nueva línea en el log");
		FicherosLog.grabarLog("Usuario eliminado: " + empleado, "src/logs/mi_log.txt");
	}

	@AfterReturning("pointCutUpdate(empleado)")
	@Override
	public void updateUsuario(Empleado empleado) {
		System.out.println("Nueva línea en el log");
		FicherosLog.grabarLog("Usuario actualizado: " + empleado.toString(), "src/logs/mi_log.txt");
	}

}
