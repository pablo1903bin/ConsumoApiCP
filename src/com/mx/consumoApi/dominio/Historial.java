package com.mx.consumoApi.dominio;

public class Historial {

	String cp, pais, estado, ciudad, municipio, asentamiento, tipo_asentamiento, r_fecha;

	public Historial() {
	}
	
	

	public Historial(String cp) {
		this.cp = cp;
	}



	public Historial(String cp, String pais, String estado, String ciudad, String municipio, String asentamiento,
			String tipo_asentamiento, String r_fecha) {
		this.cp = cp;
		this.pais = pais;
		this.estado = estado;
		this.ciudad = ciudad;
		this.municipio = municipio;
		this.asentamiento = asentamiento;
		this.tipo_asentamiento = tipo_asentamiento;
		this.r_fecha = r_fecha;
	}

	@Override
	public String toString() {
		return "\n- CP=" + cp + " Pais=" + pais + " Estado=" + estado + " Ciudad=" + ciudad + " Municipio="
				+ municipio + " Asentamiento=" + asentamiento + " Tipo de asentamiento=" + tipo_asentamiento
				+ " Fecha de consulta=" + r_fecha + "\n";
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getAsentamiento() {
		return asentamiento;
	}

	public void setAsentamiento(String asentamiento) {
		this.asentamiento = asentamiento;
	}

	public String getTipo_asentamiento() {
		return tipo_asentamiento;
	}

	public void setTipo_asentamiento(String tipo_asentamiento) {
		this.tipo_asentamiento = tipo_asentamiento;
	}

	public String getR_fecha() {
		return r_fecha;
	}

	public void setR_fecha(String r_fecha) {
		this.r_fecha = r_fecha;
	}

}