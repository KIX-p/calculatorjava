import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    JFrame frame;  //tworzy ramkę
    JTextField textField; // deklaruje pole tekstowe
    JButton[] numberButtons=new JButton[10]; // deklaruje przyciski od 0 do 9
    JButton[] functionButtons = new JButton[8];//tdeklaruje przyciski funkcjonalne (dodawanie, odejmowanie itd)
    JButton addButton, subButton, mulButton, divButton;//deklaruje przyciski (+, - itd)
    JButton decButton, equButton, delButton, clrButton;// tdeklaruje przyciski (del, clear itd)
    JPanel panel; //panel dla chronienia wszystkich przyciskow

    Font myFont = new Font("Ink Free", Font.BOLD, 30); //tworzy czcionke

    double num1=0, num2=0, result=0;
    char operator; //znak mnozenia odejmowania itd
    Calculator(){
        frame = new JFrame("Calculator"); //inicjalizacja ramki z tytulem Calculator
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//okreslamy co ma sie stac kiedy uzytkownik zamknie ramke aplikacji
        frame.setSize(420,550);//ustawia rozmiar ramki
        frame.setLayout(null); // w jaki sposob chcemy rozmiescic elementy

        textField = new JTextField(); //tworze pole tekstowe
        textField.setBounds(50,25,300,50);//dajemy pozycje dla pola tekstowego (x i y), szerokosc i wysokosc
        textField.setFont(myFont); //nadajemy czcionke dla pola tekstowego
        textField.setEditable(false); //zabezpieczanie przed wpisaniem czegos w pole tekstowe

        //tworzenia przyciskow
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");

        //dodawania przyciskow do tablicy
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for(int i=0;i<8;i++)
        {
            functionButtons[i].addActionListener(this); // dodawanie detektora akcji
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false); //zabieranie kontoru
        }

        for(int i=0;i<10;i++)
        {
            numberButtons[i] = new JButton(String.valueOf(i)); //tworzenie przycisku 1,2,3,4 itd
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        delButton.setBounds(50,430,145,50);
        clrButton.setBounds(205,430,145,50);

        panel= new JPanel(); //tworzenie nowego panelu gdzie beda sie znajdowac przyciski 1,2,3...
        panel.setBounds(50,100,300,300);//ustawienia pozycji, szerokosci i wysokosci dla tego panelu
        panel.setLayout(new GridLayout(4,4,10,10)); // dzielimy ten panel na 4 wiersze i 4 kolumny a takze ile miejsca miedzy przyciskami

        //wyswietlanie przyciskow
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);


        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField); // wyswietlamy pole tekstowe
        frame.setVisible(true); //widocznosc ramki





    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        //pobieranie wartosci i wyswietlanie jej w polu tekstowym
        for(int i = 0; i<10;i++)
        {
            if(e.getSource() == numberButtons[i])
            {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decButton){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource()==addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if(e.getSource()==subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource()==mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(e.getSource()==divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(e.getSource()==equButton){
            num2=Double.parseDouble(textField.getText());

            switch (operator){
                case'+':
                    result=num1+num2;
                    break;
                case'-':
                    result=num1-num2;
                    break;
                case'*':
                    result=num1*num2;
                    break;
                case'/':
                    result=num1/num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1=result;
        }

        if(e.getSource()==clrButton){
           textField.setText("");
        }
        if(e.getSource()==delButton){
            String string = textField.getText();
            textField.setText("");
            for(int i=0;i<string.length()-1;i++)
            {
                textField.setText(textField.getText()+string.charAt(i));
            }
        }

    }
}
