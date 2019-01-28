package co.edu.escuelaing.arem.designprimer;
import spark.Request;
import spark.Response;
import static spark.Spark.*;

import java.io.IOException;
import java.util.LinkedList;
public class SparkWebApp {
	public static void main(String[] args) { 
        setPort(4567);
        port(getPort());
        get("/", (req, res) -> calcdataPage(req, res));
        get("/results", (req, res) -> answer(req,res));
    }
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set(i.e. on localhost)
    }
    private static String calcdataPage(Request req, Response res){
        String calcdataHTML = "<!DOCTYPE html>\n" +
"<html>\n" +
"   \n" +
"   <head>\n" +
"      <title>Calculos Estadisticos</title>\n" +
"   </head>\n" +
"	\n" +
"   <body>\n" +
"      <h2>INGRESE SUS DATOS :</h2>\n" +
"      <p>*Se debe de  ingresar los numeros separados por espacios y con \".\" puntos decimales en caso de requerirlo.</p>\n" +                
"       <form action=\"/results\">\n" +
"           Ingrese los datos:<br>\n" +
"           <input type=\"text\" placeholder=\"Separated by spaces\" name=\"datos1\" ><br>\n" +
"           <input type=\"submit\" value=\"Calculate!\">\n" +
"       </form>" +     
//"      <a href = \"http://localhost:9999/results\" target = \"_self\">Ver Resultados</a>\n" +  
"   </body>\n" +
"	\n" +
"</html>";
        return calcdataHTML;
    }
    public static String answer(Request req,Response resp) throws IOException, Exception{
		String numeros = req.queryParams("datos1");
		System.out.println(numeros);
		String[] datosIngresados=numeros.split(" ");
		Operaciones operacion=new Operaciones();
		LinkedList<Double> datos=new LinkedList();
		for(String n:datosIngresados) {
			datos.add(Double.parseDouble(n));
		}
		// calculo de media
		String  media=String.valueOf(operacion.media(datos));
		//Calculo de desvicacion estandar
		String desviacion=String.valueOf(operacion.desviacion(datos));
		
		
		String respuesta="<!doctype html>\n" +
				"<html lang=\"en\">\n" +
				"<head>\n" +
				"    <meta charset=\"UTF-8\">\n" +
				"    <meta name=\"viewport\"\n" +
				"          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
				"    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
				"    <title>Document</title>\n" +
				"</head>\n" +
				"<body>\n" +
				"La media para los datos ingresados es: "+media+"\n"+"<br>"+
				"La desviacion para los datos ingresados  es: "+desviacion+"\n"+"<br>"+
				"\n" +
				"</body>\n" +
				"</html>";
		return respuesta;
}
}