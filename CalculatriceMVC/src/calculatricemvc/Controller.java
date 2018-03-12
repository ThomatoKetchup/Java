package calculatricemvc;

import calculatrice.Exceptions.ExceptionDivisionParZero;
import calculatrice.Exceptions.ExceptionOperationExistante;
import calculatrice.Exceptions.ExceptionOperationInconnu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

public class Controller {
    
    private Calculatrice c; //Notre modèle

    @FXML
    private Text output;  //output et menubar sont aussi dans le fichier fxml
    private long v1 = 0;
    private long v2 = 0;

    private String op = "";
    private boolean start = true;

    //private Model model = new Model();
    
   public Controller(){
       c = new Calculatrice();
        try {
            c.addOperation("+", new Addition());
            c.addOperation("-", new Soustraction());
            c.addOperation("/", new Division()); //Il faut necessairement que Division implément opération, sinon il ne peut pas $etre de type operation
            c.addOperation("*", new Multiplication());

        } catch (ExceptionOperationExistante e) {
            System.out.println("Cette opération existe déjà.");
        }
    }

    @FXML
    private void processNumpad(ActionEvent event) {  //lorsqu'on appuie sur le bouton Action Event event prend le chiffre
        if (start) {
            output.setText("");
            start = false;
        }
        String value = ((Button) event.getSource()).getText(); //prend ce qui vient d'être cliquer (source) et prend sa partie "text"
        output.setText(output.getText() + value);
    }

    @FXML
    private void processDelete(ActionEvent event) {
        output.setText("");
        start = false; //pour réiinustilaiser le compteur 
    }
   
    @FXML
    private void processOperator(ActionEvent event) {
        String op = ((Button) event.getSource()).getText();
        if (!"=".equals(op)) {
            if (!this.op.isEmpty()) {
                return;
            }
            this.op = op;
            System.out.println("op : "+op);

            v1 = Long.parseLong(output.getText());
            output.setText("");
        } else {
            if (this.op.isEmpty()) {
                return;
            }
            v2 = Long.parseLong(output.getText());
            System.out.println("v1 = "+v1);
            System.out.println("v2 = "+v2);
            try{
                output.setText(String.valueOf(c.calculer(v1,v2,this.op)));
                System.out.println("res =" +c.calculer(v1,v2,this.op));
        } catch (ExceptionDivisionParZero e) {
                System.out.println("Exception : division par zéro.");
                output.setText("Exception : Division par zéro");
            }catch(ExceptionOperationInconnu e){
                System.out.println("Exception : Operation inconnu");
                output.setText("Exception : Division par zéro");
            }
            this.op = "";
            start = true;
        }
    }

    /**
     * Handle action related to input (in this case specifically only responds
     * to keyboard event CTRL-A).
     *
     * @param event Input event.
     */
    @FXML
    private void handleKeyInput(final InputEvent event) {
        if (event instanceof KeyEvent) {
            final KeyEvent keyEvent = (KeyEvent) event;
            if (keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.A) {
                //provideAboutFunctionality();
            }
        }
    }

    /**
     * Perform functionality associated with "About" menu selection or CTRL-A.
     */
    private void provideAboutFunctionality() {
        System.out.println("You clicked on About!");
    }

}
