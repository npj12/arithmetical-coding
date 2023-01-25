public class Intervalle{
    private double borneInf;
    private double borneSup;
    public static int round = 2;

    public Intervalle(double borneInf, double borneSup){
        this.borneInf = borneInf;
        this.borneSup = borneSup;
    }

    public double getInf(){
        return this.borneInf;
    }

    public double getSup(){
        return this.borneSup;
    }

    public String toString(){
        return "["+ String.format("%."+ this.round +"f", this.borneInf) +";" + String.format("%."+ this.round +"f", this.borneSup) + "[";
    }
}