package builder.base;

public class AppBuilder {
	
	public static void main(String[] args) {
		
		Bolo bolo1 = new Bolo(
				TipoDaMassa.SIMPLES,
				SaborDaMassa.CHOCOLATE,
				TipoDaCobertura.GANACHE,
				SaborDaCobertura.CHOCOLATE,
				TipoDoRecheio.MANJAR,
				SaborDoRecheio.BAUNILHA,
				false,
				2);
		
		Bolo bolo5 = (new Bolo.Builder())
				.massa(TipoDaMassa.SIMPLES, SaborDaMassa.CHOCOLATE)
				.cobertura(TipoDaCobertura.GANACHE, SaborDaCobertura.BAUNILHA)
				.camadas(2)
				.frio()
				.build();
		
		
		
		
		Bolo bolo4 = new Bolo(
				TipoDaMassa.SIMPLES,
				SaborDaMassa.CHOCOLATE,
				null,
				null,
				null,
				null,
				false,
				2);
		
		Bolo bolo2 = new Bolo(
				TipoDaMassa.SIMPLES,
				SaborDaMassa.BAUNILHA,
				TipoDoRecheio.MANJAR,
				SaborDoRecheio.BAUNILHA,
				false,
				2);
		
		Bolo bolo3 = new Bolo(
				TipoDaMassa.SIMPLES,
				SaborDaMassa.BAUNILHA,
				false,
				2);
	}

}
