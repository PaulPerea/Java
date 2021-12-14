package validaciones;

import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class ClsValidacionesCliente {

	public void ValidarNombres(JTextField texto, KeyEvent evento) {
		if(!texto.getText().matches("[aA-zZ,Ò—,·¡,È…,ÌÕ,Û”,˙⁄,\\s]*")) { //el []* el asterisco es para el relleno, te deja escribir mas de 1 digito
			texto.setText("");
		}
		convertirMayusc(texto);
	}
	public void ValidarApellidos(JTextField texto, KeyEvent evento) {
		if(!texto.getText().matches("[aA-zZ,Ò—,·¡,È…,ÌÕ,Û”,˙⁄,\\s]*")) { //el []* el asterisco es para el relleno, te deja escribir mas de 1 digito
			texto.setText("");
		}
		convertirMayusc(texto);
	}
	public void ValidarDNI(JTextField texto, KeyEvent evento) { // keyEvent es para el evento de pulsar teclas
		//uso de consume
		if(texto.getText().length()==8) { //Si es mas de 8 digitos hacer esta accion
			evento.consume(); //el evento consume hace que suprima el texto que esta
		}
		char c=evento .getKeyChar(); //atrapa la informacion osea atrapa cada tecla que le colocas
		
		if (c<'0' || c >'9') {
			evento.consume();
		}
	}
	public void validaEdad(JTextField texto, KeyEvent evento) {
		//uso de consume
				if(texto.getText().length()==3) { //Si es mas de 5 digitos hacer esta accion
					evento.consume(); //el evento consume hace que suprima el texto que esta
				}
				char c=evento .getKeyChar(); //atrapa la informacion osea atrapa cada tecla que le colocas
				
				if (c<'0' || c >'9') {
					evento.consume();
				}
	}
	public void ValidarCodigo(JTextField texto, KeyEvent evento) { // keyEvent es para el evento de pulsar teclas
			if(!texto.getText().matches("[aA-zZ,Ò—,·¡,È…,ÌÕ,Û”,˙⁄,0-9,\\s]*")) { //el []* el asterisco es para el relleno, te deja escribir mas de 1 digito
				texto.setText("");
			}
			if(texto.getText().length()==4) { //Si es mas de 5 digitos hacer esta accion
				evento.consume(); //el evento consume hace que suprima el texto que esta
			}
			convertirMayusc(texto);
		}
	
	

	private void convertirMayusc(JTextField texto) {
		String cadena=texto.getText().toUpperCase(); //convierte la min a muyus
		texto.setText(cadena);
	}
	
	
}
