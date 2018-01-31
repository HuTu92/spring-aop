package com.github.fnpac.aop.aspect.annotation.introductions;

import com.github.fnpac.aop.business.DefaultEncoreable;
import com.github.fnpac.aop.business.Encoreable;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * Created by 刘春龙 on 2018/1/30.
 */
@Aspect
public class EncoreableIntroducer {

    /**
     * {@link DeclareParents}注解由三部分组成：
     * <ul>
     * <li>value属性指定了哪种类型的bean要引入该接口。在本例中，也就是所有实现Performance的类型。
     * （标记符后面的加号表示是Performance的所有子类型， 而不是Performance本身。）
     * <li>defaultImpl属性指定了为引入功能提供实现的类。在这里，我们指定的是DefaultEncoreable提供实现。
     * <li>{@link DeclareParents}注解所标注的属性指明了要引入了接口。在这里，我们所引入的是Encoreable接口。
     * </ul>
     */
    @DeclareParents(value = "com.github.fnpac.aop.business.Performance+",
            defaultImpl = DefaultEncoreable.class)
    public Encoreable encoreable;// 《Spring 实战》一书将encoreable设置为static静态变量，这不是必须的
}
