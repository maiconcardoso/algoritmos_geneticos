package algoritmo.model;

import java.util.ArrayList;
import java.util.List;

public class AlgoritmoGenetico {

    private int tamanhoPopulacao;
	private List<Individuo> populacao = new ArrayList<>();
	private int geracao;
	private Individuo melhorSolucao;

	public AlgoritmoGenetico(int tamanhoPopulacao) {
		this.tamanhoPopulacao = tamanhoPopulacao;
	}

	public void inicializaPopulacao (List<Double> espacos, List<Double> valores, Double limiteEspacos) {
		for (int i=0; i<this.tamanhoPopulacao; i++) {
			this.populacao.add(new Individuo(espacos, valores, limiteEspacos));
		}
		this.melhorSolucao = this.populacao.get(0);
	}

	public int getTamanhoPopulacao() {
		return tamanhoPopulacao;
	}

	public void setTamanhoPopulacao(int tamanhoPopulacao) {
		this.tamanhoPopulacao = tamanhoPopulacao;
	}

	public List<Individuo> getPopulacao() {
		return populacao;
	}

	public void setPopulacao(List<Individuo> populacao) {
		this.populacao = populacao;
	}

	public int getGeracao() {
		return geracao;
	}

	public void setGeracao(int geracao) {
		this.geracao = geracao;
	}

	public Individuo getMelhorSolucao() {
		return melhorSolucao;
	}

	public void setMelhorSolucao(Individuo melhorSolucao) {
		this.melhorSolucao = melhorSolucao;
	}

}
