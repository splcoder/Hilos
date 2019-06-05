package src;

import android.os.Bundle;
import android.os.Message;

public class Hilo extends Thread {
	public static final String TOTAL = "total";
	public static final String THREAD = "thread";
	int max;
	int time;
	Controlador handler;

	public Hilo( int max, int time, Controlador handler ){
		this.max = max < 0 ? -max : max;
		this.time = time;
		this.handler = handler;
	}

	@Override
	public void run(){
		for( int i = 0; i < max; i++ ){
			try {
				Thread.sleep( time );
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// Crear el mensaje para enviar al controlador
			Message msg = handler.obtainMessage();
			// Insert data in the msg
			Bundle bundle = new Bundle();
			bundle.putInt( TOTAL, i );
			bundle.putString( THREAD, currentThread().toString() );
			msg.setData( bundle );
			handler.sendMessage( msg );
		}
	}
}
