package conversao;

import java.nio.ByteBuffer;

public class BytePlus {
	
	public BytePlus(){};
	
	public byte[] shortToByteArray(short p){
		byte[] b = new byte[2];
		
		for(int i=0; i<b.length; i++)
		{
			int offset = (b.length -1 -i)*8;
			b[i] = (byte)((p >>> offset) & 0xFF);
		}
		return b;
	};
	
	public static byte[] intToByteArray(int p){
        byte[] b = new byte[4];
        
        for(int i =0; i<b.length; i++){
        	int offset = (b.length -1 -i)*8;
        	b[i] = (byte)((p >>> offset) & 0xFF);
        }
		return b;
	};
	
	void toFloatingPointer(Float f)
	{
		
	}
	
	void toFloatingPointer(Double d)
	{
		
	}

	public byte[] longToByteArray(long p){
		
		byte[] b = new byte[8];
		
		for(int i=0; i<b.length; i++){
			int offset = (b.length -1 -i)*8;
			b[i] = (byte)((p >>> offset) & 0xFF);
		}
		return b;
	};

	/*public static byte[] stringToByteArray(String p){
		byte[] b = p.getBytes();
		return b;
	};*/
	
	public static byte[] stringToByteArray(String original){
		/*char[] charArray = p.toCharArray();
		byte[] b = new byte[charArray.length << 1];
		
		for(int i=0; i<charArray.length; i++){
			
            int pos = i << 1;
            b[pos] = (byte)((charArray[i] & 0x00FF)>>8);
            b[pos+1] = (byte)(charArray[i] & 0x00FF);
		}
		
		return b;*/
		byte [] bytesStr = new byte[original.length()*2];
		bytesStr = original.getBytes();
		System.out.println("convertido de string p byte : " + bytesStr);
		return bytesStr;
	}
	

	public static byte charToByteArray(char p){
		byte b = (byte) p;
		
		return b;
	};
	
	public static byte[] booleanToByteArray(boolean p){
		byte[] b = new byte[]{(byte)(p?1:0)};
		return b;
	};
	
	public byte[] floatToByteArray(float p){
		 
		 byte[] b = new byte[4];
		    ByteBuffer.wrap(b).putFloat(p);
		    return b;
	};
	
	public byte[] doubleToByteArray(double p){
		 byte[] b = new byte[8];
		    ByteBuffer.wrap(b).putDouble(p);
		    return b;
	};
	
	
	public int byteArrayToInt(byte[] bArray){
		int value = 0;
		
		for(int i=0; i<4; i++){
			int shift = (4 -1 -i)*8;
			value += (bArray[i] & 0x000000FF) << shift;
			System.out.println(i + " " + (bArray[i] & 0x000000FF));
			System.out.println(i + " " + value);

		}
		
		return value;
	}
	
	public long byteArrayToLong(byte[] bArray){
		long value = 0;
		
		for(int i=0; i<8; i++){
			int shift = (8 -1 -i);
			value += (bArray[i] & 0x000000FF) << shift;
		}
		
		return value;
	}
	
	public short byteArrayToShort(byte[] bArray){
		short value = 0;
		
		for(int i=0; i<2; i++){
			int shift = (2 -1 -i);
			value += (bArray[i] & 0x000000FF) << shift;
		}
		
		return value;
	}
	
	/*public static String byteArrayToString(byte[] bArray){
		return  new String(bArray);
	}*/
	
	public static String byteArrayToString(byte[] bArray){
		char[] charArray = new char[bArray.length >> 1];
		
		for(int i = 0; i < charArray.length; i++){
			int pos = i << 1;
		 char c = (char)(((bArray[pos]&0x00FF)<<8)+(bArray[pos+1] & 0x00FF));
		 charArray[i] = c;
		}
		
		return  new String(bArray);
	}
	
	//public static String byteArrayToString(byte[] bArray)
	public static char byteArrayToChar(byte bArray){
		return (char)bArray;
	}
	
	public static boolean byteArrayToBoolean(byte[] bArray){
		
	   boolean value = bArray[0] != 0;
	   
	   return value;
	}
	
	public static float byteArrayToFloat(byte[] bArray){
		return ByteBuffer.wrap(bArray).getFloat();
	}
	
	public static double byteArrayToDouble(byte[] bArray){
		return ByteBuffer.wrap(bArray).getDouble();
	}
	
	/*public static void main(String[] args)
	{
       BytePlus seila = new BytePlus();
       int valor = 1000;
       
       byte[] conv = seila.intToByteArray(valor);
       System.out.println("int to byteArray = " + conv);
       
       int  desc = seila.byteArrayToInt(conv);
       
       System.out.println("byteArray to int = " + desc);
       
       long valor2 = 100;
       
       byte[] conv2 = seila.longToByteArray(valor2);
       System.out.println("long to byteArray = " + conv2);
       
       long  desc2 = seila.byteArrayToLong(conv2);
       
       System.out.println("byteArray to long = " + desc2);
       
       short valor3 = 10;
       
       byte[] conv3 = seila.shortToByteArray(valor3);
       System.out.println("short to byteArray = " + conv3);
       
       short  desc3 = seila.byteArrayToShort(conv3);
       
       System.out.println("byteArray to short = " + desc3);
       
       String word = "Muniz";
       byte[] conv4 = stringToByteArray(word);
       System.out.println("String to byteArray = " + conv4);
       
       String desc4 = byteArrayToString(conv4);
       System.out.println("byteArray to String = " + desc4);
       
       char car = 'c';
       byte conv5 = charToByteArray(car);
       System.out.println("char to byteArray = " + conv5);
       
       char desc5 = byteArrayToChar(conv5);
       System.out.println("byteArray to char = " + desc5);
       
       
       boolean isThat = false;
       byte[] conv6 = booleanToByteArray(isThat);
       System.out.println("boolean to byteArray = " + conv6);
       boolean desc6 = byteArrayToBoolean(conv6);
       System.out.println("byteArray to boolean = " + desc6);
       
       float valor4 = 45.5f;
       byte[] conv7 = seila.floatToByteArray(valor4);
       System.out.println("float to byteArray = " + conv7);
       
       float desc7 = byteArrayToFloat(conv7);
       System.out.println("byteArray to float = " + desc7);
       
       double valor5 = 95.5;
       byte[] conv8 = seila.doubleToByteArray(valor5);
       System.out.println("double to byteArray = " + conv8);
       
       double desc8 = byteArrayToDouble(conv8);
       System.out.println("byteArray to double = " + desc8);
       
	}*/

}
