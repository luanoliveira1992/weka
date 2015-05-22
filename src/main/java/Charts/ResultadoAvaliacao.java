package Charts;

public class ResultadoAvaliacao {
	private double[][] matrixCruzada;
	private double numeroInstancias;
	private double custoMedio;
	private double valoresCorretos;
	private double valoresErrados;
	private double taxaDeErro;
	private double naoClassificados;
	private String algoritmo;

	public ResultadoAvaliacao(double[][] matrixCruzada,
			double numeroInstancias, double custoMedio, double valoresCorretos,
			double valoresErrados, double taxaDeErro, double naoClassificados,String algoritmo) {
		this.matrixCruzada = matrixCruzada;
		this.numeroInstancias = numeroInstancias;
		this.custoMedio = custoMedio;
		this.valoresCorretos = valoresCorretos;
		this.valoresErrados = valoresErrados;
		this.taxaDeErro = taxaDeErro;
		this.naoClassificados = naoClassificados;
		this.algoritmo = algoritmo;

	}

	public double[][] getMatrixCruzada() {
		return matrixCruzada;
	}

	public void setMatrixCruzada(double[][] matrixCruzada) {
		this.matrixCruzada = matrixCruzada;
	}

	public double getNumeroInstancias() {
		return numeroInstancias;
	}

	public void setNumeroInstancias(double numeroInstancias) {
		this.numeroInstancias = numeroInstancias;
	}

	public double getCustoMedio() {
		return custoMedio;
	}

	public void setCustoMedio(double custoMedio) {
		this.custoMedio = custoMedio;
	}

	public double getValoresCorretos() {
		return valoresCorretos;
	}

	public void setValoresCorretos(double valoresCorretos) {
		this.valoresCorretos = valoresCorretos;
	}

	public double getValoresErrados() {
		return valoresErrados;
	}

	public void setValoresErrados(double valoresErrados) {
		this.valoresErrados = valoresErrados;
	}

	public double getTaxaDeErro() {
		return taxaDeErro;
	}

	public void setTaxaDeErro(double taxaDeErro) {
		this.taxaDeErro = taxaDeErro;
	}

	public double getNaoClassificados() {
		return naoClassificados;
	}

	public void setNaoClassificados(double naoClassificados) {
		this.naoClassificados = naoClassificados;
	}
	public String getAlgoritmo() {
		return algoritmo;
	}
	public void setAlgoritmo(String algoritmo) {
		this.algoritmo = algoritmo;
	}

}
