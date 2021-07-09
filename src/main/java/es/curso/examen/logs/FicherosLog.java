package es.curso.examen.logs;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class FicherosLog {
	
	public static void grabarLog(String linea, String path) {
		// Graba linea en un fichero de log, lo va añadiendo al final
		// Registra la fecha y la hora.
		FileOutputStream fOut = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SS");
		Date ahora = new Date();
		String contenido;
		
		try {
			contenido = sdf.format(ahora) + "\t" + linea + "\n";
			fOut = new FileOutputStream(path, true);			
			fOut.write(contenido.getBytes());
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			
		} finally {
			if (fOut != null) {
				try {
					fOut.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
