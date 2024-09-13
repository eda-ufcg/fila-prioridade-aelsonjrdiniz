import java.util.ArrayList;

public class InsereFinalFilaPrioridade implements FilaPrioridade {

	private ArrayList<Pair> fila;

	public InsereFinalFilaPrioridade(int capacidade) {
		this.fila = new ArrayList<Pair>(capacidade);
	}
	
	// criar um Pair e adicionar no fim da fila
	public void add(String elemento, int prioridade) {
       Pair par = new Pair(elemento, prioridade); 
       this.fila.add(par);
    }


	// buscar pelo elemento de maior prioridade na fila.
	public String removeNext() {
        Pair p = this.fila.get(0);
        for (int i = 1; i < this.fila.size(); i++) {
            if (this.fila.get(i).getPrioridade() > p.getPrioridade()) {
                p = this.fila.get(i);
            }
        }
        this.fila.remove(p);
		return p.getElemento();
	}

}
