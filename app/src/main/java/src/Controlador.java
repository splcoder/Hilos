package src;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

// Controlador para recibir mensajes del hilo
public class Controlador extends Handler {
	private TextView txt;

	public Controlador( TextView txt ){
		this.txt = txt;
	}

	@Override
	public void handleMessage(Message msg) {
		//super.handleMessage(msg);
		int total = msg.getData().getInt( Hilo.TOTAL );
		String thread = msg.getData().getString( Hilo.THREAD );
		txt.append( "\n" + total + " " + thread );
	}
}
