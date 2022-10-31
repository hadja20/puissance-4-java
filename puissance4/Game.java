package puissance4;

import java.util.Scanner;

public class Game {
    private final Player p1;
    private final Player p2;
    private final Grid g;
    private Boolean existWinner = false;
    private Player winner;


    public Game() {
        this.p1 = new Player("player1", Color.YELLOW);
        this.p2 = new Player("player2", Color.RED);
        this.g = new Grid();
        g.display();
    }
    public Boolean getExistWinner() {
        return existWinner;
    }
    public void setExistWinner(Boolean winner) {
        this.existWinner = winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public boolean isFull(int col) {
        return this.g.getGrid()[0][col] != null;
    }

    public Player getWinner(){
        return winner;
    }

    public void play(Player p, int column) {

        int i = 0;
        Grid g = this.g;

        if (g.getGrid()[5][column] == null) {
            g.getGrid()[5][column] = p.getColor();
        } else {
            while (g.getGrid()[i + 1][column] == null && i < 5) {
                i = i + 1;
            }

            g.getGrid()[i][column] = p.getColor();

        }
        g.display();

        this.verifyRow();
        this.verifyColumn();
        this.verifyAntiDiago();
        this.verifyDiago();
    }


    public boolean verifyRow() {
        boolean findOne = false;
        int i = 0;

        while (!findOne && i < 7) {
            int j = 5;
            int cpt = 1;
            while (j >= 0 && !findOne && this.g.getGrid()[j][i] != null) {
                int c = i;
                int l = j;

                while (c < 5 && l > 0 && !findOne && this.g.getGrid()[l][c] == this.g.getGrid()[l][c + 1] && cpt < 5) {
                    cpt++;
                    c++;
                }
                if (cpt == 4) {
                    findOne = true;
                    this.setExistWinner(true);
                    Color color = this.g.getGrid()[l][c - 1];
                    if (color == p1.getColor()) {
                        this.setWinner(p1);
                    } else {
                        this.setWinner(p2);
                    }
                } else {
                    c = i;
                    cpt = 1;
                }
                j--;
            }
            i++;
        }
        return findOne;
    }

    public boolean verifyColumn() {
        boolean findOne = false;
        int i = 0;

        while (!findOne && i < 7) {
            int j = 5;
            int cpt = 1;
            while (j >= 0 && !findOne && this.g.getGrid()[j][i] != null) {
                int c = i;
                int l = j;

                while (c < 7 && l > 0 && !findOne && this.g.getGrid()[l][c] == this.g.getGrid()[l - 1][c] && cpt < 5) {
                    cpt++;
                    l--;
                }

                if (cpt == 4) {
                    findOne = true;
                    this.setExistWinner(true);
                    Color color = this.g.getGrid()[l][c];
                    System.out.println("player1 color= " + p1.getColor());
                    if (color == p1.getColor()) {
                        this.setExistWinner(true);
                        this.setWinner(p1);
                    } else {
                        this.setWinner(p2);
                    }
                } else {
                    l = j;
                    cpt = 1;
                }
                j--;
            }
            i++;
        }
        return findOne;
    }

    public boolean verifyDiago() {
        boolean findOne = false;
        int i = 0;

        while (!findOne && i < 7) {
            int j = 5;
            int cpt = 1;
            while (j >= 0 && !findOne && this.g.getGrid()[j][i] != null) {
                int c = i;
                int l = j;
                while (c < 5 && l > 0 && !findOne && this.g.getGrid()[l][c] == this.g.getGrid()[l - 1][c + 1] && cpt < 5) {
                    cpt++;
                    l--;
                    c++;
                }

                if (cpt == 4) {
                    findOne = true;
                    this.setExistWinner(true);
                    Color color = this.g.getGrid()[l + 1][c - 1];

                    if (color == p1.getColor()) {
                        this.setWinner(p1);

                    } else {
                        this.setWinner(p2);
                    }
                } else {
                    l = j;
                    cpt = 1;
                    c = i;
                }
                j--;
            }
            i++;
        }

        //System.out.print("diago?: "+ findOne);
        return findOne;

    }

    public boolean verifyAntiDiago() {
        boolean findOne = false;
        int i = 6;
        while (!findOne && i >= 0) {
            int j = 5;
            int cpt = 1;
            while (j >= 0 && !findOne && this.g.getGrid()[j][i] != null) {
                int c = i;
                int l = j;
                while (c > 0 && l > 0 && !findOne && this.g.getGrid()[l][c] == this.g.getGrid()[l - 1][c - 1] && cpt < 5) {
                    cpt++;
                    l--;
                    c--;
                }

                if (cpt == 4) {
                    findOne = true;
                    this.setExistWinner(true);
                    Color color = this.g.getGrid()[l + 1][c + 1];
                    if (color == p1.getColor()) {
                        this.setWinner(p1);

                    } else {
                        this.setWinner(p2);
                    }
                } else {
                    l = j;
                    cpt = 1;
                    c = i;
                }


                j--;
            }
            i--;
        }
        return findOne;
    }


    public void alterneJoueur() {
        Scanner sc = new Scanner(System.in);
        while (!this.getExistWinner()) {
            System.out.println(this.p1.getName() + "  vous de jouer !");
            int col_j1 = sc.nextInt();
            while (col_j1 > 6) {
                System.out.println("Entier entre 0 et 6 :");
                col_j1 = sc.nextInt();
            }
            while (this.isFull(col_j1)) {
                System.out.println("La colonne est pleine ! Choisissez une autre colonne");
                col_j1 = sc.nextInt();
            }
            this.play(p1, col_j1);

            if (!this.getExistWinner()) {
                System.out.println(this.p2.getName() + "  vous de jouer !");
                int col_j2 = sc.nextInt();
                while (col_j2 > 6) {
                    System.out.println("Entier entre 0 et 6 :");
                    col_j2 = sc.nextInt();
                }
                while (this.isFull(col_j2)) {
                    System.out.println("La colonne est pleine ! Choisissez une autre colonne");
                    col_j2 = sc.nextInt();
                }

                this.play(p2, col_j2);
            }
        }
        sc.close();
    }


}


