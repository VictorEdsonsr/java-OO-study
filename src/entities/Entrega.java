package entities;

import java.util.ArrayList;
import java.util.List;

public class Entrega implements Runnable {
    private boolean caminhaoEntrega;
    private List<Pedido> pedidoList;

    public Entrega(List<Pedido> pedidoList) {
        this.caminhaoEntrega = true;
        this.pedidoList = pedidoList;
        new Thread(this).start();
    }

    public synchronized void saiuParaEntrega(){
        try {
            System.out.println("estou aqui");
            if(caminhaoEntrega){
                System.out.println("dentro do if");
                for (int i = 0; i <= this.pedidoList.size(); i++){
                    System.out.println("Existem " + (this.pedidoList.size()) + " disponiveis para entrega!");
                    this.pedidoList.forEach(x -> System.out.println("O item '" + x.getName() + "' de " +
                            x.getClient() + " saiu para entrega!"));

                    Thread.sleep(3000);
                }
                this.caminhaoEntrega = false;
                wait();
            }
            this.caminhaoEntrega = true;
            notify();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        saiuParaEntrega();
    }

    public List<Pedido> getPedidoList() {
        return pedidoList;
    }
}
