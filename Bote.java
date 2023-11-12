package CanibalesYMisioneros;

public class Bote {
    public enum Uso {
        CRUZANDO, DISPONIBLE
    }

    private Uso uso;

    public synchronized void enUso() {
        try {
            while (uso == Uso.CRUZANDO)
                wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        uso = Uso.CRUZANDO;
        notifyAll();
    }

    public synchronized void finalizado() {
        uso = Uso.DISPONIBLE;
        notifyAll();
    }
}
