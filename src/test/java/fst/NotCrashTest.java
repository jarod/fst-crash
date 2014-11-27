package fst;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import fst.proto.Test.TestObject;

public class NotCrashTest {
	private FSTUtil fstUtil;

	@Before
	public void setUp() throws Exception {
		fstUtil = new FSTUtil();
	}

	@Test
	public void testWriteProtoObject() {
		final TestObject o = TestObject.newBuilder().setField1(1).setField2("test").build();
		final byte[] data = fstUtil.marshal(o);
		final TestObject decoded = fstUtil.unmarshal(data, TestObject.class);
		assertEquals(o, decoded);
	}

	@Test
	public void testWriteMapList() {
		final List<Map<String, Object>> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			final Map<String, Object> o = new HashMap<>();
			o.put("field1", i);
			o.put("field2", "hello" + i);
			list.add(o);
		}
		final byte[] data = fstUtil.marshal(list);
		final List<TestObject> decoded = fstUtil.unmarshal(data, ArrayList.class);
		assertEquals(list, decoded);
	}

}
