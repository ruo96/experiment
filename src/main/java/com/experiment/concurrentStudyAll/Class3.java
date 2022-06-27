package com.experiment.concurrentStudyAll;

/**
 * @author wuruohong
 * @date 2022-06-20 16:05
 */
public class Class3 {
    /**
     * 深拷贝的五种方式，
     * 1. 新建对象的时候对于内部的属性对象，如果层级不深的话，可以直接new进去，同时把值传递进去，当然必须是基本类型的，可包括string
     * 2. 实现clonable接口， 复写clone方法， 调用super.clone接口，同时对于属性位对象的也要调用其clone方法并set进入
     * 3. 使用Apche的SerializUtils 对对象进行拷贝  SerializationUtils.clone(object)  这个需要这个对象实现序列化接口 Serializable
     * 4. 使用Gson的方式进行拷贝          Gson gson = new Gson();  Obj = gson.fromJson(gson.toJson(obj), Obj.class);
     * 5. 使用jsckson来进行拷贝           Jackson与Gson相似，但是明显不同是拷贝的类包括其成员对象需要有默认的无参构造方法
     *                                 ObjectMapper mapper = new ObjectMapper();
     *                                 Obj cloneObj = mapper.readValue(mapper.writeValueAsString(obj), Obj.class);
     *
     *  总结：
     *  1. 如果什么jar包都不想用，那么就用第一种方法，但是可用性会比较差， 而且新增对象对代码破坏也大
     *  2. 可用性也有点差， 每次新增属性对象都需要修改clone方法，其拷贝类和内部对象属性都需要实现序clonable接口， 代码书写不友好
     *  3. 可用性强， 改动很小，只需要对象及其属性对象都实现序列化接口，代码简单，优雅，但是序列化和反序列化存在系统开销
     *  4. 可用性强， 不需要改动什么东西， 其底层设计复杂， 需要引入Gson包，序列化和反序列化都存在一定的系统开销
     *  5. 可用性强， 代码不需要修改， 其底层实现复杂， 需要引入jsckson包， 拷贝类及其属性对象需要有默认的无参构造方法，序列化和反序列化存在一定系统开销
     */
}
