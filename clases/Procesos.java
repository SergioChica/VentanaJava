package clases;

public class Procesos {

	public Procesos() {
		
	}

	public double calcularIMC(double n1, double n2) {
		
		double imc=-1;
		if (validacion(n1,n2) == true){
			
			double altura = n2 / 100.0;
			double imcDouble = (int) n1 / (altura * altura);
			imc = (int) imcDouble;
		}
		
		return imc;
	}
	
	public boolean validacion(double n1, double n2) {
		
		if (n1 >= 0 && n2 >= 0) {
			return true;
		}
		return false;
	}
}
