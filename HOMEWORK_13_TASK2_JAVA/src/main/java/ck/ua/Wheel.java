package ck.ua;

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

    @Override
    public String toString() {
        return "Wheel{" +
                "tyres=" + tyres +
                '}';
    }
}
