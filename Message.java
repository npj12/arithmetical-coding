import java.util.Arrays;

public class Message{
    private String text;
    private char[] alphabet;
    private int alphabetLength;
    private double[] probabilities;
    private Intervalle[] intervalles;
    private int length;
    private int[] occurences;

    public Message(String text){
        this.text = text;
        this.length = text.length();
        this.setAlphabet();
        Arrays.sort(this.alphabet, 0, this.alphabetLength);
        this.setProbabilities();
        this.setIntervalles();
    }
    public Message(String text, double[] probabilities) throws Exception, ArithmeticException{
        // change the type of the raise exception later
        this.text = text;
        this.length = text.length();
        this.setAlphabet();
        Arrays.sort(this.alphabet, 0, this.alphabetLength);
        
        if(probabilities.length != this.alphabetLength){
            throw new Exception("the probability distribution can't be associate to the message alphabet.\n\tAlphabet length: " + this.alphabetLength + "\n\tnumber of probabilities given: " + probabilities.length + ".");
        } else{
            double s = 0.0;
            for(int i=0; i<probabilities.length; i++){ s+= probabilities[i];}
            if(s != 1.0){
                throw new ArithmeticException("The given distribution of probability is not correct because the sum of all the differents probabilities is: " + s + " != 1.");
            }
        }

        this.probabilities = probabilities;
        this.setIntervalles();
    }

    public String getText(){
        return this.text;
    }

    public int getLength(){
        return this.length;
    }
    private void setAlphabet(){
        this.alphabet = new char[this.length];
        this.alphabetLength = 0;
        this.occurences = new int[this.length];

        int j=0;
        boolean found = false;
        for(int i=0; i< this.length; i++){
            j=0;
            found =false;
            while(!found && j<this. alphabetLength){
                if(this.text.charAt(i) == this.alphabet[j]){
                    found = true;
                    this.occurences[j]++;
                } else {
                    j++;
                }
            }

            if(!found){
                this.alphabet[this.alphabetLength] = this.text.charAt(i);
                this.occurences[this.alphabetLength] = 1;
                this.alphabetLength++;
            }
        }
    }

    public char[] getAlphabet(){
        return this.alphabet;
    }
    public int getAplhabetLength(){
        return this.alphabetLength;
    }

    private void setProbabilities(){
        this.probabilities = new double[this.alphabetLength];
        double n = this.length;
        for(int i=0; i<this.alphabetLength; i++){
            this.probabilities[i] = this.occurences[i] / n;
        }
    }

    private void setIntervalles(){
        this.intervalles = new Intervalle[this.alphabetLength];
        double borneInf = 0.0;
        for(int i=0; i<this.alphabetLength; i++){
            this.intervalles[i] = new Intervalle(borneInf, borneInf+this.probabilities[i]);
            borneInf = borneInf + this.probabilities[i];
            // System.out.println(this.alphabet[i] + "-"+this.intervalles[i]);
        }
    }

    public Intervalle[] getIntervalles(){
        return this.intervalles;
    }
    public double[] getProbabilities(){
        return this.probabilities;
    }

    public String toString(){
        return this.text;
    }
}