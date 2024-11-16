
package Capibatchi;

public class Estado {
    private int valorEstado;

    public int getValorEstado() {
        return valorEstado;
    }

    public void setValorEstado(int valorEstado) {
        this.valorEstado = valorEstado;
    }

    public Estado(int valorInicial){
        this.valorEstado = valorInicial;
    }
    
    public void incrementarEstado(int cantidadAumentada){
        if(this.valorEstado < 100){
            if((this.valorEstado += cantidadAumentada) > 100){
                this.valorEstado = 100;
            }
        }
    }
    
    public void decrementarEstado(int cantidad) {
        if (this.valorEstado > 0) {
            if((this.valorEstado -= cantidad) < 0){
                this.valorEstado = 0;
            }
        }
    }
}
