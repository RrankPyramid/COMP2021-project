package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.model.Circle;
import hk.edu.polyu.comp.comp2021.clevis.model.Group;
import hk.edu.polyu.comp.comp2021.clevis.model.Picture;
import hk.edu.polyu.comp.comp2021.clevis.model.Shape;
import hk.edu.polyu.comp.comp2021.clevis.model.util.Vertex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

/**
 * Application Launcher
 */
public class Application {

    public Application(){}

    Main run = new Main();

    private JFrame frame;

    /**
     * @param args Parameters entered at launch
     */
    public static void main(String[] args) {

        Main run = Main.getInstance();

        Circle c1 = new Circle(new Vertex(100, 100), 100, 1);
        JFrame frame = new JFrame("Clevis");
        JPanel jp = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for(Shape s : run.getName_Shape().values()){
                    s.draw(g);
                }
            }
        };


        ArrayList<JPanel> panellist = new ArrayList<>();
        JPanel allPanel=new JPanel(new CardLayout());

        CardLayout cardLayout=(CardLayout)(allPanel.getLayout());
        cardLayout.show(allPanel,"card1");

        jp.setBackground(Color.white);

        JPanel controler = new JPanel();
        allPanel.setPreferredSize(new Dimension(250, 0));

        JButton rectangleButton=new JButton("Rectangle");
        JButton circleButton=new JButton("Circle");
        JButton squareButton=new JButton("Square");
        JButton lineButton=new JButton("Line");
        JButton group=new JButton("Group");
        JButton ungroup=new JButton("Ungroup");
        JButton pick_and_move=new JButton("Pick and Move");
        JButton list=new JButton("List");
        JButton intersect=new JButton("Intersect");
        JButton move=new JButton("Move");
        JButton bounding=new JButton("BoundingBox");
        JButton delete=new JButton("Delete");
        JButton[] back = new JButton[12];
        for(int x = 0; x<12 ; x++){
            back[x] = new JButton("Back");
            back[x].addActionListener(e -> cardLayout.show(allPanel,"control"));
        }
        JButton[] confirm = new JButton[12];
        for(int x = 0; x<12 ; x++){
            confirm[x] = new JButton("Confirm");
        }


        controler.add(rectangleButton);
        controler.add(circleButton);
        controler.add(lineButton);
        controler.add(squareButton);
        controler.add(group);
        controler.add(ungroup);
        controler.add(pick_and_move);
        controler.add(list);
        controler.add(intersect);
        controler.add(move);
        controler.add(bounding);
        controler.add(delete);

        controler.setLayout(new GridLayout(6,6,5,5));

        JPanel rectangleJP = new JPanel();
        rectangleJP.setLayout(new FlowLayout(FlowLayout.LEADING,20,20));
        JTextField getrectangleName = new JTextField(5);
        JTextField getrectangleX=new JTextField(5);
        JTextField getrectangleY=new JTextField(5);
        JTextField getrectangleW=new JTextField(5);
        JTextField getrectangleH=new JTextField(5);
        rectangleJP.add(getrectangleName);
        rectangleJP.add(getrectangleX);
        rectangleJP.add(getrectangleY);
        rectangleJP.add(getrectangleW);
        rectangleJP.add(getrectangleH);
        rectangleJP.add(confirm[0]);
        confirm[0].addActionListener(e -> {
            run.createRectangle(getrectangleName.getText(),Double.parseDouble(getrectangleX.getText()),Double.parseDouble(getrectangleY.getText()),Double.parseDouble(getrectangleW.getText()),Double.parseDouble(getrectangleH.getText()));
            getrectangleName.setText("");
            getrectangleX.setText("");
            getrectangleY.setText("");
            getrectangleW.setText("");
            getrectangleH.setText("");
            cardLayout.show(allPanel,"control");
            frame.repaint();
        });
        panellist.add(rectangleJP);



        JPanel circleJP = new JPanel();
        circleJP.setLayout(new FlowLayout(FlowLayout.LEADING,20,20));
        JTextField getcircleName=new JTextField(5);
        JTextField getcircleX=new JTextField(5);
        JTextField getcircleY=new JTextField(5);
        JTextField getcircleR=new JTextField(5);
        circleJP.add(getcircleName);
        circleJP.add(getcircleX);
        circleJP.add(getcircleY);
        circleJP.add(getcircleR);
        circleJP.add(confirm[1]);
        confirm[1].addActionListener(e -> {
            run.createCircle(getcircleName.getText(),Double.parseDouble(getcircleX.getText()),Double.parseDouble(getcircleY.getText()),Double.parseDouble(getcircleR.getText()));
            getcircleName.setText("");
            getcircleX.setText("");
            getcircleY.setText("");
            getcircleR.setText("");
            cardLayout.show(allPanel,"control");
            frame.repaint();
        });
        panellist.add(circleJP);

        JPanel lineJP = new JPanel();
        lineJP.setLayout(new FlowLayout(FlowLayout.LEADING,20,20));
        JTextField getlineName=new JTextField(5);
        JTextField getlineX1=new JTextField(5);
        JTextField getlineY1=new JTextField(5);
        JTextField getlineX2=new JTextField(5);
        JTextField getlineY2=new JTextField(5);
        lineJP.add(getlineName);
        lineJP.add(getlineX1);
        lineJP.add(getlineY1);
        lineJP.add(getlineX2);
        lineJP.add(getlineY2);
        lineJP.add(confirm[2]);
        confirm[2].addActionListener(e -> {
            run.createLine(getlineName.getText(),Double.parseDouble(getlineX1.getText()),Double.parseDouble(getlineY1.getText()),Double.parseDouble(getlineX2.getText()),Double.parseDouble(getlineY2.getText()));
            getlineName.setText("");
            getlineX1.setText("");
            getlineX2.setText("");
            getlineY1.setText("");
            getlineY2.setText("");
            cardLayout.show(allPanel,"control");
            frame.repaint();
        });
        panellist.add(lineJP);

        JPanel groupJP = new JPanel();
        groupJP.setLayout(new FlowLayout(FlowLayout.LEADING,20,20));
        JTextField getgroupName=new JTextField(5);
        JTextField getlist=new JTextField(5);
        groupJP.add(getgroupName);
        groupJP.add(getlist);
        groupJP.add(confirm[11]);
        confirm[11].addActionListener(e -> {
            run.createGroup(getgroupName.getText(), (ArrayList<String>) Arrays.asList(getlist.getText().split("\\s+")));
            run.getCommand(getgroupName.getText()+" " +getlist.getText());
            getgroupName.setText("");
            getlist.setText("");
            cardLayout.show(allPanel,"control");
        });
        panellist.add(groupJP);

        JPanel ungroupJP = new JPanel();
        JComboBox allGroups = new JComboBox();
        allGroups.addItem("--please choose--");
        ArrayList<Group> groupArrayList = run.groupArrayList();
        for (int x = 0; x<groupArrayList.size() ; x++){
            allGroups.addItem(groupArrayList.get(x).getShapeName());
        }
        ungroupJP.add(allGroups);
        ungroupJP.add(confirm[3]);
        confirm[3].addActionListener(e -> {
            run.unGroup((String)allGroups.getSelectedItem());
            allGroups.setSelectedIndex(0);
            cardLayout.show(allPanel,"control");
        });
        panellist.add(ungroupJP);

        JPanel squareJP = new JPanel();
        JTextField getsquareName=new JTextField(5);
        JTextField getsquareX=new JTextField(5);
        JTextField getsquareY=new JTextField(5);
        JTextField getsquareL=new JTextField(5);
        squareJP.add(getsquareName);
        squareJP.add(getsquareX);
        squareJP.add(getsquareY);
        squareJP.add(getsquareL);
        squareJP.add(confirm[4]);
        confirm[4].addActionListener(e -> {
            run.createSquare(getsquareName.getText(),Double.parseDouble(getsquareX.getText()),Double.parseDouble(getsquareY.getText()),Double.parseDouble(getsquareL.getText()));
            getsquareName.setText("");
            getsquareX.setText("");
            getsquareY.setText("");
            getsquareL.setText("");
            cardLayout.show(allPanel,"control");
            frame.repaint();

        });
        panellist.add(squareJP);

        JPanel pickAndMoveJP = new JPanel();
        JTextField getpickX=new JTextField(5);
        JTextField getpickY=new JTextField(5);
        JTextField getPickMoveX=new JTextField(5);
        JTextField getPickMoveY=new JTextField(5);
        pickAndMoveJP.add(getpickX);
        pickAndMoveJP.add(getpickY);
        pickAndMoveJP.add(getPickMoveX);
        pickAndMoveJP.add(getPickMoveY);
        pickAndMoveJP.add(confirm[5]);
        confirm[5].addActionListener(e -> {
            run.pickAndMove(Double.parseDouble(getpickX.getText()),Double.parseDouble(getpickY.getText()),Double.parseDouble(getPickMoveX.getText()),Double.parseDouble(getPickMoveY.getText()));
            getpickX.setText("");
            getpickY.setText("");
            getPickMoveX.setText("");
            getPickMoveY.setText("");
            cardLayout.show(allPanel,"control");
            frame.repaint();

        });
        panellist.add(pickAndMoveJP);


        JPanel listJP = new JPanel();
        JComboBox allShapes = new JComboBox();
        allShapes.addItem("--please choose--");
        String[] StrArray = run.getName_Shape().keySet().toArray(new String[0]);
        for(String s : StrArray){
            allShapes.addItem(s);
        }
        listJP.add(allShapes);
        listJP.add(confirm[6]);
        confirm[6].addActionListener(e -> {
            String x = (String) allShapes.getSelectedItem();
            run.getCommand("list "+x);
            ArrayList<String> out = run.getName_Shape().get(x).getInfo(x);
            String ans="";
            for(String s : out){
                ans+=s;
                ans+="\n";
            }
            JOptionPane.showMessageDialog(null,ans,x,JOptionPane.INFORMATION_MESSAGE);
            cardLayout.show(allPanel,"control");
        });
        panellist.add(listJP);


        JPanel intersectJP = new JPanel();
        JComboBox intersect_1 = new JComboBox();
        JComboBox intersect_2 = new JComboBox();
        intersect_1.addItem("--please choose--");
        intersect_2.addItem("--please choose--");
        for(String s : run.getName_Shape().keySet()){
            intersect_1.addItem(s);
            intersect_2.addItem(s);
        }
        intersectJP.add(intersect_1);
        intersectJP.add(intersect_2);
        intersectJP.add(confirm[7]);
        confirm[7].addActionListener(e -> {
            String intersect_a,intersect_b;
            intersect_a = (String)intersect_1.getSelectedItem();
            intersect_b = (String)intersect_2.getSelectedItem();
            run.getCommand("intersect "+intersect_a+" "+intersect_b);
            String intersectOrNot = "";
            intersectOrNot+=(intersect_a+" and "+intersect_b+ " is intersect ?\n"+run.getName_Shape().get(intersect_a).intersect(run.getName_Shape().get(intersect_b)));
            JOptionPane.showMessageDialog(null,intersectOrNot,"Result",JOptionPane.INFORMATION_MESSAGE);
            cardLayout.show(allPanel,"control");
        });
        panellist.add(intersectJP);

        JPanel moveJP = new JPanel();
        JComboBox moveCmb = new JComboBox();
        JTextField getMoveX=new JTextField();
        JTextField getMoveY=new JTextField();
        moveJP.add(moveCmb);
        moveJP.add(getMoveX);
        moveJP.add(getMoveY);
        moveJP.add(confirm[8]);
        confirm[8].addActionListener(e -> {
            run.getName_Shape().get(moveCmb.getSelectedItem()).move(Double.parseDouble(getMoveX.getText()),Double.parseDouble(getMoveY.getText()));
            frame.repaint();
            getMoveX.setText("");
            getMoveY.setText("");
            cardLayout.show(allPanel,"control");
        });
        panellist.add(moveJP);

        JPanel boundingBoxJP = new JPanel();
        JComboBox boundingBox = new JComboBox();
        boundingBoxJP.add(boundingBox);
        boundingBox.add(confirm[9]);
        confirm[9].addActionListener(e -> {
            Shape asked = run.getName_Shape().get((String)boundingBox.getSelectedItem());
            String boundingBoxResult = "";
            boundingBoxResult += "Top Left corner: ("+String.format(".2f",asked.getTopLeft().getX())+", "+String.format(".2f",asked.getTopLeft().getY())+"\n";
            boundingBoxResult += "Width :"+String.format(".2f",asked.getBottomRight().getX()-asked.getTopLeft().getX())+"\nHeight :"+String.format(".2f",asked.getBottomRight().getY()-asked.getTopLeft().getY());
            JOptionPane.showMessageDialog(null,boundingBoxResult,"BoundingBox",JOptionPane.INFORMATION_MESSAGE);
            cardLayout.show(allPanel,"control");
        });
        panellist.add(boundingBoxJP);


        JPanel deleteJP = new JPanel();
        JComboBox deleteCmb =new JComboBox();
        deleteJP.add(deleteCmb);
        deleteJP.add(confirm[10]);
        confirm[10].addActionListener(e -> {
            run.delete((String)deleteCmb.getSelectedItem());
            cardLayout.show(allPanel,"control");
            frame.repaint();
        });
        panellist.add(deleteJP);

        for(int x = 0 ; x<12 ; x++){
            panellist.get(x).add(back[x]);
        }

        allPanel.add(rectangleJP,"rectangle");
        allPanel.add(squareJP,"square");
        allPanel.add(circleJP,"circle");
        allPanel.add(lineJP,"line");
        allPanel.add(groupJP,"group");
        allPanel.add(ungroupJP,"ungroup");
        allPanel.add(pickAndMoveJP,"pickAndMove");
        allPanel.add(listJP,"list");
        allPanel.add(intersectJP,"intersect");
        allPanel.add(moveJP,"move");
        allPanel.add(boundingBoxJP,"boungdingbox");
        allPanel.add(deleteJP,"delete");
        allPanel.add(controler,"control");


        cardLayout.show(allPanel,"control");


        rectangleButton.addActionListener(e -> cardLayout.show(allPanel,"rectangle"));

        circleButton.addActionListener(e -> cardLayout.show(allPanel,"circle"));

        squareButton.addActionListener(e -> cardLayout.show(allPanel,"square"));
        lineButton.addActionListener(e -> cardLayout.show(allPanel,"line"));
        group.addActionListener(e -> cardLayout.show(allPanel,"group"));
        ungroup.addActionListener(e -> {
            allGroups.addItem("--please choose--");
            for(Group group1 : run.groupArrayList()){
                allGroups.addItem(group1.getShapeName());
            }
            cardLayout.show(allPanel,"ungroup");

        });
        pick_and_move.addActionListener(e -> cardLayout.show(allPanel,"pickAndMove"));
        list.addActionListener(e -> {
            allShapes.removeAllItems();
            allShapes.addItem("--please choose--");
            for(String s : run.getName_Shape().keySet()){
                allShapes.addItem(s);
            }
            listJP.add(allShapes);
            cardLayout.show(allPanel,"list");
        });
        move.addActionListener(e -> {
            moveCmb.removeAllItems();
            moveCmb.addItem("--please choose--");
            for(String s : run.getName_Shape().keySet()){
                moveCmb.addItem(s);
            }
            cardLayout.show(allPanel,"move");
        });

        bounding.addActionListener(e -> {
            boundingBox.removeAllItems();
            boundingBox.addItem("--please choose--");
            for(String s : run.getName_Shape().keySet()){
                boundingBox.addItem(s);
            }
            cardLayout.show(allPanel,"boundingbox");
        });

        delete.addActionListener(e -> {
            deleteCmb.removeAllItems();
            deleteCmb.addItem("--please choose--");
            for(String s : run.getName_Shape().keySet()){
                deleteCmb.addItem(s);
            }
            cardLayout.show(allPanel,"delete");
        });

        intersect.addActionListener(e -> {
            intersect_1.removeAllItems();
            intersect_2.removeAllItems();
            intersect_1.addItem("--please choose--");
            intersect_2.addItem("--please choose--");
            for(String s : run.getName_Shape().keySet()){
                intersect_1.addItem(s);
                intersect_2.addItem(s);
            }
            cardLayout.show(allPanel,"intersect");
        });


        frame.add(jp);
        frame.add(allPanel,BorderLayout.EAST);
        frame.setBounds(300,200,600,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }


}

