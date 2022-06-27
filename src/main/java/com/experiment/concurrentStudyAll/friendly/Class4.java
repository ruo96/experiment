package com.experiment.concurrentStudyAll.friendly;

import com.experiment.concurrentStudyAll.CommonObject;
import com.experiment.concurrentStudyAll.CommonSonObject;

/**
 * @author wuruohong
 * @date 2022-06-20 16:36
 */
public class Class4 {

    public static void main(String[] args) {
        CommonObject commonObject = new CommonObject(1,2,3,4);
        // commonObject.defaultInt;
        // commonObject.protectedInt;
        // commonObject.publicInt;

        CommonSonObject commonSonObject = new CommonSonObject(1,2,3,4);
        // 不同包中就拿不到了
        // int defaultInt = commonSonObject.defaultInt;
    }
}
