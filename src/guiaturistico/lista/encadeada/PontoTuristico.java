package guiaturistico.lista.encadeada;

//Classe PontoTuristio (similar ao Nó da Lista Encadeada)
//Cada ponto turístico(célula) é composto de um local e um ponteiro ao próximo local
public class PontoTuristico<T> {
    private T local;
    private PontoTuristico<T> prox_destino;
    
    //método construtores
    public PontoTuristico(T local) {
        this.local = local;
        this.prox_destino = null;
    }
    public PontoTuristico(T local, PontoTuristico prox_destino) {
        this.local = local;
        this.prox_destino = prox_destino;
    }

    //métodos de acesso Gets e Sets
    public T getLocal() {
        return local;
    }

    public void setLocal(T local) {
        this.local = local;
    }

    public PontoTuristico<T> getProx_destino() {
        return prox_destino;
    }

    public void setProx_destino(PontoTuristico prox_destino) {
        this.prox_destino = prox_destino;
    }

    //método de visualização do Ponto Turístico
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(local).append("\n Proximo Destino: ").append(prox_destino);
        return builder.toString();
    }
    
    
}
