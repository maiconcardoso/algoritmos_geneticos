package algoritmo.model;

import java.util.ArrayList;
import java.util.List;

public class Individuo implements Comparable<Individuo>{

    private List<Double> espacos = new ArrayList<>();
	private List<Double> valores = new ArrayList<>();
	private Double limitesEspacos;
	private Double notaAvaliacao;
	private Double espacoUsado;
	private int geracao;
	private List<String> cromossomo = new ArrayList<>();
	
	public Individuo(List<Double> espacos, List<Double> valores, Double limitesEspacos) {
		this.espacos = espacos;
		this.valores = valores;
		this.limitesEspacos = limitesEspacos;
		this.notaAvaliacao = 0.0;
		this.espacoUsado = 0.0;
		this.geracao = 0;
		
		for (int i=0; i<espacos.size(); i++) {
			if (Math.random() < 0.5) {
				this.cromossomo.add("0");
			} else {
				this.cromossomo.add("1");
			}
		}
		
	}
	
	public void avaliacao() {
		Double nota = 0.0;
		Double somaEspacos = 0.0;
		
		for (int i = 0; i < this.cromossomo.size(); i++) {
			if (this.cromossomo.get(i).equals("1")) {
				nota += this.valores.get(i);
				somaEspacos += this.espacos.get(i);
			}
		}
		
		if (somaEspacos > this.limitesEspacos) {
			nota = 1.0;
		}
		
		this.notaAvaliacao = nota;
		this.espacoUsado = somaEspacos;
	}
	
	public List<Individuo> crossover(Individuo outroIndividuo) {
		
		int corte = (int) Math.round(Math.random() * this.cromossomo.size());
		List<String> filho = new ArrayList<>();
		
		filho.addAll(outroIndividuo.getCromossomo().subList(0, corte));
		filho.addAll(this.cromossomo.subList(corte, this.cromossomo.size()));
		
		List<String> filho2 = new ArrayList<>();
		
		filho2.addAll(this.cromossomo.subList(0, corte));
		filho2.addAll(outroIndividuo.getCromossomo().subList(corte, this.cromossomo.size()));
		
		List<Individuo> filhos = new ArrayList<>();
		filhos.add(new Individuo(espacos, valores, limitesEspacos));
		filhos.add(new Individuo(espacos, valores, limitesEspacos));
		
		filhos.get(0).setCromossomo(filho);
		filhos.get(0).setGeracao(this.geracao + 1);
		
		filhos.get(1).setCromossomo(filho2);
		filhos.get(1).setGeracao(this.geracao + 1);
		
		return filhos;
	}

	public Individuo mutacao(Double taxaMutacao) {
		System.out.println("Cromossomo antes da mutação: " + this.cromossomo);
		for (int i=0; i < this.cromossomo.size(); i++) {
			if (Math.random() < taxaMutacao) {
				if (this.cromossomo.get(i).equals("1")) {
					this.cromossomo.set(i, "0");
				} else {
					this.cromossomo.set(i, "1");
				}
			}
		}

		System.out.println("Cromossomo depois da mutação: " + this.cromossomo);
		return this;
	}

    @Override
    public int compareTo(Individuo individuo) {
        if (this.notaAvaliacao > individuo.getNotaAvaliacao()) {
            return -1;
        } 
        if (this.notaAvaliacao < individuo.getNotaAvaliacao()) {
            return 1;
        }
        return 0;
    }   

	public List<Double> getEspacos() {
		return espacos;
	}

	public void setEspacos(List<Double> espacos) {
		this.espacos = espacos;
	}

	public List<Double> getValores() {
		return valores;
	}

	public void setValores(List<Double> valores) {
		this.valores = valores;
	}

	public Double getLimitesEspacos() {
		return limitesEspacos;
	}

	public void setLimitesEspacos(Double limitesEspacos) {
		this.limitesEspacos = limitesEspacos;
	}

	public Double getNotaAvaliacao() {
		return notaAvaliacao;
	}

	public void setNotaAvaliacao(Double notaAvaliacao) {
		this.notaAvaliacao = notaAvaliacao;
	}

	public Double getEspacoUsado() {
		return espacoUsado;
	}

	public void setEspacoUsado(Double espacoUsado) {
		this.espacoUsado = espacoUsado;
	}

	public int getGeracao() {
		return geracao;
	}

	public void setGeracao(int geracao) {
		this.geracao = geracao;
	}

	public List<String> getCromossomo() {
		return cromossomo;
	}

	public void setCromossomo(List<String> cromossomo) {
		this.cromossomo = cromossomo;
	}

}
