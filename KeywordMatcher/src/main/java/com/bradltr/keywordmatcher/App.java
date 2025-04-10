package com.bradltr.keywordmatcher;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    private List<String> keywords = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(App::new);
    }

    public App() {
        // Create the main frame
        JFrame frame = new JFrame("Keyword Matcher");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new GridLayout(1, 2));

        // Left panel for keyword input
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());

        // Input field and buttons panel
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField keywordInput = new JTextField(15);
        JButton addKeywordButton = new JButton("+");
        JButton removeKeywordButton = new JButton("-");
        JButton removeKeywordButton1 = new JButton("x");
        inputPanel.add(keywordInput);
        inputPanel.add(addKeywordButton);
        inputPanel.add(removeKeywordButton);
        inputPanel.add(removeKeywordButton1);

        DefaultListModel<String> keywordListModel = new DefaultListModel<>();
        JList<String> keywordList = new JList<>(keywordListModel);

        addKeywordButton.addActionListener(e -> {
            String keyword = keywordInput.getText().trim();
            if (!keyword.isEmpty() && !keywords.contains(keyword)) {
                keywords.add(keyword);
                keywordListModel.addElement(keyword);
                keywordInput.setText("");
            }
        });

        removeKeywordButton.addActionListener(e -> {
            String selectedKeyword = keywordList.getSelectedValue();
            if (selectedKeyword != null) {
                keywords.remove(selectedKeyword);
                keywordListModel.removeElement(selectedKeyword);
            }
        });

        leftPanel.add(inputPanel, BorderLayout.NORTH);
        leftPanel.add(new JScrollPane(keywordList), BorderLayout.CENTER);

        // Right panel for job description and matching
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());

        JTextArea jobDescriptionArea = new JTextArea();
        JButton matchButton = new JButton("Match Against Keyword List");

        matchButton.addActionListener(e -> {
            String jobDescription = jobDescriptionArea.getText();
            if (!jobDescription.isEmpty()) {
                // Calculate keyword counts
                List<String> updatedKeywords = new ArrayList<>();
                for (String keyword : keywords) {
                    int count = jobDescription.split("\\b" + keyword + "\\b", -1).length - 1;
                    updatedKeywords.add(keyword + " (" + count + ")");
                }

                // Update the left panel with counts
                keywordListModel.clear();
                for (String updatedKeyword : updatedKeywords) {
                    keywordListModel.addElement(updatedKeyword);
                }
            }
        });

        rightPanel.add(new JScrollPane(jobDescriptionArea), BorderLayout.CENTER);
        rightPanel.add(matchButton, BorderLayout.SOUTH);

        // Add panels to the frame
        frame.add(leftPanel);
        frame.add(rightPanel);

        // Make the frame visible
        frame.setVisible(true);
    }
}