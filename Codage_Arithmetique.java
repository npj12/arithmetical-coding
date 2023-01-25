public class Codage_Arithmetique{
    public static void main(String args[]){
        int n = args.length;
        Message m;
        double encodedText;
        if(n == 1){
            m = new Message(args[0]);
            encodedText = encode(m);
            System.out.println("The encoded form of \""+ m +"\" is: " + encodedText);
        } else if(n>=2){
            double probabilities[] = new double[n-1];
            for(int i=0; i<n-1; i++){
                probabilities[i] = Double.parseDouble(args[i+1]);
            }
            // double probabilities[] = { 0.4, 0.2, 0.4}; 
            try{
                m = new Message(args[0], probabilities);
                encodedText = encode(m);
                System.out.println("The encoded form of \""+ m +"\" is: " + encodedText);
            }catch(ArithmeticException e){
                System.out.println(e.getMessage());
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        
        }
    }

    public static double encode(Message m){
        double borneInf = 0.0;
        double borneSup = 1.0;
        double taille, x, y;    
        char c;
        int position, n=m.getLength();
        Intervalle intervalle;
        char[] alphabet = m.getAlphabet();
        for(int i=0; i<n; i++){
            taille = borneSup - borneInf;
            c = m.getText().charAt(i);
            position = getPosition(c, alphabet);
            intervalle = m.getIntervalles()[position];
            x = intervalle.getInf();
            y = intervalle.getSup();
            borneSup = borneInf + y*taille;
            borneInf = borneInf + x*taille;
            // System.out.println("x: "+x+" y: "+y+" taille: "+ taille +"       [" + borneInf + ";" + borneSup + "[");
        }
        return borneSup;
    }

    public static int getPosition(char c, char[] alphabet){
        for(int i=0; i<alphabet.length; i++){
            if(c == alphabet[i])
                return i;
        }
        return -1;
    }
}