package algoritmo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Produto {
	
	private String nome;
	private Double espaco;
	private Double valor;
	
	public Produto() {
		
	}
	
	public Produto(String nome, Double espaco, Double valor) {
		this.nome = nome;
		this.espaco = espaco;
		this.valor = valor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getEspaco() {
		return espaco;
	}
	public void setEspaco(Double espaco) {
		this.espaco = espaco;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "\nProduto [Nome: " + nome + ", Espaco: " + espaco + ", Valor: " + valor + "]";
	}
	
}

class Individuo{
	
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

public class Executar {
	
	public static void main(String[] args) {
		Produto p1 = new Produto("Geladeira Dako", 0.751, 859.90);
		Produto p2 = new Produto("Iphone 6", 0.000089, 2911.12);
		Produto p3 = new Produto("TV 55", 0.400, 4346.99);
		Produto p4 = new Produto("TV 50", 0.290, 3999.90);
		Produto p5 = new Produto("TV 42", 0.200, 2999.00);
		Produto p6 = new Produto("Notebook Dell", 0.0350, 2499.90);
		Produto p7 = new Produto("Ventilador Panasonic", 0.496, 199.90);
		Produto p8 = new Produto("Microondas LG", 0.0544, 308.661);
		Produto p9 = new Produto("Microondas Panasonic", 0.0319, 299.29);
		Produto p10 = new Produto("Geladeira Brastemp", 0.635, 849.00);
		Produto p11 = new Produto("Geladeira Consul", 0.870, 3199.89);
		Produto p12 = new Produto("Notebook Lenovo", 0.498, 1999.90);
		Produto p13 = new Produto("Notebook Asus", 0.527, 3999.00);
		
		
		List<Produto> listaProdutos = new ArrayList<Produto>();
		listaProdutos.addAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13));
		
		List<Double> espacos = new ArrayList<>();
		List<Double> valores = new ArrayList<>();
		List<String> nomes = new ArrayList<>();
		
		for (Produto produto : listaProdutos) {
			espacos.add(produto.getEspaco());
			valores.add(produto.getValor());
			nomes.add(produto.getNome());
		}
		
		Double limite = 3.0;
		
		Individuo individuo = new Individuo(espacos, valores, limite);
		System.out.println("Espacos: " + individuo.getEspacos());
		System.out.println("Valores: " + individuo.getValores());
		System.out.println("Cromossomos: " + individuo.getCromossomo());
		
		Individuo individuo2 = new Individuo(espacos, valores, limite);
		System.out.println("Espacos: " + individuo2.getEspacos());
		System.out.println("Valores: " + individuo2.getValores());
		System.out.println("Cromossomos: " + individuo2.getCromossomo());
		
		individuo.crossover(individuo2);

		System.out.println();
		individuo.mutacao(0.05);
		individuo2.mutacao(0.05);
		
		System.out.println("\nComponentes da carga: ");
		for (int i=0; i<listaProdutos.size(); i++) {
			if (individuo.getCromossomo().get(i) == "1") {
				System.out.println("Produto: " + listaProdutos.get(i).getNome() + " R$: " + listaProdutos.get(i).getValor());
			}
		}
		
		individuo.avaliacao();
		System.out.println("\nNota Avaliação: " + individuo.getNotaAvaliacao());
		System.out.println("Espaço Usado: " + individuo.getEspacoUsado());
	}
}
