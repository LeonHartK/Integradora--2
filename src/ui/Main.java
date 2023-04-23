package ui;

import java.util.Date;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import model.Enterprise;

public class Main {

    Scanner entrada;
    Enterprise mensajero;
    String currentProyect;

    public Main() {
        mensajero = new Enterprise();
        entrada = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Main green = new Main();

        try{
            green.mensajero.leerProyectos();
            green.mensajero.leerCap();
        } catch (Exception e){
            e.printStackTrace();
        }

        int opc;

        do {
            opc = green.menu();

            green.ejecutar(opc);
        } while (opc != 10);
    }

    public int menu() {
        System.out.println("1)Crear un proyecto");
        System.out.println("2)Culminar etapa de un proyecto");
        System.out.println("3)Registrar una capsula");
        System.out.println("4)Aprobar una capsula");
        System.out.println("5)Publicar capsula");
        System.out.println("6)Numero de capsulas registradas por tipo de cápsula");
        System.out.println("7)Lecciones Aprendidas (No funcional)");
        System.out.println("8)Proyecto con mas capsulas registradas");
        System.out.println("9)Verificar si un colaborador registro algúna cápsula");
        System.out
                .println("10) Situaciones y lecciones aprendidas de las capsulas aprobadas y aplicadas (No funcional)");

        int n = entrada.nextInt();
        entrada.nextLine();

        return n;
    }

    public void registerProyect() {
        System.out.println("Escribe el nombre del proyecto");
        String nameProyect = entrada.nextLine();

        System.out.println("Escribe el nombre del cliente");
        String nameClient = entrada.nextLine();

        System.out.println("Escribe el telefono del cliente");
        String phoneClient = entrada.nextLine();

        System.out.println("Digite la fecha estimada para iniciar el proyecto");
        String fecha = entrada.nextLine();

        Date fechaactualizada=null;

        try {
            fechaactualizada=mensajero.parseo(fecha);
        } catch (InputMismatchException e){
            System.out.println(e);
        }

        System.out.println("Digite la fecha estimada para finalizar el proyecto");
        String fechafinal = entrada.nextLine();

        Date fechafinalactualizada=null;

        try {
            fechafinalactualizada=mensajero.parseo(fechafinal);
        } catch (InputMismatchException e){
            System.out.println(e);
        }

        System.out.println("Escribe el presupuesto para el proyecto");
        double budget = entrada.nextDouble();
        entrada.nextLine();

        System.out.println("Escribe el nombre del gerente del proyecto");
        String nameManager = entrada.nextLine();

        System.out.println("Escribe el numero del gerente del proyecto");
        String phoneManager = entrada.nextLine();

        System.out.println(mensajero.addProyect(nameProyect, nameClient, phoneClient, fechaactualizada, fechafinalactualizada, budget,
                nameManager, phoneManager));
        setCurrentProyect(nameProyect);
    }

    public void endStageProyect() {
        System.out.println("¿Desea finalizar la etapa de un proyecto? Escribe la palabra por favor");
        System.out.println("1) Si");
        System.out.println("1) No");
        String answer = entrada.nextLine();

        if (answer.equalsIgnoreCase("Si")) {
            System.out.println("Escriba el nombre de algún proyecto");
            String nameProy = entrada.nextLine();
            System.out.println(mensajero.endStage(nameProy));
        }
    }

    public void registerCapsule() {
        System.out.println("Escriba el nombre del proyecto en el cual se registrara la capsula:");
        String nameProyect = entrada.nextLine();
        System.out.println("Digite el id de la capsula:");
        String id = entrada.nextLine();
        System.out.println("Describa la situacion que desea registrar:");
        String description = entrada.nextLine();
        System.out.println("Escriba el nombre del colaborador por favor:");
        String nameColaborator = entrada.nextLine();
        System.out.println("Escriba la posicion del colaborador:");
        String position = entrada.nextLine();
        System.out.println("Aprendizaje de dicha situacion: ");
        String learn = entrada.nextLine();
        System.out.println(
                "Escriba el tipo de capsula para la situacion: \n1) Tecnico\n2) Gestion\n3) Dominio\n4) Experiencia");
        int typeCapsule = entrada.nextInt();

        System.out.println(
                mensajero.addCapsule(nameProyect, id, description, nameColaborator, position, learn, typeCapsule));
    }

    public void approvedCapsule() {
        System.out.println("Escriba el nombre del proyecto en el cual se aprobara la capsula");
        String nameProyect = entrada.nextLine();
        System.out.println("Digite el id de la capsula");
        String id = entrada.nextLine();

        System.out.println(mensajero.approvedCapsule(nameProyect, id));
    }

    public void publicCapules() {
        System.out.println("Escriba el nombre del proyecto del cual desea publicar sus capsulas");
        String nameProyect = entrada.nextLine();
        String ruta = "./src/outData/index.html";

        System.out.println(mensajero.publicCapules(nameProyect, ruta));
    }

    public void cantCap() {
        System.out.println("Escriba el nombre del proyecto del cual desea saber el numero de capsulas por tipo");
        String nameProyect = entrada.nextLine();

        System.out.println(mensajero.cantCapType(nameProyect));
    }

    public void maxProyect() {
        System.out.println(mensajero.finMax());
    }

    public void ifColaborator() {
        System.out.println("Escribe el nombre del colaborador a buscar");
        String nameColaborator = entrada.nextLine();

        System.out.println(mensajero.Colaborator(nameColaborator));
    }

    public void ejecutar(int n) {
        if (n == 1) {
            registerProyect();
        } else if (n == 2) {
            endStageProyect();
        } else if (n == 3) {
            registerCapsule();
        } else if (n == 4) {
            approvedCapsule();
        } else if (n == 5) {
            publicCapules();
        } else if (n == 6) {
            cantCap();
        } else if (n == 7) {

        } else if (n == 8) {
            maxProyect();
        } else if (n == 9) {
            ifColaborator();
        }
    }

    public String getCurrentProyect() {
        return currentProyect;
    }

    public void setCurrentProyect(String currentProyect) {
        this.currentProyect = currentProyect;
    }
}
