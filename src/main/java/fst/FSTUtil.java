package fst;

import java.io.IOException;
import java.io.OutputStream;

import org.nustaq.serialization.FSTConfiguration;
import org.nustaq.serialization.FSTObjectOutput;

public class FSTUtil {

	private FSTConfiguration conf = FSTConfiguration.createDefaultConfiguration();

	public void writeObject(final OutputStream stream, final Object obj) {
		try {
			final FSTObjectOutput out = conf.getObjectOutput(stream);
			out.writeObject(obj);
			out.flush();
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public byte[] marshal(final Object obj) {
		try {
			final FSTObjectOutput out = conf.getObjectOutput();
			out.writeObject(obj);
			return out.getCopyOfWrittenBuffer();
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T> T unmarshal(final byte[] data, final Class<T> cls) {
		try {
			return (T) conf.getObjectInput(data).readObject(cls);
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}
}
