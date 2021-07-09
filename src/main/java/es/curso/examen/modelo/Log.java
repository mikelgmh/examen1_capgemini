package es.curso.examen.modelo;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.curso.examen.logs.FicherosLog;

@Component
@Aspect
public class Log implements ILog {

	@Autowired(required = false)
	private Empleado empleado;

	public Log() {
		super();
	}

	public Log(Empleado empleado) {
		super();
		this.empleado = empleado;
	}

	@Pointcut(value = "execution(* es.curso.examen.modelo.IEmpleado.create(es.curso.examen.modelo.Empleado))")
	public void pointCutCreate(Empleado empleado) {
	};

	@Pointcut(value = "execution(* es.curso.examen.modelo.IEmpleado.delete(..))")
	public void pointCutDelete(int id) {
	};

	@Pointcut(value = "execution(* es.curso.examen.modelo.IEmpleado.create(es.curso.examen.modelo.Empleado))")
	public void pointCutUpdate(Empleado empleado) {
	};

	@After("pointCutCreate(empleado)")
	public void createUsuario() {
		FicherosLog.grabarLog("Usuario creado: " + empleado.toString(), "src/logs/mi_log.txt");
	}

	@After("pointCutDelete(empleado)")
	public void deleteUsuario() {
		FicherosLog.grabarLog("Usuario eliminado: " + empleado.toString(), "src/logs/mi_log.txt");
	}

	@After("pointCutUpdate(empleado)")
	public void updateUsuario() {
		FicherosLog.grabarLog("Usuario actualizado: " + empleado.toString(), "src/logs/mi_log.txt");
	}

}
