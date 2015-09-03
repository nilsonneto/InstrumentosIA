package jena;

public class InstrumentosBean {
	private String rdf;
	private String feitoDe;
	private String tipoInstrumento;
	private Integer numeroCordas;
	private Boolean temPes;
	private float mediaPreco;
	private float minPreco;
	private float maxPreco;
	
	public String getRdf() {
		return rdf;
	}

	public void setRdf(String rdf) {
		this.rdf = rdf;
	}
	
	public String getFeitoDe() {
		return feitoDe;
	}

	public void setFeitoDe(String feitoDe) {
		this.feitoDe = feitoDe;
	}

	public String getTipoInstrumento() {
		return tipoInstrumento;
	}

	public void setTipoInstrumento(String tipoInstrumento) {
		this.tipoInstrumento = tipoInstrumento;
	}

	public Integer getNumeroCordas() {
		return numeroCordas;
	}

	public void setNumeroCordas(Integer integer) {
		this.numeroCordas = integer;
	}

	public Boolean getTemPes() {
		return temPes;
	}

	public void setTemPes(Boolean temPes) {
		this.temPes = temPes;
	}

	public float getMediaPreco() {
		return mediaPreco;
	}

	public void setMediaPreco(float mediaPreco) {
		this.mediaPreco = mediaPreco;
	}

	public float getMinPreco() {
		return minPreco;
	}

	public void setMinPreco(float minPreco) {
		this.minPreco = minPreco;
	}

	public float getMaxPreco() {
		return maxPreco;
	}

	public void setMaxPreco(float maxPreco) {
		this.maxPreco = maxPreco;
	}
}
