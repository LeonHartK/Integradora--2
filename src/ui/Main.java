package ui;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import model.Enterprise;
import model.Proyect;

public class Main {

    Scanner entrada;
    Enterprise mensajero;

    public Main(){
        mensajero = new Enterprise();
        entrada = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Main green = new Main();

        int opc;

        do{
            opc=green.menu();

            green.ejecutar(opc);
        } while(opc!=3);
    }

    public int menu(){
        System.out.println("1)Crear un proyecto");
        System.out.println("2)Culminar etapa de un proyecto");

        int n=entrada.nextInt();
        entrada.nextLine();

        return n;
    }

    public void registerProyect(){
        System.out.println("Escribe el nombre del proyecto");
        String nameProyect=entrada.nextLine();

        System.out.println("Escribe el nombre del cliente");
        String nameClient=entrada.nextLine();

        System.out.println("Escribe el telefono del cliente");
        String phoneClient=entrada.nextLine();

        System.out.println("Digite la fecha estimada para iniciar el proyecto");
        String fecha = entrada.nextLine();

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date testDate = null;

        String date = fecha;
        
        try {
            testDate = df.parse(date);
            System.out.println("Ahora hemos creado un objeto date con la fecha indicada, "+testDate);
        } catch (Exception e){ System.out.println("invalid format");}

        if (!df.format(testDate).equals(date)){
            System.out.println("invalid date!!");
        } else {
            System.out.println("valid date");
        }

        System.out.println("Digite la fecha estimada para finalizar el proyecto");
        String fechafinal = entrada.nextLine();

        SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
        Date testDate2 = null;

        String datefinal = fechafinal;
        
        try {
            testDate2 = df2.parse(datefinal);
            System.out.println("Ahora hemos creado un objeto date con la fecha indicada, "+testDate2);
        } catch (Exception e){ System.out.println("invalid format");}

        if (!df2.format(testDate2).equals(datefinal)){
            System.out.println("invalid date!!");
        } else {
            System.out.println("valid date");
        }

        System.out.println("Escribe el presupuesto para el proyecto");
        double budget=entrada.nextDouble();
        entrada.nextLine();

        System.out.println("Escribe el nombre del gerente del proyecto");
        String nameManager=entrada.nextLine();

        System.out.println("Escribe el numero del gerente del proyecto");
        String phoneManager=entrada.nextLine();

        System.out.println(mensajero.addProyect(nameProyect, nameClient, phoneClient, testDate, testDate2, budget, nameManager, phoneManager));
    }

    public void endStageProyect(){
        System.out.println("¿Desea finalizar la etapa de este proyecto?");
        String answer = entrada.nextLine();

        Proyect objProyect = new Proyect("", "", "", null, null, 0, "", "");

        System.out.println(objProyect.endStage(objProyect.numeroEtapa()));
    }

    

    public void ejecutar(int n){
        if(n==1){
            registerProyect();
        } else if(n==2){
            endStageProyect();
        }
    }
}
