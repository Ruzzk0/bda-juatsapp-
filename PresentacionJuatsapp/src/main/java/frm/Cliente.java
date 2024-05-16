
package frm;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
/**
 *
 * @author Ruzzky
 */
public class Cliente extends javax.swing.JFrame {
    private static boolean isRunning = false;
    private Socket socket;
    private DataInputStream entrada;
    private DataOutputStream salida;
    public Cliente() {
        initComponents();
        
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        enviarMensaje();
    }
});
        try {
            // Conectar al servidor
            socket = new Socket("192.168.56.1", 1023);
            entrada = new DataInputStream(socket.getInputStream());
            salida = new DataOutputStream(socket.getOutputStream());

            // Iniciar hilo para recibir mensajes del servidor
            HiloRecibir hilo = new HiloRecibir(entrada);
            hilo.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void enviarMensaje() {
        String mensaje = txtMensajeCliente.getText();
        try {
            salida.writeUTF(mensaje);
            salida.flush();
            txtMensajeCliente.setText("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class HiloRecibir extends Thread {
        private DataInputStream entrada;

        public HiloRecibir(DataInputStream entrada) {
            this.entrada = entrada;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    String mensaje = entrada.readUTF();
                    msg_area.append("Servidor: " + mensaje + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }
    @Override
public void dispose() {
    try {
        if (socket != null) {
            socket.close();
        }
        if (entrada != null) {
            entrada.close();
        }
        if (salida != null) {
            salida.close();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    super.dispose();
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtMensajeCliente = new javax.swing.JTextField();
        cliente = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        msg_area = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtMensajeCliente.setBackground(new java.awt.Color(204, 204, 204));

        cliente.setForeground(new java.awt.Color(0, 102, 153));
        cliente.setText("CON QUIEN SE VA A PLATICAR");

        btnEnviar.setBackground(new java.awt.Color(0, 102, 153));
        btnEnviar.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        btnEnviar.setText("ENVIAR");

        msg_area.setBackground(new java.awt.Color(204, 204, 204));
        msg_area.setColumns(20);
        msg_area.setRows(5);
        jScrollPane1.setViewportView(msg_area);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/japon (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1)
                        .addGap(137, 137, 137)
                        .addComponent(cliente))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(txtMensajeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEnviar)))
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(36, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(cliente))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 281, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnviar)
                    .addComponent(txtMensajeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(69, 69, 69)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(93, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    if (!isRunning) { // Verifica si no hay una instancia en ejecución
            isRunning = true; // Marca que hay una instancia en ejecución
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Cliente().setVisible(true);
                }
            });
        } else {
            System.out.println("El cliente ya está en ejecución");
        }
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel cliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea msg_area;
    private javax.swing.JTextField txtMensajeCliente;
    // End of variables declaration//GEN-END:variables
}
