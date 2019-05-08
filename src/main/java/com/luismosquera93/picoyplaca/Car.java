package com.luismosquera93.picoyplaca;

/**
 *
 * @author Luis Mosquera
 */
public class Car {
    private String platenumber;

    /**
     * @return the platenumber
     */
    public String getPlatenumber() {
        return platenumber;
    }

    public Car(String platenumber) throws Exception{
        this.setPlatenumber(platenumber);
    }
    
    /**
     * @return the last number at platenumber
     */
    public int getLastnumber(){
        int response = Integer.parseInt(platenumber.charAt(platenumber.length()-1)+"");
        return response==0?10:response;
    }

    /**
     * @param platenumber the platenumber to set and validate
     * @throws java.lang.Exception
     */
    private void setPlatenumber(String platenumber) throws Exception{
        if(platenumber.length()!=7)
            throw new Exception("Length of platenumber is invalid");
        for (int i = 0; i < platenumber.length(); i++) {
            if(i<3){
                if(!Character.isLetter(platenumber.charAt(i)))
                    throw new Exception("Character not acepted at "+i);
            }else{
                if(!Character.isDigit(platenumber.charAt(i)))
                    throw new Exception("Character not acepted at "+i);
            }
        }
        this.platenumber = platenumber;
    }
}
