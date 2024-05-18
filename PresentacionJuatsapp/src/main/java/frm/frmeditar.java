package frm;

import excepciones.NegocioException;
import java.awt.Image;
import java.io.File;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import juatsapp.dtos.UsuarioDTO;
import juatsapp.negocio.UsuarioBO;
import juatsapp.negocioInterfaces.IUsuarioBO;
import presentacion.Control.ControlPresentacion;

/**
 *
 * @author Usuario
 */
public class FrmEditar extends javax.swing.JFrame {

    ControlPresentacion control;
    IUsuarioBO funcionalidadesUsuario;

    public FrmEditar() {
        initComponents();
        control.getInstance();
        funcionalidadesUsuario = new UsuarioBO();
    }

    private void cargarDatosUsuario() {
        // Recuperar los datos del usuario desde tu sistema de almacenamiento
        control.getUsuarioActivo();
        // Establecer los datos en los campos de texto
        if (control.getUsuarioActivo() != null) {
            nombre.setText(control.getUsuarioActivo().getNombre());
            telefono.setText(control.getUsuarioActivo().getTelefono());
            txtusuario.setText(control.getUsuarioActivo().getUsuario());
            ComboBoxPaises.setSelectedItem(control.getUsuarioActivo().getRegion());
            sexo.setSelectedItem(control.getUsuarioActivo().getSexo());
            Date fechaNacimiento = control.getUsuarioActivo().getFechaNacimiento();
            LocalDate fecha = fechaNacimiento.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            dtpkFechaNacimiento.setDate(fecha);
            txtContra.setText(control.getUsuarioActivo().getContra());
        } else {
            // Manejar el caso en que no se encuentre el usuario
            System.out.println("El usuario no fue encontrado");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnSeleccionarImagen = new javax.swing.JButton();
        JLImg = new javax.swing.JLabel();
        JLDireccion = new javax.swing.JLabel();
        REGRESAR = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        modificar1 = new javax.swing.JButton();
        nombre = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        lblpais = new javax.swing.JLabel();
        ComboBoxPaises = new javax.swing.JComboBox<>();
        sexo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtContra = new javax.swing.JPasswordField();
        mostrar = new javax.swing.JCheckBox();
        txtcontra2 = new javax.swing.JPasswordField();
        mostrar2 = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        dtpkFechaNacimiento = new com.github.lgooddatepicker.components.DatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(16, 99, 182));

        btnSeleccionarImagen.setText("Seleccionar Imagen");
        btnSeleccionarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarImagenActionPerformed(evt);
            }
        });

        REGRESAR.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        REGRESAR.setForeground(new java.awt.Color(0, 102, 153));
        REGRESAR.setText("REGRESAR");
        REGRESAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REGRESARActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JLDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSeleccionarImagen)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLImg, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(REGRESAR))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(REGRESAR, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(JLImg, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btnSeleccionarImagen)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel2.setText("Fecha de Nacimiento:");

        jLabel4.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel4.setText("sexo:");

        jLabel5.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel5.setText("telefono:");

        jLabel6.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel6.setText("Usuario:");

        jLabel7.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel7.setText("Contraseña:");

        jLabel8.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel8.setText("Contraseña:");

        modificar1.setBackground(new java.awt.Color(0, 102, 153));
        modificar1.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        modificar1.setForeground(new java.awt.Color(255, 255, 255));
        modificar1.setText("MODIFICAR");
        modificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificar1ActionPerformed(evt);
            }
        });

        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });

        telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoActionPerformed(evt);
            }
        });

        lblpais.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        lblpais.setText("País:");

        ComboBoxPaises.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        lblpais.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        lblpais.setText("País:");

        // Obtener una lista de códigos de países
        String[] codigosPaises = Locale.getISOCountries();

        // Crear una lista de nombres de países
        List<String> nombresPaises = new ArrayList<>();
        for (String codigoPais : codigosPaises) {
            Locale pais = new Locale("", codigoPais);
            nombresPaises.add(pais.getDisplayCountry());
        }

        // Ordenar la lista alfabéticamente
        Collections.sort(nombresPaises);

        // Agregar los nombres de países al ComboBox
        ComboBoxPaises = new javax.swing.JComboBox<>(nombresPaises.toArray(new String[0]));
        ComboBoxPaises.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxPaisesActionPerformed(evt);
            }
        });

        sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Femenino", "Masculino", "Transformer", "Otro" }));
        sexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexoActionPerformed(evt);
            }
        });

        jLabel11.setText("La contraseña debe contener al menos una mayúscula, una minúscula,");

        jLabel12.setText(" un dígito numérico, un carácter especial y tener un mínimo de 8 caracteres.");

        mostrar.setText("Mostrar");
        mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarActionPerformed(evt);
            }
        });

        mostrar2.setText("Mostar");
        mostrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrar2ActionPerformed(evt);
            }
        });

        jLabel9.setText("repetir contraseña");

        jLabel10.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel10.setText("Nombre:");

        txtusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuarioActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(0, 102, 153));
        btnGuardar.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        eliminar.setBackground(new java.awt.Color(0, 102, 153));
        eliminar.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        eliminar.setForeground(new java.awt.Color(255, 255, 255));
        eliminar.setText("ELIMINAR");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(64, 64, 64))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtcontra2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(mostrar))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(mostrar2))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4))
                                        .addGap(45, 45, 45))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblpais)
                                        .addGap(87, 87, 87)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(sexo, javax.swing.GroupLayout.Alignment.LEADING, 0, 227, Short.MAX_VALUE)
                                    .addComponent(telefono)
                                    .addComponent(ComboBoxPaises, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dtpkFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(216, 216, 216)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(modificar1)
                                    .addComponent(jLabel9))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(dtpkFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblpais)
                    .addComponent(ComboBoxPaises, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mostrar))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mostrar2)
                    .addComponent(txtcontra2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modificar1)
                    .addComponent(btnGuardar)
                    .addComponent(eliminar))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar1ActionPerformed

        String telefonoIngresado = telefono.getText();
        boolean esValido = validarTelefono(telefonoIngresado);
        String contrasenaIngresada = txtContra.getText();
        boolean contrasenaValida = validarContrasena(contrasenaIngresada);

        if (!nombre.getText().isEmpty()
                && ComboBoxPaises.getSelectedItem() != null
                && !txtusuario.getText().isEmpty()
                && !contrasenaIngresada.isEmpty()
                && contrasenaIngresada.equals(txtcontra2.getText())
                && esValido
                && contrasenaValida) {

            UsuarioDTO usuario = new UsuarioDTO(nombre.getText(), ComboBoxPaises.getSelectedItem().toString(),
                    telefonoIngresado, txtusuario.getText(),
                    contrasenaIngresada);

            try {
                if (funcionalidadesUsuario.insertar(usuario)) {
                    JOptionPane.showMessageDialog(this, "Registro Exitoso");
                    FrmInicioSesion iniciarsesion = new FrmInicioSesion();
                    iniciarsesion.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Usuario ya existente");
                }
            } catch (Exception ex) {
                Logger.getLogger(FrmRegistro.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (!esValido) {
                JOptionPane.showMessageDialog(this, "Error en el teléfono. Debe ingresar un número de máximo 10 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
                telefono.setText(""); // Limpiar el campo de teléfono
            } else if (!contrasenaValida) {
                JOptionPane.showMessageDialog(this, "La contraseña debe contener al menos una mayúscula, una minúscula, un dígito numérico, un carácter especial y tener un mínimo de 8 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
                txtContra.setText(""); // Limpiar el campo de contraseña
                txtcontra2.setText(""); // Limpiar el campo de repetir contraseña
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos requeridos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_modificar1ActionPerformed

    private boolean validarTelefono(String telefono) {
        // Expresión regular para validar que solo contenga dígitos
        String regex = "^\\d{10}$";

        // Verificar si el teléfono coincide con la expresión regular
        return telefono.matches(regex);
    }

    private boolean validarContrasena(String contrasena) {
        // Expresión regular para validar la contraseña
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&/\\-_ñ°+\\]\\['¿.,])[A-Za-z\\d@$!%*?&/\\-_ñ°+\\]\\['¿.,]{8,}$";

        // Verificar si la contraseña coincide con la expresión regular
        return contrasena.matches(regex);

    }

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed

        if (!txtusuario.getText().isEmpty()) {
            try {
                if (funcionalidadesUsuario.eliminar(txtusuario.getText())) {
                    JOptionPane.showMessageDialog(this, "Usario Eliminado");
                } else {
                    JOptionPane.showMessageDialog(this, "Usuario No encontrado");
                }
            } catch (NegocioException ex) {
                Logger.getLogger(FrmEditar.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_eliminarActionPerformed

    private void btnSeleccionarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarImagenActionPerformed
        int resultado;

        FrmBuscarImg buscar = new FrmBuscarImg();
        FileNameExtensionFilter formato = new FileNameExtensionFilter("JPG,PNG Y GIF", "jpg", "png", "gif");
        buscar.JFCImg.setFileFilter(formato);

        resultado = buscar.JFCImg.showOpenDialog(null);

        if (JFileChooser.APPROVE_OPTION == resultado) {
            File archivo = buscar.JFCImg.getSelectedFile();
            JLDireccion.setText(archivo.getAbsolutePath());

            try {
                ImageIcon ImgIcon = new ImageIcon(archivo.toString());
                Icon icono = new ImageIcon(ImgIcon.getImage().getScaledInstance(JLImg.getWidth(), JLImg.getHeight(), Image.SCALE_DEFAULT));
                JLImg.setIcon(icono);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al abrir: " + e.getMessage());
            }
        }

    }//GEN-LAST:event_btnSeleccionarImagenActionPerformed

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoActionPerformed

    }//GEN-LAST:event_telefonoActionPerformed

    private void ComboBoxPaisesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxPaisesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxPaisesActionPerformed

    private void sexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sexoActionPerformed

    private void mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarActionPerformed
        if (mostrar.isSelected()) {
            txtContra.setEchoChar((char) 0);
        } else {
            txtContra.setEchoChar('*');
        }
    }//GEN-LAST:event_mostrarActionPerformed

    private void mostrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrar2ActionPerformed
        if (mostrar2.isSelected()) {
            txtcontra2.setEchoChar((char) 0);
        } else {
            txtcontra2.setEchoChar('*');
        }
    }//GEN-LAST:event_mostrar2ActionPerformed

    private void txtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuarioActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void REGRESARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REGRESARActionPerformed
        // Mostrar un cuadro de diálogo de confirmación
        int opcion = JOptionPane.showConfirmDialog(this, "Por seguridad ira al inisio de sesion, Esto cerrará la ventana actual.", "Confirmación", JOptionPane.YES_NO_OPTION);

        // Verificar la opción seleccionada por el usuario
        if (opcion == JOptionPane.YES_OPTION) {
            // Si el usuario elige sí, regresar al inicio de sesión
            FrmMenuPrincipal inicio = new FrmMenuPrincipal();
            inicio.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_REGRESARActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> ComboBoxPaises;
    private javax.swing.JLabel JLDireccion;
    private javax.swing.JLabel JLImg;
    private javax.swing.JButton REGRESAR;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSeleccionarImagen;
    private com.github.lgooddatepicker.components.DatePicker dtpkFechaNacimiento;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblpais;
    private javax.swing.JButton modificar1;
    private javax.swing.JCheckBox mostrar;
    private javax.swing.JCheckBox mostrar2;
    private javax.swing.JTextField nombre;
    private javax.swing.JComboBox<String> sexo;
    private javax.swing.JTextField telefono;
    private javax.swing.JPasswordField txtContra;
    private javax.swing.JPasswordField txtcontra2;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
