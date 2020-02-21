package Reporter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Hashtable;
import java.io.*;
import java.util.Objects;

public class SenderController {

    public Hashtable<String,String[]> matchData = new Hashtable<>();

    ObservableList<String> observableListM = FXCollections.observableArrayList();

    @FXML
    public ListView<String> matchList = new ListView<>(observableListM);

    ReporterMain ReporterMain;
    Socket socket;

    @FXML
    public TextArea description,summary,squad,sssss,proper;

    @FXML
    public TextField matchName;

    @FXML
    public void update()throws IOException {
        String match[] = new String[3];
        match[0] = matchName.getText();
        //match[1] = description.getText();
        //String s;
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        if(matchName.getText().equals("Ban Vs Sri 12/12/12")) {
            FileReader fff = new FileReader("E:\\Cricket ScoreBoard\\src\\Reporter\\Ban Vs Sri.txt");
            BufferedReader cr = new BufferedReader(fff);
            while ((match[1] = cr.readLine()) != null) {
                //description.setText(match[1]);
                description.appendText(match[1]);
                description.appendText("\n");
                //objectOutputStream.writeObject(match[1]);
            }
            fff.close();
            FileReader rrr = new FileReader("E:\\Cricket ScoreBoard\\src\\Reporter\\Ban Vs Sri Summary.txt");
            BufferedReader kr = new BufferedReader(rrr);
            while ((match[2] = kr.readLine()) != null) {
                //description.setText(match[1]);
                summary.appendText(match[2]);
                summary.appendText("\n");
                //objectOutputStream.writeObject(match[1]);
            }
            rrr.close();
        }
        else if(matchName.getText().equals("Aus Vs Ind 12/12/12"))
        {
            FileReader fff = new FileReader("E:\\Cricket ScoreBoard\\src\\Reporter\\Aus Vs Ind.txt");
            BufferedReader cr = new BufferedReader(fff);
            while ((match[1] = cr.readLine()) != null) {
                //description.setText(match[1]);
                description.appendText(match[1]);
                description.appendText("\n");
                //objectOutputStream.writeObject(match[1]);
            }
            fff.close();
            FileReader rrr = new FileReader("E:\\Cricket ScoreBoard\\src\\Reporter\\Aus Vs Ind Summary.txt");
            BufferedReader kr = new BufferedReader(rrr);
            while ((match[2] = kr.readLine()) != null) {
                //description.setText(match[1]);
                summary.appendText(match[2]);
                summary.appendText("\n");
                //objectOutputStream.writeObject(match[1]);
            }
            rrr.close();
        }
        else if(matchName.getText().equals("New Vs Ind 12/12/12"))
        {
            FileReader fff = new FileReader("E:\\Cricket ScoreBoard\\src\\Reporter\\New Vs Ind.txt");
            BufferedReader cr = new BufferedReader(fff);
            while ((match[1] = cr.readLine()) != null) {
                //description.setText(match[1]);
                description.appendText(match[1]);
                description.appendText("\n");
                //objectOutputStream.writeObject(match[1]);
            }
            fff.close();
            FileReader rrr = new FileReader("E:\\Cricket ScoreBoard\\src\\Reporter\\New Vs Ind Summary.txt");
            BufferedReader kr = new BufferedReader(rrr);
            while ((match[2] = kr.readLine()) != null) {
                //description.setText(match[1]);
                summary.appendText(match[2]);
                summary.appendText("\n");
                //objectOutputStream.writeObject(match[1]);
            }
            rrr.close();
        }
        else if(matchName.getText().equals("Pak Vs Eng 12/12/12"))
        {
            FileReader fff = new FileReader("E:\\Cricket ScoreBoard\\src\\Reporter\\Pak Vs Eng.txt");
            BufferedReader cr = new BufferedReader(fff);
            while ((match[1] = cr.readLine()) != null) {
                //description.setText(match[1]);
                description.appendText(match[1]);
                description.appendText("\n");
                //objectOutputStream.writeObject(match[1]);
            }
            fff.close();
            FileReader rrr = new FileReader("E:\\Cricket ScoreBoard\\src\\Reporter\\Pak Vs Eng Summary.txt");
            BufferedReader kr = new BufferedReader(rrr);
            while ((match[2] = kr.readLine()) != null) {
                //description.setText(match[1]);
                summary.appendText(match[2]);
                summary.appendText("\n");
                //objectOutputStream.writeObject(match[1]);
            }
            rrr.close();
        }
        objectOutputStream.writeObject(match);
    }
    @FXML
    public void Curr_update()throws IOException {
        String match[] = new String[6];
        match[0] = matchName.getText();
        match[1] = description.getText();
        match[2]=summary.getText();
        match[3]=squad.getText();
        match[4]=sssss.getText();
        match[5]=proper.getText();
        int i=0;
        if((match[5].substring(0,10)).compareTo("Javed Omar")==0) {
            FileWriter fff = new FileWriter("E:\\Cricket ScoreCard001\\javed Omar.txt");
            FileOutputStream fos = new FileOutputStream("E:\\Cricket ScoreCard001\\javed Omar.txt");
            while (match[5].charAt(i) != '_') {
                fos.write(match[5].charAt(i));
                i++;
            }
            fff.close();
        }
        else if((match[5].substring(0,17)).compareTo("Mohammad Ashraful")==0)
        {
            FileWriter fff = new FileWriter("E:\\Cricket ScoreCard001\\Mohammad Ashraful.txt");
            FileOutputStream fos = new FileOutputStream("E:\\Cricket ScoreCard001\\Mohammad Ashraful.txt");
            while (match[5].charAt(i) != '_') {
                fos.write(match[5].charAt(i));
                i++;
            }
            fff.close();
        }
        else if((match[5].substring(0,15)).compareTo("Kumar Sangakara")==0)
        {
            FileWriter fff = new FileWriter("E:\\Cricket ScoreCard001\\Sangakara.txt");
            FileOutputStream fos = new FileOutputStream("E:\\Cricket ScoreCard001\\Sangakara.txt");
            while (match[5].charAt(i) != '_') {
                fos.write(match[5].charAt(i));
                i++;
            }
            fff.close();
        }
        else if((match[5].substring(0,13)).compareTo("Upal Tharanga")==0)
        {
            FileWriter fff = new FileWriter("E:\\Cricket ScoreCard001\\Tharanga.txt");
            FileOutputStream fos = new FileOutputStream("E:\\Cricket ScoreCard001\\Tharanga.txt");
            while (match[5].charAt(i) != '_') {
                fos.write(match[5].charAt(i));
                i++;
            }
            fff.close();
        }
        else if((match[5].substring(0,12)).compareTo("Sahid Afridi")==0)
        {
            FileWriter fff = new FileWriter("E:\\Cricket ScoreCard001\\Afridi.txt");
            FileOutputStream fos = new FileOutputStream("E:\\Cricket ScoreCard001\\Afridi.txt");
            while (match[5].charAt(i) != '_') {
                fos.write(match[5].charAt(i));
                i++;
            }
            fff.close();
        }
        else if((match[5].substring(0,14)).compareTo("Mohammad Yunus")==0)
        {
            FileWriter fff = new FileWriter("E:\\Cricket ScoreCard001\\Yunus.txt");
            FileOutputStream fos = new FileOutputStream("E:\\Cricket ScoreCard001\\Yunus.txt");
            while (match[5].charAt(i) != '_') {
                fos.write(match[5].charAt(i));
                i++;
            }
            fff.close();
        }


        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(match);
    }
    public void setReporterMain(ReporterMain ReporterMain, Socket socket)
    {
        this.socket = socket;
        this.ReporterMain = ReporterMain;
    }

}
