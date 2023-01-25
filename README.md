# arithmetical-coding
This project was built in Java in order to make the representation of some word into floating point number given a probability distribution or not.

To run this program, you should compiled it before by running the following command:
javac ArithmeticalCoding.java

once the program is compiled you have two options to run it:
1- Just give the word to encode in paramater to the program as following
  java ArithmeticalCoding text_to_encode
2- In addition to the text to encrypt you can add the different probability of appearance of differents letters who constitute the word in alphabetical order
  eg: if the text to encode have n differents letters with the probabilities p1, p2, ..., pn, the command to run is:
  java ArithmeticalCoding text_to_encode p1 p2 ... pn
