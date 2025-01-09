package app;

public class QuickSort {

	private int[] valores;

	private QuickSort(int[] valores) {
		this.valores = valores; 
	}

	public static QuickSort getInstancia(int[] valores) {
		return new QuickSort(valores);
	}

	public int getSize() {
		return valores.length;
	}

	//O particionamento do quicksort consiste em alocar o pivo em uma posicao 
	//na qual a parte anterior é composta de valores menores do que ele e a 
	//parte posterior, de valores maiores do que ele. 
	public int particionamento(int left, int right) {

		//1º passo: determinar o pivo e inicializar a variavel que controla a troca
		// de elementos. 
		
		//Essas duas instruções abaixo nao permitem que sejam aplicado 
		//"Extrair Método" nelas, de modo a dividir o método "particionamento"
		//em passos menores. 
		int pivot = valores[left];
		int i = left;
		
		//2º passo: varrer o pivo e realizar as trocas de elementos sempre que necessário
		for (int j=i+1; j<=right; j++) {
			if (valores[j] <= pivot) {
				i++; 
				swap(i, j); 
			}
		}
		
		//3º passo: trocar o pivo com o elemento da ultima posicao dos numeros menores que ele
		swap(left, i);
		return i;
	}

	private void swap(int i, int j) {
		int temp = valores[i];
		valores[i] = valores[j];
		valores[j] = temp;
	}

	public int[] ordenar(int left, int right) {
		if (left < right) {
			int indicePivot = particionamento(left, right);
			ordenar(left, indicePivot -1);
			ordenar(indicePivot + 1, right);
		}
		return valores;
	}

}
