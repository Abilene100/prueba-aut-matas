
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author abile
 */
public class VentanaPrincipal extends JFrame {

    private JTextArea areaCodigo;
    private JTextArea areaIdentificadores;

    // Identificador: empieza con letra, luego letras/numeros/_
    private static final Pattern ID = Pattern.compile("\\b[A-Za-z][A-Za-z0-9_]*\\b");

    public VentanaPrincipal() {
        setTitle("Ventana Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);

        // Área grande (código)
        areaCodigo = new JTextArea();
        areaCodigo.setFont(new Font("Consolas", Font.PLAIN, 14));
        JScrollPane scrollCodigo = new JScrollPane(areaCodigo);

        // Área abajo (identificadores)
        areaIdentificadores = new JTextArea();
        areaIdentificadores.setEditable(false);
        areaIdentificadores.setFont(new Font("Consolas", Font.PLAIN, 13));
        JScrollPane scrollIds = new JScrollPane(areaIdentificadores);

        // Split: arriba código, abajo identificadores
        JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scrollCodigo, scrollIds);
        split.setDividerLocation(380);
        split.setResizeWeight(0.7);

        setJMenuBar(crearMenu());
        add(split, BorderLayout.CENTER);
    }

    private JMenuBar crearMenu() {
        JMenuBar barra = new JMenuBar();
        JMenu menuAbrir = new JMenu("Abrir");

        JMenuItem itemAbrirArchivo = new JMenuItem("Abrir archivo...");
        itemAbrirArchivo.addActionListener(this::abrirArchivo);

        JMenuItem itemProcesar = new JMenuItem("Procesos (Identificadores)");
        itemProcesar.addActionListener(this::procesarIdentificadores);

        menuAbrir.add(itemAbrirArchivo);
        menuAbrir.add(itemProcesar);

        barra.add(menuAbrir);
        return barra;
    }

    private void abrirArchivo(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        int opcion = chooser.showOpenDialog(this);

        if (opcion != JFileChooser.APPROVE_OPTION) return;

        File archivo = chooser.getSelectedFile();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(archivo), StandardCharsets.UTF_8))) {

            StringBuilder sb = new StringBuilder();
            String linea;
            while ((linea = br.readLine()) != null) {
                sb.append(linea).append("\n");
            }

            areaCodigo.setText(sb.toString());
            areaIdentificadores.setText(""); // limpia resultados

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo leer el archivo", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void procesarIdentificadores(ActionEvent e) {
        String texto = areaCodigo.getText();
        if (texto == null || texto.isBlank()) {
            areaIdentificadores.setText("No hay texto. Primero abre un archivo.\n");
            return;
        }

        Matcher m = ID.matcher(texto);

        StringBuilder salida = new StringBuilder();
        int n = 1;

        while (m.find()) {
            salida.append(n).append(") ").append(m.group()).append("\n");
            n++;
        }

        if (n == 1) {
            salida.append("No se encontraron identificadores válidos.\n");
        }

        areaIdentificadores.setText(salida.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaPrincipal().setVisible(true));
    }
}