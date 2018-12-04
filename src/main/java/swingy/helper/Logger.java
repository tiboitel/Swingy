package swingy.helper;

import lombok.Setter;
import lombok.Getter;

import javax.swing.*;

public class Logger {
    private static Logger logger = null;
    private int count = 0;
    @Getter
    @Setter
    private char        mode;
    @Getter
    @Setter
    private JTextPane   textArea;

    public static synchronized Logger getLogger()
    {
        if (logger == null)
            logger = new Logger();
        return (logger);
    }

    public void log(String message)
    {
        count++;
        if (mode == 'c')
            System.out.println(message);
        else
        {
            if (textArea != null)
            {
                if (count == 6) {
                    count = 0;
                    textArea.setText("");
                }
                textArea.setText(textArea.getText() + message + '\n');
            }
        }
    }
}
