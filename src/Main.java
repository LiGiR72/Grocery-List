import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class Main {
     static List<String> basket = new ArrayList<>();
     static  List<String> outputList = new ArrayList<>();
     static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        cmds();
        while(true){
            int cmdNum = 0;
            System.out.println("Введите номер команды");
            String input = scanner.nextLine();
            if(input.equals("end")){
                break;
            }
            try {
                cmdNum = Integer.parseInt(input);
            }
            catch (IllegalArgumentException e){
                System.out.println("Введена неверная команда");
                continue;
            }
            switch (cmdNum){
                case 1:
                    add();
                    break;
                case 2:
                    remove();
                    break;
                case 3:
                    find();
                    break;
                case 4:
                    show();
                    break;
                case 5:
                    cmds();
                    break;
                default:
                    System.out.println("Введена неверная команда");
                    break;
            }
        }
    }
    public static void add(){
        System.out.println("Какую покупку вы хотите добавить?");
        String input = scanner.nextLine();
        if(basket.contains(input.toLowerCase())){
            System.out.println("Этот товар уже в корзине!");
            return;
        }
        basket.add(input.toLowerCase());
        outputList.add(input);
    }
    public static void show(){
        System.out.println("Список покупок:");
        for(int i = 0; i < basket.size(); i++){
            System.out.println((i + 1 ) + ". " + outputList.get(i));
        }
    }

    public static void remove(){
        System.out.println("Введите название или номер покупки, которую хотите удалить?");
        String input = scanner.nextLine();
        int inpt = 0;
        try {
            inpt = Integer.parseInt(input);
        }
        catch (IllegalArgumentException e){
            if(basket.contains(input.toLowerCase())== false){
                System.out.println("Такого товара нет!");
                return;
            }
            outputList.remove(basket.indexOf(input.toLowerCase()));
            basket.remove(input.toLowerCase());
            return;
        }
        basket.remove(inpt - 1);
        outputList.remove(inpt - 1);
    }

    public static void find(){
        System.out.println("Введите покупку, которую вы хотите найти");
        String input = scanner.nextLine();
        int count = 0;
        System.out.println("Найдено:");
        for (int i = 0; i < basket.size(); i++){
           if(basket.get(i).contains(input.toLowerCase())){
               System.out.println((i + 1) + ". " + outputList.get(i));
               count++;
           }
        }
        System.out.println("Найдено " + count + " результатов");
    }

    public static void cmds(){
        System.out.println("Список команд:");
        System.out.println("1 - Добавить ");
        System.out.println("2 - Удалить");
        System.out.println("3 - Найти");
        System.out.println("4 - Показать список покупок");
        System.out.println("5 - Вывести списко команд");
        System.out.println("end - Выйти из программы");

    }



}