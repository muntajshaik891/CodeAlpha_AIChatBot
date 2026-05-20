import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AIChatBotGUI extends JFrame {

    JTextPane chatArea;
    JTextField inputField;
    JButton sendButton, clearButton;

    public AIChatBotGUI() {

        // ===== FRAME SETTINGS =====
        setTitle("AI Assistant ChatBot");
        setSize(700, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ===== HEADER PANEL =====
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(25, 118, 210));
        headerPanel.setPreferredSize(new Dimension(700, 80));

        JLabel heading =
                new JLabel("🤖 AI CHATBOT ASSISTANT");

        heading.setForeground(Color.WHITE);

        heading.setFont(
                new Font("Arial", Font.BOLD, 28));

        headerPanel.add(heading);

        // ===== CHAT AREA =====
        chatArea = new JTextPane();

        chatArea.setEditable(false);

        chatArea.setFont(
                new Font("Segoe UI", Font.PLAIN, 18));

        chatArea.setBackground(
                new Color(245, 245, 245));

        chatArea.setMargin(
                new Insets(15, 15, 15, 15));

        JScrollPane scrollPane =
                new JScrollPane(chatArea);

        // ===== BOTTOM PANEL =====
        JPanel bottomPanel = new JPanel();

        bottomPanel.setLayout(new BorderLayout());

        bottomPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        10, 10, 10, 10));

        // ===== INPUT FIELD =====
        inputField = new JTextField();

        inputField.setFont(
                new Font("Segoe UI", Font.PLAIN, 18));

        inputField.setPreferredSize(
                new Dimension(500, 50));

        // ===== BUTTON PANEL =====
        JPanel buttonPanel =
                new JPanel(new GridLayout(1, 2, 10, 0));

        // ===== SEND BUTTON =====
        sendButton = new JButton("Send");

        sendButton.setFont(
                new Font("Arial", Font.BOLD, 16));

        sendButton.setBackground(
                new Color(25, 118, 210));

        sendButton.setForeground(Color.WHITE);

        sendButton.setFocusPainted(false);

        // ===== CLEAR BUTTON =====
        clearButton = new JButton("Clear");

        clearButton.setFont(
                new Font("Arial", Font.BOLD, 16));

        clearButton.setBackground(
                new Color(220, 53, 69));

        clearButton.setForeground(Color.WHITE);

        clearButton.setFocusPainted(false);

        // ===== ADD BUTTONS =====
        buttonPanel.add(sendButton);
        buttonPanel.add(clearButton);

        // ===== ADD COMPONENTS =====
        bottomPanel.add(inputField, BorderLayout.CENTER);

        bottomPanel.add(buttonPanel, BorderLayout.EAST);

        add(headerPanel, BorderLayout.NORTH);

        add(scrollPane, BorderLayout.CENTER);

        add(bottomPanel, BorderLayout.SOUTH);

        // ===== WELCOME MESSAGE =====
        appendMessage(
                "🤖 Bot : Hello! I am your AI Assistant.\n",
                false);

        appendMessage(
                "🤖 Bot : Ask me anything about Java, AI, OOP, Internship, Time, Date.\n",
                false);

        appendMessage(
                "🤖 Bot : Type 'bye' or 'exit' to close the chatbot.\n\n",
                false);

        // ===== SEND BUTTON ACTION =====
        sendButton.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                processChat();
            }
        });

        // ===== ENTER KEY ACTION =====
        inputField.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                processChat();
            }
        });

        // ===== CLEAR BUTTON =====
        clearButton.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                chatArea.setText("");

                appendMessage(
                        "🤖 Bot : Chat Cleared Successfully.\n\n",
                        false);
            }
        });

        setVisible(true);

        // ===== CURSOR FOCUS =====
        SwingUtilities.invokeLater(
                new Runnable() {

            @Override
            public void run() {

                inputField.requestFocusInWindow();
            }
        });
    }

    // ===== APPEND MESSAGE METHOD =====
    public void appendMessage(String message,
                              boolean isBold) {

        StyledDocument doc =
                chatArea.getStyledDocument();

        Style style =
                chatArea.addStyle("Style", null);

        StyleConstants.setBold(style, isBold);

        try {

            doc.insertString(
                    doc.getLength(),
                    message,
                    style);

        } catch (BadLocationException e) {

            e.printStackTrace();
        }
    }

    // ===== CHAT PROCESS =====
    public void processChat() {

        String userText =
                inputField.getText().trim();

        if (userText.isEmpty()) {
            return;
        }

        // ===== USER MESSAGE (BOLD) =====
        appendMessage(
                "🧑 You : " + userText + "\n",
                true);

        String input =
                userText.toLowerCase();

        String response;

        // ===== CHATBOT RESPONSES =====

        if (input.contains("hello") ||
            input.contains("hi")) {

            response =
                    "Hello! How can I assist you today?";
        }

        else if (input.contains("your name")) {

            response =
                    "I am a Java-based AI ChatBot Assistant.";
        }

        else if (input.contains("java")) {

            response =
                    "Java is a high-level, object-oriented programming language created by Oracle Corporation (originally developed by Sun Microsystems in 1995). It is designed to be:\r\n" + //
                                                "Simple – easier to learn than lower-level languages like C++\r\n" + //
                                                "Portable – “Write Once, Run Anywhere” using the Java Virtual Machine (JVM)\r\n" + //
                                                "Secure – widely used in enterprise and banking systems\r\n" + //
                                                "Robust – good memory management and error handling\r\n" + //
                                                "Multithreaded – supports running multiple tasks simultaneously\r\n";
        }

        else if (input.contains("oop")) {

            response =
                    "OOP (Object-Oriented Programming) is a programming concept where programs are designed using objects and classes instead of only functions and logic.\r\n" + //
                                                "Java is mainly based on OOP concepts.\r\n" + //
                                                "Basic Idea of OOP\r\n" + //
                                                "Think of a car 🚗\r\n" + //
                                                "A car has:\r\n" + //
                                                "Properties → color, model, speed\r\n" + //
                                                "Behaviors → start(), stop(), accelerate()\r\n" + //
                                                "In OOP:\r\n" + //
                                                "Class = blueprint/design of the car\r\n" + //
                                                "Object = actual car created from that blueprint";
        }

        else if (input.contains("ai")) {

            response =
                    "Artificial Intelligence (AI) is a technology that enables computers and machines to think, learn, and make decisions similar to humans.\r\n" + //
                                                "AI systems can:\r\n" + //
                                                "Learn from data\r\n" + //
                                                "Recognize patterns\r\n" + //
                                                "Understand language\r\n" + //
                                                "Solve problems\r\n" + //
                                                "Make predictions";
        }

        else if (input.contains("internship")) {

            response =
                    "Internships help students gain practical experience.";
        }

        else if (input.contains("college")) {

            response =
                    "College helps students improve knowledge and skills.";
        }

        else if (input.contains("time")) {

            DateTimeFormatter timeFormat =
                    DateTimeFormatter.ofPattern(
                            "hh:mm:ss a");

            response =
                    "Current Time : "
                    + LocalDateTime.now()
                    .format(timeFormat);
        }

        else if (input.contains("date")) {

            DateTimeFormatter dateFormat =
                    DateTimeFormatter.ofPattern(
                            "dd-MM-yyyy");

            response =
                    "Today's Date : "
                    + LocalDateTime.now()
                    .format(dateFormat);
        }

        else if (input.contains("help")) {

            response =
                    "You can ask me about Java, AI, OOP, Internship, Time, Date, and College.";
        }

        else if (input.contains("bye") ||
                 input.contains("exit")) {

            response =
                    "Goodbye! Have a wonderful day.";
        }

        else {

            response =
                    "Sorry, I couldn't understand your question.";
        }

        // ===== BOT MESSAGE (NORMAL) =====
        appendMessage(
                "🤖 Bot : " + response + "\n\n",
                false);

        // ===== CLEAR INPUT =====
        inputField.setText("");

        // ===== AUTO SCROLL =====
        chatArea.setCaretPosition(
                chatArea.getDocument().getLength());

        // ===== EXIT =====
        if (input.contains("bye") ||
            input.contains("exit")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Chat Ended Successfully!");

            System.exit(0);
        }
    }

    // ===== MAIN METHOD =====
    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                new Runnable() {

            @Override
            public void run() {

                new AIChatBotGUI();
            }
        });
    }
}
