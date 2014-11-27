package fst;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fst.proto.Test.TestObject;

public class CrashTest {
	private FSTUtil fstUtil;

	@Before
	public void setUp() throws Exception {
		fstUtil = new FSTUtil();
	}

	@Test
	public void testWriteProtoObjectList() {
		final List<TestObject> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			final TestObject o = TestObject.newBuilder().setField1(i).setField2("test" + i).build();
			list.add(o);
		}
		final byte[] data = fstUtil.marshal(list);
		final List<TestObject> decoded = fstUtil.unmarshal(data, ArrayList.class);
		assertEquals(list, decoded);
	}

}
