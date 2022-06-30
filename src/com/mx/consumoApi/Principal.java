package com.mx.consumoApi;

import java.util.Date;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mx.consumoApi.dominio.Historial;
import com.mx.consumoApi.servicio.MetodosImp;

public class Principal {
	public static void main(String[] args) {

		String cp, pais = "", estado = "", ciudad = "", municipio = "", asentamiento = "", tipo_asentamiento = "",
				r_fecha;
		DateFormat df;
		char confirm = ' ';

		int menu = 0;

		MetodosImp impM = new MetodosImp();
		Historial h = null;
		Scanner in = null;
		
		System.out.println("\n\n***Bienvenido consulta de Codigo Postal***\n");
		System.out.println("Seleccione una opcion del menu");

		do {
			try {
				System.out.println("\n1 Consultar codigo postal");
				System.out.println("2 Historial de consultas");
				System.out.println("3 Eliminar historial");
				System.out.println("4 Eliminar registro");
				System.out.println("5 Salir");

				in = new Scanner(System.in);
				menu = in.nextInt();

				switch (menu) {
				case 1:
					System.out.println("\nMenu De Consulta");
					System.out.println("Ingrese Codigo Postal");
					in = new Scanner(System.in);
					cp = in.nextLine();
					try {
						String endpoint_sepomex = "https://api.copomex.com/query/info_cp/";
						String codPos = cp;
						String token = "?token=pruebas";
						String url_sepomex = endpoint_sepomex + codPos + token;

						URL url = new URL(url_sepomex);
						HttpURLConnection conn = (HttpURLConnection) url.openConnection();
						conn.setRequestMethod("GET");
						conn.connect();

						int responseCode = conn.getResponseCode();
						if (responseCode != 200) {
							throw new RuntimeException("Error en codigo postal: " + responseCode);
						} else {
							StringBuilder informationString = new StringBuilder();
							in = new Scanner(url.openStream());
							while (in.hasNext()) {
								informationString.append(in.nextLine());
							}
							in.close();
							JSONArray arregloJson = new JSONArray(informationString.toString());
							JSONObject jsonObject = arregloJson.getJSONObject(0);
							JSONObject respuesta = jsonObject.getJSONObject("response");

							cp = respuesta.getString("cp");
							pais = respuesta.getString("pais");
							estado = respuesta.getString("estado");
							ciudad = respuesta.getString("ciudad");
							municipio = respuesta.getString("municipio");
							asentamiento = respuesta.getString("asentamiento");
							tipo_asentamiento = respuesta.getString("tipo_asentamiento");

							System.out.println("\nCodigo Postal: " + cp);
							System.out.println("Pais: " + pais);
							System.out.println("Estado: " + estado);
							System.out.println("Ciudad: " + ciudad);
							System.out.println("Municipio: " + municipio);
							System.out.println("Asentamiento: " + asentamiento);
							System.out.println("Tipo de asentamiento: " + tipo_asentamiento);
						}
					} catch (Exception e) {
						System.out.println("Error:" + e);
					}
					df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
					Date date = new Date();
					r_fecha = df.format(date);
					h = new Historial(cp, pais, estado, ciudad, municipio, asentamiento, tipo_asentamiento, r_fecha);
					impM.guardar(h);
					break;
				case 2:
					System.out.println("\nOpcion para mostrar registros");
					impM.mostrar();
					break;

				case 3:
					System.out.println("\nOpcion para eliminar historial");
					impM.mostrar();
					System.out.println("\nPreciona la tecla s para confirmar ");
					in = new Scanner(System.in);
					confirm = in.next().charAt(0);
					if (confirm == 's') {
						impM.eliminarTodo();
					} else {
						System.out.println("No se aplicaron los cambios");
					}
					break;
				case 4:
					System.out.println("\nOpcion para eliminar regitro");
					impM.mostrar();

					System.out.println("\nFavor de ingresar CP");
					in = new Scanner(System.in);
					cp = in.nextLine();
					h = new Historial(cp);
					h = (Historial) impM.buscar(h);

					System.out.println("\nFavor de confirmar presionando s ");
					in = new Scanner(System.in);
					confirm = in.next().charAt(0);
					if (confirm == 's') {
						impM.eliminar(h);
						System.out.println("Se elimino " + h);
					} else {
						System.out.println("Cambios no aplicados");
					}
					break;

				case 5:
					System.out.println("Vuelva pronto...");
					break;
				}
			} catch (Exception e) {
				System.out.println("Error" + e);
			}
		} while (menu != 5);
	}
}



