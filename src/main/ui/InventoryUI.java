package ui;

import constant.InventoryManagerMessage;
import constant.KitchenUIMessage;
import controller.InventoryManager;
import use_case.InventoryFactory;

import java.util.Scanner;

public class InventoryUI implements UserInterface{
    private static InventoryManager im;
    private static InventoryFactory infc = new InventoryFactory();

    public InventoryUI(){this.im = new InventoryManager();}

    public InventoryUI(InventoryManager im){
        this.im = im;
    }

    @Override
    public void loadUi(String id){
        while (true) {
            System.out.println(InventoryManagerMessage.SELECT_ACTION);
            Scanner scanner = new Scanner(System.in);
            String action = scanner.nextLine();
            switch (action) {
                case "1":
                    System.out.println(InventoryManagerMessage.REQUEST_NAME);
                    if (scanner.hasNextLine()) {
                        String str = scanner.nextLine();
                        System.out.println(im.getInfo(str));
                    }
                    break;
                case "2":
                    System.out.println(InventoryManagerMessage.REQUEST_INFO);
                    if (scanner.hasNextLine()) {
                        String str = scanner.nextLine();
                        String[] para = str.split(",");
                        im.addNewInventory(para);
                        System.out.println(im.getInfo(para[1]));
                    }
                    break;
                case "3":
                    System.out.println(InventoryManagerMessage.REQUEST_FRESH);
                    if (scanner.hasNextLine()) {
                        String str = scanner.nextLine();
                        String[] t = str.split(",");
                        im.newFreshness(t[0],t[1]);
                        System.out.println(im.getInfo(t[0]));
                    }
                    break;
                case "4":
                    System.out.println(InventoryManagerMessage.REQUEST_USAGE);
                    if (scanner.hasNextLine()) {
                        String str = scanner.nextLine();
                        String[] q = str.split(",");
                        im.newQuantity(q[0],q[1]);
                        System.out.println(im.getInfo(q[0]));
                    }
                    break;
                case "0":
                    return;

            }
        }
    }
}
