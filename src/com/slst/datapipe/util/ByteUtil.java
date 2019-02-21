package com.slst.datapipe.util;

import java.util.BitSet;
import java.util.LinkedList;

public class ByteUtil {
	public final static int BITS_PER_BYTE = 8;
	public final static int SIZEOF_BYTE = 1 * (Byte.SIZE / BITS_PER_BYTE);
	public final static int SIZEOF_WORD = 2 * (Byte.SIZE / BITS_PER_BYTE);
	public final static int SIZEOF_DWORD = 4 * (Byte.SIZE / BITS_PER_BYTE);

	/**
	 * 转换byte为byte
	 *
	 * @param b
	 * @param bt
	 *            需要转换的byte
	 * @param index
	 */
	public static void putByte(byte b[], byte bt, int index) {
		b[index + 0] = bt;
	}

	/**
	 * 转换byte为byte
	 *
	 * @param bt
	 *            需要转换的byte
	 */
	public static byte[] putByte(byte bt) {
		byte[] b = new byte[1];
		b[0] = bt;
		return b;
	}

	/**
	 * 通过byte数组取到byte
	 *
	 * @param b
	 * @param index
	 *            第几位开始取
	 * @return
	 */
	public static byte getByte(byte[] b, int index) {
		return b[index + 0];
	}

	/**
	 * 转换short为byte
	 *
	 * @param b
	 * @param s
	 *            需要转换的short
	 * @param index
	 */
	public static void putShort(byte b[], short s, int index) {
		b[index + 0] = (byte) (s >> 8);
		b[index + 1] = (byte) (s >> 0);
	}

	/**
	 * 转换short为byte
	 *
	 * @param s
	 *            需要转换的short
	 */
	public static byte[] putShort(short s) {

		byte[] b = new byte[2];

		b[1] = (byte) (s >> 8);
		b[0] = (byte) (s >> 0);

		return b;
	}

	/**
	 * 通过byte数组取到short
	 *
	 * @param b
	 * @param index
	 *            第几位开始取
	 * @return
	 */
	public static short getShort(byte[] b, int index) {
		return (short) (((b[index + 0] << 8) | b[index + 1] & 0xff));
	}

	/**
	 * 转换int为byte数组
	 *
	 * @param bb
	 * @param x
	 * @param index
	 */
	public static void putInt(byte[] bb, int x, int index) {
		bb[index + 3] = (byte) (x >> 24);
		bb[index + 2] = (byte) (x >> 16);
		bb[index + 1] = (byte) (x >> 8);
		bb[index + 0] = (byte) (x >> 0);
	}

	/**
	 * 转换int为byte数组
	 *
	 * @param x
	 */
	public static byte[] putInt(int x) {
		// byte[] b = new byte[4];

		// b[3] = (byte) (x >> 24);
		// b[2] = (byte) (x >> 16);
		// b[1] = (byte) (x >> 8);
		// b[0] = (byte) (x >> 0);

		byte[] b = new byte[2];

		b[0] = (byte) (x >> 8);
		b[1] = (byte) (x >> 0);

		return b;
	}

	public static byte[] putLong(long x) {
		byte[] b = new byte[4];

		b[0] = (byte) (x >> 24);
		b[1] = (byte) (x >> 16);
		b[2] = (byte) (x >> 8);
		b[3] = (byte) (x >> 0);

		return b;
	}

	/**
	 * 通过byte数组取到int
	 *
	 * @param bb
	 * @param index
	 *            第几位开始
	 * @return
	 */
	public static int getInt(byte[] bb, int index) {
		return ((((bb[index + 3] & 0xff) << 24) | ((bb[index + 2] & 0xff) << 16) | ((bb[index + 1] & 0xff) << 8) | ((bb[index + 0] & 0xff) << 0)));
	}

	/**
	 * 转换long型为byte数组
	 *
	 * @param bb
	 * @param x
	 * @param index
	 */
	public static void putLong(byte[] bb, long x, int index) {
		bb[index + 0] = (byte) (x >> 56);
		bb[index + 1] = (byte) (x >> 48);
		bb[index + 2] = (byte) (x >> 40);
		bb[index + 3] = (byte) (x >> 32);
		bb[index + 4] = (byte) (x >> 24);
		bb[index + 5] = (byte) (x >> 16);
		bb[index + 6] = (byte) (x >> 8);
		bb[index + 7] = (byte) (x >> 0);
	}

	/**
	 * 通过byte数组取到long
	 *
	 * @param bb
	 * @param index
	 * @return
	 */
	public static long getLong(byte[] bb, int index) {
		return ((((long) bb[index + 7] & 0xff) << 56) | (((long) bb[index + 6] & 0xff) << 48) | (((long) bb[index + 5] & 0xff) << 40) | (((long) bb[index + 4] & 0xff) << 32)
				| (((long) bb[index + 3] & 0xff) << 24) | (((long) bb[index + 2] & 0xff) << 16) | (((long) bb[index + 1] & 0xff) << 8) | (((long) bb[index + 0] & 0xff) << 0));
	}

	/**
	 * 字符到字节转换
	 *
	 * @param ch
	 * @return
	 */
	public static void putChar(byte[] bb, char ch, int index) {
		int temp = ch;
		// byte[] b = new byte[2];
		for (int i = 0; i < 2; i++) {
			bb[index + i] = new Integer(temp & 0xff).byteValue(); // 将最高位保存在最低位
			temp = temp >> 8; // 向右移8位
		}

	}

	/**
	 * 字节到字符转换
	 *
	 * @param b
	 * @return
	 */
	public static char getChar(byte[] b, int index) {
		int s = 0;
		if (b[index + 1] > 0)
			s += b[index + 1];
		else
			s += 256 + b[index + 0];
		s *= 256;
		if (b[index + 0] > 0)
			s += b[index + 1];
		else
			s += 256 + b[index + 0];
		char ch = (char) s;
		return ch;
	}

	/**
	 * float转换byte
	 *
	 * @param bb
	 * @param x
	 * @param index
	 */
	public static void putFloat(byte[] bb, float x, int index) {
		int l = Float.floatToIntBits(x);
		for (int i = 0; i < 4; i++) {
			bb[index + i] = new Integer(l).byteValue();
			l = l >> 8;
		}
	}

	public static byte[] putFloat(float x) {
		byte[] bb = new byte[4];
		int l = Float.floatToIntBits(x);
		for (int i = 0; i < 4; i++) {
			bb[i] = new Integer(l).byteValue();
			l = l >> 8;
		}

		return bb;
	}

	public static float getFloat(byte[] b, int index) {
		int l;
		l = b[index + 0];
		l &= 0xff;
		l |= ((long) b[index + 1] << 8);
		l &= 0xffff;
		l |= ((long) b[index + 2] << 16);
		l &= 0xffffff;
		l |= ((long) b[index + 3] << 24);
		return Float.intBitsToFloat(l);
	}

	/**
	 * double转换byte
	 *
	 * @param bb
	 * @param x
	 * @param index
	 */
	public static void putDouble(byte[] bb, double x, int index) {
		// byte[] b = new byte[8];
		long l = Double.doubleToLongBits(x);
		for (int i = 0; i < 4; i++) {
			bb[index + i] = new Long(l).byteValue();
			l = l >> 8;
		}
	}

	public static double getDouble(byte[] b, int index) {
		long l;
		l = b[0];
		l &= 0xff;
		l |= ((long) b[1] << 8);
		l &= 0xffff;
		l |= ((long) b[2] << 16);
		l &= 0xffffff;
		l |= ((long) b[3] << 24);
		l &= 0xffffffffl;
		l |= ((long) b[4] << 32);
		l &= 0xffffffffffl;
		l |= ((long) b[5] << 40);
		l &= 0xffffffffffffl;
		l |= ((long) b[6] << 48);
		l &= 0xffffffffffffffl;
		l |= ((long) b[7] << 56);
		return Double.longBitsToDouble(l);
	}

	/**
	 * 把byte转为字符串的bit
	 */
	public static String byteToBit(byte b) {
		return "" + (byte) ((b >> 7) & 0x1) + (byte) ((b >> 6) & 0x1) + (byte) ((b >> 5) & 0x1) + (byte) ((b >> 4) & 0x1) + (byte) ((b >> 3) & 0x1) + (byte) ((b >> 2) & 0x1)
				+ (byte) ((b >> 1) & 0x1) + (byte) ((b >> 0) & 0x1);
	}

	/**
	 * 把byte转为字符串的bit
	 */
	public static String byteToBit(byte[] byteArray) {
		String ret = "";
		int len = byteArray.length;
		if (len > 0) {
			for (int idx = 0; idx < len; ++idx) {
				byte b = byteArray[idx];
				ret += byteToBit(b);
			}
		}
		return ret;
	}

	/**
	 * 把bitSet转为byte数组
	 */
	public static byte[] bitSet2ByteArray(BitSet bitSet) {
		byte[] bytes = new byte[bitSet.size() / 8];
		for (int i = 0; i < bitSet.size(); i++) {
			int index = i / 8;
			int offset = 7 - i % 8;
			bytes[index] |= (bitSet.get(i) ? 1 : 0) << offset;
		}
		return bytes;
	}

	/**
	 * 把byte数组转为 bitSet
	 */
	public static BitSet byteArray2BitSet(byte[] bytes) {
		int bytes_Len = bytes.length;

		BitSet bitSet = new BitSet(bytes_Len * 8);
		// int bitSet_Len = bitSet.size();
		int index = 0;
		for (int i = 0; i < bytes.length; i++) {
			for (int j = 7; j >= 0; j--) {
				bitSet.set(index++, (bytes[i] & (1 << j)) >> j == 1 ? true : false);
			}
		}
		return bitSet;
	}

	/**
	 * @功能: BCD码转为10进制串(阿拉伯数据)
	 * @参数: BCD码
	 * @结果: 10进制串
	 */
	public static String bcd2Str(byte[] bytes) {
		StringBuffer temp = new StringBuffer(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			temp.append((byte) ((bytes[i] & 0xf0) >>> 4));
			temp.append((byte) (bytes[i] & 0x0f));
		}
		return temp.toString().substring(0, 1).equalsIgnoreCase("0") ? temp.toString().substring(1) : temp.toString();
	}

	/**
	 * @功能: 10进制串转为BCD码
	 * @参数: 10进制串
	 * @结果: BCD码
	 */
	public static byte[] str2Bcd(String asc) {
		if (null != asc && asc.length() > 0) {
			int len = asc.length();
			int mod = len % 2;

			if (mod != 0) {
				asc = "0" + asc;
				len = asc.length();
			}

			byte abt[] = new byte[len];

			if (len >= 2) {
				len = len / 2;
			}

			byte bbt[] = new byte[len];
			abt = asc.getBytes();
			int j, k;

			for (int p = 0; p < asc.length() / 2; p++) {
				if ((abt[2 * p] >= '0') && (abt[2 * p] <= '9')) {
					j = abt[2 * p] - '0';
				} else if ((abt[2 * p] >= 'a') && (abt[2 * p] <= 'z')) {
					j = abt[2 * p] - 'a' + 0x0a;
				} else {
					j = abt[2 * p] - 'A' + 0x0a;
				}

				if ((abt[2 * p + 1] >= '0') && (abt[2 * p + 1] <= '9')) {
					k = abt[2 * p + 1] - '0';
				} else if ((abt[2 * p + 1] >= 'a') && (abt[2 * p + 1] <= 'z')) {
					k = abt[2 * p + 1] - 'a' + 0x0a;
				} else {
					k = abt[2 * p + 1] - 'A' + 0x0a;
				}

				int a = (j << 4) + k;
				byte b = (byte) a;
				bbt[p] = b;
			}

			return bbt;
		} else {
			return null;
		}
	}

	@SuppressWarnings("null")
	public static void bytesZero(byte[] buf) {
		if (null == buf && 0 == buf.length)
			throw new IndexOutOfBoundsException();

		for (int idx = 0; idx < buf.length; ++idx) {
			buf[idx] = 0x00;
		}

	}

	@SuppressWarnings("null")
	public static byte[] setBitValue(byte[] buf, int pos, boolean bitValue) {
		if (null == buf && 0 == buf.length)
			throw new IndexOutOfBoundsException();
		int bitLength = buf.length * 8;
		if (pos < 0 && pos >= bitLength)
			throw new IndexOutOfBoundsException();

		int a1 = pos / 8;
		int a2 = pos - a1 * 8;

		if (true == bitValue) {
			// 设置为1
			buf[a1] = (byte) (buf[a1] | (1 << a2));
		} else {
			// 设置为0
			buf[a1] = (byte) (buf[a1] & ~(1 << a2));
		}
		return buf;
	}

	@SuppressWarnings("null")
	public static boolean getBitValue(byte[] buf, int pos) {
		if (null == buf && 0 == buf.length)
			throw new IndexOutOfBoundsException();
		int bitLength = buf.length * 8;
		if (pos < 0 && pos >= bitLength)
			throw new IndexOutOfBoundsException();

		int a1 = pos / 8;
		int a2 = pos - a1 * 8;
		return (buf[a1] >> a2 & 1) == 1;

	}

	@SuppressWarnings("null")
	public static byte[] WORD_Reverse(byte[] bytes) {
		if (null == bytes && bytes.length != 2)
			throw new IndexOutOfBoundsException();

		byte[] newbuf = new byte[2];
		newbuf[0] = bytes[1];
		newbuf[1] = bytes[0];

		return newbuf;

	}

	@SuppressWarnings("null")
	public static byte[] DWORD_Reverse(byte[] bytes) {
		if (null == bytes && bytes.length != 4)
			throw new IndexOutOfBoundsException();

		byte[] newbuf = new byte[4];
		newbuf[0] = bytes[3];
		newbuf[1] = bytes[2];
		newbuf[2] = bytes[1];
		newbuf[3] = bytes[0];

		return newbuf;

	}

	/**
	 * print HexString
	 * 
	 * @param b
	 */
	public static String printHexString(byte[] b) {
		String res = "";
		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			res += (hex.toUpperCase() + " ");
		}
		return res;
	}

	/**
	 * bytes to HexString
	 * 
	 * @param b
	 */
	public static String toHexString(byte[] b) {
		String s = "";
		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			s += hex.toUpperCase();
		}
		return s;
	}

	/**
	 * 计算校验和
	 * 
	 * @param datas
	 * @param endoffset
	 * @return checksum
	 */
	public static short byteSumCheck(byte[] datas, int endoffset) {
		short temp = datas[2];
		for (int i = 3; i < datas.length - endoffset; i++) {
			temp += (datas[i] & 0xFF);
			// ByteUtil.printHexString(new byte[] { datas[i] });
		}
		return temp;
	}

	/**
	 * 合并两个byte数组
	 * 
	 * @param byte_1
	 * @param byte_2
	 * @return
	 */
	public static byte[] byteMerger(byte[] byte_1, byte[] byte_2) {
		byte[] results = new byte[byte_1.length + byte_2.length];
		System.arraycopy(byte_1, 0, results, 0, byte_1.length);
		System.arraycopy(byte_2, 0, results, byte_1.length, byte_2.length);
		// bytesZero(byte_1);
		// bytesZero(byte_2);
		return results;
	}

	/**
	 * 发送前byte[]转义
	 * 
	 * @param bs
	 * @return
	 */
	public static byte[] byteEncode(byte[] bs) {
		LinkedList<Byte> listA = new LinkedList<Byte>();
		byte[] temp = new byte[bs.length];
		for (int i = 1; i < bs.length - 1; i++) {// 去除首尾标识位
			temp[i - 1] = bs[i];
		}
		for (int i = 0; i < temp.length; i++) {// 使用LIST辅助操作
			listA.add(temp[i]);
		}
		listA.pollLast();
		listA.pollLast();
		int pos = 0;
		for (int i = 0; i < temp.length; i++) {// 追加
			if (temp[i] == 0x7e) {
				listA.add(i + 1 + pos++, new Byte((byte) 0x02));
			} else if (temp[i] == 0x7d) {
				listA.add(i + 1 + pos++, new Byte((byte) 0x01));
			}
		}

		LinkedList<Byte> listB = new LinkedList<Byte>();
		for (Byte a : listA) {// 替换
			if (a.byteValue() == 0x7e) {
				listB.add(new Byte((byte) 0x7d));
			} else {
				listB.add(a);
			}
		}
		listA.clear();
		listB.addFirst(new Byte((byte) 0x7e));// 添加首标识位
		listB.addLast(new Byte((byte) 0x7e));// 添加尾标识位

		byte[] results = new byte[listB.size()];
		for (int i = 0; i < results.length; i++) {// 转成byte[]
			results[i] = listB.get(i);
		}
		listB.clear();
		bytesZero(temp);
		return results;
	}

	/**
	 * 接收后byte[]转义
	 * 
	 * @param bs
	 * @return
	 */
	public static byte[] byteDecode(byte[] bs) {
		LinkedList<Byte> listA = new LinkedList<Byte>();
		for (int i = 0; i < bs.length; i++) {// 查找
			if (bs[i] == 0x7d) {
				if (bs[i + 1] == 0x01) {
					listA.add(new Byte((byte) 0x7d));
				} else if (bs[i + 1] == 0x02) {
					listA.add(new Byte((byte) 0x7e));
				}
				i++;
			} else {
				listA.add(bs[i]);
			}
		}
		byte[] results = new byte[listA.size()];
		for (int i = 0; i < results.length; i++) {// 转成byte[]
			results[i] = listA.get(i).byteValue();
		}
		listA.clear();
		return results;
	}

	/**
	 * 将byte转换为一个长度为8的byte数组，数组每个值代表bit
	 */
	public static byte[] getBooleanArray(byte b) {
		byte[] array = new byte[8];
		for (int i = 7; i >= 0; i--) {
			array[i] = (byte) (b & 1);
			b = (byte) (b >> 1);
		}
		return array;
	}

	/**
	 * 二进制字符串转byte
	 */
	public static byte decodeBinaryString(String byteStr) {
		int re, len;
		if (null == byteStr) {
			return 0;
		}
		len = byteStr.length();
		if (len != 4 && len != 8) {
			return 0;
		}
		if (len == 8) {// 8 bit处理
			if (byteStr.charAt(0) == '0') {// 正数
				re = Integer.parseInt(byteStr, 2);
			} else {// 负数
				re = Integer.parseInt(byteStr, 2) - 256;
			}
		} else {// 4 bit处理
			re = Integer.parseInt(byteStr, 2);
		}
		return (byte) re;
	}

}