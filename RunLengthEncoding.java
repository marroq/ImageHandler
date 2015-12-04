import java.io.FileInputStream;
import java.io.FileOutputStream;

public class RunLengthEncoding {
	String name;
	FileInputStream imgRLE;
	FileOutputStream imagenS;

	public RunLengthEncoding(String nombre, FileInputStream imagenRLE) {
		name= nombre;
		imgRLE = imagenRLE;
	}

	public void rle() throws Exception {
		byte[] arreglo = new byte[imgRLE.available()];
		imagenS = new FileOutputStream("RLE-"+name+".bmp");

		for (int z=0; z<arreglo.length; z++) {
			imgRLE.read(arreglo);
			imagenS.write(arreglo[z]);
		}
	}
}
/*
int linea = 1920;
int inicio = 54;
int fin = 1973;
int i = 0;

while (i<480){
	for (int r=0, m=inicio, n=fin; r<1920; r++, m++, n--){
	vrotate[m] = extra[n];
	}
	inicio= fin + 1;
	fin = fin + linea;
	i++;
	}*/