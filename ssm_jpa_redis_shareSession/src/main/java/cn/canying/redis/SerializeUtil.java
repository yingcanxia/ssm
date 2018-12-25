package cn.canying.redis;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
 
public class SerializeUtil {
    /**
     *
     * ���л�
     */
    public static byte[] serialize(Object obj) {
 
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
 
        try {
            // ���л�
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
 
            oos.writeObject(obj);
            byte[] byteArray = baos.toByteArray();
            return byteArray;
 
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
 
    /**
     *
     * �����л�
     *
     * @param bytes
     * @return
     */
    public static Object unSerialize(byte[] bytes) {
 
        ByteArrayInputStream bais = null;
 
        try {
            // �����л�Ϊ����
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
