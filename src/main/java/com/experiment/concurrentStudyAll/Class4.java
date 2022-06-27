package com.experiment.concurrentStudyAll;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wuruohong
 * @date 2022-06-20 16:36
 */
public class Class4 {

    public static void main1(String[] args) {
        CommonObject commonObject = new CommonObject(1,2,3,4);
        int defaultInt1 = commonObject.defaultInt;
        int protectedInt = commonObject.protectedInt;
        int publicInt = commonObject.publicInt;

        CommonSonObject commonSonObject = new CommonSonObject(1,2,3,4);
        int defaultInt = commonSonObject.defaultInt;

        // ArrayList

        HashFunction function = Hashing.murmur3_32_fixed();
        System.out.println(function.hashBytes("abcdefg".getBytes()).asInt());

        Integer i = 1;
        System.out.println("i.hashCode() = " + i.hashCode());
        Integer j = 1234567890;
        System.out.println("j.hashCode() = " + j.hashCode());

        String a = "a";
        System.out.println("a.hashCode() = " + a.hashCode());
        String b = "b";
        System.out.println("b.hashCode() = " + b.hashCode());
        String c = "ab";
        System.out.println("c.hashCode() = " + c.hashCode());
        System.out.println(31 * 97 + 98);

        String d = "abc";
        System.out.println("d.hashCode() = " + d.hashCode());
        System.out.println(31 * (31 * 97 + 98) + 99);

        String e = "abcdefghijklmnopgqrjdksdljfjdslfja;sdkfjasldjfalsd;jfaskldjfa;sdkfjka;sdfjkffjasldjfalsd;jfaskldjfa;sdkfjka;sdfjkfjdslfja;sdkfjasldjfalsd;jfaskldjfa;sdkfjka;f1234jasldjfalsd;jfaskldjfa;sdkfjka;sdfjkfjdslfja;sdkfjasldjfalsd;jfaskldjfa;sdkfjka;fjasldjfalsd;jfaskldjfa;sdkfjka;sdfjkfjdslfja;sdkfjasldjfalsd;jfaskldjfa;sdkfjka;jdslfja;sdkfjasldjfalsd;jfaskldjfa;sdkfjka;sdfjkalsdfjkajlsdfja;sdfjkaslfjdslfja;sdkfjasldjfalsd;jfaskldjfa;sdkfjka;sdfjkalsdfjkajlsdfja;sdfjkaslfjdslfja;sdkfjasldjfalsd;jfaskldjfa;sdkfjka;sdfjkalsdfjkajlsdfja;sdfjkaslfjdslfja;sdkfjasldjfalsd;jfaskldjfa;sdkfjka;sdfjkalsdfjkajlsdfja;sdfjkaslfjdslfja;sdkfjasldjfalsd;jfaskldjfa;sdkfjka;sdfjkalsdfjkajlsdfja;sdfjkaslfjdslfja;sdkfjasldjfalsd;jfaskldjfa;sdkfjka;sdfjkalsdfjkajlsdfja;sdfjkaslalsdfjkajlsdfja;sdfjkasldfjalksdfjsadl;fjasd";
        System.out.println("e.hashCode() = " + e.hashCode());

        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("a","b");
        String as = new String("abc");
        String bs = as.intern();
        System.out.println("as == bs = " + (as == bs));
        as = "java1";
        bs = as.intern();
        System.out.println("as == bs = " + (as == bs));

        /**  单例双重检查锁的第二层是为了效率*/

        int a1=5;
        int b1=11;
        int c1=14;
        a1 = b1 =c1= 2;
        System.out.println("a1 = " + a1);
        System.out.println("b1 = " + b1);
        System.out.println("c1 = " + c1);

        int n = 14;
        int m = n -(n>>>2);
        System.out.println("m = " + m);
    }

    public static void main2(String[] args) {

        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("a","b");
        Map<String, String> map1 = new HashMap<>(3);
        map1.put("a","b");
        map1.get("a");

        int initialCapacity = 8;
        int i = initialCapacity + (initialCapacity >>> 1) + 1;
        System.out.println("i = " + i);
        System.out.println("tableSizeFor(i) = " + tableSizeFor(i));

        Hashtable<String, String> hashtable = new Hashtable();
    }
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    private static final int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public static void main3(String[] args) {
        int i = -1;
        int j = i>>1;
        int m = i >>>1;
        System.out.println("j = " + j);
        System.out.println("m = " + m);
    }

    public static void main(String[] args) {
        System.out.println("highestOneBit(5) = " + highestOneBit(5));
        System.out.println("lowestOneBit(1) = " + lowestOneBit(8));
        System.out.println("numberOfLeadingZeros(4) = " + numberOfLeadingZeros(4));
        System.out.println("numberOfLeadingZeros(16) = " + numberOfLeadingZeros(16));
    }

    public static int highestOneBit(int i) {
        // HD, Figure 3-1
        i |= (i >>  1);
        i |= (i >>  2);
        i |= (i >>  4);
        i |= (i >>  8);
        i |= (i >> 16);
        return i - (i >>> 1);
    }

    public static int lowestOneBit(int i) {
        // HD, Section 2-1
        return i & -i;
    }

    public static int numberOfLeadingZeros(int i) {
        // HD, Figure 5-6
        if (i == 0)
            return 32;
        int n = 1;
        if (i >>> 16 == 0) { n += 16; i <<= 16; }
        if (i >>> 24 == 0) { n +=  8; i <<=  8; }
        if (i >>> 28 == 0) { n +=  4; i <<=  4; }
        if (i >>> 30 == 0) { n +=  2; i <<=  2; }
        n -= i >>> 31;
        return n;
    }

    public static int numberOfTrailingZeros(int i) {
        // HD, Figure 5-14
        int y;
        if (i == 0) return 32;
        int n = 31;
        y = i <<16; if (y != 0) { n = n -16; i = y; }
        y = i << 8; if (y != 0) { n = n - 8; i = y; }
        y = i << 4; if (y != 0) { n = n - 4; i = y; }
        y = i << 2; if (y != 0) { n = n - 2; i = y; }
        return n - ((i << 1) >>> 31);
    }

    public static int bitCount(int i) {
        // HD, Figure 5-2
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3f;
    }

}
