package com.company;

import java.io.IOException;
import java.util.ArrayList;

public class Sort {

    private ArrayList<String> dataIn;
    private ArrayList<String> dataOut = new ArrayList<>();

    public ArrayList<String> sort (String fp, Double brightness) {  //sorting algorithm which removes certain rows

        try {
            dataIn = new ArrayList<>(FileIO.readFile(fp));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < dataIn.size(); i++) { //algorithm itself
            String str = dataIn.get(i);

            if(str.length()<200 || str.contains("---") || str.contains("NKO"))
                continue;

            ArrayList<Double> numbers = new ArrayList<>();
            String tempS = ""; // converting string to array of doubles "numbers"
            for (int j = 0; j < str.length(); j++) {
                if ("+-.0123456789".indexOf(str.charAt(j))>=0){
                    tempS+=str.charAt(j);
                    continue;
                }

                if(tempS.length()>0) {
                    numbers.add(Double.parseDouble(tempS));
                    tempS = "";
                }
            }

            if (numbers.get(6)!=99.8 && (numbers.get(5)>=144 || (numbers.get(5)>=-180 && numbers.get(5)<=-10)))
                continue;
            else if (numbers.get(2)>=40 && numbers.get(16)==9999)
                continue;
            else if (numbers.get(2)<10 && numbers.get(16)<5000)
                continue;
            else if (numbers.get(18)>=brightness)
                continue;
            else if (numbers.get(21)>=5)
                continue;
            else if (numbers.get(23)>=1)
               continue;

                dataOut.add(dataIn.get(i));
        }

        return dataOut;
    }
}
