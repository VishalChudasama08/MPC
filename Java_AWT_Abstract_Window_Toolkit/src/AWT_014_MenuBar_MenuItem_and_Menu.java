import java.awt.*;

class AWT_014_MenuBar_MenuItem_and_Menu {
    AWT_014_MenuBar_MenuItem_and_Menu() {
        Frame frame = new Frame("Menu and MenuItem Example");

        // Create a single MenuBar that will hold all menus
        MenuBar menuBar = new MenuBar();

        // -------- Menu 1 --------
        Menu menu1 = new Menu("Menu 1");
        Menu submenu1 = new Menu("Sub Menu 1");
        MenuItem item1_1 = new MenuItem("Item 1.1");
        MenuItem item1_2 = new MenuItem("Item 1.2");
        MenuItem item1_3 = new MenuItem("Item 1.3");
        MenuItem item1_4 = new MenuItem("Item 1.4");
        MenuItem item1_5 = new MenuItem("Item 1.5");
        // Add items to the menu
        menu1.add(item1_1);
        menu1.add(item1_2);
        menu1.add(item1_3);
        // Add items to the submenu
        submenu1.add(item1_4);
        submenu1.add(item1_5);
        // Add the submenu to the main menu
        menu1.add(submenu1);
        // Add menu1 to the MenuBar
        menuBar.add(menu1);

        // -------- Menu 2 --------
        Menu menu2 = new Menu("Menu 2");
        Menu submenu2 = new Menu("Sub Menu 2");
        MenuItem item2_1 = new MenuItem("Item 2.1");
        MenuItem item2_2 = new MenuItem("Item 2.2");
        MenuItem item2_3 = new MenuItem("Item 2.3");
        MenuItem item2_4 = new MenuItem("Item 2.4");
        MenuItem item2_5 = new MenuItem("Item 2.5");
        // Add items to the menu
        menu2.add(item2_1);
        menu2.add(item2_2);
        menu2.add(item2_3);
        // Add items to the submenu
        submenu2.add(item2_4);
        submenu2.add(item2_5);
        // Add the submenu to the main menu
        menu2.add(submenu2);
        // Add menu2 to the MenuBar
        menuBar.add(menu2);

        // -------- Menu 3 --------
        Menu menu3 = new Menu("Menu 3");
        Menu submenu3 = new Menu("Sub Menu 3");
        MenuItem item3_1 = new MenuItem("Item 3.1");
        MenuItem item3_2 = new MenuItem("Item 3.2");
        MenuItem item3_3 = new MenuItem("Item 3.3");
        MenuItem item3_4 = new MenuItem("Item 3.4");
        MenuItem item3_5 = new MenuItem("Item 3.5");
        // Add items to the menu
        menu3.add(item3_1);
        menu3.add(item3_2);
        menu3.add(item3_3);
        // Add items to the submenu
        submenu3.add(item3_4);
        submenu3.add(item3_5);
        // Add the submenu to the main menu
        menu3.add(submenu3);
        // Add menu3 to the MenuBar
        menuBar.add(menu3);

        // -------- Menu 4 --------
        Menu menu4 = new Menu("Menu 4");

        MenuItem item4_1 = new MenuItem("Item 1_4");
        MenuItem item4_2 = new MenuItem("Item 2_4");
        MenuItem item4_3 = new MenuItem("Item 3_4");

        // Create the first-level submenu with unique names
        Menu submenu1_4 = new Menu("Submenu 1_4");
        MenuItem item1_1_4 = new MenuItem("Item 1_1_4");
        MenuItem item1_2_4 = new MenuItem("Item 1_2_4");
        MenuItem item1_3_4 = new MenuItem("Item 1_3_4");

        // Create the second-level submenu with unique names under the last item of submenu1_4
        Menu submenu2_4 = new Menu("Submenu 2_4");
        MenuItem item2_1_4 = new MenuItem("Item 2_1_4");
        MenuItem item2_2_4 = new MenuItem("Item 2_2_4");
        MenuItem item2_3_4 = new MenuItem("Item 2_3_4");

        // Create the third-level submenu with unique names under the last item of submenu2_4
        Menu submenu3_4 = new Menu("Submenu 3_4");
        MenuItem item3_1_4 = new MenuItem("Item 3_1_4");
        MenuItem item3_2_4 = new MenuItem("Item 3_2_4");
        MenuItem item3_3_4 = new MenuItem("Item 3_3_4");

        // Create the fourth-level submenu with unique names under the last item of submenu3_4
        Menu submenu4_4 = new Menu("Submenu 4_4");
        MenuItem item4_1_4 = new MenuItem("Item 4_1_4");
        MenuItem item4_2_4 = new MenuItem("Item 4_2_4");
        MenuItem item4_3_4 = new MenuItem("Item 4_3_4");

        // Create the fifth-level submenu with unique names under the last item of submenu4_4
        Menu submenu5_4 = new Menu("Submenu 5_4");
        MenuItem item5_1_4 = new MenuItem("Item 5_1_4");
        MenuItem item5_2_4 = new MenuItem("Item 5_2_4");
        MenuItem item5_3_4 = new MenuItem("Item 5_2_4");

        menuBar.add(menu4);

        menu4.add(item4_1);
        menu4.add(item4_2);
        menu4.add(item4_3);
        menu4.add(submenu1_4);

        submenu1_4.add(item1_1_4);
        submenu1_4.add(item1_2_4);
        submenu1_4.add(item1_3_4);
        submenu1_4.add(submenu2_4);

        submenu2_4.add(item2_1_4);
        submenu2_4.add(item2_2_4);
        submenu2_4.add(item2_3_4);
        submenu2_4.add(submenu3_4);

        submenu3_4.add(item3_1_4);
        submenu3_4.add(item3_2_4);
        submenu3_4.add(item3_3_4);
        submenu3_4.add(submenu4_4);

        submenu4_4.add(item4_1_4);
        submenu4_4.add(item4_2_4);
        submenu4_4.add(item4_3_4);
        submenu4_4.add(submenu5_4);

        submenu5_4.add(item5_1_4);
        submenu5_4.add(item5_2_4);
        submenu5_4.add(item5_3_4);


        // Set MenuBar to the frame
        frame.setMenuBar(menuBar);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        new AWT_014_MenuBar_MenuItem_and_Menu();
    }
}
