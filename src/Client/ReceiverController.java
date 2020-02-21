package Client;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class ReceiverController extends ClientController{

    public Hashtable<String,String[]> matchData = new Hashtable<>();
    public Hashtable<String,String[]> mtData = new Hashtable<>();

    ObservableList<String> observableListM = FXCollections.observableArrayList();
    ObservableList<String> observableListSM = FXCollections.observableArrayList();
    ObservableList<String> observeSquad = FXCollections.observableArrayList();
    ObservableList<String> observeSSSSS= FXCollections.observableArrayList();
    ObservableList<String> obs=FXCollections.observableArrayList();
    ObservableList<String> mtc=FXCollections.observableArrayList();
    public int kk=-1;

    @FXML
    public ListView<String> matchList = new ListView<>(observableListM);
    @FXML
    public ListView<String> selectedMatchList = new ListView<>(observableListSM);
    @FXML
    public ListView<String> sqd=new ListView<>(observeSquad);
    @FXML
    public ListView<String> sss=new ListView<>(observeSSSSS);
    @FXML
    public ListView<String> pre= new ListView<>(obs);
    @FXML
    public ListView<String> matt=new ListView<>(mtc);

    ClientMain clientMain;
    Socket socket;
    DetailsController details;
    @FXML
    public String nnnm[];

    @FXML
    public TextArea description,Summary,mat1,mat2,mat3,proper;



    //disconnects from server . it creates a new connection with server , sends clientName and status-"no" and returns connection page
    public void disconnect() {
            try {
                Socket socket = new Socket("127.0.0.1",33333);
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                clientMain.clientData[1] = "no";
                outputStream.writeObject(clientMain.clientData);

                clientMain.showConnectionPage();

            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    void setMatchList(String[] match){
        int sz=0;
        //if server says to delete this match
        if(match[1].equals("delete")){
            //if the deleted match was being viewed
            if(match[0].equals(selectedMatchList.getSelectionModel().getSelectedItem())){
                description.clear();
            }

            //remove data of that match
            observableListM.remove(match[0]);
            observableListSM.remove(match[0]);
            matchData.remove(match[0]);
        }
        else{
            //if already on matchList

            //if(!observableListM.contains(match[2])) observableListM.add(match[2]);

            if(!mtc.contains(match[0]))
            {
                mtc.add(match[0]);
                observableListM.add(match[2]);
                kk++;
            }
            else
            {
                observableListM.remove(kk);
                observableListM.add(match[2]);
            }
            //if(!observeSquad.contains(match[3]))observeSquad.add(match[3]);
            //save the new data
            matchData.put(match[2],match);
            mtData.put(match[0],match);

            //if the updated match is already selected and being viewed by client this will update that data
            String name = matchList.getSelectionModel().getSelectedItem();
            if(name!=null&&name.equals(match[2])){
                description.setText(match[1]);
            }
        }
        //update the list

        matchList.setItems(observableListM);

    }

    @FXML
    void selection(){
        matchList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ObservableList<String>selected = matchList.getSelectionModel().getSelectedItems();
        for(int i=0;i<selected.size();i++){
            String s =selected.get(i);
            System.out.println(s);
            if(!observableListSM.contains(s))observableListSM.add(s);
        }
        selectedMatchList.setItems(observableListSM);
    }
    @FXML
    void showw()
    {
        //nnnm = matchList.getSelectionModel().getSelectedItem();
        try {
            clientMain.showDetails();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void hm()
    {
        try {
            clientMain.showReceiverPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showMatchDetails(){

        String name = matchList.getSelectionModel().getSelectedItem();
        if(name!=null){
            String match[] = matchData.get(name);
            nnnm=matchData.get(name);
            System.out.println(match[5]);
            description.setText(match[1]);
            observeSquad.clear();
            observeSSSSS.clear();
            String[] ara=new String[500];
            int i=0,j=0,k=0;
            for(int kk=0;kk<match[3].length();kk++)
            {
                //System.out.println("crap");
                if(match[3].charAt(i)=='\n')
                {
                    ara[j]=match[3].substring(k,i);
                    k=i+1;
                    j++;
                }
                i++;
            }

            for(int kk=0;kk<12;kk++)
            {
                observeSquad.add(ara[kk]);
            }
            String[] ara1=new String[500];
            int i1=0,j1=0,k1=0;
            for(int kk=0;kk< match[4].length();kk++)
            {
                //System.out.println("crap");
                if(match[4].charAt(i1)=='\n')
                {
                    ara1[j1]=match[4].substring(k1,i1);
                    k1=i1+1;
                    j1++;
                }
                i1++;
            }

            for(int kk=0;kk<12;kk++)
            {
                observeSSSSS.add(ara1[kk]);
            }
            sss.setItems(observeSSSSS);
            sqd.setItems(observeSquad);
        }


    }
    @FXML
    void press2()throws IOException{
        String[] mat=new String[3];
        obs.clear();
        mat1.clear();
        mat2.clear();
        mat3.clear();
        FileReader fff = new FileReader("E:\\Cricket ScoreCard001\\src\\Reporter\\Zim Vs Ban Summary.txt");
        BufferedReader cr = new BufferedReader(fff);
        while ((mat[0] = cr.readLine()) != null) {
            mat1.appendText(mat[0]);
            mat1.appendText("\n");
            //description.setText(match[1]);
            //objectOutputStream.writeObject(match[1]);
        }
        obs.add(mat1.getText());
        fff.close();
        FileReader rrr = new FileReader("E:\\Cricket ScoreCard001\\src\\Reporter\\Wes Vs Eng Summary.txt");
        BufferedReader kr = new BufferedReader(rrr);
        while ((mat[1] = kr.readLine()) != null) {
            mat2.appendText(mat[1]);
            mat2.appendText("\n");
            //description.setText(match[1]);
            //objectOutputStream.writeObject(match[1]);
        }
        obs.add(mat2.getText());
        rrr.close();
        pre.setItems(obs);

    }
    @FXML
    void press1()throws IOException{
        String[] mat=new String[3];
        obs.clear();
        mat1.clear();
        mat2.clear();
        mat3.clear();
        FileReader fff = new FileReader("D:\\Cricket ScoreBoard\\src\\Reporter\\Sri Vs Ind Summary.txt");
        BufferedReader cr = new BufferedReader(fff);
        while ((mat[0] = cr.readLine()) != null) {
            mat1.appendText(mat[0]);
            mat1.appendText("\n");
            //description.setText(match[1]);
            //objectOutputStream.writeObject(match[1]);
        }
        obs.add(mat1.getText());
        fff.close();
        FileReader rrr = new FileReader("D:\\Cricket ScoreBoard\\src\\Reporter\\Sri Vs Eng Summary.txt");
        BufferedReader kr = new BufferedReader(rrr);
        while ((mat[1] = kr.readLine()) != null) {
            mat2.appendText(mat[1]);
            mat2.appendText("\n");
            //description.setText(match[1]);
            //objectOutputStream.writeObject(match[1]);
        }
        obs.add(mat2.getText());
        rrr.close();
        FileReader kkk = new FileReader("D:\\Cricket ScoreBoard\\src\\Reporter\\RSA Vs Pak Summary.txt");
        BufferedReader tr = new BufferedReader(kkk);
        while ((mat[2] = tr.readLine()) != null) {
            mat3.appendText(mat[2]);
            mat3.appendText("\n");
            //description.setText(match[1]);
            //objectOutputStream.writeObject(match[1]);
        }
        obs.add(mat3.getText());
        kkk.close();
        pre.setItems(obs);

    }
    @FXML
    void nomatch()
    {
        obs.clear();
        obs.add("NO MATCH TO DISPLAY");
        pre.setItems(obs);
    }
    @FXML
    void pp()throws IOException
    {
        proper.clear();
        String name=null;
        //String kkk=null;
        name=sqd.getSelectionModel().getSelectedItem();
        //kkk=sss.getSelectionModel().getSelectedItem();
        if(name!=null)
        {
            String[] mat=new String[100];
            //System.out.println(nnnm[5]);
            if(name.compareTo("J.Omar     ")==0)
            {
                FileReader rrr = new FileReader("E:\\Cricket ScoreCard001\\javed Omar.txt");
                BufferedReader kr = new BufferedReader(rrr);
                while ((mat[1] = kr.readLine()) != null) {
                    proper.appendText(mat[1]);
                    proper.appendText("\n");
                    //description.setText(match[1]);
                    //objectOutputStream.writeObject(match[1]);
                }
                rrr.close();
            }
            else if(name.compareTo("M.Ashraful ")==0)
            {
                FileReader rrr = new FileReader("E:\\Cricket ScoreCard001\\Mohammad Ashraful.txt");
                BufferedReader kr = new BufferedReader(rrr);
                while ((mat[2] = kr.readLine()) != null) {
                    proper.appendText(mat[2]);
                    proper.appendText("\n");
                    //description.setText(match[1]);
                    //objectOutputStream.writeObject(match[1]);
                }
                rrr.close();
            }
            else if(name.compareTo("U.Tharanga")==0)
            {
                FileReader rrr = new FileReader("E:\\Cricket ScoreCard001\\Tharanga.txt");
                BufferedReader kr = new BufferedReader(rrr);
                while ((mat[3] = kr.readLine()) != null) {
                    proper.appendText(mat[3]);
                    proper.appendText("\n");
                    //description.setText(match[1]);
                    //objectOutputStream.writeObject(match[1]);
                }
                rrr.close();
            }
            else if(name.compareTo("K.Sangakara")==0)
            {
                FileReader rrr = new FileReader("E:\\Cricket ScoreCard001\\Sangakara.txt");
                BufferedReader kr = new BufferedReader(rrr);
                while ((mat[4] = kr.readLine()) != null) {
                    proper.appendText(mat[4]);
                    proper.appendText("\n");
                    //description.setText(match[1]);
                    //objectOutputStream.writeObject(match[1]);
                }
                rrr.close();
            }
            else if(name.compareTo("S.Afridi")==0)
            {
                FileReader rrr = new FileReader("E:\\Cricket ScoreCard001\\Afridi.txt");
                BufferedReader kr = new BufferedReader(rrr);
                while ((mat[5] = kr.readLine()) != null) {
                    proper.appendText(mat[5]);
                    proper.appendText("\n");
                    //description.setText(match[1]);
                    //objectOutputStream.writeObject(match[1]);
                }
                rrr.close();
            }
            else if(name.compareTo("M.Yunus")==0)
            {
                FileReader rrr = new FileReader("E:\\Cricket ScoreCard001\\Yunus.txt");
                BufferedReader kr = new BufferedReader(rrr);
                while ((mat[6] = kr.readLine()) != null) {
                    proper.appendText(mat[6]);
                    proper.appendText("\n");
                    //description.setText(match[1]);
                    //objectOutputStream.writeObject(match[1]);
                }
                rrr.close();
            }
        }
    }
    @FXML
    void pp1()throws IOException{
        proper.clear();
        String kkk=null;
        kkk=sss.getSelectionModel().getSelectedItem();
        if(kkk!=null)
        {
            String[] mat=new String[100];
            if(kkk.compareTo("J.Omar     ")==0)
            {
                //String[] mat=new String[100];
                FileReader rrr = new FileReader("E:\\Cricket ScoreCard001\\javed Omar.txt");
                BufferedReader kr = new BufferedReader(rrr);
                while ((mat[1] = kr.readLine()) != null) {
                    proper.appendText(mat[1]);
                    proper.appendText("\n");
                    //description.setText(match[1]);
                    //objectOutputStream.writeObject(match[1]);
                }
                rrr.close();
            }
            else if(kkk.compareTo("M.Ashraful ")==0)
            {
                FileReader rrr = new FileReader("E:\\Cricket ScoreCard001\\Mohammad Ashraful.txt");
                //String[] mat=new String[100];
                BufferedReader kr = new BufferedReader(rrr);
                while ((mat[2] = kr.readLine()) != null) {
                    proper.appendText(mat[2]);
                    proper.appendText("\n");
                    //description.setText(match[1]);
                    //objectOutputStream.writeObject(match[1]);
                }
                rrr.close();
            }
            else if(kkk.compareTo("U.Tharanga")==0)
            {
                FileReader rrr = new FileReader("E:\\Cricket ScoreCard001\\Tharanga.txt");
                BufferedReader kr = new BufferedReader(rrr);
                while ((mat[3] = kr.readLine()) != null) {
                    proper.appendText(mat[3]);
                    proper.appendText("\n");
                    //description.setText(match[1]);
                    //objectOutputStream.writeObject(match[1]);
                }
                rrr.close();
            }
            else if(kkk.compareTo("K.Sangakara")==0)
            {
                FileReader rrr = new FileReader("E:\\Cricket ScoreCard001\\Sangakara.txt");
                BufferedReader kr = new BufferedReader(rrr);
                while ((mat[4] = kr.readLine()) != null) {
                    proper.appendText(mat[4]);
                    proper.appendText("\n");
                    //description.setText(match[1]);
                    //objectOutputStream.writeObject(match[1]);
                }
                rrr.close();
            }
            else if(kkk.compareTo("S.Afridi")==0)
            {
                FileReader rrr = new FileReader("E:\\Cricket ScoreCard001\\Afridi.txt");
                BufferedReader kr = new BufferedReader(rrr);
                while ((mat[5] = kr.readLine()) != null) {
                    proper.appendText(mat[5]);
                    proper.appendText("\n");
                    //description.setText(match[1]);
                    //objectOutputStream.writeObject(match[1]);
                }
                rrr.close();
            }
            else if(kkk.compareTo("M.Yunus")==0)
            {
                FileReader rrr = new FileReader("E:\\Cricket ScoreCard001\\Yunus.txt");
                BufferedReader kr = new BufferedReader(rrr);
                while ((mat[6] = kr.readLine()) != null) {
                    proper.appendText(mat[6]);
                    proper.appendText("\n");
                    //description.setText(match[1]);
                    //objectOutputStream.writeObject(match[1]);
                }
                rrr.close();
            }
        }
    }
    @FXML
    void show2()throws IOException
    {
        String name = pre.getSelectionModel().getSelectedItem();
        String[] mat=new String[100];
        description.clear();
        observeSquad.clear();
        observeSSSSS.clear();
        if(name.compareTo(mat1.getText())==0)
        {
            FileReader fff = new FileReader("E:\\Cricket ScoreCard001\\src\\Reporter\\Sri Vs Ind.txt");
            BufferedReader cr = new BufferedReader(fff);
            while ((mat[0] = cr.readLine()) != null) {
                description.appendText(mat[0]);
                description.appendText("\n");
                //description.setText(match[1]);
                //objectOutputStream.writeObject(match[1]);
            }
            fff.close();
            FileReader kkk = new FileReader("E:\\Cricket ScoreCard001\\Srilanka.txt");
            BufferedReader kr = new BufferedReader(kkk);
            while ((mat[1] = kr.readLine()) != null) {
                observeSquad.add(mat[1]);
                //observeSquad.add("\n");
                //description.setText(match[1]);
                //objectOutputStream.writeObject(match[1]);
            }
            sqd.setItems(observeSquad);
            kkk.close();

            FileReader ttt = new FileReader("E:\\Cricket ScoreCard001\\India.txt");
            BufferedReader tr = new BufferedReader(ttt);
            while ((mat[2] = tr.readLine()) != null) {
                observeSSSSS.add(mat[2]);
                //observeSSSSS.add("\n");
                //description.setText(match[1]);
                //objectOutputStream.writeObject(match[1]);
            }
            sss.setItems(observeSSSSS);
            ttt.close();
        }
        else if(name.compareTo(mat2.getText())==0)
        {
            FileReader fff = new FileReader("E:\\Cricket ScoreCard001\\src\\Reporter\\Sri Vs Eng.txt");
            BufferedReader cr = new BufferedReader(fff);
            while ((mat[0] = cr.readLine()) != null) {
                description.appendText(mat[0]);
                description.appendText("\n");
                //description.setText(match[1]);
                //objectOutputStream.writeObject(match[1]);
            }
            fff.close();
            FileReader kkk = new FileReader("E:\\Cricket ScoreCard001\\Srilanka.txt");
            BufferedReader kr = new BufferedReader(kkk);
            while ((mat[1] = kr.readLine()) != null) {
                observeSquad.add(mat[1]);
                //observeSquad.add("\n");
                //description.setText(match[1]);
                //objectOutputStream.writeObject(match[1]);
            }
            sqd.setItems(observeSquad);
            kkk.close();

            FileReader ttt = new FileReader("E:\\Cricket ScoreCard001\\England.txt");
            BufferedReader tr = new BufferedReader(ttt);
            while ((mat[2] = tr.readLine()) != null) {
                observeSSSSS.add(mat[2]);
                //observeSSSSS.add("\n");
                //description.setText(match[1]);
                //objectOutputStream.writeObject(match[1]);
            }
            sss.setItems(observeSSSSS);
            ttt.close();

        }
        else if(name.compareTo(mat3.getText())==0)
        {
            FileReader fff = new FileReader("E:\\Cricket ScoreCard001\\src\\Reporter\\RSA Vs Pak.txt");
            BufferedReader cr = new BufferedReader(fff);
            while ((mat[0] = cr.readLine()) != null) {
                description.appendText(mat[0]);
                description.appendText("\n");
                //description.setText(match[1]);
                //objectOutputStream.writeObject(match[1]);
            }
            fff.close();
            FileReader kkk = new FileReader("E:\\Cricket ScoreCard001\\RSA.txt");
            BufferedReader kr = new BufferedReader(kkk);
            while ((mat[1] = kr.readLine()) != null) {
                observeSquad.add(mat[1]);
                //observeSquad.add("\n");
                //description.setText(match[1]);
                //objectOutputStream.writeObject(match[1]);
            }
            sqd.setItems(observeSquad);
            kkk.close();

            FileReader ttt = new FileReader("E:\\Cricket ScoreCard001\\Pakistan.txt");
            BufferedReader tr = new BufferedReader(ttt);
            while ((mat[2] = tr.readLine()) != null) {
                observeSSSSS.add(mat[2]);
                //observeSSSSS.add("\n");
                //description.setText(match[1]);
                //objectOutputStream.writeObject(match[1]);
            }
            sss.setItems(observeSSSSS);
            ttt.close();
        }
    }

    void setClientMain(ClientMain clientMain, Socket socket)
    {
        this.socket = socket;
        this.clientMain = clientMain;
    }
}

