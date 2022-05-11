package guiaturistico.lista.encadeada;
import javax.swing.JOptionPane;

//Classe Guia Turístico (similar a estrutura dinâmica Lista Encadeada)
public class GuiaTuristico<T>{
    private PontoTuristico<T> inicio;
    private PontoTuristico<T> fim;
    private static GuiaTuristico g = new GuiaTuristico(); 
    private int tamanho;
    
    //método construtor
    public GuiaTuristico(){
        this.tamanho = 0;
    }
    
    //métodos de acesso Gets e Sets
    public PontoTuristico<T> getInicio() {
        return inicio;
    }

    public void setInicio(PontoTuristico<T> inicio) {
        this.inicio = inicio;
    }

    public PontoTuristico<T> getFim() {
        return fim;
    }

    public void setFim(PontoTuristico<T> fim) {
        this.fim = fim;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    
    //método de adicionar um local ao Guia Turistico
    public void adiciona(T local){
        PontoTuristico<T> ponto = new PontoTuristico<T>(local);
       
        if (this.inicio == null && this.fim == null) {
            this.inicio = ponto;
            this.fim = ponto;
        } else {
            this.fim.setProx_destino(ponto);
            this.fim = ponto;
        }
        this.tamanho++;
    }
    
    //método de remoção do loca
    public boolean remover(String local){
        PontoTuristico anterior = null;
        PontoTuristico atual = this.inicio;
        
        for (int i = 0; i < this.getTamanho(); i++) {
            if (atual.getLocal().equals(local)) {
                if (this.tamanho == 1) {
                    this.inicio = null;
                    this.fim = null;
                } else if(atual == inicio){
                    this.inicio = atual.getProx_destino();
                    atual.setProx_destino(null);
                } else if(atual == fim){
                    this.fim = anterior;
                    anterior.setProx_destino(null);
                } else{
                    anterior.setProx_destino(atual.getProx_destino());
                    atual = null;
                    this.tamanho--;
                    break;
                }
                return true;
            }
            anterior = atual;
            atual = atual.getProx_destino();
        }
        return false;
    }
    
    //método de busca por index/posição do local
    public void busca(int posicao){
        if(posicao <0 || posicao >= tamanho){
            JOptionPane.showMessageDialog(null, "Não existe busca correspondente!");
        } else {
            PontoTuristico atual = this.inicio;
        
            for (int i = 0; i < posicao; i++) {
                if (atual.getProx_destino() != null) {
                    atual = atual.getProx_destino();
                }
            }
            JOptionPane.showMessageDialog(null,"RESULTADO DA BUSCA: \n Destino:" + atual);
           
        }
    }
        
    //método de visualização dos dados
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Guia Turistico:\n\n INÍCIO: ").append(inicio).append("\n\n\n FIM: ").append(fim);
        return builder.toString();
    }
    
    //verifica se a lista de pontos turísticos está vazia
    public boolean isEmpty(){
        return this.inicio == null;
    }
    
    //menu de exibição do programa
    public void menu(){
        int resp;
        do{
            resp = Integer.parseInt(JOptionPane.showInputDialog(null,"***PLANEJADOR GUIA TURISTICO***" + 
                "\n Bem-vindo! " +
                "\n\n1 - Adicionar destino" +
                "\n2 - Remover destino" +
                "\n3 - Buscar destino" + 
                "\n4 - Ver Guia Turístico gerado" +
                "\n5 - Sair" +
                        "\n\n Digite sua opção: "));
                 planoGuia(resp);
        }while(resp!=5);
    }
    
    //gerador do Guia - constituido de um Switch com os métodos (adicionar, busca, remover, visualizar)
    public void planoGuia(int resp){
        switch (resp){
            case 1:
                String destino = JOptionPane.showInputDialog(null, "Adicione um ponto turístico: ");
                if(destino == null || "".equals(destino)){
                    JOptionPane.showMessageDialog(null, "Nenhum ponto turístico inserido!", "Atenção!", JOptionPane.WARNING_MESSAGE);
                } else {
                    g.adiciona(destino);
                    
                    JOptionPane.showMessageDialog(null, "Local: " + g.getFim().getLocal() + " foi adicionado com sucesso! ");    
                }
            break;
            case 2:
                String destinoRemovido = JOptionPane.showInputDialog(null, "Digite o ponto turístico desejado: ");
                if(!this.g.isEmpty()){
                    if(this.g.remover(destinoRemovido)){
                        JOptionPane.showMessageDialog(null, "Ponto turístico foi excluído!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Ponto turístico não encontrado!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ponto turístico não encontrado!", "Atenção", JOptionPane.WARNING_MESSAGE);
                }
            break;
            case 3:
                if(this.g.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Nenhum ponto turístico adicionado!", "Atenção", JOptionPane.WARNING_MESSAGE);
                }else{
                    int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual a posição/index?: "));
                    g.busca(num);
                }
                
                
            break;
            case 4:
                if (g.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhum destino reigstrado!", "Atenção", JOptionPane.WARNING_MESSAGE);
                }
                JOptionPane.showMessageDialog(null, g.toString());                
            break;
                
        }
    }

}
