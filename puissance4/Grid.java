package puissance4;

import previousGame.Couleur;

public class Grid {
    private Color grid[][];

    public Grid() {
        this.setGrille(new Color[6][7]);
    }

    public Color[][] getGrid() {
        return grid;
    }


    public void setGrille(Color[][] g) {
        this.grid = g;
    }

    public void display() {
        System.out.println("----------------------------------------");

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {

                if (grid[i][j] == Color.RED) {
                    System.out.print("R");
                } else if (grid[i][j] == Color.YELLOW) {
                    System.out.print("J");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
        System.out.println("----------------------------------------");
    }
}