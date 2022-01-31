import java.util.*;

public class HashFunc {

    String[] HTArray;
    int arraySize;
    int count = 0;
    double originalLoadFactor = 0.5;

    HashFunc(int size) {
        arraySize = size;
        HTArray = new String[size];
        for(int i=0; i< HTArray.length;i++){
            HTArray[i]="-1";
        }
    }

    public void computeHash(String [] givenArray){
        for(int i=0; i<givenArray.length; i++){
            int hashValue = givenArray[i].hashCode() % givenArray.length;

            if(hashValue < 0 )
                hashValue *= -1;


            System.out.println(i+") "+givenArray[i]+": "+ hashValue);

            if (HTArray[hashValue] == "-1") {

                HTArray[hashValue] = givenArray[i];
                count++;
                System.out.println("Count: "+count);
            }

            else {
//            	Open Addressing - Quadratic probing
                for(int j = 0; j < givenArray.length; j++) {
                    int newHV = (hashValue + j * j) % givenArray.length;
                    if(HTArray[newHV]=="-1"){
                        HTArray[newHV] = givenArray[i];
                        count++;
                        System.out.println("Collision count: "+count);
                        break;
                    }
                }
//                return newHV;
            }

            System.out.println((double)count/HTArray.length);
            if((double)count/HTArray.length > originalLoadFactor)
                resizeHT();
        }
    }

    public void resizeHT(){
        count = 0;
        System.out.println("\nNew Table");
        int newSize = HTArray.length*2;
        String [] newHT = new String[newSize];
        for(int i=0; i < HTArray.length;i++){
            newHT = HTArray;
        }
    }

    public static void main(String[] args) {

        HashFunc HTWordList = new HashFunc(31);

        String[] wordList = { "New York",
                "SFO",
                "Orlando",
                "Dallas",
                "Austin",
                "Houston",
                "Miami",
                "San Jose",
                "Salem",
                "Seattle",
                "Phoenix",
                "El Paso",
                "Atlanta",
                "Chicago",
                "Juneau",
                "London",
                "Tokyo",
                "Delhi",
                "Paris",
                "Rio" };

        HTWordList.computeHash(wordList);
    }


}