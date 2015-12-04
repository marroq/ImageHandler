import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Colors {
	String name;
	FileInputStream imgR;
	FileInputStream imgG;
	FileInputStream imgB;
	FileInputStream imgRAVR;
	FileInputStream imgAux;
	FileInputStream imgRVAR;
	FileInputStream imgAux2;
	FileOutputStream archivoC;

	public Colors(String nombre, FileInputStream imagenR, FileInputStream imagenG, FileInputStream imagenB, FileInputStream imagenRAVR, FileInputStream imagenAux, FileInputStream imagenRVAR, FileInputStream imagenAux2) {
		name = nombre;
		imgR = imagenR;
		imgG = imagenG;
		imgB = imagenB;
		imgRAVR = imagenRAVR;
		imgAux = imagenAux;
		imgRVAR = imagenRVAR;
		imgAux2 = imagenAux2;
	}

	public void covertRed() throws Exception {
		byte[] arreglo = new byte[imgR.available()];
		archivoC = new FileOutputStream("Red"+name+".bmp");
		for (int i=0; i<54; i++) {
			imgR.read(arreglo);
			archivoC.write(arreglo[i]);
		}
		for (int j=54; j<arreglo.length; j+=3) {
			arreglo[j]=0;
		}
		for (int z=55; z<arreglo.length; z+=3) {
			arreglo[z]=0;
		}
		for (int y=54; y<arreglo.length; y++) {
			imgR.read(arreglo);
			archivoC.write(arreglo[y]);
		}
	}

	public void covertGreen() throws Exception {
		byte[] arreglo = new byte[imgG.available()];
		archivoC = new FileOutputStream("Green"+name+".bmp");
		for (int i=0; i<54; i++) {
			imgG.read(arreglo);
			archivoC.write(arreglo[i]);
		}
		for (int j=54; j<arreglo.length; j+=3) {
			arreglo[j]=0;
		}
		for (int z=56; z<arreglo.length; z+=3) {
			arreglo[z]=0;
		}
		for (int y=54; y<arreglo.length; y++) {
			imgG.read(arreglo);
			archivoC.write(arreglo[y]);
		}
	}

	public void covertBlue() throws Exception {
		byte[] arreglo = new byte[imgB.available()];
		archivoC = new FileOutputStream("Blue"+name+".bmp");
		for (int i=0; i<54; i++) {
			imgB.read(arreglo);
			archivoC.write(arreglo[i]);
		}
		for (int j=55; j<arreglo.length; j+=3) {
			arreglo[j]=0;
		}
		for (int z=56; z<arreglo.length; z+=3) {
			arreglo[z]=0;
		}
		for (int y=54; y<arreglo.length; y++) {
			imgB.read(arreglo);
			archivoC.write(arreglo[y]);
		}
	}

	public void corrimientoRAVR() throws Exception {
		byte[] arreglo = new byte[imgRAVR.available()];
		byte[] aux = new byte[imgAux.available()];
		archivoC = new FileOutputStream("RAV"+name+".bmp");
		for (int i=0; i<54; i++) {
			imgRAVR.read(arreglo);
			imgAux.read(aux);
			archivoC.write(arreglo[i]);
		}
		for (int j=54, k=56; k<aux.length; j+=3, k+=3) {
			arreglo[k]=aux[j];
		}
		for (int z=55, a=54; a<aux.length; z+=3, a+=3) {
			arreglo[a]=aux[z];
		}
		for (int l=56, m=55; l<aux.length; l+=3, m+=3) {
			arreglo[m]=aux[l];
		}
		for (int y=54; y<arreglo.length; y++) {
			imgRAVR.read(arreglo);
			archivoC.write(arreglo[y]);
		}		
	}

	public void corrimientoRVAR() throws Exception {
		byte[] arreglo = new byte[imgRVAR.available()];
		byte[] aux = new byte[imgAux2.available()];
		archivoC = new FileOutputStream("RVA"+name+".bmp");
		for (int i=0; i<54; i++) {
			imgRVAR.read(arreglo);
			imgAux2.read(aux);
			archivoC.write(arreglo[i]);
		}
		for (int j=55, k=56; k<aux.length; j+=3, k+=3) {
			arreglo[k]=aux[j];
		}
		for (int z=54, a=55; a<aux.length; z+=3, a+=3) {
			arreglo[a]=aux[z];
		}
		for (int l=56, m=54; l<aux.length; l+=3, m+=3) {
			arreglo[m]=aux[l];
		}
		for (int y=54; y<arreglo.length; y++) {
			imgRAVR.read(arreglo);
			archivoC.write(arreglo[y]);
		}
	}
}