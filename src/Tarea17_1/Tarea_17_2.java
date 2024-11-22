package Tarea17_1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.HashMap;



public class Tarea_17_2 extends JFrame {
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtTelefono;
    private JPasswordField txtContrasena;
    private HashMap<String, Usuario> usuariosRegistrados;

    public Tarea_17_2() {
        setTitle("Registro de Usuarios");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        usuariosRegistrados = new HashMap<>();

        
        add(new JLabel("Nombre:"));
        txtNombre = new JTextField(15);
        add(txtNombre);

        add(new JLabel("Apellido:"));
        txtApellido = new JTextField(15);
        add(txtApellido);

        add(new JLabel("Teléfono:"));
        txtTelefono = new JTextField(15);
        add(txtTelefono);

        add(new JLabel("Contraseña:"));
        txtContrasena = new JPasswordField(15);
        add(txtContrasena);

        
        JButton btnRegistrar = new JButton("Registrar");
        add(btnRegistrar);

       
        JButton btnVerificar = new JButton("Verificar");
        add(btnVerificar);

        
        btnRegistrar.addActionListener(e -> {
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String telefono = txtTelefono.getText();
            String contrasena = new String(txtContrasena.getPassword());

            if (!usuariosRegistrados.containsKey(telefono)) {
                Usuario nuevoUsuario = new Usuario(nombre, apellido, telefono, contrasena);
                usuariosRegistrados.put(telefono, nuevoUsuario);
                guardarUsuarioEnArchivo(nuevoUsuario);
                JOptionPane.showMessageDialog(null, "Usuario registrado correctamente.");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(null, "El número de teléfono ya está registrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

       
        btnVerificar.addActionListener(e -> {
            String telefono = txtTelefono.getText();
            if (usuariosRegistrados.containsKey(telefono)) {
                Usuario usuario = usuariosRegistrados.get(telefono);
                JOptionPane.showMessageDialog(null, "Usuario encontrado:\n" +
                        "Nombre: " + usuario.getNombre() + "\n" +
                        "Apellido: " + usuario.getApellido() + "\n" +
                        "Teléfono: " + usuario.getTelefono());
            } else {
                JOptionPane.showMessageDialog(null, "El usuario no está registrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }

    private void guardarUsuarioEnArchivo(Usuario usuario) {
        try (FileWriter writer = new FileWriter("E:/yuio/usuarios.txt", true)) {
            writer.write(usuario.getNombre() + "," +
                         usuario.getApellido() + "," +
                         usuario.getTelefono() + "," +
                         usuario.getContrasena() + "\n");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
        txtContrasena.setText("");
    }

    public static void main(String[] args) {
        new Tarea_17_2();
    }
}