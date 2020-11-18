package com.company;

/**
 *
 */
public class Singoleton {



    private static Singoleton singoleton;

    private Singoleton(){

    }

    /**
     *
     * @return
     */
    public static Singoleton getInstance(){
        if( singoleton == null){
            singoleton = new Singoleton();
        }
       return singoleton;
    }



    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
