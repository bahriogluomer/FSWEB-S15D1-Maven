package org.example.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Grocery {

    public static List<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);

        switch (scanner.nextInt()) {
            case 0:
                System.out.println("Program sonlandırılıyor...");
                break;
            case 1:
                System.out.println("Eklenmesini istediğiniz elemanları giriniz. ");
                String inputs = scanner.nextLine();
                addItems(inputs);
                break;
            case 2:
                System.out.println("Cıkarılmasını istediğiniz elemanları giriniz.");
                String inputs2 = scanner.nextLine();
                removeItems(inputs2);
                break;

            default:
                break;
        }
    }

    public static void addItems(String items) {
        String [] splitItems = items.split(",");
        for (String item : splitItems) {
            String trimmed = item.trim();
            if(!checkItemIsInList(trimmed)){
                groceryList.add(trimmed);
                groceryList.sort(String.CASE_INSENSITIVE_ORDER);
            }else {
                System.out.println("Bu eleman zaten mevcut");
            }
        }

    }

    public static void removeItems(String items) {
        String [] splitItems = items.split(",");
        for (String item : splitItems) {
            String trimmed = item.trim();
            if(checkItemIsInList(trimmed)){
                groceryList.remove(trimmed);
                groceryList.sort(String.CASE_INSENSITIVE_ORDER);
            }else {
                System.out.println("Bu eleman mevcut degil");
            }
        }
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        groceryList.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println(groceryList);
    }


}
