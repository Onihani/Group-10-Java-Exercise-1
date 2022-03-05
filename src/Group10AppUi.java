import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Group10AppUi {
    private static JFrame aboutWindowFrame; // Frame for about window JWindow
    private JPanel framePanel;
    private JPanel enterIntPanel;
    private JLabel inputIntegerLabel;
    private JTextField inputIntegerTextField;
    private JPanel resultPanel;
    private JLabel resultLabel;
    private JTextField resultTextField;

    public Group10AppUi() {
        inputIntegerTextField.addActionListener(e -> {
            String enteredData = inputIntegerTextField.getText();
            String accumulatedResultData = resultTextField.getText();

            try {
                if (!isNumeric(enteredData)) {
                    throw new RuntimeException("Please enter a valid");
                }

                int parsedEnteredData = Integer.parseInt(enteredData);
                int parsedAccumulatedResultData = 0;

                if (isNumeric(accumulatedResultData)) {
                    parsedAccumulatedResultData = Integer.parseInt(accumulatedResultData);
                }

                int result = parsedEnteredData + parsedAccumulatedResultData;

                resultTextField.setText(String.valueOf(result));
            } catch (Exception error) {
                System.out.println("ERROR: " + error.getMessage());
            }
        });
    }

    // method/function to check if a string is numeric or not
    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int i = Integer.parseInt(strNum);
            System.out.println("isNumeric:" + i);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    // function to create menu bar
    private static JMenuBar createAppMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // menus on menu bar
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");

        // fileMenu menu items
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem saveAsMenuItem = new JMenuItem("Save As");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        // editMenu find sub menu
        JMenu findMenu = new JMenu("Find");
        // editMenu find sub menu items
        JMenuItem findMenuItem = new JMenuItem("Find");
        JMenuItem replaceMenuItem = new JMenuItem("Replace");
        // add editMenu find sub menu items to editMenu sub menu
        findMenu.add(findMenuItem);
        findMenu.add(replaceMenuItem);

        // editMenu menu items
        JMenuItem copyMenuItem = new JMenuItem("Copy");
        JMenuItem pasteMenuItem = new JMenuItem("Paste");
        JMenuItem preferencesMenuItem = new JMenuItem("Preferences");

        // editMenu menu items
        JMenuItem aboutMenuItem = new JMenuItem("About");

        // add file menu items to fileMenu
        fileMenu.add(newMenuItem);
        fileMenu.add(saveAsMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        // add edit menu items to editMenu
        editMenu.add(copyMenuItem);
        editMenu.add(pasteMenuItem);
        editMenu.addSeparator();
        editMenu.add(findMenu);
        editMenu.add(preferencesMenuItem);

        // add help menu items to helpMenu
        helpMenu.add(aboutMenuItem);

        // adding menus to the menuBar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        // set mnemonics
        fileMenu.setMnemonic(KeyEvent.VK_F);
        editMenu.setMnemonic(KeyEvent.VK_E);
        helpMenu.setMnemonic(KeyEvent.VK_H);

        // set accelerator to exit program
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));

        // add action listener to about menu item
        aboutMenuItem.addActionListener(e -> {
            // check if aboutWindowFrame is not null and isVisible
            if (aboutWindowFrame != null && aboutWindowFrame.isVisible()) {
                // move about window frame forward
                aboutWindowFrame.toFront();

                return;
            }

            // if aboutWindowFrame is null then show about window;
            showAboutJWindow();
        });

        // add action listener to exit menu item
        exitMenuItem.addActionListener(e -> System.exit(0));

        return menuBar;
    }

    // method/function to show about JWindow
    public static void showAboutJWindow() {
        // create a new frame
        aboutWindowFrame = new JFrame("Group 10 Members");

        // create a panel
        JPanel aboutWindowPanel = new JPanel();

        JTextArea aboutTextArea = new JTextArea(
                String.join("\n"
                        , "Nathaniel Quansah - 01200877D"
                        , "Nathaniel Quansah - 01200877D"
                        , "Nathaniel Quansah - 01200877D"
                        , "Nathaniel Quansah - 01200877D"
                        , "Nathaniel Quansah - 01200877D"
                        , "Nathaniel Quansah - 01200877D"
                ));

        // add button to panel
        aboutWindowPanel.add(aboutTextArea);

        aboutWindowFrame.add(aboutWindowPanel);

        // set relative to null
        aboutWindowFrame.setLocationRelativeTo(null);
        // set the size of frame
        aboutWindowFrame.setSize(400, 400);
        // make it visible
        aboutWindowFrame.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Java Group 10 Exercise 1.0 App");
        frame.setContentPane(new Group10AppUi().framePanel);
        frame.setLocationRelativeTo(null);
        frame.setJMenuBar(createAppMenuBar());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 300);
        frame.setVisible(true);
    }
}
