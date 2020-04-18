package builder.base;

public class Bolo {	
	private TipoDaMassa tipoDaMassa;
	private SaborDaMassa saborDaMassa;
	private TipoDaCobertura tipoDaCobertura;
	private SaborDaCobertura saborDaCobertura;
	private TipoDoRecheio tipoDoRecheio;
	private SaborDoRecheio saborDoRecheio;
	private boolean frio;
	private int camadasDeMassa;

	private Bolo() {
		
	}
	public Bolo(TipoDaMassa tipoDaMassa, SaborDaMassa saborDaMassa, TipoDaCobertura tipoDaCobertura,
			SaborDaCobertura saborDaCobertura, TipoDoRecheio tipoDoRecheio, SaborDoRecheio saborDoRecheio, boolean frio,
			int camadasDeMassa) {
		this.tipoDaMassa = tipoDaMassa;
		this.saborDaMassa = saborDaMassa;
		this.tipoDaCobertura = tipoDaCobertura;
		this.saborDaCobertura = saborDaCobertura;
		this.tipoDoRecheio = tipoDoRecheio;
		this.saborDoRecheio = saborDoRecheio;
		this.frio = frio;
		this.camadasDeMassa = camadasDeMassa;
	}

	public Bolo(TipoDaMassa tipoDaMassa, SaborDaMassa saborDaMassa, TipoDoRecheio tipoDoRecheio,
			SaborDoRecheio saborDoRecheio, boolean frio, int camadasDeMassa) {
		this.tipoDaMassa = tipoDaMassa;
		this.saborDaMassa = saborDaMassa;
		this.tipoDaCobertura = null;
		this.saborDaCobertura = null;
		this.tipoDoRecheio = tipoDoRecheio;
		this.saborDoRecheio = saborDoRecheio;
		this.frio = frio;
		this.camadasDeMassa = camadasDeMassa;
	}
	
	public Bolo(TipoDaMassa tipoDaMassa, SaborDaMassa saborDaMassa, boolean frio, int camadasDeMassa) {
		this.tipoDaMassa = tipoDaMassa;
		this.saborDaMassa = saborDaMassa;
		this.tipoDaCobertura = null;
		this.saborDaCobertura = null;
		this.tipoDoRecheio = null;
		this.saborDoRecheio = null;
		this.frio = frio;
		this.camadasDeMassa = camadasDeMassa;
	}

	public static class Builder {
		private TipoDaMassa tipoDaMassa;
		private SaborDaMassa saborDaMassa;
		private TipoDaCobertura tipoDaCobertura;
		private SaborDaCobertura saborDaCobertura;
		private TipoDoRecheio tipoDoRecheio;
		private SaborDoRecheio saborDoRecheio;
		private boolean frio;
		private int camadasDeMassa;
		
		public Builder massa(TipoDaMassa tipoDaMassa, SaborDaMassa saborDaMassa) {
			this.tipoDaMassa = tipoDaMassa;
			this.saborDaMassa = saborDaMassa;
			return this;
		}

		public Builder cobertura(TipoDaCobertura tipoDaCobertura, SaborDaCobertura saborDaCobertura) {
			this.tipoDaCobertura = tipoDaCobertura;
			this.saborDaCobertura = saborDaCobertura;
			return this;
		}

		public Builder camadas(int camadasDeMassa) {
			this.camadasDeMassa = camadasDeMassa;
			return this;
		}

		public Builder frio() {
			this.frio = true;
			return this;			
		}
		
		public Builder quente() {
			this.frio = false;
			return this;			
		}

		public Bolo build() {
			Bolo novo = new Bolo();
			novo.saborDaCobertura = this.saborDaCobertura;
			novo.saborDaMassa = this.saborDaMassa;
			novo.saborDoRecheio = this.saborDoRecheio;
			novo.tipoDaCobertura = this.tipoDaCobertura;
			novo.tipoDoRecheio = this.tipoDoRecheio;
			novo.tipoDaMassa = this.tipoDaMassa;
			novo.frio = this.frio;
			novo.camadasDeMassa = this.camadasDeMassa;
			return novo;
		}

	}

}
