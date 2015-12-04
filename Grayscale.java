import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Grayscale {
	String name;
	FileInputStream imgGris;
	FileInputStream imgAux6;
	FileOutputStream imagenS;

	public Grayscale(String nombre, FileInputStream imagenGris, FileInputStream imagenAux6) {
		name=nombre;
		imgGris = imagenGris;
		imgAux6 = imagenAux6;
	}

	public void escalaGris() throws Exception {
		byte[] arreglo = new byte[imgGris.available()];
		int[] aux = new int[arreglo.length];
		int[] aux3 = new int[640*480];
		double[] aux2 = new double[arreglo.length];
		double[] aux22 = new double[640*480];
		imagenS = new FileOutputStream("Grays"+name+".bmp");
		//HEADER
		for (int i=0; i<54; i++) {
			imgGris.read(arreglo);
			imagenS.write(arreglo[i]);
		}
		//PALETA DE COLORES
		for (int i=54; i<arreglo.length; i++) {
			aux[i]=(int)arreglo[i] & 0xff;
		}
		for (int i=54, a=0, b=1; i<1078; i++, b++) {
			aux[i]=a;
			if (b==4) {
				a++;
				b=0;
			}
		}
		for (int i=57; i<1078; i+=4) {
			aux[i]=0;
		}
		//ESCALA GRISES
		for (int i=1078; i<arreglo.length; i++) {
			aux2[i]=(double)aux[i];
		}
		for (int i=1078; i<arreglo.length; i+=3) {
			aux2[i]=aux2[i]*0.11;
		}
		for (int i=1079; i<arreglo.length; i+=3) {
			aux2[i]=aux2[i]*0.59;
		}
		for (int i=1080; i<arreglo.length; i+=3) {
			aux2[i]=aux2[i]*0.3;
		}
		for (int i=1078, j=0; i<aux22.length; i++, j++) {
			aux22[j]=(aux2[i]+aux2[i+1]+aux2[i+2]);
		}
		for (int i=0; i<aux22.length; i++) {
			aux3[i]=(int)aux22[i];
		}
		for (int i=54; i<1078; i++) {
			arreglo[i]=(byte)aux[i];
		}
		for (int i=1078, j=0; i<(640*480); i++, j++) {
			arreglo[i]=(byte)aux3[j];
		}
		for (int z=54; z<arreglo.length; z++) {
			imgGris.read(arreglo);
			imagenS.write(arreglo[z]);
		}
	}
}