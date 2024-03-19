package View;

import Controller.ThreadPing;

public class Main {
    public static void main(String[] args) {

        Thread google = new ThreadPing("google");
        google.start();
        Thread terra = new ThreadPing("terra");
        terra.start();
        Thread uol = new ThreadPing("uol");
        uol.start();




    }
}
