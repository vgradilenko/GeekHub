/**
 * Created by grava on 29.01.17.
 */
public class Wheel {
    private Tyres tyres;

    public Wheel(Tyres tyres) {
        this.tyres = tyres;
    }

    public Wheel() {
    }

    public Tyres getTyres() {
        return tyres;
    }

    public void setTyres(Tyres tyres) {
        this.tyres = tyres;
    }
}
