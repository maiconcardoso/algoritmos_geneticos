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
	
	private List<String> espacos = new ArrayList<>();
	private List<String> valores = new ArrayList<>();
	private Double limitesEspacos;
	private Double notaAvaliacao;
	private int geracao;
	private List<String> cromossomo = new ArrayList<>();
	
	public Individuo(List espacos, List valores, Double limitesEspacos) {
		this.espacos = espacos;
		this.valores = valores;
		this.limitesEspacos = limitesEspacos;
		
		for (int i=0; i<espacos.size(); i++) {
			if (Math.random() < 0.5) {
				this.cromossomo.add("0");
			} else {
				this.cromossomo.add("1");
			}
		}
	}

	public List<String> getEspacos() {
		return espacos;
	}

	public void setEspacos(List<String> espacos) {
		this.espacos = espacos;
	}

	public List<String> getValores() {
		return valores;
	}

	public void setValores(List<String> valores) {
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
		
		for (Produto produto: listaProdutos) {
			System.out.print(produto);
		}
	}
}
