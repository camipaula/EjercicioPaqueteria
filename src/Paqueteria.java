import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

public class Paqueteria extends JFrame {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JButton CREARButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField eliminar;
    private JButton ELIMINARButton;
    private JButton mostrarPaquetesButton;
    private JTextArea textArea1;
    private JButton quemarDatosButton;
    private JTextPane textPane1;
    private JTextField textField13;
    private JButton BUSCARButton;
    private JTextArea textArea2;
    private JTextField textField14;
    private JButton BUSCARButton1;
    private JTextArea textArea3;
    private JTextArea textArea4;
    private JTextField textField15;
    private JTextField textField16;
    private JTextField textField17;
    private JTextField textField18;
    private JButton BUSCARButton2;
    private JTextField textField12;

    private TrackingSystem ts;

    public Paqueteria(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();
        ts=new TrackingSystem();


        CREARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ts.addPackage(new Package(new Address(textField1.getText(),textField5.getText(),textField6.getText(),textField7.getText()),
                        new Address(textField2.getText(),textField8.getText(),textField9.getText(),textField10.getText()),
                        LocalDate.of(Integer.parseInt(textField11.getText()),Integer.parseInt(textField4.getText()),Integer.parseInt(textField3.getText()))));
                JOptionPane.showMessageDialog(null, "Paquete creado con éxito \n Código de rastreo: "+ts.getLastPackageCode());
            }
        });


        ELIMINARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ts.removePackage(textField12.getText())){
                    JOptionPane.showMessageDialog(null, "Paquete eliminado");
                }else{
                    JOptionPane.showMessageDialog(null, "No se encontro el paquete, intentelo nuevamente");
                }
            }
        });


        quemarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ts.Quemardatos();
                JOptionPane.showMessageDialog(null, "Datos quemados");
                quemarDatosButton.setEnabled(false);
            }
        });


        mostrarPaquetesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    textArea1.setText(ts.toString());
            }
        });

//BUSQUEDA POR DIRECCION
        BUSCARButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Package pk1=ts.searchByRecipientAddress(new Address(textField15.getText(),textField16.getText(),textField17.getText(),textField18.getText()));
                if(pk1!=null){
                    textArea4.setText(pk1.toString());
                }else{
                    textArea4.setText("No se encontraron resultados para la busqueda");
                }
            }
        });

//BUSQUEDA POR CIUDAD
        BUSCARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Package> ciudades=ts.searchByCity(textField13.getText());
                System.out.println("Tamaño arreglo ciudades: "+ciudades.size());
                if(ciudades.size()>0){
                    textArea2.setText(ts.mostrarLista(ciudades));
                }
                else{textArea2.setText("No se encontraron resultados para la busqueda");
                }
            }
        });

//BUSQUEDA POR NUMERO DE PAQUETE
        BUSCARButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Package pk1=ts.searchByTrackingNumber(textField14.getText());
                if(pk1!=null){
                    textArea3.setText(pk1.toString());
                }else{
                    textArea3.setText("No se encontraron resultados de la busqueda");
                }
            }
        });
    }
}
