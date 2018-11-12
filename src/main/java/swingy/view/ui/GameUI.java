package swingy.view.ui;

import lombok.Getter;
import lombok.Setter;
import swingy.model.character.Character;

import javax.swing.*;

@Getter
@Setter
public class GameUI extends JFrame {
    private Character player;
    private JPanel mainPanel;
    private JLabel characterName;
    private JLabel characterClass;
    private JLabel characterStrength;
    private JLabel characterIntelligence;
    private JLabel characterAgility;

    public GameUI()
    {
        setSize(800, 600);
        setContentPane(mainPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void register (Character player) {
        this.player = player;
    }
}