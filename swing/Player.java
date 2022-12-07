package swing;

public class Player {

    private String name;
    private Color color;

    public Player(String n, Color c) {
        this.name=n;
        this.color=c;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color c) {
        this.color = c;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
