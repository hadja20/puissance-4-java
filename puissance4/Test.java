package puissance4;

public class Test {
    public static void main(String[] args){

        Game p=new Game();
        p.alterneJoueur();
        System.out.println(" La partie est termine. Joueur "+ p.getWinner().getName() + " a gagné la partie");

    }
}
