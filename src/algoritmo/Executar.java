package algoritmo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import algoritmo.model.AlgoritmoGenetico;
import algoritmo.model.Individuo;
import algoritmo.model.Produto;


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
		int tamanhoPopulacao = 20;
		AlgoritmoGenetico ag = new AlgoritmoGenetico(tamanhoPopulacao);
		ag.inicializaPopulacao(espacos, valores, limite);

		// Avaliação
		for (Individuo individuo : ag.getPopulacao()) {
			individuo.avaliacao();
		}

		// Ordernar populaçao
		ag.ordenaPopulacao();

		// Melhor indíviduo
		ag.melhorIndividuo(ag.getPopulacao().get(0));

		Double soma = ag.somaAvaliacao();
		System.out.println();
		System.out.print("\nSoma da avaliação: " + soma);

		System.out.println();
		System.out.println("\nMelhor solução: " + ag.getMelhorSolucao().getCromossomo() + 
			"\nNota: " + ag.getMelhorSolucao().getNotaAvaliacao());
		
	}
}
