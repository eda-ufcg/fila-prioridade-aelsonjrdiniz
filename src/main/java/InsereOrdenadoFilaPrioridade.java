public class InsereOrdenadoFilaPrioridade implements FilaPrioridade {

	private Pair[] fila;
	private int head;
	private int last;

	public InsereOrdenadoFilaPrioridade(int capacidade) {
		this.fila = new Pair[capacidade];
		this.last = -1;
		this.head = -1;
	}

	private boolean isFull() {
		return this.last == this.fila.length - 1;
	}

	private boolean isEmpty() {
		return this.head == -1; && this.last == -1;
	}
	
	// criar um Pair e inserir de forma ordenada decrescente no array.
	public void add(String elemento, int prioridade) {
        	Pair p = new Pair(elemento, prioridade);

        	if (isFull()) removeNext();
		
		int size = this.fila.length;
		this.fila[++this.last % size] = p;
		int i = this.last % size;

		while (i != (this.head % size) && this.fila[i % size].getPrioridade() > this.fila[(i-1) % size].getPrioridade()) {
			swap(i % size, (i-1) % size);
			i--;
		}
    	}

	private void swap(int i, int j) {
		int aux = this.fila[i];
		this.fila[i] = this.fila[j];
		this.fila[j] = aux;
	}


	// remover e retornar o primeiro elemento do array, que é o de maior prioridade. lembrar manipular head e tail
	// para ser uma fila circular. assim a remoção fica O(1)
	public String removeNext() {
		if (isEmpty()) return "";
		return this.fila[(++this.head) % this.fila.length];
	}
	
}
