package swingy.view.ui;

import com.sun.xml.internal.ws.util.StringUtils;
import lombok.Getter;
import lombok.Setter;
import swingy.model.character.Character;
import swingy.model.map.SquareMap;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;

@Getter
@Setter
public class GameUI extends JFrame {
    private JPanel mainPanel;
    private JLabel characterName;
    private JLabel characterClass;
    private JLabel characterCombatCapacity;
    private JLabel characterStrength;
    private JLabel characterIntelligence;
    private JLabel characterAgility;
    private JLabel characterExperience;
    private JLabel characterLevel;
    private JComboBox characterDirection;
    private JButton moveButton;
    private JButton fightButton;
    private JTextPane mapViewer;

    public GameUI()
    {
        setSize(800, 600);
        setContentPane(mainPanel);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void update(Character character)
    {
        characterName.setText("Name: " + character.getName());
        characterClass.setText("Class:" + character.getPlayerclass());
        characterLevel.setText("Level: " + character.getLevel());
        characterExperience.setText("Experience: " + character.getExperience());
        characterCombatCapacity.setText("Combat Capacity: " + character.getCombatCapacity());
        characterStrength.setText("Strength: " + character.getStrength());
        characterIntelligence.setText("Intelligence: " + character.getIntelligence());
        characterAgility.setText("Agility: " + character.getAgility());
    }

    public void update(SquareMap map) {
        String render = map.toString();
        String padding;
        int numberLines = (int) (render.chars().filter(x -> x == '\n').count() + 1);
        JTextPane mapViewer = getMapViewer();
        int rows = mapViewer.getHeight() / 10;

        StyledDocument document = mapViewer.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        document.setParagraphAttributes(0, document.getLength(), center, false);
        System.out.println("Rows: " + rows + ", NumberLines: " + numberLines);
        padding = new String(new char[((rows / 2) - (numberLines / 2)) / 2]).replace('\0', '\n');
        render = padding + render;
        mapViewer.setText(render);
    }
}