package ui;

import java.util.Date;
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

        int opc;

        do {
            opc = green.menu();

            green.ejecutar(opc);
        } while (opc != 9);
    }

    public int menu() {
        System.out.println("1)Crear un proyecto");
        System.out.println("2)Culminar etapa de un proyecto");
        System.out.println("3)Registrar una capsula");
        System.out.println("4)Aprobar una capsula");
        System.out.println("5)Publicar capsula");
        System.out.println("6)Numero de capsulas registradas por tipo de capsula");
        System.out.println("7)Lecciones Aprendidas");
        System.out.println("8)Proyecto con mas capsulas registradas");

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

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date testDate = null;

        String date = fecha;

        try {
            testDate = df.parse(date);
            System.out.println("Ahora hemos creado un objeto date con la fecha indicada, " + testDate);
        } catch (Exception e) {
            System.out.println("invalid format");
        }

        if (!df.format(testDate).equals(date)) {
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
            System.out.println("Ahora hemos creado un objeto date con la fecha indicada, " + testDate2);
        } catch (Exception e) {
            System.out.println("invalid format");
        }

        if (!df2.format(testDate2).equals(datefinal)) {
            System.out.println("invalid date!!");
        } else {
            System.out.println("valid date");
        }

        System.out.println("Escribe el presupuesto para el proyecto");
        double budget = entrada.nextDouble();
        entrada.nextLine();

        System.out.println("Escribe el nombre del gerente del proyecto");
        String nameManager = entrada.nextLine();

        System.out.println("Escribe el numero del gerente del proyecto");
        String phoneManager = entrada.nextLine();

        System.out.println(mensajero.addProyect(nameProyect, nameClient, phoneClient, testDate, testDate2, budget,
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
        }
    }

    public String getCurrentProyect() {
        return currentProyect;
    }

    public void setCurrentProyect(String currentProyect) {
        this.currentProyect = currentProyect;
    }

}
