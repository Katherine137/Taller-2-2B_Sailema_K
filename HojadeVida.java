package Grafica.clases;

import ficheros.clases.Escritura;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HojadeVida extends JFrame {
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtEmail;
    private JTextField txtTeléfono;
    private JRadioButton masculinoRadioButton;
    private JRadioButton femeninoRadioButton;
    private JRadioButton otroRadioButton;
    private JComboBox cbinstruccion;
    private JTextArea txtExperiencia;
    private JCheckBox leerCheckBox;
    private JCheckBox viajarCheckBox;
    private JCheckBox deportesCheckBox;
    private JCheckBox pintarCheckBox;
    private JButton btnguardar;
    private JButton btnlimpiar;
    private JButton btnsalir;
    private JPanel HDV;
    private JRadioButton enCursoRadioButton;
    private JTextArea txtformacion;

    public HojadeVida() {
        setTitle("Hoja de vida");
        setSize(700,600);
        setContentPane(HDV);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        btnguardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Datos
                String nombre= txtNombre.getText();
                String apellido = txtApellido.getText();
                String email = txtEmail.getText();
                String telefono = txtTeléfono.getText();

                //Genero
                String genero =" ";
                if (masculinoRadioButton.isSelected()) genero = "Masculino";
                else if (femeninoRadioButton.isSelected()) genero = "Femenino";
                else if (otroRadioButton.isSelected()) genero = "Otro";

                //Experiencia
                String experiencia = txtExperiencia.getText();

                //Hobbies
                StringBuilder hobbies = new StringBuilder();
                if (leerCheckBox.isSelected()) hobbies.append("Leer, ");
                if (viajarCheckBox.isSelected()) hobbies.append("Viajar, ");
                if (deportesCheckBox.isSelected()) hobbies.append("Deportes, ");
                if (pintarCheckBox.isSelected()) hobbies.append("Pintar, ");

                //Formacion
                String formacion = txtformacion.getText();

                // Nivel de instrucción
                String nivelInstruccion = cbinstruccion.getSelectedItem().toString();
                String estadoInstruccion = enCursoRadioButton.isSelected() ?"En curso":" ";

                //to string
                StringBuilder contenido = new StringBuilder();
                contenido.append("Nombre;Apellido;Correo;Teléfono;Género;Nivel de instrucción;Estado;Formación;Experiencia;Hobbies\n");
                contenido.append(nombre).append(";")
                        .append(apellido).append(";")
                        .append(email).append(";")
                        .append(telefono).append(";")
                        .append(genero).append(";")
                        .append("\"").append(nivelInstruccion).append("\";")
                        .append("\"").append(estadoInstruccion).append("\"; ")
                        .append("\"").append(experiencia.replace("\n", " ")).append("\";")
                        .append("\"").append(formacion.replace("\n", " ")).append("\";")
                        .append("\"").append(hobbies).append("\"\n");


                // Guardar en archivo
                Escritura es = new Escritura();
                es.escribirfichero(contenido.toString(), "F:/POO/hojadevida.csv");

                // Confirmación
                JOptionPane.showMessageDialog(null, "Hoja de vida guardada correctamente en D:/POO/hojadevida.csv");
            }

        });
        btnlimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNombre.setText(" ");
                txtApellido.setText(" ");
                txtEmail.setText(" ");
                txtTeléfono.setText(" ");
                masculinoRadioButton.setSelected(false);
                femeninoRadioButton.setSelected(false);
                otroRadioButton.setSelected(false);
                txtExperiencia.setText(" ");
                cbinstruccion.setSelectedIndex(0);
                enCursoRadioButton.setSelected(false);
                txtformacion.setText(" ");
                leerCheckBox.setSelected(false);
                viajarCheckBox.setSelected(false);
                deportesCheckBox.setSelected(false);
                pintarCheckBox.setSelected(false);
            }
        });
        btnsalir.addActionListener(e -> System.exit(0));
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{new HojadeVida().setVisible(true);
        });
    }
}
