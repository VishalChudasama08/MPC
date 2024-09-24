import javax.swing.*;

public class Swing_015_MenuBar_Menu_MenuItem {
    JFrame frame, frame2;
    Swing_015_MenuBar_Menu_MenuItem() {
        frame = new JFrame("Menu and MenuItem Example");

        // Create a single MenuBar that will hold all menus
        JMenuBar menuBar = new JMenuBar();

        // -------- Menu 1 --------
        JMenu menu1 = new JMenu("Menu 1");
        JMenu submenu1 = new JMenu("Sub Menu 1");
        JMenuItem item1_1 = new JMenuItem("Item 1.1");
        JMenuItem item1_2 = new JMenuItem("Item 1.2");
        JMenuItem item1_3 = new JMenuItem("Item 1.3");
        JMenuItem item1_4 = new JMenuItem("Item 1.4");
        JMenuItem item1_5 = new JMenuItem("Item 1.5");
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
        JMenu menu2 = new JMenu("Menu 2");
        JMenu submenu2 = new JMenu("Sub Menu 2");
        JMenuItem item2_1 = new JMenuItem("Item 2.1");
        JMenuItem item2_2 = new JMenuItem("Item 2.2");
        JMenuItem item2_3 = new JMenuItem("Item 2.3");
        JMenuItem item2_4 = new JMenuItem("Item 2.4");
        JMenuItem item2_5 = new JMenuItem("Item 2.5");
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
        JMenu menu3 = new JMenu("Menu 3");
        JMenu submenu3 = new JMenu("Sub Menu 3");
        JMenuItem item3_1 = new JMenuItem("Item 3.1");
        JMenuItem item3_2 = new JMenuItem("Item 3.2");
        JMenuItem item3_3 = new JMenuItem("Item 3.3");
        JMenuItem item3_4 = new JMenuItem("Item 3.4");
        JMenuItem item3_5 = new JMenuItem("Item 3.5");
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
        JMenu menu4 = new JMenu("Menu 4");

        JMenuItem item4_1 = new JMenuItem("Item 1_4");
        JMenuItem item4_2 = new JMenuItem("Item 2_4");
        JMenuItem item4_3 = new JMenuItem("Item 3_4");

        // Create the first-level submenu with unique names
        JMenu submenu1_4 = new JMenu("Submenu 1_4");
        JMenuItem item1_1_4 = new JMenuItem("Item 1_1_4");
        JMenuItem item1_2_4 = new JMenuItem("Item 1_2_4");
        JMenuItem item1_3_4 = new JMenuItem("Item 1_3_4");

        // Create the second-level submenu with unique names under the last item of submenu1_4
        JMenu submenu2_4 = new JMenu("Submenu 2_4");
        JMenuItem item2_1_4 = new JMenuItem("Item 2_1_4");
        JMenuItem item2_2_4 = new JMenuItem("Item 2_2_4");
        JMenuItem item2_3_4 = new JMenuItem("Item 2_3_4");

        // Create the third-level submenu with unique names under the last item of submenu2_4
        JMenu submenu3_4 = new JMenu("Submenu 3_4");
        JMenuItem item3_1_4 = new JMenuItem("Item 3_1_4");
        JMenuItem item3_2_4 = new JMenuItem("Item 3_2_4");
        JMenuItem item3_3_4 = new JMenuItem("Item 3_3_4");

        // Create the fourth-level submenu with unique names under the last item of submenu3_4
        JMenu submenu4_4 = new JMenu("Submenu 4_4");
        JMenuItem item4_1_4 = new JMenuItem("Item 4_1_4");
        JMenuItem item4_2_4 = new JMenuItem("Item 4_2_4");
        JMenuItem item4_3_4 = new JMenuItem("Item 4_3_4");

        // Create the fifth-level submenu with unique names under the last item of submenu4_4
        JMenu submenu5_4 = new JMenu("Submenu 5_4");
        JMenuItem item5_1_4 = new JMenuItem("Item 5_1_4");
        JMenuItem item5_2_4 = new JMenuItem("Item 5_2_4");
        JMenuItem item5_3_4 = new JMenuItem("Item 5_2_4");

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
        frame.setJMenuBar(menuBar);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);

        MenuForNotepad();
    }

    void MenuForNotepad(){
        frame2 = new JFrame("Notepad");
        frame2.setSize(810, 760);
        frame2.setLayout(null);

        JMenuBar notePade = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu view = new JMenu("View");

        JMenuItem newTab = new JMenuItem("New Tab");
        JMenuItem newWindow = new JMenuItem("New Window");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem saveAs = new JMenuItem("Save As");
        JMenuItem saveAll = new JMenuItem("Save All");
        file.add(newTab);
        file.add(newWindow);
        file.add(open);
        file.add(save);
        file.add(saveAs);
        file.add(saveAll);

        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem paste = new JMenuItem("Paste");
        JMenuItem delete = new JMenuItem("Delete");
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(delete);

        JMenuItem zoom = new JMenuItem("Zoom");
        JMenuItem statusBar = new JMenuItem("Status Bar");
        JMenuItem wordWrap = new JMenuItem("Word Wrap");
        view.add(zoom);
        view.add(statusBar);
        view.add(wordWrap);

        notePade.add(file);
        notePade.add(edit);
        notePade.add(view);

        frame2.setJMenuBar(notePade);

        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);
        frame2.setLocationRelativeTo(null);
    }

    public static void main(String args[]) {
        new Swing_015_MenuBar_Menu_MenuItem();
    }
}
