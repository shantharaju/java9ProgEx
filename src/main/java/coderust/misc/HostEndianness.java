package coderust.misc;

import java.nio.ByteOrder;

public class HostEndianness {

	/*
	 * int x = 0x01020304;
	 * 
	 * littleEndian = 01020304	// least significant bit at the end
	 * bigEndian =    04030201
	 */
	public static boolean isBigendian() {
		return ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
	}

	public static void main(String[] args) {
		System.out.println(isBigendian());

	}

}
