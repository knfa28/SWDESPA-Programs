package emailwidget;

import java.util.*;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class emailGUI extends JFrame implements ActionListener{
    private List<String> twitterDetails = new ArrayList<String>();
    private List<String> googleDetails = new ArrayList<String>();
    private List<String> fbDetails = new ArrayList<String>();
    private List<String> fbTextDetails = new ArrayList<String>();
    private List<String> csvDetails = new ArrayList<String>();
    
    private int twitterCheck = 1,
                fbCheck = 1,
                googleCheck = 1,
                csvCheck = 1,
                txtOnly = 0;
    
    private JPanel Menu = new JPanel();
    private JPanel Top = new JPanel();
    private JPanel Right = new JPanel();
    private JPanel Contacts = new JPanel();
    private JPanel Format = new JPanel();
    private JPanel Bottom = new JPanel();
    private JPanel Left = new JPanel();
    private JLabel Welcome = new JLabel("Welcome Username!"); //Will be set in initialize function
    private JLabel Fullname = new JLabel("John Doe");
    private ButtonGroup Selections = new ButtonGroup();
    private JRadioButton[] Options = new JRadioButton[6];
    private JButton Clear = new JButton("Clear");
    //private JList ContactsList = new JList();
    private DefaultListModel<String> ContactsListModel = new DefaultListModel<String>();
    private JList ContactsList = new JList(ContactsListModel);
	
    private JScrollPane browseContacts = new JScrollPane();
        
    public emailGUI(){
        setTitle("MyContacts");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ContactsList = new JList(ContactsListModel);
		browseContacts = new JScrollPane(ContactsList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        Options[0] = new JRadioButton("Facebook", true);
        Options[1] = new JRadioButton("Twitter", true);
        Options[2] = new JRadioButton("Google", true);
        Options[3] = new JRadioButton("CSV", true);
        Options[4] = new JRadioButton("Text-only");
        Options[5] = new JRadioButton("Rich-format", true);
        Clear.addActionListener(this);
        Top.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 15));
        Top.setPreferredSize(new Dimension(600,50));
        Bottom.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        Right.setLayout(new BorderLayout());
        Right.setPreferredSize(new Dimension(100,300));
        Contacts.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        Format.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        Format.setPreferredSize(new Dimension(100,80));
        Left.setPreferredSize(new Dimension(10,300));
        Menu.setLayout(new BorderLayout());
        for(int i = 0; i < 6; i++){
            Options[i].addActionListener(this);
        }
        for(int i = 0; i < 4; i++){
            Contacts.add(Options[i]); 
        }
        Format.add(Options[4]);
        Format.add(Options[5]);
        Selections.add(Options[4]);
        Selections.add(Options[5]);
        Top.add(Welcome);
        Top.add(Fullname);
        Bottom.add(Clear);
        Right.add(Contacts, BorderLayout.CENTER);
        Right.add(Format, BorderLayout.SOUTH);
        Menu.add(Top, BorderLayout.NORTH);
        Menu.add(browseContacts, BorderLayout.CENTER);
        Menu.add(Left, BorderLayout.WEST);
        Menu.add(Right, BorderLayout.EAST);
        Menu.add(Bottom, BorderLayout.SOUTH);
        add(Menu);
        
        
        initialize();
        loadAllContacts();
        setVisible(true);
    }
    
    public void initialize(){
        String username = "@esKILLYOU";
        Welcome.setText("Welcome "+username);
        Fullname.setText("Patrick Esquillo");
    }
    
    public void actionPerformed(ActionEvent event){
        //Data Pulled from Facebook
        if(event.getSource() == Options[0]){
            if(fbCheck == 0)
                fbCheck = 1;
            else fbCheck = 0;
       
            ContactsListModel.clear();
            loadContacts();
        }
        //Data Pulled from Twitter
        else if(event.getSource() == Options[1]){
            if(twitterCheck == 0)
                twitterCheck = 1;
            else twitterCheck = 0;
            
            ContactsListModel.clear();
            loadContacts();
        }
        //Data Pulled from Google
        else if(event.getSource() == Options[2]){
            if(googleCheck == 0)
                googleCheck = 1;
            else googleCheck = 0;
            
            ContactsListModel.clear();
            loadContacts();
        }
        //Data Pulled from CSV
        else if(event.getSource() == Options[3]){
            if(csvCheck == 0)
                csvCheck = 1;
            else csvCheck = 0;
            
            ContactsListModel.clear();
            loadContacts();
        }
        else if(event.getSource() == Options[4]){
            txtOnly = 1;
            
            ContactsListModel.clear();
            loadContacts();
        }
        else if(event.getSource() == Options[5]){
            txtOnly = 0;
            
            ContactsListModel.clear();
            loadContacts();
        }
        else if(event.getSource() == Clear){
            ContactsListModel.clear();
        }
    }
    
    public void loadAllContacts(){
        fbAdapter fb = new fbAdapter("ptrck.esquillo@gmail.com", "1234", "Patrick Esquillo", "09152824229", "(^_^)");
        fbDetails = fb.getContactDetails();
        fbTextDetails = fb.getTextDetails();
        for(int i = 0; i < fbDetails.size(); i++){
            ContactsListModel.addElement(fbDetails.get(i));
            //System.out.println(fbDetails.get(i));
            System.out.println(fbTextDetails.get(i));
        }
        
        twitterAdapter t = new twitterAdapter("@esKILLYOU", "ptrck.esquillo@gmail.com", "1234", "Patrick Esquillo");
        twitterDetails = t.getContactDetails();
        for(int i = 0; i < twitterDetails.size(); i++){
            ContactsListModel.addElement(twitterDetails.get(i));
            System.out.println(twitterDetails.get(i));
        }
        
        googleAdapter gc = new googleAdapter("briane.samson@dlsu.edu.ph", "DLSUCCSRocks!");
        googleDetails = gc.getContactDetails();
        for(int i = 0; i < googleDetails.size(); i++){
            ContactsListModel.addElement(googleDetails.get(i));
            System.out.println(googleDetails.get(i));
        }
        
        csvAdapter newCSV = new csvAdapter();
        csvDetails = newCSV.getContactDetails();
        for(int i = 0; i < csvDetails.size(); i++){
            ContactsListModel.addElement(csvDetails.get(i));
            System.out.println(csvDetails.get(i));
        }
    }
    
    public void loadContacts(){
        
        if(fbCheck == 1){
            if(txtOnly == 0)
                for(int i = 0; i < fbDetails.size(); i++)
                    ContactsListModel.addElement(fbDetails.get(i));
            else
                for(int i = 0; i < fbTextDetails.size(); i++)
                    ContactsListModel.addElement(fbTextDetails.get(i));
        }
        
        if(twitterCheck == 1)
            for(int i = 0; i < twitterDetails.size(); i++)
                ContactsListModel.addElement(twitterDetails.get(i));
        
        if(googleCheck == 1)
            for(int i = 0; i < googleDetails.size(); i++)
                ContactsListModel.addElement(googleDetails.get(i));
        
        if(csvCheck == 1)
            for(int i = 0; i < csvDetails.size(); i++)
                ContactsListModel.addElement(csvDetails.get(i));
        
    }
}
