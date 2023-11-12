package CanibalesYMisioneros;

public class Tripulacion extends Thread {
    private int numCan;
    private int numMis;
    private Bote bote;

    public Tripulacion(Bote bote) {
        this.bote = bote;
    }

    @Override
    public void run() {
        for (; ; ) {
            navegar();
        }
    }

    public void navegar() {
        bote.enUso();

        for (int i = 1; i <= 3; i++) {
            int tipoPersona = (int) (Math.random() * 2) + 1;
            if (tipoPersona == 1) {
                numCan++;
            } else {
                numMis++;
            }
        }

        System.out.println("Caníbales a bordo: " + numCan);
        System.out.println("Misioneros a bordo: " + numMis);

        if (numCan == 2 && numMis == 1) {
            System.out.println("El caníbal ha saltado.");
        } else {
            System.out.println("¡Han cruzado!");
        }

        numMis = 0;
        numCan = 0;
        bote.finalizado();
    }
}