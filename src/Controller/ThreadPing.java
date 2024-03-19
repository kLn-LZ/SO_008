package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ThreadPing extends Thread {

    String site;

    public ThreadPing (String site) {

        this.site = site;
    }

    public void run() {
        SiteChoose(site);
    }

    private void SiteChoose (String siteC) {

        switch (siteC) {

            case "google": pingGoogle();
                break;
            case "uol": pingUol();
                break;
            case "terra": pingTerra();
                break;
            default:
                System.out.println("Nothing");
                break;
        }
    }

    private void pingGoogle() {


            try {
                Process p = Runtime.getRuntime().exec("ping -4 -c 10 www.google.com.br");
                InputStream fluxo = p.getInputStream();
                InputStreamReader leitor = new InputStreamReader(fluxo);

                BufferedReader buffer = new BufferedReader(leitor);
                String linha = buffer.readLine();

                while (linha != null) {

                  if(linha.contains("time")) {
                      String[] avg = linha.split(" ");


                        System.out.println("Google " + avg[4]);


                    }



                    if(linha.contains("Average")) {

                        String[]  avg = linha.split(",");

                        System.out.println("Google " + avg[2]);


                    }

            //        System.out.println(linha);
                    linha = buffer.readLine();

                }

                buffer.close();
                leitor.close();
                fluxo.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }

    private void pingTerra() {


        try {
            Process p = Runtime.getRuntime().exec("ping -4 -c 10 www.terra.com.br");
            InputStream fluxo = p.getInputStream();
            InputStreamReader leitor = new InputStreamReader(fluxo);

            BufferedReader buffer = new BufferedReader(leitor);
            String linha = buffer.readLine();

            while (linha != null) {

                if(linha.contains("time")) {
                    String[] avg = linha.split(" ");


                    System.out.println("terra " + avg[4]);


                }



                if(linha.contains("Average")) {

                    String[]  avg = linha.split(",");

                    System.out.println("terra " + avg[2]);


                }

                //        System.out.println(linha);
                linha = buffer.readLine();

            }

            buffer.close();
            leitor.close();
            fluxo.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    private void pingUol() {


        try {
            Process p = Runtime.getRuntime().exec("ping -4 -c 10 www.uol.com.br");
            InputStream fluxo = p.getInputStream();
            InputStreamReader leitor = new InputStreamReader(fluxo);

            BufferedReader buffer = new BufferedReader(leitor);
            String linha = buffer.readLine();

            while (linha != null) {

                if(linha.contains("time")) {
                    String[] avg = linha.split(" ");


                    System.out.println("uol " + avg[4]);


                }



                if(linha.contains("Average")) {

                    String[]  avg = linha.split(",");

                    System.out.println("uol " + avg[2]);


                }

                //        System.out.println(linha);
                linha = buffer.readLine();

            }

            buffer.close();
            leitor.close();
            fluxo.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    }




