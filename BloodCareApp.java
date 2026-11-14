import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BloodCareApp extends JFrame {

    // =========================================================
    // COLORS
    // =========================================================
    private final Color RED = new Color(190, 35, 55);
    private final Color DARK = new Color(35, 38, 45);
    private final Color BG = new Color(245, 247, 250);
    private final Color WHITE = Color.WHITE;
    private final Color GREEN = new Color(40, 160, 100);
    private final Color BLUE = new Color(55, 115, 210);
    private final Color ORANGE = new Color(230, 145, 45);

    // =========================================================
    // LOGIN
    // =========================================================
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "1234";

    // =========================================================
    // MAIN UI
    // =========================================================
    private JPanel contentPanel;
    private JLabel pageTitle;
    private JLabel loggedUser;

    // =========================================================
    // DATA
    // =========================================================
    private final List<Donor> donors = new ArrayList<>();

    private int aPositive = 18;
    private int aNegative = 8;
    private int bPositive = 15;
    private int bNegative = 6;
    private int abPositive = 10;
    private int abNegative = 4;
    private int oPositive = 25;
    private int oNegative = 9;

    private DefaultTableModel donorModel;

    // =========================================================
    // DONOR CLASS
    // =========================================================
    static class Donor {
        String id;
        String name;
        int age;
        String gender;
        String blood;
        String phone;
        String city;

        Donor(String id, String name, int age,
              String gender, String blood,
              String phone, String city) {

            this.id = id;
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.blood = blood;
            this.phone = phone;
            this.city = city;
        }
    }

    // =========================================================
    // CONSTRUCTOR
    // =========================================================
    public BloodCareApp() {

        setTitle("BloodCare - Blood Bank Management System");
        setSize(1200, 750);
        setMinimumSize(new Dimension(1000, 650));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loadSampleData();

        // Open Welcome/Login Page first
        showWelcomePage();
    }

    // =========================================================
    // SAMPLE DATA
    // =========================================================
    private void loadSampleData() {

        donors.add(new Donor(
                "D001",
                "Rahul Sharma",
                22,
                "Male",
                "O+",
                "9876543210",
                "Panipat"
        ));

        donors.add(new Donor(
                "D002",
                "Priya Singh",
                21,
                "Female",
                "A+",
                "9876501234",
                "Delhi"
        ));

        donors.add(new Donor(
                "D003",
                "Aman Kumar",
                24,
                "Male",
                "B+",
                "9876512345",
                "Karnal"
        ));
    }

    // =========================================================
    // WELCOME / LOGIN PAGE
    // =========================================================
    private void showWelcomePage() {

        JPanel background = new JPanel(new GridBagLayout());
        background.setBackground(RED);

        JPanel card = new JPanel(new GridBagLayout());

        card.setBackground(WHITE);

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(220, 220, 220), 1
                        ),
                        new EmptyBorder(35, 45, 35, 45)
                )
        );

        card.setPreferredSize(
                new Dimension(480, 540)
        );

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(8, 10, 8, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Heart Logo
        JLabel logo = new JLabel(
                "♥",
                SwingConstants.CENTER
        );

        logo.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        70
                )
        );

        logo.setForeground(RED);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        card.add(logo, gbc);

        // Welcome Title
        JLabel title = new JLabel(
                "Welcome to BloodCare",
                SwingConstants.CENTER
        );

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        28
                )
        );

        title.setForeground(DARK);

        gbc.gridy = 1;

        card.add(title, gbc);

        // Subtitle
        JLabel subtitle = new JLabel(
                "Blood Bank Management System",
                SwingConstants.CENTER
        );

        subtitle.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        15
                )
        );

        subtitle.setForeground(Color.GRAY);

        gbc.gridy = 2;

        card.add(subtitle, gbc);

        // Space
        gbc.gridy = 3;

        card.add(
                new JLabel(" "),
                gbc
        );

        // Username Label
        JLabel userLabel = new JLabel(
                "Username"
        );

        userLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        gbc.gridy = 4;

        card.add(userLabel, gbc);

        // Username Field
        JTextField usernameField =
                new JTextField();

        usernameField.setPreferredSize(
                new Dimension(300, 40)
        );

        usernameField.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        15
                )
        );

        gbc.gridy = 5;

        card.add(
                usernameField,
                gbc
        );

        // Password Label
        JLabel passLabel = new JLabel(
                "Password"
        );

        passLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        gbc.gridy = 6;

        card.add(
                passLabel,
                gbc
        );

        // Password Field
        JPasswordField passwordField =
                new JPasswordField();

        passwordField.setPreferredSize(
                new Dimension(300, 40)
        );

        passwordField.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        15
                )
        );

        gbc.gridy = 7;

        card.add(
                passwordField,
                gbc
        );

        // Login Button
        JButton loginButton =
                new JButton("LOGIN  →");

        loginButton.setPreferredSize(
                new Dimension(300, 45)
        );

        loginButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        15
                )
        );

        loginButton.setForeground(WHITE);
        loginButton.setBackground(RED);
        loginButton.setFocusPainted(false);
        loginButton.setBorderPainted(false);
        loginButton.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        gbc.gridy = 8;

        card.add(
                loginButton,
                gbc
        );

        // Demo Details
        JLabel demo = new JLabel(
                "<html><center>"
                        + "<font color='#777777'>"
                        + "Demo Login<br><br>"
                        + "<b>Username:</b> admin<br>"
                        + "<b>Password:</b> 1234"
                        + "</font>"
                        + "</center></html>",
                SwingConstants.CENTER
        );

        gbc.gridy = 9;

        card.add(
                demo,
                gbc
        );

        // Login Action
        loginButton.addActionListener(e -> {

            String user =
                    usernameField
                            .getText()
                            .trim();

            String pass =
                    new String(
                            passwordField
                                    .getPassword()
                    );

            if (user.equals(USERNAME)
                    && pass.equals(PASSWORD)) {

                JOptionPane.showMessageDialog(
                        this,
                        "Login Successful!\n"
                                + "Welcome, " + user + "!",
                        "Welcome",
                        JOptionPane.INFORMATION_MESSAGE
                );

                createMainUI();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Invalid Username or Password!",
                        "Login Failed",
                        JOptionPane.ERROR_MESSAGE
                );

                passwordField.setText("");
            }
        });

        // Enter Key Login
        passwordField.addActionListener(
                e -> loginButton.doClick()
        );

        background.add(card);

        setContentPane(background);

        revalidate();
        repaint();
    }

    // =========================================================
    // MAIN UI
    // =========================================================
    private void createMainUI() {

        JPanel root =
                new JPanel(
                        new BorderLayout()
                );

        root.setBackground(BG);

        root.add(
                createSidebar(),
                BorderLayout.WEST
        );

        root.add(
                createContentArea(),
                BorderLayout.CENTER
        );

        setContentPane(root);

        showDashboard();
    }

    // =========================================================
    // SIDEBAR
    // =========================================================
    private JPanel createSidebar() {

        JPanel sidebar =
                new JPanel(
                        new BorderLayout()
                );

        sidebar.setPreferredSize(
                new Dimension(230, 0)
        );

        sidebar.setBackground(DARK);

        // Logo
        JPanel logoPanel =
                new JPanel();

        logoPanel.setBackground(DARK);

        logoPanel.setBorder(
                new EmptyBorder(
                        25, 15, 25, 15
                )
        );

        JLabel logo =
                new JLabel(
                        "<html><div style='text-align:center;'>"
                                + "<font color='white' size='6'>♥</font><br>"
                                + "<font color='white' size='5'>"
                                + "<b>BloodCare</b>"
                                + "</font>"
                                + "</div></html>"
                );

        logoPanel.add(logo);

        // Menu
        JPanel menu =
                new JPanel(
                        new GridLayout(
                                7, 1, 0, 8
                        )
                );

        menu.setBackground(DARK);

        menu.setBorder(
                new EmptyBorder(
                        10, 12, 10, 12
                )
        );

        JButton dashboard =
                menuButton("⌂   Dashboard");

        JButton donorsButton =
                menuButton("♙   Donors");

        JButton inventory =
                menuButton("▣   Blood Inventory");

        JButton request =
                menuButton("♥   Blood Request");

        JButton statistics =
                menuButton("◈   Statistics");

        JButton about =
                menuButton("ⓘ   About");

        JButton exit =
                menuButton("×   Exit");

        menu.add(dashboard);
        menu.add(donorsButton);
        menu.add(inventory);
        menu.add(request);
        menu.add(statistics);
        menu.add(about);
        menu.add(exit);

        dashboard.addActionListener(
                e -> showDashboard()
        );

        donorsButton.addActionListener(
                e -> showDonors()
        );

        inventory.addActionListener(
                e -> showInventory()
        );

        request.addActionListener(
                e -> showBloodRequest()
        );

        statistics.addActionListener(
                e -> showStatistics()
        );

        about.addActionListener(
                e -> showAbout()
        );

        exit.addActionListener(e -> {

            int result =
                    JOptionPane.showConfirmDialog(
                            this,
                            "Are you sure you want to exit?",
                            "Exit",
                            JOptionPane.YES_NO_OPTION
                    );

            if (result ==
                    JOptionPane.YES_OPTION) {

                System.exit(0);
            }
        });

        sidebar.add(
                logoPanel,
                BorderLayout.NORTH
        );

        sidebar.add(
                menu,
                BorderLayout.CENTER
        );

        JLabel footer =
                new JLabel(
                        "Blood Donation Saves Lives",
                        SwingConstants.CENTER
                );

        footer.setForeground(
                Color.LIGHT_GRAY
        );

        footer.setBorder(
                new EmptyBorder(
                        15, 5, 15, 5
                )
        );

        sidebar.add(
                footer,
                BorderLayout.SOUTH
        );

        return sidebar;
    }

    // =========================================================
    // MENU BUTTON
    // =========================================================
    private JButton menuButton(
            String text) {

        JButton button =
                new JButton(text);

        button.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        button.setForeground(WHITE);
        button.setBackground(DARK);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setHorizontalAlignment(
                SwingConstants.LEFT
        );

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        return button;
    }

    // =========================================================
    // CONTENT AREA
    // =========================================================
    private JPanel createContentArea() {

        JPanel main =
                new JPanel(
                        new BorderLayout()
                );

        main.setBackground(BG);

        JPanel header =
                new JPanel(
                        new BorderLayout()
                );

        header.setBackground(WHITE);

        header.setBorder(
                new EmptyBorder(
                        18, 25, 18, 25
                )
        );

        pageTitle =
                new JLabel("Dashboard");

        pageTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        26
                )
        );

        pageTitle.setForeground(DARK);

        loggedUser =
                new JLabel(
                        "Administrator  ●"
                );

        loggedUser.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        loggedUser.setForeground(GREEN);

        header.add(
                pageTitle,
                BorderLayout.WEST
        );

        header.add(
                loggedUser,
                BorderLayout.EAST
        );

        contentPanel =
                new JPanel(
                        new BorderLayout()
                );

        contentPanel.setBackground(BG);

        main.add(
                header,
                BorderLayout.NORTH
        );

        main.add(
                contentPanel,
                BorderLayout.CENTER
        );

        return main;
    }

    // =========================================================
    // DASHBOARD
    // =========================================================
    private void showDashboard() {

        pageTitle.setText("Dashboard");

        JPanel panel =
                basePanel();

        JLabel welcome =
                new JLabel(
                        "<html>"
                                + "<font size='5'>"
                                + "<b>Welcome to BloodCare</b>"
                                + "</font><br>"
                                + "<font color='#666666'>"
                                + "Manage donors, blood inventory "
                                + "and requests from one place."
                                + "</font>"
                                + "</html>"
                );

        welcome.setBorder(
                new EmptyBorder(
                        10, 10, 20, 10
                )
        );

        panel.add(
                welcome,
                BorderLayout.NORTH
        );

        JPanel cards =
                new JPanel(
                        new GridLayout(
                                1, 4, 18, 18
                        )
                );

        cards.setBackground(BG);

        cards.add(
                statCard(
                        "TOTAL DONORS",
                        String.valueOf(
                                donors.size()
                        ),
                        BLUE
                )
        );

        cards.add(
                statCard(
                        "TOTAL BLOOD",
                        String.valueOf(
                                getTotalBloodUnits()
                        ),
                        RED
                )
        );

        cards.add(
                statCard(
                        "BLOOD GROUPS",
                        "8",
                        ORANGE
                )
        );

        cards.add(
                statCard(
                        "AVAILABLE",
                        "YES",
                        GREEN
                )
        );

        panel.add(
                cards,
                BorderLayout.CENTER
        );

        JPanel lower =
                new JPanel(
                        new BorderLayout(
                                15, 15
                        )
                );

        lower.setBackground(BG);

        lower.setBorder(
                new EmptyBorder(
                        25, 0, 0, 0
                )
        );

        lower.add(
                createQuickActions(),
                BorderLayout.CENTER
        );

        lower.add(
                createBloodSummary(),
                BorderLayout.EAST
        );

        panel.add(
                lower,
                BorderLayout.SOUTH
        );

        contentPanel.removeAll();

        contentPanel.add(panel);

        refresh();
    }

    // =========================================================
    // QUICK ACTIONS
    // =========================================================
    private JPanel createQuickActions() {

        JPanel panel =
                new JPanel(
                        new GridLayout(
                                2, 2, 12, 12
                        )
                );

        panel.setBackground(WHITE);

        panel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(225, 225, 225)
                        ),
                        new EmptyBorder(
                                20, 20, 20, 20
                        )
                )
        );

        JButton add =
                normalButton(
                        "Add New Donor",
                        RED
                );

        JButton search =
                normalButton(
                        "Search Donor",
                        BLUE
                );

        JButton issue =
                normalButton(
                        "Issue Blood",
                        GREEN
                );

        JButton request =
                normalButton(
                        "New Request",
                        ORANGE
                );

        add.addActionListener(
                e -> showDonorForm()
        );

        search.addActionListener(
                e -> showDonors()
        );

        issue.addActionListener(
                e -> showInventory()
        );

        request.addActionListener(
                e -> showBloodRequest()
        );

        panel.add(add);
        panel.add(search);
        panel.add(issue);
        panel.add(request);

        return panel;
    }

    // =========================================================
    // BLOOD SUMMARY
    // =========================================================
    private JPanel createBloodSummary() {

        JPanel panel =
                new JPanel(
                        new GridLayout(
                                4, 2, 10, 8
                        )
                );

        panel.setPreferredSize(
                new Dimension(300, 180)
        );

        panel.setBackground(WHITE);

        panel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(225, 225, 225)
                        ),
                        new EmptyBorder(
                                15, 20, 15, 20
                        )
                )
        );

        panel.add(
                boldLabel("Blood")
        );

        panel.add(
                boldLabel("Units")
        );

        addSummary(
                panel,
                "A+",
                aPositive
        );

        addSummary(
                panel,
                "B+",
                bPositive
        );

        addSummary(
                panel,
                "O+",
                oPositive
        );

        return panel;
    }

    private void addSummary(
            JPanel panel,
            String group,
            int units) {

        panel.add(
                new JLabel(group)
        );

        JLabel value =
                new JLabel(
                        units + " units"
                );

        value.setForeground(RED);

        value.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        panel.add(value);
    }

    // =========================================================
    // DONORS PAGE
    // =========================================================
    private void showDonors() {

        pageTitle.setText(
                "Donor Management"
        );

        JPanel panel =
                basePanel();

        JPanel top =
                new JPanel(
                        new BorderLayout()
                );

        top.setBackground(BG);

        JButton addButton =
                normalButton(
                        "+  Register New Donor",
                        RED
                );

        addButton.addActionListener(
                e -> showDonorForm()
        );

        top.add(
                addButton,
                BorderLayout.WEST
        );

        panel.add(
                top,
                BorderLayout.NORTH
        );

        String[] columns = {
                "ID",
                "Name",
                "Age",
                "Gender",
                "Blood Group",
                "Phone",
                "City"
        };

        donorModel =
                new DefaultTableModel(
                        columns,
                        0
                ) {

                    @Override
                    public boolean isCellEditable(
                            int row,
                            int column) {

                        return false;
                    }
                };

        JTable table =
                new JTable(donorModel);

        table.setRowHeight(35);

        table.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        13
                )
        );

        table.getTableHeader()
                .setFont(
                        new Font(
                                "Arial",
                                Font.BOLD,
                                13
                        )
                );

        loadDonorTable();

        JScrollPane scroll =
                new JScrollPane(table);

        panel.add(
                scroll,
                BorderLayout.CENTER
        );

        JPanel bottom =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.LEFT
                        )
                );

        bottom.setBackground(BG);

        JButton delete =
                normalButton(
                        "Delete Selected",
                        RED
                );

        delete.addActionListener(e -> {

            int row =
                    table.getSelectedRow();

            if (row == -1) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please select a donor first."
                );

                return;
            }

            String id =
                    donorModel
                            .getValueAt(row, 0)
                            .toString();

            donors.removeIf(
                    d -> d.id.equals(id)
            );

            loadDonorTable();

            JOptionPane.showMessageDialog(
                    this,
                    "Donor deleted successfully."
            );
        });

        bottom.add(delete);

        panel.add(
                bottom,
                BorderLayout.SOUTH
        );

        contentPanel.removeAll();

        contentPanel.add(panel);

        refresh();
    }

    // =========================================================
    // LOAD DONOR TABLE
    // =========================================================
    private void loadDonorTable() {

        if (donorModel == null)
            return;

        donorModel.setRowCount(0);

        for (Donor d : donors) {

            donorModel.addRow(
                    new Object[]{
                            d.id,
                            d.name,
                            d.age,
                            d.gender,
                            d.blood,
                            d.phone,
                            d.city
                    }
            );
        }
    }

    // =========================================================
    // DONOR FORM
    // =========================================================
    private void showDonorForm() {

        pageTitle.setText(
                "Register Donor"
        );

        JPanel panel =
                basePanel();

        JPanel form =
                new JPanel(
                        new GridBagLayout()
                );

        form.setBackground(WHITE);

        form.setBorder(
                new EmptyBorder(
                        25, 80, 25, 80
                )
        );

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(
                        10, 10, 10, 10
                );

        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        JTextField id = field();
        JTextField name = field();
        JTextField age = field();
        JTextField phone = field();
        JTextField city = field();

        JComboBox<String> gender =
                new JComboBox<>(
                        new String[]{
                                "Male",
                                "Female",
                                "Other"
                        }
                );

        JComboBox<String> blood =
                new JComboBox<>(
                        new String[]{
                                "A+",
                                "A-",
                                "B+",
                                "B-",
                                "AB+",
                                "AB-",
                                "O+",
                                "O-"
                        }
                );

        addFormRow(
                form,
                gbc,
                0,
                "Donor ID",
                id
        );

        addFormRow(
                form,
                gbc,
                1,
                "Full Name",
                name
        );

        addFormRow(
                form,
                gbc,
                2,
                "Age",
                age
        );

        addFormRow(
                form,
                gbc,
                3,
                "Gender",
                gender
        );

        addFormRow(
                form,
                gbc,
                4,
                "Blood Group",
                blood
        );

        addFormRow(
                form,
                gbc,
                5,
                "Phone Number",
                phone
        );

        addFormRow(
                form,
                gbc,
                6,
                "City",
                city
        );

        JButton save =
                normalButton(
                        "Save Donor",
                        RED
                );

        gbc.gridx = 1;
        gbc.gridy = 7;

        form.add(
                save,
                gbc
        );

        save.addActionListener(e -> {

            if (id.getText().trim().isEmpty()
                    || name.getText().trim().isEmpty()
                    || age.getText().trim().isEmpty()
                    || phone.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please fill all required fields.",
                        "Validation",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            int donorAge;

            try {

                donorAge =
                        Integer.parseInt(
                                age.getText()
                        );

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Age must be a number."
                );

                return;
            }

            if (donorAge < 18
                    || donorAge > 65) {

                JOptionPane.showMessageDialog(
                        this,
                        "Donor age should be between 18 and 65."
                );

                return;
            }

            Donor d =
                    new Donor(
                            id.getText(),
                            name.getText(),
                            donorAge,
                            gender.getSelectedItem()
                                    .toString(),
                            blood.getSelectedItem()
                                    .toString(),
                            phone.getText(),
                            city.getText()
                    );

            donors.add(d);

            increaseBlood(
                    d.blood,
                    1
            );

            JOptionPane.showMessageDialog(
                    this,
                    "Donor registered successfully!\n"
                            + "1 unit added to blood inventory.",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );

            showDonors();
        });

        panel.add(
                form,
                BorderLayout.CENTER
        );

        contentPanel.removeAll();

        contentPanel.add(panel);

        refresh();
    }

    // =========================================================
    // INVENTORY
    // =========================================================
    private void showInventory() {

        pageTitle.setText(
                "Blood Inventory"
        );

        JPanel panel =
                basePanel();

        JPanel inventory =
                new JPanel(
                        new GridLayout(
                                4, 2, 18, 18
                        )
                );

        inventory.setBackground(BG);

        inventory.setBorder(
                new EmptyBorder(
                        20, 20, 20, 20
                )
        );

        inventory.add(
                inventoryCard(
                        "A+",
                        aPositive
                )
        );

        inventory.add(
                inventoryCard(
                        "A-",
                        aNegative
                )
        );

        inventory.add(
                inventoryCard(
                        "B+",
                        bPositive
                )
        );

        inventory.add(
                inventoryCard(
                        "B-",
                        bNegative
                )
        );

        inventory.add(
                inventoryCard(
                        "AB+",
                        abPositive
                )
        );

        inventory.add(
                inventoryCard(
                        "AB-",
                        abNegative
                )
        );

        inventory.add(
                inventoryCard(
                        "O+",
                        oPositive
                )
        );

        inventory.add(
                inventoryCard(
                        "O-",
                        oNegative
                )
        );

        panel.add(
                inventory,
                BorderLayout.CENTER
        );

        contentPanel.removeAll();

        contentPanel.add(panel);

        refresh();
    }

    // =========================================================
    // INVENTORY CARD
    // =========================================================
    private JPanel inventoryCard(
            String group,
            int units) {

        JPanel card =
                new JPanel(
                        new BorderLayout()
                );

        card.setBackground(WHITE);

        card.setBorder(
                BorderFactory.createLineBorder(
                        new Color(
                                220,
                                220,
                                220
                        )
                )
        );

        JLabel blood =
                new JLabel(
                        "  Blood Group " + group
                );

        blood.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        20
                )
        );

        blood.setForeground(RED);

        JLabel amount =
                new JLabel(
                        units + " Units",
                        SwingConstants.CENTER
                );

        amount.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        25
                )
        );

        JButton issue =
                normalButton(
                        "Issue 1 Unit",
                        GREEN
                );

        issue.addActionListener(e -> {

            if (getBloodUnits(group) <= 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "No " + group
                                + " blood available."
                );

                return;
            }

            decreaseBlood(
                    group,
                    1
            );

            JOptionPane.showMessageDialog(
                    this,
                    "1 unit of "
                            + group
                            + " blood issued."
            );

            showInventory();
        });

        card.add(
                blood,
                BorderLayout.NORTH
        );

        card.add(
                amount,
                BorderLayout.CENTER
        );

        card.add(
                issue,
                BorderLayout.SOUTH
        );

        return card;
    }

    // =========================================================
    // BLOOD REQUEST
    // =========================================================
    private void showBloodRequest() {

        pageTitle.setText(
                "Blood Request"
        );

        JPanel panel =
                basePanel();

        JPanel form =
                new JPanel(
                        new GridLayout(
                                6, 2, 15, 15
                        )
                );

        form.setBackground(WHITE);

        form.setBorder(
                new EmptyBorder(
                        50, 100, 50, 100
                )
        );

        JTextField hospital = field();
        JTextField patient = field();
        JTextField units = field();

        JComboBox<String> blood =
                new JComboBox<>(
                        new String[]{
                                "A+",
                                "A-",
                                "B+",
                                "B-",
                                "AB+",
                                "AB-",
                                "O+",
                                "O-"
                        }
                );

        JButton submit =
                normalButton(
                        "Submit Request",
                        RED
                );

        form.add(
                boldLabel("Hospital Name")
        );

        form.add(hospital);

        form.add(
                boldLabel("Patient Name")
        );

        form.add(patient);

        form.add(
                boldLabel("Blood Group")
        );

        form.add(blood);

        form.add(
                boldLabel("Required Units")
        );

        form.add(units);

        form.add(
                new JLabel("")
        );

        form.add(submit);

        submit.addActionListener(e -> {

            if (hospital.getText().isEmpty()
                    || patient.getText().isEmpty()
                    || units.getText().isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please complete the request."
                );

                return;
            }

            int required;

            try {

                required =
                        Integer.parseInt(
                                units.getText()
                        );

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Units must be a number."
                );

                return;
            }

            if (required <= 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Units must be greater than 0."
                );

                return;
            }

            String group =
                    blood.getSelectedItem()
                            .toString();

            if (getBloodUnits(group)
                    < required) {

                JOptionPane.showMessageDialog(
                        this,
                        "Insufficient "
                                + group
                                + " blood available.",
                        "Request Failed",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            decreaseBlood(
                    group,
                    required
            );

            JOptionPane.showMessageDialog(
                    this,
                    "Blood Request Approved!\n\n"
                            + "Hospital: "
                            + hospital.getText()
                            + "\nPatient: "
                            + patient.getText()
                            + "\nBlood: "
                            + group
                            + "\nUnits: "
                            + required,
                    "Request Approved",
                    JOptionPane.INFORMATION_MESSAGE
            );

            hospital.setText("");
            patient.setText("");
            units.setText("");
        });

        panel.add(
                form,
                BorderLayout.CENTER
        );

        contentPanel.removeAll();

        contentPanel.add(panel);

        refresh();
    }

    // =========================================================
    // STATISTICS
    // =========================================================
    private void showStatistics() {

        pageTitle.setText(
                "Statistics"
        );

        JPanel panel =
                basePanel();

        JPanel stats =
                new JPanel(
                        new GridLayout(
                                2, 2, 20, 20
                        )
                );

        stats.setBackground(BG);

        stats.setBorder(
                new EmptyBorder(
                        30, 30, 30, 30
                )
        );

        stats.add(
                statCard(
                        "REGISTERED DONORS",
                        String.valueOf(
                                donors.size()
                        ),
                        BLUE
                )
        );

        stats.add(
                statCard(
                        "TOTAL BLOOD UNITS",
                        String.valueOf(
                                getTotalBloodUnits()
                        ),
                        RED
                )
        );

        stats.add(
                statCard(
                        "MALE DONORS",
                        String.valueOf(
                                countGender("Male")
                        ),
                        GREEN
                )
        );

        stats.add(
                statCard(
                        "FEMALE DONORS",
                        String.valueOf(
                                countGender("Female")
                        ),
                        ORANGE
                )
        );

        panel.add(
                stats,
                BorderLayout.CENTER
        );

        contentPanel.removeAll();

        contentPanel.add(panel);

        refresh();
    }

    // =========================================================
    // ABOUT
    // =========================================================
    private void showAbout() {

        pageTitle.setText(
                "About BloodCare"
        );

        JPanel panel =
                basePanel();

        JPanel about =
                new JPanel(
                        new GridBagLayout()
                );

        about.setBackground(WHITE);

        about.setBorder(
                new EmptyBorder(
                        40, 50, 40, 50
                )
        );

        JLabel title =
                new JLabel(
                        "<html><center>"
                                + "<font size='7' color='#BE2337'>♥</font><br>"
                                + "<font size='6'>"
                                + "<b>BloodCare</b>"
                                + "</font>"
                                + "</center></html>"
                );

        JLabel info =
                new JLabel(
                        "<html><center>"
                                + "<font size='4'>"
                                + "Blood Bank Management System"
                                + "</font><br><br>"
                                + "Developed using Java Swing GUI"
                                + "<br>"
                                + "College Project"
                                + "<br><br>"
                                + "<b>Purpose:</b><br>"
                                + "To manage blood donors, blood stock"
                                + "<br>"
                                + "and hospital blood requests."
                                + "</center></html>"
                );

        JPanel box =
                new JPanel(
                        new BorderLayout(
                                10,
                                20
                        )
                );

        box.setBackground(WHITE);

        box.add(
                title,
                BorderLayout.NORTH
        );

        box.add(
                info,
                BorderLayout.CENTER
        );

        about.add(box);

        panel.add(
                about,
                BorderLayout.CENTER
        );

        contentPanel.removeAll();

        contentPanel.add(panel);

        refresh();
    }

    // =========================================================
    // UTILITY METHODS
    // =========================================================
    private JPanel basePanel() {

        JPanel panel =
                new JPanel(
                        new BorderLayout()
                );

        panel.setBackground(BG);

        panel.setBorder(
                new EmptyBorder(
                        25, 25, 25, 25
                )
        );

        return panel;
    }

    private JPanel statCard(
            String title,
            String value,
            Color color) {

        JPanel card =
                new JPanel(
                        new BorderLayout()
                );

        card.setBackground(WHITE);

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(
                                        225,
                                        225,
                                        225
                                )
                        ),
                        new EmptyBorder(
                                20, 20, 20, 20
                        )
                )
        );

        JLabel t =
                new JLabel(title);

        t.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        13
                )
        );

        t.setForeground(
                Color.GRAY
        );

        JLabel v =
                new JLabel(
                        value,
                        SwingConstants.CENTER
                );

        v.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        32
                )
        );

        v.setForeground(color);

        card.add(
                t,
                BorderLayout.NORTH
        );

        card.add(
                v,
                BorderLayout.CENTER
        );

        return card;
    }

    private JButton normalButton(
            String text,
            Color color) {

        JButton button =
                new JButton(text);

        button.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        13
                )
        );

        button.setForeground(WHITE);

        button.setBackground(color);

        button.setFocusPainted(false);

        button.setBorderPainted(false);

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        return button;
    }

    private JTextField field() {

        JTextField field =
                new JTextField();

        field.setPreferredSize(
                new Dimension(
                        200,
                        35
                )
        );

        return field;
    }

    private JLabel boldLabel(
            String text) {

        JLabel label =
                new JLabel(text);

        label.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        return label;
    }

    private void addFormRow(
            JPanel panel,
            GridBagConstraints gbc,
            int row,
            String label,
            Component component) {

        gbc.gridx = 0;
        gbc.gridy = row;

        panel.add(
                boldLabel(label),
                gbc
        );

        gbc.gridx = 1;

        panel.add(
                component,
                gbc
        );
    }

    // =========================================================
    // BLOOD CALCULATIONS
    // =========================================================
    private int getTotalBloodUnits() {

        return aPositive
                + aNegative
                + bPositive
                + bNegative
                + abPositive
                + abNegative
                + oPositive
                + oNegative;
    }

    private int getBloodUnits(
            String group) {

        switch (group) {

            case "A+":
                return aPositive;

            case "A-":
                return aNegative;

            case "B+":
                return bPositive;

            case "B-":
                return bNegative;

            case "AB+":
                return abPositive;

            case "AB-":
                return abNegative;

            case "O+":
                return oPositive;

            case "O-":
                return oNegative;

            default:
                return 0;
        }
    }

    private void increaseBlood(
            String group,
            int amount) {

        switch (group) {

            case "A+":
                aPositive += amount;
                break;

            case "A-":
                aNegative += amount;
                break;

            case "B+":
                bPositive += amount;
                break;

            case "B-":
                bNegative += amount;
                break;

            case "AB+":
                abPositive += amount;
                break;

            case "AB-":
                abNegative += amount;
                break;

            case "O+":
                oPositive += amount;
                break;

            case "O-":
                oNegative += amount;
                break;
        }
    }

    private void decreaseBlood(
            String group,
            int amount) {

        switch (group) {

            case "A+":
                aPositive -= amount;
                break;

            case "A-":
                aNegative -= amount;
                break;

            case "B+":
                bPositive -= amount;
                break;

            case "B-":
                bNegative -= amount;
                break;

            case "AB+":
                abPositive -= amount;
                break;

            case "AB-":
                abNegative -= amount;
                break;

            case "O+":
                oPositive -= amount;
                break;

            case "O-":
                oNegative -= amount;
                break;
        }
    }

    private int countGender(
            String gender) {

        int count = 0;

        for (Donor d : donors) {

            if (d.gender.equals(gender)) {
                count++;
            }
        }

        return count;
    }

    private void refresh() {

        contentPanel.revalidate();

        contentPanel.repaint();
    }

    // =========================================================
    // MAIN METHOD
    // =========================================================
    public static void main(
            String[] args) {

        try {

            UIManager.setLookAndFeel(
                    UIManager
                            .getSystemLookAndFeelClassName()
            );

        } catch (Exception ignored) {
        }

        SwingUtilities.invokeLater(() -> {

            BloodCareApp app =
                    new BloodCareApp();

            app.setVisible(true);
        });
    }
}