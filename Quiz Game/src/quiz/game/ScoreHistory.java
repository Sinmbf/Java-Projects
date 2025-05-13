package quiz.game;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class ScoreHistory {

    boolean isMostRecentSelected = false;
    JComboBox<String> sortOrderComboBox;  // Declare as an instance variable
    JFrame frame;
    CustomStack<String[]> leaderboardStack;

    public static void main(String[] args) {
        new ScoreHistory();
    }

    ScoreHistory() {
        // Create the frame
        frame = new JFrame("Leaderboard");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Read scores from the file
        leaderboardStack = readScoresFromFile("scores.txt");

        // Create a panel to hold the sorting options and the table
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Create the combo box for sorting order
        String[] sortOptions = {"Top Score", "Most Recent"};
        sortOrderComboBox = new JComboBox<>(sortOptions);
        sortOrderComboBox.setSelectedIndex(0); // Default to "Top Score"
        
        // Add an action listener to update the sorting order based on user selection
        sortOrderComboBox.addActionListener(e -> {
            isMostRecentSelected = sortOrderComboBox.getSelectedIndex() == 1;  // If "Most Recent" is selected
            refreshTable(panel);  // Refresh the table based on the new selection
        });

        // Add the combo box to the panel above the table
        panel.add(sortOrderComboBox, BorderLayout.NORTH);

        // Initial table display
        refreshTable(panel);

        // Add the panel to the frame
        frame.add(panel, BorderLayout.CENTER);

        // Make the frame visible
        frame.setVisible(true);
    }

    private void refreshTable(JPanel panel) {
        // Convert the stack data to a format suitable for JTable
        String[] columnNames = {"Username", "Score", "Played On"};
        String[][] tableData;

        // Extract the data from the stack into a temporary array
        String[][] tempData = new String[leaderboardStack.size()][];

        // Fill tempData with the current stack contents
        CustomStack<String[]> tempStack = new CustomStack<>(leaderboardStack.size());
        for (int i = 0; !leaderboardStack.isEmpty(); i++) {
            tempData[i] = leaderboardStack.pop();
            tempStack.push(tempData[i]);  // Preserve the original stack order
        }

        // Restore the original stack (after temporary pop for table display)
        while (!tempStack.isEmpty()) {
            leaderboardStack.push(tempStack.pop());
        }

        // If "Most Recent" is selected, display data as is (no need to reverse)
        if (isMostRecentSelected) {
            // Simply use the data as it is, without reversing
            tableData = tempData;
        } else {
            // Sort the array by score (descending order)
            for (int i = 0; i < tempData.length - 1; i++) {
                int maxIndex = i;
                for (int j = i + 1; j < tempData.length; j++) {
                    int score1 = Integer.parseInt(tempData[j][1]);
                    int score2 = Integer.parseInt(tempData[maxIndex][1]);
                    if (score1 > score2) {
                        maxIndex = j; // Find the maximum score (for descending order)
                    }
                }
                // Swap elements
                String[] temp = tempData[i];
                tempData[i] = tempData[maxIndex];
                tempData[maxIndex] = temp;
            }
            tableData = tempData;
        }

        // Create the table
        JTable leaderboardTable = new JTable(tableData, columnNames);
        leaderboardTable.setFont(new Font("Arial", Font.PLAIN, 17));
        leaderboardTable.setRowHeight(25);

        // Style the header
        JTableHeader header = leaderboardTable.getTableHeader();
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

                JLabel label = (JLabel) super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);

                label.setFont(new Font("Arial", Font.BOLD, 16));
                label.setBackground(new Color(70, 130, 180)); // Steel blue
                label.setForeground(Color.WHITE);
                label.setOpaque(true);

                return label;
            }
        });

        // Remove the previous table (if any) and add the new table
        JScrollPane scrollPane = new JScrollPane(leaderboardTable);
        panel.removeAll();  // Clear the panel
        panel.add(sortOrderComboBox, BorderLayout.NORTH);  // Add the combo box back
        panel.add(scrollPane, BorderLayout.CENTER);  // Add the new table
        panel.revalidate();  // Revalidate the panel to update the UI
        panel.repaint();     // Repaint the panel to reflect changes
    }

    // Method to read scores from the file
    private CustomStack<String[]> readScoresFromFile(String filePath) {
        CustomStack<String[]> stack = new CustomStack<>(50); // Initialize with a max size
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",\\s*"); // Split on comma and optional space
                stack.push(parts);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading scores file: " + e.getMessage(),
                    "File Read Error", JOptionPane.ERROR_MESSAGE);
        }
        return stack;
    }
}

// Custom stack implementation
class CustomStack<T> {

    private Object[] elements;
    private int top;

    public CustomStack(int capacity) {
        elements = new Object[capacity];
        top = -1;
    }

    public void push(T value) {
        if (top == elements.length - 1) {
            throw new StackOverflowError("Stack is full");
        }
        elements[++top] = value;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return (T) elements[top--];
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return (T) elements[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray(T[] a) {
        if (a.length < size()) {
            return (T[]) java.util.Arrays.copyOf(elements, size(), a.getClass());
        }
        System.arraycopy(elements, 0, a, 0, size());
        if (a.length > size()) {
            a[size()] = null; // Null-terminate if array is larger than required
        }
        return a;
    }
}
