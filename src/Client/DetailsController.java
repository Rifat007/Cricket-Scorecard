package Client;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
public class DetailsController {
    ClientMain clientMain;
    Socket socket;

    @FXML
    public TextArea description,Summary;



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

    public void home() throws Exception {
        clientMain.showReceiverPage();
    }
    void setClientMain(ClientMain clientMain, Socket socket)
    {
        this.socket = socket;
        this.clientMain = clientMain;
    }

}
