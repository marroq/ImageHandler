import java.io.FileInputStream;
import java.io.FileOutputStream;

//IMPORT'S PARA GENERAN PARTE GRAFICA
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.imageio.stream.*;
import java.net.URL;
//IMPORT'S PARA GENERAR PARTE GRAFICA

public class BmpImageHandler {
	public static Colors imageI;
	public static Rotates imageII;
	public static DarkAndBright imageII2;
	public static Grayscale imageIII;
	public static RunLengthEncoding imageIV;
	public static FileInputStream imagenRed;
	public static FileInputStream imagenGreen;
	public static FileInputStream imagenBlue;
	public static FileInputStream imagenRAVR;
	public static FileInputStream imagenAux;
	public static FileInputStream imagenRVAR;
	public static FileInputStream imagenAux2;
	public static FileInputStream imagenDeCabeza;
	public static FileInputStream imagenAux3;
	public static FileInputStream imagenAIzquierda;
	public static FileInputStream imagenAux4;
	public static FileInputStream imagenGiroRecto;
	public static FileInputStream imagenAux5;
	public static FileInputStream imagenAclarada;
	public static FileInputStream imagenOscura;
	public static FileInputStream imagenGris;
	public static FileInputStream imagenAux6;
	public static FileInputStream imagenRLE;
	public static String name;

	public static void main (String[] args) throws Exception {
		System.out.println("**********BIENVENIDO 'Bmp Image Handler'**********");
			if (args[0].equals("-help")) {
				System.out.println();System.out.println("********************AYUDA DEL PROGRAMA*********************");System.out.println();
				System.out.println("NOTA: 'imagen' es el nombre de su imagen");System.out.println();
				System.out.println("PARA SEPARAR LA IMAGEN EN TONOS DE ROJO-VERDE-AZUL EJECUTE:");
				System.out.println("	java BmpImageHandler -colors imagen.bmp"); System.out.println();
				System.out.println("PARA ROTAR LA IMAGEN EJECUTE:");
				System.out.println("	java BmpImageHandler -rotate imagen.bmp"); System.out.println();
				System.out.println("PARA ACLARAR Y OSCURECER LA IMAGEN EJECUTE:");
				System.out.println("	java BmpImageHandler -bd imagen.bmp"); System.out.println();
				System.out.println("PARA ESCALA DE GRISES EJECUTE:");
				System.out.println("	java BmpImageHandler -grayscale imagen.bmp"); System.out.println();
				System.out.println("PARA COMPRIMIR LA IMAGEN EJECUTE:");
				System.out.println("	java BmpImageHandler -rle imagen.bmp"); System.out.println();
				System.out.println("PARA EJECUTAR TODAS LAS SECCIONES DEL PROYECTO EJECUTE:");
				System.out.println("	java BmpImageHandler -all imagen.bmp"); System.out.println();
			}
			else if (args[0].equals("-colors")) {
				System.out.println("CONVIRTIENDO IMAGENES...");
				name = args[1];
				imagenRed = new FileInputStream(args[1]);
				imagenGreen = new FileInputStream(args[1]);
				imagenBlue = new FileInputStream(args[1]);
				imagenRAVR = new FileInputStream(args[1]);
				imagenAux = new FileInputStream(args[1]);
				imagenRVAR = new FileInputStream(args[1]);
				imagenAux2 = new FileInputStream(args[1]);
				imageI = new Colors(name, imagenRed, imagenGreen, imagenBlue, imagenRAVR, imagenAux, imagenRVAR, imagenAux2);
				imageI.covertRed();
				imageI.covertGreen();
				imageI.covertBlue();
				imageI.corrimientoRAVR();
				imageI.corrimientoRVAR();
				System.out.println("IMAGENES PROCESADAS EXITOSAMENTE");
				Frame mainFrame = new Frame(args[1], args[0]);
			}
			else if (args[0].equals("-rotate")) {
				System.out.println("CONVIRTIENDO IMAGENES...");
				name = args[1];
				imagenDeCabeza = new FileInputStream(args[1]);
				imagenAIzquierda = new FileInputStream(args[1]);
				imagenGiroRecto = new FileInputStream(args[1]);
				imagenAux3 = new FileInputStream(args[1]);
				imagenAux4 = new FileInputStream(args[1]);
				imagenAux5 = new FileInputStream(args[1]);
				imageII = new Rotates(name, imagenDeCabeza, imagenAIzquierda, imagenGiroRecto, imagenAux3, imagenAux4, imagenAux5);
				imageII.deCabeza();
				imageII.rigthTOleft();
				imageII.correrCuadro();
				System.out.println("IMAGENES PROCESADAS EXITOSAMENTE");
				Frame mainFrame = new Frame(args[1], args[0]);
			}
			else if (args[0].equals("-bd")) {
				System.out.println("CONVIRTIENDO IMAGENES...");
				name = args[1];
				imagenAclarada = new FileInputStream(args[1]);
				imagenOscura = new FileInputStream(args[1]);
				imageII2 = new DarkAndBright(name, imagenAclarada, imagenOscura);
				imageII2.aclarar();
				imageII2.oscurecer();
				System.out.println("IMAGENES PROCESADAS EXITOSAMENTE");
				Frame mainFrame = new Frame(args[1], args[0]);
			}
			else if (args[0].equals("-grayscale")) {
				System.out.println("CONVIRTIENDO IMAGENES...");
				name = args[1];
				imagenGris = new FileInputStream(args[1]);
				imagenAux6 = new FileInputStream(args[1]);
				imageIII = new Grayscale(name, imagenGris, imagenAux6);
				imageIII.escalaGris();
				System.out.println("IMAGENES PROCESADAS EXITOSAMENTE");
				Frame mainFrame = new Frame(args[1], args[0]);
			}
			else if (args[0].equals("-rle")) {
				System.out.println("CONVIRTIENDO IMAGENES...");
				name = args[1];
				imagenRLE = new FileInputStream(args[1]);
				imageIV = new RunLengthEncoding(name, imagenRLE);
				imageIV.rle();
				System.out.println("IMAGENES PROCESADAS EXITOSAMENTE");
				Frame mainFrame = new Frame(args[1], args[0]);
			}
			else if (args[0].equals("-all")) {
				System.out.println("CONVIRTIENDO IMAGENES...");
				name = args[1];
				imagenRed = new FileInputStream(args[1]);
				imagenGreen = new FileInputStream(args[1]);
				imagenBlue = new FileInputStream(args[1]);
				imagenRAVR = new FileInputStream(args[1]);
				imagenAux = new FileInputStream(args[1]);
				imagenRVAR = new FileInputStream(args[1]);
				imagenAux2 = new FileInputStream(args[1]);
				imageI = new Colors(name, imagenRed, imagenGreen, imagenBlue, imagenRAVR, imagenAux, imagenRVAR, imagenAux2);
				imageI.covertRed();
				imageI.covertGreen();
				imageI.covertBlue();
				imageI.corrimientoRAVR();
				imageI.corrimientoRVAR();
				imagenDeCabeza = new FileInputStream(args[1]);
				imagenAIzquierda = new FileInputStream(args[1]);
				imagenGiroRecto = new FileInputStream(args[1]);
				imagenAux3 = new FileInputStream(args[1]);
				imagenAux4 = new FileInputStream(args[1]);
				imagenAux5 = new FileInputStream(args[1]);
				imageII = new Rotates(name, imagenDeCabeza, imagenAIzquierda, imagenGiroRecto, imagenAux3, imagenAux4, imagenAux5);
				imageII.deCabeza();
				imageII.rigthTOleft();
				imageII.correrCuadro();
				imagenAclarada = new FileInputStream(args[1]);
				imagenOscura = new FileInputStream(args[1]);
				imageII2 = new DarkAndBright(name, imagenAclarada, imagenOscura);
				imageII2.aclarar();
				imageII2.oscurecer();
				imagenGris = new FileInputStream(args[1]);
				imageIII = new Grayscale(name, imagenGris, imagenAux6);
				imageIII.escalaGris();
				imagenRLE = new FileInputStream(args[1]);
				imageIV = new RunLengthEncoding(name, imagenRLE);
				imageIV.rle();
				System.out.println("IMAGENES PROCESADAS EXITOSAMENTE");
				Frame mainFrame = new Frame(args[1], args[0]);
			}
			else {
				System.out.println("INSTRUCCION INCORRECTA");
			}
	}
}

//CLASE PARA PARTE GRAFICA
class Frame implements ActionListener {
    JPanel panelGeneral;
    JPanel panelBotones;
    JButton btnOriginal;
    JButton btnColors1;
    JButton btnColors2;
    JButton btnColors3;
    JButton btnColors4;
    JButton btnColors5;
    JButton btnRotate1;
    JButton btnRotate2;
    JButton btnRotate3;
    JButton btnBD1;
    JButton btnBD2;
    JButton btnGrayScale;
    JButton btnRLE;
    JLabel lblImagen;
    File imageFile;
    Image image;
    ImageIcon imageIcon;
    String strFileName;

    public Frame(String strFileName,String strOption){
        this.strFileName = strFileName;

        panelGeneral = new JPanel(new GridLayout(1,2));
        panelBotones = new JPanel(new GridLayout(3,1));

        lblImagen = new JLabel();

        panelGeneral.add(panelBotones);
        panelGeneral.add(lblImagen);

        if (strOption.equals("-colors")) {
        	btnOriginal = new JButton("Imagen Original");
            btnColors1 = new JButton("Blue Tonality");
            btnColors2 = new JButton("Green Tonality");
            btnColors3 = new JButton("Red Tonality");
            btnColors4 = new JButton("Corrimiento RAV");
            btnColors5 = new JButton("Corrimiento RVA");
        	
        	btnOriginal.addActionListener(this);
            btnColors1.addActionListener(this);
            btnColors2.addActionListener(this);
            btnColors3.addActionListener(this);
            btnColors4.addActionListener(this);
            btnColors5.addActionListener(this);

            panelBotones.add(btnOriginal);
            panelBotones.add(btnColors1);
            panelBotones.add(btnColors2);
            panelBotones.add(btnColors3);
            panelBotones.add(btnColors4);
            panelBotones.add(btnColors5);
        }
        else if(strOption.equals("-rotate")) {
            btnOriginal = new JButton("Imagen Original");
            btnRotate1 = new JButton("Horizontal Rotation");
            btnRotate2 = new JButton("Vertical Rotation");
            btnRotate3 = new JButton("Divide");
    
            btnOriginal.addActionListener(this);
            btnRotate1.addActionListener(this);
            btnRotate2.addActionListener(this);
            btnRotate3.addActionListener(this);

            panelBotones.add(btnOriginal);
            panelBotones.add(btnRotate1);
            panelBotones.add(btnRotate2);
            panelBotones.add(btnRotate3);
        } 
        else if(strOption.equals("-bd")) {
            btnOriginal = new JButton("Imagen Original");
            btnBD1 = new JButton("Aclarado");
            btnBD2 = new JButton("Oscurecido");

            btnOriginal.addActionListener(this);
            btnBD1.addActionListener(this);
            btnBD2.addActionListener(this);

            panelBotones.add(btnOriginal);
            panelBotones.add(btnBD1);
            panelBotones.add(btnBD2);
        }
        else if (strOption.equals("-grayscale")) {
            btnOriginal = new JButton("Imagen Original");
            btnGrayScale = new JButton("Escala de Grises");

            btnOriginal.addActionListener(this);
            btnGrayScale.addActionListener(this);
            
            panelBotones.add(btnOriginal);
            panelBotones.add(btnGrayScale);
        }
        else if (strOption.equals("-rle")) {
            btnOriginal = new JButton("Imagen Original");
            btnRLE = new JButton("Run Length Encoding");
            
			btnOriginal.addActionListener(this);
            btnRLE.addActionListener(this);
            
			panelBotones.add(btnOriginal);
            panelBotones.add(btnRLE);
        }
        else if (strOption.equals("-all")) {
            btnOriginal = new JButton("Imagen Original");
            btnColors1 = new JButton("Blue Tonality");
            btnColors2 = new JButton("Green Tonality");
            btnColors3 = new JButton("Red Tonality");
            btnColors4 = new JButton("Corrimiento RAV");
            btnColors5 = new JButton("Corrimiento RVA");
            btnRotate1 = new JButton("Horizontal Rotation");
            btnRotate2 = new JButton("Vertical Rotation");
            btnRotate3 = new JButton("Divide");
            btnBD1 = new JButton("Aclarado");
            btnBD2 = new JButton("Oscurecido");
            btnGrayScale = new JButton("Escala de Grises");
            btnRLE = new JButton("Run Length Encoding");
        
            btnOriginal.addActionListener(this);
            btnColors1.addActionListener(this);
            btnColors2.addActionListener(this);
            btnColors3.addActionListener(this);
            btnColors4.addActionListener(this);
            btnColors5.addActionListener(this);
            btnRotate1.addActionListener(this);
            btnRotate2.addActionListener(this);
            btnRotate3.addActionListener(this);
            btnBD1.addActionListener(this);
            btnBD2.addActionListener(this);
            btnGrayScale.addActionListener(this);
            btnRLE.addActionListener(this);

            panelBotones.add(btnOriginal);
            panelBotones.add(btnColors1);
            panelBotones.add(btnColors2);
            panelBotones.add(btnColors3);
            panelBotones.add(btnColors4);
            panelBotones.add(btnColors5);
		    panelBotones.add(btnRotate1);
            panelBotones.add(btnRotate2);
            panelBotones.add(btnRotate3);
            panelBotones.add(btnBD1);
            panelBotones.add(btnBD2);
            panelBotones.add(btnGrayScale);
            panelBotones.add(btnRLE);
        }

        JFrame frame = new JFrame("Cargar Imagen");
        frame.setVisible(true);
        frame.setSize(1300,550);
        frame.setContentPane(panelGeneral);
    }

    public void actionPerformed(ActionEvent e) {
        try { 
        	if (e.getSource() == btnOriginal) {
        		imageFile = new File("./"+strFileName);
        		image = ImageIO.read(imageFile);
        		imageIcon = new ImageIcon(image);
        		lblImagen.setIcon(imageIcon);
        	} else if(e.getSource() == btnColors1) {
                imageFile = new File("./Blue"+strFileName+".bmp"); 
                image = ImageIO.read(imageFile);
                imageIcon = new ImageIcon(image);
                lblImagen.setIcon(imageIcon);
            } else if(e.getSource() == btnColors2) {
                imageFile = new File("./Green"+strFileName+".bmp"); 
                image = ImageIO.read(imageFile);
                imageIcon = new ImageIcon(image);
                lblImagen.setIcon(imageIcon);
            } else if(e.getSource() == btnColors3) {
                imageFile = new File("./Red"+strFileName+".bmp"); 
                image = ImageIO.read(imageFile);
                imageIcon = new ImageIcon(image);
                lblImagen.setIcon(imageIcon);
            } else if(e.getSource() == btnColors4) {
                imageFile = new File("./RAV"+strFileName+".bmp"); 
                image = ImageIO.read(imageFile);
                imageIcon = new ImageIcon(image);
                lblImagen.setIcon(imageIcon);
            } else if(e.getSource() == btnColors5) {
                imageFile = new File("./RVA"+strFileName+".bmp"); 
                image = ImageIO.read(imageFile);
                imageIcon = new ImageIcon(image);
                lblImagen.setIcon(imageIcon);
            } else if(e.getSource() == btnRotate1) {
                imageFile = new File("./HRotate"+strFileName+".bmp"); 
                image = ImageIO.read(imageFile);
                imageIcon = new ImageIcon(image);
                lblImagen.setIcon(imageIcon);
            } else if(e.getSource() == btnRotate2) {
                imageFile = new File("./VRotate"+strFileName+".bmp"); 
                image = ImageIO.read(imageFile);
                imageIcon = new ImageIcon(image);
                lblImagen.setIcon(imageIcon);
            } else if(e.getSource() == btnRotate3) {
                imageFile = new File("./Cross"+strFileName+".bmp"); 
                image = ImageIO.read(imageFile);
                imageIcon = new ImageIcon(image);
                lblImagen.setIcon(imageIcon);
            } else if(e.getSource() == btnBD1) {
                imageFile = new File("./Bright"+strFileName+".bmp"); 
                image = ImageIO.read(imageFile);
                imageIcon = new ImageIcon(image);
                lblImagen.setIcon(imageIcon);
            } else if(e.getSource() == btnBD2) {
                imageFile = new File("./Dark"+strFileName+".bmp"); 
                image = ImageIO.read(imageFile);
                imageIcon = new ImageIcon(image);
                lblImagen.setIcon(imageIcon);
            } else if(e.getSource() == btnGrayScale) {
                imageFile = new File("./Grays"+strFileName+".bmp");
                image = ImageIO.read(imageFile);
                imageIcon = new ImageIcon(image);
                lblImagen.setIcon(imageIcon);
            } else if (e.getSource() == btnRLE) {
                imageFile = new File("./RLE-"+strFileName+".bmp");
                image = ImageIO.read(imageFile);
                imageIcon = new ImageIcon(image);
                lblImagen.setIcon(imageIcon); 
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }
}