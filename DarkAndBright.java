import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DarkAndBright {
	String name;
	FileInputStream imgAclarar;
	FileInputStream imgOscurecer;
	FileOutputStream imagenS;

	public DarkAndBright(String nombre, FileInputStream imagenAclarar, FileInputStream imagenOscurecer) {
		name=nombre;
		imgAclarar = imagenAclarar;
		imgOscurecer = imagenOscurecer;
	}
	
	public void aclarar() throws Exception {
		byte[] arreglo = new byte[imgAclarar.available()];
		int [] aux = new int[arreglo.length];
		double[] aux2 = new double[arreglo.length];
		imagenS = new FileOutputStream("Bright"+name+".bmp");
		for (int i=0; i<54; i++) {
			imgAclarar.read(arreglo);
			imagenS.write(arreglo[i]);
		}

		for (int i=54; i<arreglo.length; i++) {
			aux[i]=(int)arreglo[i] & 0xff;
		}

		for (int i=54; i<arreglo.length; i++) {
			aux2[i]=(double)aux[i];
		}
		
		for (int i=54; i<arreglo.length; i++) {
			aux2[i]=aux2[i]+(aux2[i]*0.5);
		}

		for (int i=54; i<arreglo.length; i++) {
			aux[i]=(int)aux2[i];
			if (aux[i]>255)
				aux[i]=255;
			else if (aux[i]<0)
				aux[i]=0;
		}

		for (int i=54; i<arreglo.length; i++) {
			arreglo[i]=(byte)aux[i];
		}
		
		for (int z=54; z<arreglo.length; z++) {
			imgAclarar.read(arreglo);
			imagenS.write(arreglo[z]);
		}
	}

	public void oscurecer() throws Exception {
		byte[] arreglo = new byte[imgOscurecer.available()];
		int [] aux = new int[arreglo.length];
		double[] aux2 = new double[arreglo.length];
		imagenS = new FileOutputStream("Dark"+name+".bmp");
		for (int i=0; i<54; i++) {
			imgOscurecer.read(arreglo);
			imagenS.write(arreglo[i]);
		}

		for (int i=54; i<arreglo.length; i++) {
			aux[i]=(int)arreglo[i] & 0xff;
		}

		for (int i=54; i<arreglo.length; i++) {
			aux2[i]=(double)aux[i];
		}

		for (int i=54; i<arreglo.length; i++) {
			aux2[i]=aux2[i]-(aux2[i]*0.5);
		}

		for (int i=54; i<arreglo.length; i++) {
			aux[i]=(int)aux2[i];
			if (aux[i]>255)
				aux[i]=255;
			else if (aux[i]<0)
				aux[i]=0;
		}

		for (int i=54; i<arreglo.length; i++) {
			arreglo[i]=(byte)aux[i];
		}
		
		for (int z=54; z<arreglo.length; z++) {
			imgOscurecer.read(arreglo);
			imagenS.write(arreglo[z]);
		}
	}
}