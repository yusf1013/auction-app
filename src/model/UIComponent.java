package model;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class UIComponent {

    AnchorPane panel;

    public UIComponent(AnchorPane panel) {
        this.panel = panel;
    }

    private Node getNodeRecursive(AnchorPane pane, String id) {
        for(Node child: pane.getChildren()) {

            if(child instanceof AnchorPane)
            {
                Node l = getNodeRecursive((AnchorPane) child, id);
                if(l!=null)
                    return l;
            }

            if(child.getId()!=null && child.getId().equalsIgnoreCase(id))
                return child;
        }
        return null;
    }

    public Label getLabel(String id) {
        return (Label) getNodeRecursive(panel, id);
    }

    public Button getButton(String id) {
        return (Button) getNodeRecursive(panel, id);
    }
}
