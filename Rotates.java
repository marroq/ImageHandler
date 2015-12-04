import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Rotates {
	String name;
	FileInputStream imgDeCabeza;
	FileInputStream imgRtL;
	FileInputStream imgGRecto;
	FileInputStream imgAux3;
	FileInputStream imgAux4;
	FileInputStream imgAux5;
	FileOutputStream imagenS;

	public Rotates(String nombre, FileInputStream imagenDeCabeza, FileInputStream imagenDerToIz, FileInputStream imagenGirar90, FileInputStream imagenAux3, FileInputStream imagenAux4, FileInputStream imagenAux5) {
		name = nombre;
		imgDeCabeza = imagenDeCabeza;
		imgRtL = imagenDerToIz;
		imgGRecto = imagenGirar90;
		imgAux3 = imagenAux3;
		imgAux4 = imagenAux4;
		imgAux5 = imagenAux5;
	}

	public void deCabeza() throws Exception {
		byte[] arreglo = new byte[imgDeCabeza.available()];
		byte[] aux = new byte[imgAux3.available()];
		imagenS = new FileOutputStream("HRotate"+name+".bmp");
		for (int i=0; i<54; i++) {
			imgDeCabeza.read(arreglo);
			imgAux3.read(aux);
			imagenS.write(arreglo[i]);
		}

		for (int j=54, h=(aux.length-1922), a=0; j<(arreglo.length-1922); j++, a++, h++) {
			arreglo[j]=aux[h];
			if (a==1920) {
				h-=3840;
				a=0;
			}
		}

		for (int z=54; z<arreglo.length; z++) {
			imgDeCabeza.read(arreglo);
			imagenS.write(arreglo[z]);
		}
	}

	public void rigthTOleft() throws Exception {
		byte[] arreglo = new byte[imgRtL.available()];
		byte[] aux = new byte[imgAux4.available()];
		imagenS = new FileOutputStream("VRotate"+name+".bmp");
		for (int i=0; i<54; i++) {
			imgRtL.read(arreglo);
			imgAux4.read(aux);
			imagenS.write(arreglo[i]);
		}

		for (int j=54, h=1971, a=0, b=0; j<(arreglo.length-1971); j++, a++, h++, b++) {
			arreglo[j]=aux[h];
			if (a==3) {
				h-=6;
				a=0;
			}
			if (b==1920) {
				h+=3840;
				b=0;
			}
		}

		for (int z=54; z<arreglo.length; z++) {
			imgRtL.read(arreglo);
			imagenS.write(arreglo[z]);
		}
	}

	public void correrCuadro() throws Exception {
		byte[] arreglo = new byte[imgGRecto.available()];
		byte[] aux = new byte[imgAux5.available()];
		imagenS = new FileOutputStream("Cross"+name+".bmp");
		for (int i=0; i<54; i++) {
			imgGRecto.read(arreglo);
			imgAux5.read(aux);
			imagenS.write(arreglo[i]);
		}
		//PARTE IZQUIERDA INFERIOR
		for (int j=54, h=1014, a=0; j<460854; j++, a++, h++) {
			arreglo[j]=aux[h];
			if(a==960) {
				j+=960;
				h+=960;
				a=0;
			}
		}
		//PARTE INFERIOR DERECHA
		for (int j=1014, h=461814, a=0; j<460854; j++, a++, h++) {
			arreglo[j]=aux[h];
			if(a==960) {
				j+=960;
				h+=960;
				a=0;
			}
		}
		//PARTE SUPERIOR IZQUIERDA
		for (int j=460854, h=54, a=0; j<arreglo.length; j++, a++, h++) {
			arreglo[j]=aux[h];
			if(a==960) {
				j+=960;
				h+=960;
				a=0;
			}
		}
		// PARTE SUPERIOR DERECHA
		for (int j=461814, h=460854, a=0; j<arreglo.length; j++, a++, h++) {
			arreglo[j]=aux[h];
			if(a==960) {
				j+=960;
				h+=960;
				a=0;
			}
		}
		for (int z=54; z<arreglo.length; z++) {
			imgGRecto.read(arreglo);
			imagenS.write(arreglo[z]);
		}
	}
}